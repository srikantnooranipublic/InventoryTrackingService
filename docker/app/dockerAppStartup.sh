#!/bin/bash

echo "Starting Docker App Scripts"

PWD_NEW=`echo $PWD | sed 's_/_\\\\/_g'`
sed 's/RUNTIME_FOLDER/'$PWD_NEW'/g' run.sh > run.sh.changed
/bin/mv -f run.sh.changed run.sh

chmod 755 run.sh


echo "Docker App cleanup"

./clean.sh

echo "Docker App build image"

./build.sh

echo "Docker App run app "

./run.sh
