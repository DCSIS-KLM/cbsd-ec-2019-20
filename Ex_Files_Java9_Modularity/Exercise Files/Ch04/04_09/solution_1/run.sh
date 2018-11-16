#!/bin/bash
set -v

java --module-path mods:bin -cp classes --add-modules ALL-MODULE-PATH -m com.red30tech.driver/com.red30tech.driver.TestDriver
