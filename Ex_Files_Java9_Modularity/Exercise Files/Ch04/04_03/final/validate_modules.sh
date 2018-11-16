#!/bin/bash
set -v

java --validate-modules --upgrade-module-path mods2 --module-path mods -m com.red30tech.axle/com.red30tech.axle.api.TestAxle
