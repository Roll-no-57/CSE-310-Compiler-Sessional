#pragma once

#include <iostream>
#include <string>

#include "2105057_ScopeTable.hpp"

using namespace std;

class SymbolTable
{
private:
    int numOfBuckets;
    ScopeTable *currentScope;
    int numOfScope;
    ostream& out;
    HashFunction hashFunc;

public:
    // Default hash function is SDBMHash
    SymbolTable(int n,HashFunction hashFunc = &Hash::SDBMHash, ostream& outfile = cout, bool verbose = false): out(outfile)
    {
        this->numOfBuckets = n;
        this->hashFunc = hashFunc;
        this->currentScope = nullptr;
        this->numOfScope = 1;

        enterScope(verbose);
    }

    ~SymbolTable()
    {
        endProgram();
    }

    void incrementNumOfScope()
    {
        this->numOfScope++;
    }
    int getNumOfScope()
    {
        return this->numOfScope;
    }

    ScopeTable *getCurrentScope()
    {
        return currentScope;
    }

    void enterScope(bool verbose = false)
    {

        if (currentScope != nullptr)
        {
            incrementNumOfScope();
        }
        ScopeTable *newScope = new ScopeTable(this->numOfBuckets, this->numOfScope, this->hashFunc, this->currentScope,this->out); // set current as parentScope

        this->currentScope = newScope;
        if (verbose)
            out << "\tScopeTable# " << currentScope->getId() << " created" << endl;
    }


    void exitScope(bool verbose = false, bool quit = false)
    {
        if (currentScope->parentScope == nullptr && !quit)
        {
            if (verbose)
                out << "\tScopeTable# " << currentScope->getId() << "  cannot be removed" << endl;
            return;
        }
        ScopeTable *temp = currentScope;
        currentScope = currentScope->parentScope;
        temp->parentScope = nullptr;
        string tempId = temp->getId();
        delete temp;
        if (verbose)
            out << "\tScopeTable# " << tempId << " removed" << endl;
    }

    bool Insert(string name, string type, bool verbose = false)
    {
        if(currentScope == nullptr){
            out<<"\tCannot Insert anymore . You have removed all Scope."<<endl;
        }
        bool success = currentScope->Insert(name, type, verbose);
        return success;
    }

    bool Remove(string name, bool verbose = false)
    {
        bool success = currentScope->Remove(name, verbose);
        return success;
    }

    SymbolInfo *LookUp(string name, bool verbose = false)
    {
        // first searches currentscope if not found then recursively searches the parentscope.

        ScopeTable *searchScope = currentScope;

        // search until parentscope is not nullptr or main scope
        while (searchScope != nullptr)
        {

            SymbolInfo *searchedSymbol = searchScope->LookUp(name, verbose);
            if (searchedSymbol != nullptr)
            {
                return searchedSymbol;
            }
            searchScope = searchScope->parentScope;
        }
        if (verbose)
            out << "\t'" << name << "' not found in any of the ScopeTables" << endl;
        return nullptr;
    }

    bool endProgram(bool verbose = false)
    {
        if (currentScope == nullptr)
        {
            if (verbose)
                out << "\tNo ScopeTable exists" << endl;
            return false;
        }
        while (currentScope != nullptr)
        {
            exitScope(verbose, true);
        }
        return true;
    }

    void printCurrentScopeTable()
    {
        currentScope->printScopeTable(1);
    }

    void printAllScopeTable()
    {
        ScopeTable *curr = currentScope;
        int scopeCount = 1;
        while (curr != nullptr)
        {
            curr->printScopeTable(scopeCount);
            curr = curr->parentScope;
            scopeCount++;
        }
    }

    double getMeanCollisionRatio()
    {
        double sum = 0.0;
        double scopeCount = 0.0;

        ScopeTable *curr = currentScope;
        while (curr != nullptr)
        {
            sum += curr->getCollisionRatio();
            scopeCount++;
            curr = curr->parentScope;
        }

        return scopeCount > 0 ? sum / scopeCount : 0.0;
    }
};