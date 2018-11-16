#!/bin/bash
set -v

java --module-path mods/ --show-module-resolution -m com.red30tech.driver/com.red30tech.driver.TestDriver
