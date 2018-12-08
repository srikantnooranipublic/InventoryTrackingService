#FROM centos
FROM java:8
# install image

LABEL MAINTAINER="srikant.noorani@ca.com"

WORKDIR /opt/ca/springbootApp

ENV APP_HOME=/opt/ca/springbootApp\
    APP_FILES=./APP_FILES\
    AGENT_FILE=tomcat-7.0.146.tar\
    APP_JAR=InventoryTrackingService.jar\
    AGENT_PROFILE=IntroscopeAgent.profile\
    CUSTOM_PBD=./${APP_FILES}/UserDaoBE.pbd\
    SPRING_BOOT_PBD=spring-boot.pbd\
    SPRING_BOOT_JAR=spring-boot.jar
    

RUN curl http://truss.ca.com/builds/InternalBuilds/10.7.0-ISCP/build-992308\(10.7.0.146\)/introscope10.7.0.146/IntroscopeAgentFiles-NoInstaller10.7.0.146tomcat.unix.tar -o ${AGENT_FILE} \
  && tar xf  ${APP_HOME}/${AGENT_FILE} 

RUN curl http://172.17.0.1:8989/artifactory/list/libs-release-local/com/example/springboot/InventoryTrackingService/1.1.3/InventoryTrackingService-1.1.3.jar -o ${APP_JAR} 

COPY ${APP_FILES}/${AGENT_PROFILE} ${APP_HOME}/wily/core/config
COPY ${APP_FILES}/${SPRING_BOOT_JAR} ${APP_HOME}/wily/core/ext
COPY ${APP_FILES}/${SPRING_BOOT_PBD} ${APP_HOME}/wily/core/config
COPY ${APP_FILES}/${CUSTOM_PBD} ${APP_HOME}/wily/core/config/hotdeploy

COPY ["${APP_FILES}/entrypoint.sh", "/"]

RUN   chmod +x /entrypoint.sh

expose 8999

#ENTRYPOINT ["/entrypoint.sh"]
