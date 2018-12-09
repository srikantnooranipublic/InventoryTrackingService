docker run -d \
-p 8999:8080 \
-v RUNTIME_FOLDER/logs:/opt/ca/springbootApp/wily/logs \
--name=apm-agent \
apm-agent:latest
