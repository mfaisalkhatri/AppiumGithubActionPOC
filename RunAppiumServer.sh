#!/bin/bash
set -ex
appium -v
appium -a 127.0.0.1 &
appium &>/dev/null &
