#pragma once
#include <string>
#include <vector>
#include <sstream>

class str_list {
private:
    std::vector<std::string> variables;

public:
    // Constructor
    str_list() = default;

    // Add a variable
    void add(const std::string& var) {
        variables.push_back(var);
    }

    // Get variables
    const std::vector<std::string>& get_variables() const {
        return variables;
    }

    // Set variables
    void set_variables(const std::vector<std::string>& vars) {
        variables = vars;
    }

    // Get size
    size_t size() const {
        return variables.size();
    }

    // Convert to string (comma-separated)
    std::string get_list_as_string() const {
        if (variables.empty()) return "";
        std::stringstream ss;
        for (size_t i = 0; i < variables.size(); ++i) {
            ss << variables[i];
            if (i < variables.size() - 1) ss << ",";
        }
        return ss.str();
    }
};