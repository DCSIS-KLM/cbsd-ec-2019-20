#!/bin/bash   
set -v

rm -rf bin classes mods
mkdir bin

javac -d ./mods/ --module-source-path src_9 $(find src_9/com.red30tech.movement -name "*.java")
javac -d ./mods/ --module-source-path src_9 $(find src_9/com.red30tech.airbag -name "*.java")
javac -d classes -cp mods/com.red30tech.movement:mods/com.red30tech.airbag  $(find src_8 -name "*.java")
jar --create --file ./bin/com.red30tech.chassis.jar -C classes com/red30tech/chassis
javac -d ./mods/ --module-path bin:mods --module-source-path src_9 $(find src_9/com.red30tech.driver -name "*.java")
