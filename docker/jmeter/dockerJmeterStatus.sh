#!/bin/bash
  
echo "Starting Docker JMETER Scripts"

echo "Docker Jmeter cleanup"

./cleanup.sh

echo "Docker Jmeter build image"

./build.sh

echo "Docker Jmeter run app "

./run.sh
