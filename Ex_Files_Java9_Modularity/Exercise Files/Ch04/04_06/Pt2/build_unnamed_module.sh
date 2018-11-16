#!/bin/bash   
set -v

rm -rf mods bin classes
mkdir mods bin classes

javac -d ./mods/ --module-source-path src_9 $(find src_9 -name "*.java")
javac -d ./classes/ -cp mods/com.red30tech.movement --source-path src_8 $(find src_8 -name "*.java")

jar --create --file ./bin/com.red30tech.movement.jar -C mods/com.red30tech.movement .
