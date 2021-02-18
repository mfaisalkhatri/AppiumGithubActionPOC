#!/bin/bash
set -ex
appium -v
appium &>/dev/null &
appium -a 127.0.0.1 &
