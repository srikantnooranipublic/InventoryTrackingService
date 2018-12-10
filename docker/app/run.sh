docker run -d \
-p 8999:8080 \
-v /Users/noosr03/Documents/CA_Technical/2_ProjectRepo/InventoryTrackingService/docker/app/logs:/opt/ca/springbootApp/wily/logs \
--name=apm-agent \
apm-agent:latest
