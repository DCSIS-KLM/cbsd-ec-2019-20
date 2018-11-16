#!/bin/bash   
set -v

rm -rf jmods jlink jmods2
mkdir jmods jmods2

#Compile
javac -d ./mods/ --module-source-path src $(find src -name "*.java")

#Jmod
jmod create jmods/com.red30tech.movement.jmod --class-path mods/com.red30tech.movement
jmod create jmods/com.red30tech.axle.jmod --class-path mods/com.red30tech.axle
jmod create jmods/com.red30tech.chassis.jmod --class-path mods/com.red30tech.chassis
jmod create jmods/com.red30tech.airbag.jmod --class-path mods/com.red30tech.airbag
jmod create jmods/com.red30tech.driver.jmod --class-path mods/com.red30tech.driver
jmod hash --module-path jmods --hash-modules .*

#Jmod again to a different directory
jmod create jmods2/com.red30tech.movement.jmod --class-path mods/com.red30tech.movement
jmod create jmods2/com.red30tech.axle.jmod --class-path mods/com.red30tech.axle
jmod create jmods2/com.red30tech.chassis.jmod --class-path mods/com.red30tech.chassis
jmod create jmods2/com.red30tech.airbag.jmod --class-path mods/com.red30tech.airbag
jmod create jmods2/com.red30tech.driver.jmod --class-path mods/com.red30tech.driver

#Hash again
jmod hash --module-path jmods2 --hash-modules .*

#describe
jmod describe jmods/com.red30tech.movement.jmod
jmod describe jmods2/com.red30tech.movement.jmod

#Jlink
jlink --module-path $JAVA_HOME/jmods:jmods2/com.red30tech.movement.jmod:jmods/com.red30tech.axle.jmod:jmods/com.red30tech.chassis.jmod:jmods/com.red30tech.airbag.jmod:jmods/com.red30tech.driver.jmod --add-modules com.red30tech.driver --output jlink --launcher run=com.red30tech.driver/com.red30tech.driver.TestDriver
