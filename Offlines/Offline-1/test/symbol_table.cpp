#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>

using namespace std;

class SymbolInfo {
private:
    string name;
    string type;
    SymbolInfo* next;
public:
    SymbolInfo(string name, string type) : name(name), type(type), next(nullptr) {}
    string getName() const { return name; }
    string getType() const { return type; }
    void setName(string n) { name = n; }
    void setType(string t) { type = t; }
    SymbolInfo* getNext() const { return next; }
    void setNext(SymbolInfo* n) { next = n; }
};

class ScopeTable {
private:
    SymbolInfo** buckets;
    int num_buckets;
    ScopeTable* parent;
    int id;
    unsigned int SDBMHash(string str) {
        unsigned int hash = 0;
        for (char c : str) {
            hash = (c + (hash << 6) + (hash << 16) - hash) % num_buckets;
        }
        return hash;
    }
    string format_type(string type) {
        stringstream ss(type);
        string token;
        ss >> token;
        if (token == "FUNCTION") {
            string return_type;
            ss >> return_type;
            vector<string> params;
            string param;
            while (ss >> param) {
                params.push_back(param);
            }
            string param_str = "(";
            for (size_t j = 0; j < params.size(); j++) {
                if (j > 0) param_str += ",";
                param_str += params[j];
            }
            param_str += ")";
            return "FUNCTION," + return_type + "<==" + param_str;
        } else if (token == "STRUCT" || token == "UNION") {
            vector<string> fields;
            string field;
            while (ss >> field) {
                fields.push_back(field);
            }
            string field_str = "{";
            for (size_t j = 0; j < fields.size(); j += 2) {
                if (j > 0) field_str += ",";
                field_str += "(" + fields[j] + "," + fields[j + 1] + ")";
            }
            field_str += "}";
            return token + "," + field_str;
        } else {
            return type;
        }
    }
public:
    ScopeTable(int n, int id, ScopeTable* parent = nullptr) : num_buckets(n), parent(parent), id(id) {
        buckets = new SymbolInfo*[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = nullptr;
        }
    }
    ~ScopeTable() {
        for (int i = 0; i < num_buckets; i++) {
            SymbolInfo* curr = buckets[i];
            while (curr != nullptr) {
                SymbolInfo* temp = curr;
                curr = curr->next;
                delete temp;
            }
        }
        delete[] buckets;
    }
    bool insert(string name, string type, int& bucket, int& pos) {
        unsigned int h = SDBMHash(name);
        SymbolInfo* curr = buckets[h];
        SymbolInfo* prev = nullptr;
        pos = 1;
        while (curr != nullptr) {
            if (curr->getName() == name) return false;
            prev = curr;
            curr = curr->next;
            pos++;
        }
        SymbolInfo* new_si = new SymbolInfo(name, type);
        if (prev == nullptr) {
            buckets[h] = new_si;
        } else {
            prev->setNext(new_si);
        }
        bucket = h + 1;
        return true;
    }
    SymbolInfo* lookup(string name, int& bucket, int& pos) {
        unsigned int h = SDBMHash(name);
        SymbolInfo* curr = buckets[h];
        pos = 1;
        while (curr != nullptr) {
            if (curr->getName() == name) {
                bucket = h + 1;
                return curr;
            }
            curr = curr->next;
            pos++;
        }
        return nullptr;
    }
    bool deleteSymbol(string name, int& bucket, int& pos) {
        unsigned int h = SDBMHash(name);
        SymbolInfo* curr = buckets[h];
        SymbolInfo* prev = nullptr;
        pos = 1;
        while (curr != nullptr) {
            if (curr->getName() == name) {
                if (prev == nullptr) {
                    buckets[h] = curr->next;
                } else {
                    prev->setNext(curr->next);
                }
                delete curr;
                bucket = h + 1;
                return true;
            }
            prev = curr;
            curr = curr->next;
            pos++;
        }
        return false;
    }
    void print(ofstream& outfile) {
        outfile << "\tScopeTable# " << id << endl;
        for (int i = 0; i < num_buckets; i++) {
            outfile << "\t" << i + 1 << "--> ";
            SymbolInfo* curr = buckets[i];
            while (curr != nullptr) {
                outfile << "<" << curr->getName() << "," << format_type(curr->getType()) << "> ";
                curr = curr->next;
            }
            outfile << endl;
        }
    }
    ScopeTable* getParent() { return parent; }
    int getId() { return id; }
};

class SymbolTable {
private:
    ScopeTable* current;
    int next_id;
    int num_buckets;
public:
    SymbolTable(int n) : num_buckets(n), next_id(1) {
        current = new ScopeTable(n, next_id++);
        cout << "\tScopeTable# 1 created" << endl;
    }
    ~SymbolTable() {
        while (current != nullptr) {
            ScopeTable* temp = current;
            current = current->getParent();
            cout << "\tScopeTable# " << temp->getId() << " removed" << endl;
            delete temp;
        }
    }
    void enterScope() {
        ScopeTable* new_scope = new ScopeTable(num_buckets, next_id++, current);
        current = new_scope;
        cout << "\tScopeTable# " << new_scope->getId() << " created" << endl;
    }
    void exitScope() {
        if (current->getParent() != nullptr) {
            ScopeTable* temp = current;
            current = current->getParent();
            cout << "\tScopeTable# " << temp->getId() << " removed" << endl;
            delete temp;
        }
    }
    bool insert(string name, string type) {
        int bucket, pos;
        bool success = current->insert(name, type, bucket, pos);
        if (success) {
            cout << "\tInserted in ScopeTable# " << current->getId() << " at position " << bucket << ", " << pos << endl;
        } else {
            cout << "\t'" << name << "' already exists in the current ScopeTable" << endl;
        }
        return success;
    }
    bool remove(string name) {
        int bucket, pos;
        bool success = current->deleteSymbol(name, bucket, pos);
        if (success) {
            cout << "\tDeleted '" << name << "' from ScopeTable# " << current->getId() << " at position " << bucket << ", " << pos << endl;
        } else {
            cout << "\tNot found in the current ScopeTable" << endl;
        }
        return success;
    }
    SymbolInfo* lookup(string name) {
        ScopeTable* temp = current;
        while (temp != nullptr) {
            int bucket, pos;
            SymbolInfo* si = temp->lookup(name, bucket, pos);
            if (si != nullptr) {
                cout << "\t'" << name << "' found in ScopeTable# " << temp->getId() << " at position " << bucket << ", " << pos << endl;
                return si;
            }
            temp = temp->getParent();
        }
        cout << "\t'" << name << "' not found in any of the ScopeTables" << endl;
        return nullptr;
    }
    void printCurrent(ofstream& outfile) {
        current->print(outfile);
    }
    void printAll(ofstream& outfile) {
        ScopeTable* temp = current;
        while (temp != nullptr) {
            temp->print(outfile);
            temp = temp->getParent();
        }
    }
};

int main(int argc, char* argv[]) {
    if (argc != 3) {
        cerr << "Usage: ./a.out input.txt output.txt" << endl;
        return 1;
    }

    ifstream infile(argv[1]);
    if (!infile.is_open()) {
        cerr << "Cannot open input file" << endl;
        return 1;
    }

    ofstream outfile(argv[2]);
    if (!outfile.is_open()) {
        cerr << "Cannot open output file" << endl;
        infile.close();
        return 1;
    }

    // Read number of buckets
    string first_line;
    if (!getline(infile, first_line)) {
        cerr << "Input file is empty" << endl;
        infile.close();
        outfile.close();
        return 1;
    }
    int num_buckets = stoi(first_line);
    SymbolTable symbolTable(num_buckets);

    // Process commands
    string line;
    int cmd_count = 0;
    while (getline(infile, line)) {
        cmd_count++;
        outfile << "Cmd " << cmd_count << ": " << line << endl;
        stringstream ss(line);
        string command;
        ss >> command;

        if (command == "I") {
            string name, type;
            if (!(ss >> name >> type)) {
                outfile << "\tNumber of parameters mismatch for the command I" << endl;
                continue;
            }
            vector<string> words;
            string word;
            while (ss >> word) {
                words.push_back(word);
            }
            string type_string;
            if (type == "FUNCTION") {
                if (words.size() < 1) {
                    outfile << "\tNumber of parameters mismatch for the command I" << endl;
                    continue;
                }
                type_string = "FUNCTION " + words[0];
                for (size_t i = 1; i < words.size(); i++) {
                    type_string += " " + words[i];
                }
            } else if (type == "STRUCT" || type == "UNION") {
                if (words.size() % 2 != 0) {
                    outfile << "\tNumber of parameters mismatch for the command I" << endl;
                    continue;
                }
                type_string = type;
                for (const string& w : words) {
                    type_string += " " + w;
                }
            } else {
                if (!words.empty()) {
                    outfile << "\tNumber of parameters mismatch for the command I" << endl;
                    continue;
                }
                type_string = type;
            }
            symbolTable.insert(name, type_string);
        }
        else if (command == "L") {
            string name;
            if (!(ss >> name)) {
                outfile << "\tNumber of parameters mismatch for the command L" << endl;
                continue;
            }
            string extra;
            if (ss >> extra) {
                outfile << "\tNumber of parameters mismatch for the command L" << endl;
                continue;
            }
            symbolTable.lookup(name);
        }
        else if (command == "D") {
            string name;
            if (!(ss >> name)) {
                outfile << "\tNumber of parameters mismatch for the command D" << endl;
                continue;
            }
            string extra;
            if (ss >> extra) {
                outfile << "\tNumber of parameters mismatch for the command D" << endl;
                continue;
            }
            symbolTable.remove(name);
        }
        else if (command == "P") {
            string option;
            if (!(ss >> option)) {
                outfile << "\tNumber of parameters mismatch for the command P" << endl;
                continue;
            }
            if (option == "A") {
                symbolTable.printAll(outfile);
            } else if (option == "C") {
                symbolTable.printCurrent(outfile);
            } else {
                outfile << "\tInvalid option for command P" << endl;
            }
        }
        else if (command == "S") {
            symbolTable.enterScope();
        }
        else if (command == "E") {
            symbolTable.exitScope();
        }
        else if (command == "Q") {
            break;
        }
        else {
            outfile << "\tInvalid command" << endl;
        }
    }

    infile.close();
    outfile.close();
    return 0;
}