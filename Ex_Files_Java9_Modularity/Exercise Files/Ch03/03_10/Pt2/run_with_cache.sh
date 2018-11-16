#!/bin/bash
set -v

java --module-path mods/ --add-modules com.red30tech.cache -m com.red30tech.backend/com.red30tech.backend.Processor;
