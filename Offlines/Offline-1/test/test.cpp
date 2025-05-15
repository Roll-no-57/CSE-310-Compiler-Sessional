#include <bits/stdc++.h>
using namespace std;
#define trav(a, x) for(auto& a : x)
#define FOR(i, a, b) for (int i=(a); i<=(signed)(b); i++)
#define ROF(i, a, b) for (int i=(a); i>=(signed)(b); i--)
#define F0R(i, a) for (int i=0; i<(signed)(a); i++)
#define vi vector<int>
#define f first
#define s second
#define all(v) (v).begin(), (v).end()
#define int long long

const int mod = 1e9 + 7, MOD = 998244353;


string formatType(string type) {
    const char *cstr = type.c_str();
    int i = 0;

    // Read the first keyword: FUNCTION / STRUCT / UNION
    string keyword = "";
    while (cstr[i] != ' ' && cstr[i] != '\0') {
        keyword += cstr[i++];
    }

    // Skip the space
    while (cstr[i] == ' ') i++;

    if (keyword == "FUNCTION") {
        // Read tokens: first one might be return type
        string returnType = "", token = "";
        string args = "";
        bool firstArg = true;

        // Read return type
        while (cstr[i] != ' ' && cstr[i] != '\0') {
            returnType += cstr[i++];
        }

        // Skip space
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
            // Read type
            string fieldType = "";
            while (cstr[i] != ' ' && cstr[i] != '\0') {
                fieldType += cstr[i++];
            }

            while (cstr[i] == ' ') i++;

            // Read name
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


signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    // Your code goes here
    string type = "d";
    string formattedType = formatType(type);
    cout << formattedType << endl; // Output: FUNCTION,INT<==(INT,FLOAT,INT)
    
    return 0;
}