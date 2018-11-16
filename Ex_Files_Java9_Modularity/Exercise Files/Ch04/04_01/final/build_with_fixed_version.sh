#!/bin/bash   
set -v

javac -d ./mods/ --module-source-path src --module-version 1TwoThree.01  $(find src -name "*.java")

