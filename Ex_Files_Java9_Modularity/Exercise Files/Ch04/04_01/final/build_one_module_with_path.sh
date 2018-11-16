#!/bin/bash   
set -v

javac -d ./mods/ --module-path mods --module com.red30tech.axle --module-source-path src
