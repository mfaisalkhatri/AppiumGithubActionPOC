#!/bin/bash
set -ex
npm install -g appium
appium -v
appium &>/dev/null &
appium -a 127.0.0.1
