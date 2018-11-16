#!/bin/bash   
set -v

javac -d ./classes/ $(find src/com.red30tech.movement -name "*.java")
