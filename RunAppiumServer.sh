#!/bin/bash
set -ex
npm install -g appium
appium -
appium &>/dev/null &
