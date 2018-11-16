#!/bin/bash   
set -v

rm -rf bin
mkdir bin

javac -d ./mods/ --module-source-path src $(find src -name "*.java")

jar --create --file ./bin/com.red30tech.movement.jar -C mods/com.red30tech.movement .
jar --create --file ./bin/com.red30tech.axle.jar -C mods/com.red30tech.axle .
jar --create --file ./bin/com.red30tech.chassis.jar -C mods/com.red30tech.chassis .
jar --create --file ./bin/com.red30tech.driver.jar -C mods/com.red30tech.driver .
jar --create --file ./bin/com.red30tech.airbag.jar -C mods/com.red30tech.airbag .
