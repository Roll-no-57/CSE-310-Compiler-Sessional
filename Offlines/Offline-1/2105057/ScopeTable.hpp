#pragma once

#include <iostream>
#include <string>

#include "symbolInfo.hpp"
#include "Hash.hpp"
using namespace std;

class ScopeTable
{
private:
    // properties of hashtable
    int numOfBuckets;
    // attributes for scope table identification
    string id;

    SymbolInfo **hashTable;

public:
    ScopeTable *parentScope;

    // constructor
    ScopeTable(int n, int scopeNum, ScopeTable *parentScope = nullptr)
    {
        // initialization of the hash table
        this->numOfBuckets = n;

        this->parentScope = parentScope;

        this->hashTable = new SymbolInfo *[numOfBuckets];

        for (int i = 0; i < numOfBuckets; i++)
        {
            hashTable[i] = nullptr;
        }

        this->id = to_string(scopeNum);
    }

    // destructor
    ~ScopeTable()
    {

        // We will delete the first Symbol of any bucket and the rest of the symbol will be deleted recursively
        for (int i = 0; i < numOfBuckets; i++)
        {
            if (hashTable[i] != nullptr)
                delete hashTable[i];
        }

        delete[] hashTable;
    }

    string getId()
    {
        return id;
    }

    int calculateBucketIndex(string name)
    {
        uint64_t hash = Hash::SDBMHash(name, numOfBuckets);
        int index = hash % this->numOfBuckets;
        return index;
    }

    SymbolInfo *LookUp(string name, bool verbose = false)
    {
        int index = calculateBucketIndex(name);
        int indexInChain = 1;
        SymbolInfo *currentSymbol = hashTable[index];

        while (currentSymbol != nullptr)
        {
            if (currentSymbol->get_name() == name)
            {
                if (verbose)
                    cout << "\t'" << name << "' found in ScopeTable# " << getId() << " at position " << (index + 1) << ", " << indexInChain << endl;
                return currentSymbol;
            }
            currentSymbol = currentSymbol->next;
            indexInChain++;
        }

        return nullptr;
    }

    bool Insert(string name, string type, bool verbose = false)
    {

        SymbolInfo *existingSymbol = LookUp(name);

        int index = calculateBucketIndex(name);
        int indexInChain = 1;

        if (existingSymbol != nullptr)
        {
            if (verbose)
                cout << "\t'" << name << "' already exists in the current ScopeTable" << endl;
            return false;
        }
        else
        {
            SymbolInfo *newSymbol = new SymbolInfo(name, type, nullptr);

            SymbolInfo *current = hashTable[index];

            // if first entry of that bucket is empty then insert
            if (current == nullptr)
            {
                hashTable[index] = newSymbol;
            }
            else
            {
                SymbolInfo *nextInfo = current;
                while (nextInfo->next != nullptr)
                {
                    nextInfo = nextInfo->next;
                    indexInChain++;
                }
                nextInfo->next = newSymbol;
                indexInChain++;
            }
        }

        if (verbose)
            cout << "\tInserted in ScopeTable# " << getId() << " at position " << (index + 1) << ", " << indexInChain << endl;
        return true;
    }

    bool Remove(string name, bool verbose = false)
    {
        // first search if the symbol already exist if not then you can't delete
        SymbolInfo *existingSymbol = LookUp(name);
        int index = calculateBucketIndex(name);
        int indexInChain = 1;

        if (existingSymbol != nullptr)
        {
            // remove

            SymbolInfo *CurrentSymbol = hashTable[index];
            // SymbolInfo *prev;
            SymbolInfo *temp;

            // in case we remove the first symbol from a bucket then update the reference in hashtable .
            if (CurrentSymbol == existingSymbol)
            {
                hashTable[index] = CurrentSymbol->next;
                temp = CurrentSymbol;
            }
            else
            {
                while (CurrentSymbol->next != existingSymbol)
                {
                    CurrentSymbol = CurrentSymbol->next;
                    indexInChain++;
                }
                temp = CurrentSymbol->next; // want to delete CurrentSymbol->next;
                CurrentSymbol->next = CurrentSymbol->next->next;
            }

            // to avoid recursive deletion
            temp->next = nullptr;
            delete temp;

            if (verbose)
                cout << "\tDeleted '" << name << "' from ScopeTable# " << getId() << " at position " << (index + 1) << ", " << indexInChain << endl;

            return true;
        }
        else
        {
            // doesn't exist cant remove
            if (verbose)
                cout << "\tNot found in the current ScopeTable" << endl;
            return false;
        }
    }

    void printScopeTable(int scopeCount)
    {

        for (int j = 0; j < scopeCount; j++)
        {
            cout << "\t";
        }

        cout << "ScopeTable# " << this->id << endl;
        for (int i = 0; i < numOfBuckets; i++)
        {
            for (int j = 0; j < scopeCount; j++)
            {
                cout << "\t";
            }
            cout << i + 1;
            cout << "--> ";
            SymbolInfo *curr = hashTable[i];
            while (curr != nullptr)
            {
                cout << "<" << curr->get_name() << "," << curr->get_type() << "> ";
                curr = curr->next;
            }
            cout << endl;
        }
    }
};
