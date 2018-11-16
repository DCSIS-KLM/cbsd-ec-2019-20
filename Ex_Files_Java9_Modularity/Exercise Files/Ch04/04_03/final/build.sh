#!/bin/bash   
set -v

rm -rf mods mods2

javac -d ./mods/ --module-source-path src $(find src -name "*.java")
