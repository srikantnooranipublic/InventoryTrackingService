#!/bin/bash

echo "Starting Docker App Scripts"

PWD_NEW=`echo $PWD | sed 's_/_\\\\/_g'`
sed 's/RUNTIME_FOLDER/'$PWD_NEW'/g' run.sh > run.sh.changed
/bin/mv -f run.sh.changed run.sh

chmod 755 run.sh

cp -f ../../target/InventoryTrackingService-1.1.1-SNAPSHOT.jar APP_FILES/InventoryTrackingService.jar


IS_APM_AGENT_UP=`docker ps |grep apm-agent`

if [ x"$IS_APM_AGENT_UP" == "x" ] 
then 
   	echo "APM Agent Not running"

	echo "Docker App cleanup"

	./cleanup.sh

	echo "Docker App build image"

	./build.sh

	echo "Docker App run app "

	./run.sh
fi
