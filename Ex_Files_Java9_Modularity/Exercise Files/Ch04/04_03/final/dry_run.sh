#!/bin/bash
set -v

java --module-path mods/ --dry-run -m com.red30tech.driver/com.red30tech.driver.TestDriver
