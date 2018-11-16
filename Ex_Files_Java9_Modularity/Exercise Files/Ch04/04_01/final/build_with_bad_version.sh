#!/bin/bash   
set -v

javac -d ./mods/ --module-source-path src --module-version OneTwoThree.01 $(find src -name "*.java")

