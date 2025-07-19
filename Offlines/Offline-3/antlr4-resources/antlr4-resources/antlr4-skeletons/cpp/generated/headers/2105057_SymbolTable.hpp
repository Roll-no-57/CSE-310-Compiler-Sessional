#pragma once

#include <iostream>
#include <string>
#include <stack>

#include "2105057_symbolInfo.hpp"
#include "2105057_ScopeTable.hpp"
#include "2105057_Hash.hpp"

using namespace std;

typedef uint64_t (*HashFunction)(string, uint64_t);

class SymbolTable
{
private:
    ScopeTable *currentScope;
    int bucketSize;
    int totalScopes;
    HashFunction hashFunc;
    ostream& out;
    bool verbose;
    stack<ScopeTable*> scopeStack;

public:
    // constructor
    SymbolTable(int n, HashFunction hashFunction = &Hash::SDBMHash, ostream& outFile = cout, bool verboseMode = true) : out(outFile)
    {
        this->bucketSize = n;
        this->currentScope = new ScopeTable(n, 1, hashFunction, nullptr, outFile);
        this->totalScopes = 1;
        this->hashFunc = hashFunction;
        this->verbose = verboseMode;
        scopeStack.push(currentScope);
    }

    // destructor
    ~SymbolTable()
    {
        while (currentScope != nullptr)
        {
            ScopeTable *temp = currentScope;
            currentScope = currentScope->parentScope;
            delete temp;
        }
    }

    void EnterScope()
    {
        if (currentScope == nullptr)
        {
            if (verbose)
                out << "\tScopeTable# cannot be created" << endl;
            return;
        }

        currentScope->incrementChildCount();
        int childNum = currentScope->getChildCount();
        ScopeTable *newScope = new ScopeTable(bucketSize, childNum, hashFunc, currentScope, out);
        currentScope = newScope;
        totalScopes++;
        scopeStack.push(currentScope);

        if (verbose)
            out << "\tScopeTable# " << currentScope->getId() << " created" << endl;
    }

    void ExitScope()
    {
        if (currentScope == nullptr)
        {
            if (verbose)
                out << "\tScopeTable# cannot be removed" << endl;
            return;
        }

        if (verbose)
        {
            out << "\tScopeTable# " << currentScope->getId() << " removed" << endl;
            // Print the scope table before removing it
            currentScope->printScopeTable(0);
        }

        ScopeTable *temp = currentScope;
        currentScope = currentScope->parentScope;
        
        if (!scopeStack.empty()) {
            scopeStack.pop();
        }
        
        delete temp;
    }

    bool Insert(string name, string type, bool verboseMode = true)
    {
        if (currentScope == nullptr)
        {
            if (verbose)
                out << "\tNo ScopeTable exists" << endl;
            return false;
        }

        int bucket, chainPos;
        bool success = currentScope->Insert(name, type, bucket, chainPos, verboseMode);
        return success;
    }

    bool Remove(string name)
    {
        if (currentScope == nullptr)
        {
            if (verbose)
                out << "\tNo ScopeTable exists" << endl;
            return false;
        }

        return currentScope->Remove(name, verbose);
    }

    SymbolInfo *LookUp(string name, bool verboseMode = true)
    {
        ScopeTable *current = currentScope;

        while (current != nullptr)
        {
            SymbolInfo *symbol = current->LookUp(name, false);
            if (symbol != nullptr)
            {
                if (verboseMode && verbose)
                    out << "\t'" << name << "' found in ScopeTable# " << current->getId() << endl;
                return symbol;
            }
            current = current->parentScope;
        }

        if (verboseMode && verbose)
            out << "\t'" << name << "' not found in any ScopeTable" << endl;
        return nullptr;
    }

    SymbolInfo *LookUpCurrentScope(string name)
    {
        if (currentScope == nullptr) return nullptr;
        return currentScope->LookUp(name, false);
    }

    void printCurrentScopeTable()
    {
        if (currentScope != nullptr)
        {
            currentScope->printScopeTable(0);
        }
    }

    void printAllScopeTable()
    {
        if (verbose)
            out << "\tSymbol Table:" << endl;
        
        ScopeTable *current = currentScope;
        int depth = 0;

        // Calculate depth
        while (current != nullptr)
        {
            depth++;
            current = current->parentScope;
        }

        // Print from root to current
        current = currentScope;
        for (int i = depth - 1; i >= 0; i--)
        {
            ScopeTable *temp = current;
            for (int j = 0; j < i; j++)
            {
                if (temp->parentScope != nullptr)
                    temp = temp->parentScope;
            }
            temp->printScopeTable(depth - i - 1);
        }
    }

    string getCurrentScopeId()
    {
        if (currentScope != nullptr)
            return currentScope->getId();
        return "";
    }

    ScopeTable* getCurrentScope() {
        return currentScope;
    }

    // Enhanced methods for semantic analysis
    bool insertVariable(string name, string dataType, bool isArray = false, int arraySize = 0, int lineNumber = 0)
    {
        // Check if variable already exists in current scope
        SymbolInfo* existing = LookUpCurrentScope(name);
        if (existing != nullptr)
        {
            return false; // Variable already declared in current scope
        }

        // Create new symbol
        SymbolInfo* symbol = new SymbolInfo(name, dataType, nullptr, out);
        symbol->set_dataType(dataType);
        symbol->set_isArray(isArray);
        symbol->set_arraySize(arraySize);

        int bucket, chainPos;
        return currentScope->Insert(name, dataType, bucket, chainPos, verbose);
    }

    bool insertFunction(string name, string returnType, vector<string> paramTypes, vector<string> paramNames, bool isDefined, int lineNumber = 0)
    {
        SymbolInfo* existing = LookUp(name, false);
        
        if (existing != nullptr && existing->get_isFunction())
        {
            FunctionInfo* existingFunc = existing->get_functionInfo();
            FunctionInfo newFunc(returnType, paramTypes, paramNames);
            
            // Check if signatures match
            if (!existingFunc->matchesSignature(newFunc))
            {
                return false; // Function signature mismatch
            }

            // Update definition status
            if (isDefined)
            {
                if (existingFunc->isDefined)
                {
                    return false; // Function already defined
                }
                existingFunc->isDefined = true;
            }
            else
            {
                existingFunc->isDeclared = true;
            }
            
            return true;
        }
        else if (existing != nullptr)
        {
            return false; // Name already used for non-function
        }

        // Create new function symbol
        FunctionInfo* funcInfo = new FunctionInfo(returnType, paramTypes, paramNames);
        funcInfo->isDefined = isDefined;
        funcInfo->isDeclared = !isDefined;
        funcInfo->lineNumber = lineNumber;

        SymbolInfo* symbol = new SymbolInfo(name, "FUNCTION", nullptr, out);
        symbol->set_isFunction(true);
        symbol->set_functionInfo(funcInfo);

        int bucket, chainPos;
        return currentScope->Insert(name, "FUNCTION " + returnType, bucket, chainPos, verbose);
    }

    bool checkVariableUsage(string name, bool isArrayAccess, int lineNumber = 0)
    {
        SymbolInfo* symbol = LookUp(name, false);
        if (symbol == nullptr)
        {
            return false; // Variable not declared
        }

        if (symbol->get_isFunction())
        {
            return false; // Cannot use function as variable
        }

        if (isArrayAccess && !symbol->get_isArray())
        {
            return false; // Cannot index non-array
        }

        if (!isArrayAccess && symbol->get_isArray())
        {
            return false; // Cannot use array without index
        }

        return true;
    }

    SymbolInfo* getFunctionInfo(string name)
    {
        SymbolInfo* symbol = LookUp(name, false);
        if (symbol != nullptr && symbol->get_isFunction())
        {
            return symbol;
        }
        return nullptr;
    }
};