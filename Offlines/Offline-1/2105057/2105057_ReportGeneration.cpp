#include <iostream>
#include <string>
#include "fstream"
#include "2105057_SymbolTable.hpp"
#include "2105057_Hash.hpp"

using namespace std;

int main(int argc, char *argv[])
{
    HashFunction hashFunc = Hash::SDBMHash;
    string hashName = "SDBMHash";
    string hashSource = "Provided in specification";
    string inputFile = "input.txt";

    // parse the command line arguments for hash function and input file
    for (int i = 1; i < argc; i++)
    {
        string arg = argv[i];
        if (arg.find("--hash=") == 0)
        {
            string hash = arg.substr(7);
            if (hash == "djb2")
            {
                hashFunc = Hash::DJB2Hash;
                hashName = "DJB2Hash";
                hashSource = "http://www.cse.yorku.ca/~oz/hash.html";
            }
            else if (hash == "fnv1a")
            {
                hashFunc = Hash::FNV1AHash;
                hashName = "FNV1AHash";
                hashSource = "http://www.isthe.com/chongo/tech/comp/fnv/";
            }
            else if (hash == "sum")
            {
                hashFunc = Hash::SumHash;
                hashName = "SumHash";
                hashSource = "Custom hash function";
            }
        }
        else if (arg.find("--input=") == 0)
        {
            inputFile = arg.substr(8);
        }
    }

    int numOfBuckets = 100;
    SymbolTable *ST = new SymbolTable(numOfBuckets, hashFunc);

    ifstream file(inputFile);
    if (!file.is_open())
    {
        cerr << "Error opening file." << endl;
        return 1;
    }

    string name;
    int count = 0;
    while (file >> name)
    {
        // as main scope is created when ST declared so we will enter new scope for 2nd hundred names and so on
        if (count % numOfBuckets == 0 && count > 0)
        {
            ST->enterScope();
        }

        ST->Insert(name, "INT");
        count++;
    }
    file.close();

    if (count == 0)
    {
        cerr << "Input file is empty: " << inputFile << endl;
        delete ST;
        return 1;
    }

    double ratio = ST->getMeanCollisionRatio();

    // Write to report file
    ofstream report("report.txt", ios::app);
    if (!report.is_open())
    {
        cerr << "Error opening report file." << endl;
        ST->endProgram();
        delete ST;
        return 1;
    }

    // Write header if file is empty
    if (report.tellp() == 0)
    {
        report << "HashFunction,Buckets,Count,CollisionRatio,InputFile\n";
    }

    report << hashName << "," << numOfBuckets << "," << count << "," << ratio << "," << inputFile << "\n";
    report.close();

    // Console output
    cout << "Hash Function: " << hashName << "\n"
         << "Source: " << hashSource << "\n"
         << "Number of Buckets: " << numOfBuckets << "\n"
         << "Count: " << count << "\n"
         << "Mean Collision Ratio: " << ratio << "\n"
         << "Input File: " << inputFile << "\n";

    ST->endProgram();
    delete ST;
    return 0;
}



// Run command:
// ./2105057_report_generator --hash=sdbm --input=random.txt
// ./2105057_report_generator --hash=djb2 --input=random.txt
// ./2105057_report_generator --hash=fnv1a --input=random.txt
// ./2105057_report_generator --hash=sum --input=random.txt
// ./2105057_report_generator --hash=sdbm --input=similar_prefix.txt
