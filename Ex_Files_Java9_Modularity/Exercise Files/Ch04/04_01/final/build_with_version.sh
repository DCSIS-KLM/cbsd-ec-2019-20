#!/bin/bash   
set -v

javac -d ./mods/ --module-source-path src --module-version 123.01 $(find src -name "*.java")

