#pragma once

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Forward declaration
class FunctionInfo;

class SymbolInfo
{
private:
    string name;
    string type;
    string dataType;  // INT, FLOAT, VOID
    bool isArray;
    int arraySize;
    bool isFunction;
    FunctionInfo* functionInfo;
    ostream& out;

public:
    // This pointer is used to chain multiple symbol in same bucket of the hashTable
    SymbolInfo *next;

    // constructor
    SymbolInfo(string name, string type, SymbolInfo *next = nullptr, ostream& outfile = cout): out(outfile)
    {
        this->name = name;
        this->next = next;
        this->type = formatType(type);
        this->isArray = false;
        this->arraySize = 0;
        this->isFunction = false;
        this->functionInfo = nullptr;
        this->dataType = extractDataType(type);
    }

    // destructor
    ~SymbolInfo()
    {
        // Here we are recursively deleting this symbol and the following symbols
        if(next != nullptr) delete next;
        if(functionInfo != nullptr) delete functionInfo;
    }

    string extractDataType(string type) {
        if (type.find("INT") != string::npos) return "INT";
        if (type.find("FLOAT") != string::npos) return "FLOAT";
        if (type.find("VOID") != string::npos) return "VOID";
        return "UNKNOWN";
    }

    string formatType(string type) {
        const char *cstr = type.c_str();
        int i = 0;
    
        // Read the first keyword: FUNCTION / STRUCT / UNION
        string keyword = "";
        while (cstr[i] != ' ' && cstr[i] != '\0') {
            keyword += cstr[i++];
        }
    
        while (cstr[i] == ' ') i++;
    
        if (keyword == "FUNCTION") {
            string returnType = "", token = "";
            string args = "";
            bool firstArg = true;

            while (cstr[i] != ' ' && cstr[i] != '\0') {
                returnType += cstr[i++];
            }
    
            while (cstr[i] == ' ') i++;
    
            // Collect arguments if any
            if (returnType == "VOID" && cstr[i] == '\0') {
                return "FUNCTION,VOID<==()";
            }
    
            while (cstr[i] != '\0') {
                token = "";
                while (cstr[i] != ' ' && cstr[i] != '\0') {
                    token += cstr[i++];
                }
                if (!firstArg) args += ",";
                args += token;
                firstArg = false;
    
                while (cstr[i] == ' ') i++;
            }
    
            return "FUNCTION," + returnType + "<==(" + args + ")";
        }
        else if (keyword == "STRUCT" || keyword == "UNION") {
            string result = keyword + ",{";
            bool first = true;
    
            while (cstr[i] != '\0') {
                string fieldType = "";
                while (cstr[i] != ' ' && cstr[i] != '\0') {
                    fieldType += cstr[i++];
                }
    
                while (cstr[i] == ' ') i++;
    
                string fieldName = "";
                while (cstr[i] != ' ' && cstr[i] != '\0') {
                    fieldName += cstr[i++];
                }
    
                while (cstr[i] == ' ') i++;
    
                if (!first) result += ",";
                result += "(" + fieldType + "," + fieldName + ")";
                first = false;
            }
    
            result += "}";
            return result;
        }
    
        return type;
    }
    
    // Getters and setters 
    void set_name(string name) { this->name = name; }
    void set_type(string type) { this->type = type; }
    void set_next(SymbolInfo* next) { this->next = next; }
    void set_dataType(string dataType) { this->dataType = dataType; }
    void set_isArray(bool isArray) { this->isArray = isArray; }
    void set_arraySize(int arraySize) { this->arraySize = arraySize; }
    void set_isFunction(bool isFunction) { this->isFunction = isFunction; }
    void set_functionInfo(FunctionInfo* functionInfo) { this->functionInfo = functionInfo; }

    string get_name() { return name; }
    string get_type() { return type; }
    string get_dataType() { return dataType; }
    bool get_isArray() { return isArray; }
    int get_arraySize() { return arraySize; }
    bool get_isFunction() { return isFunction; }
    FunctionInfo* get_functionInfo() { return functionInfo; }
    SymbolInfo* get_next() { return next; }

    // Debug
    void show()
    {
        out << endl;
        out << "SymbolInfo :";
        out << "Name = " << get_name() << " ";
        out << "Type = " << get_type() << endl;
    }
};

// Function information class
class FunctionInfo {
public:
    string returnType;
    vector<string> parameterTypes;
    vector<string> parameterNames;
    bool isDefined;
    bool isDeclared;
    int lineNumber;

    FunctionInfo() {
        isDefined = false;
        isDeclared = false;
        lineNumber = 0;
    }

    FunctionInfo(string retType, vector<string> paramTypes, vector<string> paramNames) {
        returnType = retType;
        parameterTypes = paramTypes;
        parameterNames = paramNames;
        isDefined = false;
        isDeclared = false;
        lineNumber = 0;
    }

    bool matchesSignature(const FunctionInfo& other) const {
        if (returnType != other.returnType) return false;
        if (parameterTypes.size() != other.parameterTypes.size()) return false;
        
        for (size_t i = 0; i < parameterTypes.size(); i++) {
            if (parameterTypes[i] != other.parameterTypes[i]) return false;
        }
        return true;
    }

    string getSignature() const {
        string sig = returnType + "(";
        for (size_t i = 0; i < parameterTypes.size(); i++) {
            if (i > 0) sig += ",";
            sig += parameterTypes[i];
        }
        sig += ")";
        return sig;
    }
};