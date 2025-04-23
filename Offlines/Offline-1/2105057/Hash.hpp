// Guard against multiple declarations
#ifndef HASH_CLASS_HEADER
#define HASH_CLASS_HEADER

#include <iostream>
#include <string>

using namespace std;

// Hash class provides differnt hash functions

class Hash
{
public:

    //sdbm hash function provided by instructor
    static uint64_t SDBMHash(string str, uint64_t num_buckets)
    {
        uint64_t hash = 0;
        uint64_t len = str.length();

        for (uint64_t i = 0; i < len; i++)
        {
            hash = ((str[i]) + (hash << 6) + (hash << 16) - hash) %
                   num_buckets;
        }

        return hash;
    }

    // Implement new hash functions
    //.....loading
};

#endif