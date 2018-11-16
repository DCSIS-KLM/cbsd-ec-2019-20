#!/bin/bash   
set -v

rm -rf jmods jlink
mkdir jmods 

#Compile
javac -d ./mods/ --module-source-path src $(find src -name "*.java")

#Jmod
jmod create jmods/com.red30tech.movement.jmod --class-path mods/com.red30tech.movement
jmod create jmods/com.red30tech.axle.jmod --class-path mods/com.red30tech.axle
jmod create jmods/com.red30tech.chassis.jmod --class-path mods/com.red30tech.chassis
jmod create jmods/com.red30tech.airbag.jmod --class-path mods/com.red30tech.airbag
jmod create jmods/com.red30tech.driver.jmod --class-path mods/com.red30tech.driver

#Jlink
jlink --module-path $JAVA_HOME/jmods:jmods --add-modules com.red30tech.driver --output jlink --launcher run=com.red30tech.driver/com.red30tech.driver.TestDriver
