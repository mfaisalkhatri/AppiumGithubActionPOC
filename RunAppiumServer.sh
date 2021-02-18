#!/bin/bash
set -ex
npm install -g appium
appium -v
appium &>/dev/null &
appium -a 0.0.0.0
