#!/bin/bash   
set -v

javac -d ./mods/ --module-version 123.01  --module-source-path src $(find src -name "*.java")
