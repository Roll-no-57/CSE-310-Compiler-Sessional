#pragma once
#include <string>
#include <vector>
#include <sstream>

class rule {
private:
    std::vector<std::string> variables; // List of variables (e.g., ["x", "y", "z"])
    int lineNumber;                     // Line number where rule is applied
    std::string ruleName;               // Rule name (e.g., "type_specifier")
    std::string ruleContent;            // Rule content (e.g., "INT")
    std::string appliedCode;            // Code snippet (e.g., "int x,y,z;")

public:
    // Constructor
    rule(int lineNumber, const std::string& ruleName, const std::string& ruleContent, const std::string& appliedCode)
        : lineNumber(lineNumber), ruleName(ruleName), ruleContent(ruleContent), appliedCode(appliedCode) {
        variables = std::vector<std::string>();
    }

    rule() : lineNumber(0), ruleName(""), ruleContent(""), appliedCode("") {
        variables = std::vector<std::string>();
    }

    // Getters
    const std::vector<std::string>& get_variables() const { return variables; }
    int get_lineNumber() const { return lineNumber; }
    const std::string& get_ruleName() const { return ruleName; }
    const std::string& get_ruleContent() const { return ruleContent; }
    const std::string& get_appliedCode() const { return appliedCode; }

    // Setters
    void set_variables(const std::vector<std::string>& vars) { variables = vars; }
    void add_variable(const std::string& var) { variables.push_back(var); }
    void set_lineNumber(int line) { lineNumber = line; }
    void set_ruleName(const std::string& name) { ruleName = name; }
    void set_ruleContent(const std::string& content) { ruleContent = content; }
    void set_appliedCode(const std::string& code) { appliedCode = code; }

    // Format rule for logging (e.g., "Line 1: type_specifier : INT")
    std::string toLogString() const {
        std::stringstream ss;
        ss << "Line " << lineNumber << ": " << ruleName << " : " << ruleContent;
        return ss.str();
    }

    // Format applied code for logging (on a new line)
    std::string getAppliedCodeLog() const {
        return appliedCode.empty() ? "" : "\n" + appliedCode + "\n";
    }
};