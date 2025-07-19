#!/bin/bash

# Enable extended globbing for pattern matching
shopt -s extglob

# Loop through all files that do NOT match *.sh, *.g4, or Ctester.cpp
for file in !(*.sh|*.g4|Ctester.cpp); do
    if [[ -f "$file" ]]; then
        rm -f "$file"
    fi
done

# Remove the 'output' directory if it exists
rm -rf output

# Clean 'generated' but keep str_list.cpp and headers directory
if [ -d "generated" ]; then
    find generated -mindepth 1 ! -name 'str_list.cpp' ! -name 'rule.cpp' ! -name 'headers' ! -path 'generated/headers/*' -exec rm -rf {} +
fi