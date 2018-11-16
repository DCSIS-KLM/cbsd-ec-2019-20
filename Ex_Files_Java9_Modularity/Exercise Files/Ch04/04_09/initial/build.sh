#!/bin/bash   
set -v

javac -d classes   $(find src_8 -name "*.java")
javac -d ./mods/ -cp classes --module-source-path src_9 $(find src_9 -name "*.java")
