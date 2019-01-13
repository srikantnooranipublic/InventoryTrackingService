#!/bin/bash
  
echo "Starting Docker JMETER Scripts"

IS_JMETER_UP=`docker ps |grep jmeter`

if [ x"$IS_JMETER_UP" == "x" ]
then 
        echo "APM Agent Not running"

	echo "Docker Jmeter cleanup"

	./cleanup.sh
	
	echo "Docker Jmeter build image"
	
	./build.sh
	
	echo "Docker Jmeter run app "
	
	./run.sh
fi
