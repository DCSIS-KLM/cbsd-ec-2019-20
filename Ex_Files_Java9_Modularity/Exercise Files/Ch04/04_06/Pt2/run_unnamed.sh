#!/bin/bash
set -v

java --module-path bin --add-modules ALL-MODULE-PATH -cp classes com.red30tech.axle.api.TestAxle
