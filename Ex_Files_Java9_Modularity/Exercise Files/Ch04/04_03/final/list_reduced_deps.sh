#!/bin/bash
set -v

jdeps --list-reduced-deps --module-path mods/ mods/com.red30tech.driver
