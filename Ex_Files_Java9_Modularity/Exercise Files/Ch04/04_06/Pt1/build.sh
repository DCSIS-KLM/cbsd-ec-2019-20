!/bin/bash   
set -v

javac -d ./classes --source-path src $(find src -name "*.java")
