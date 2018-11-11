node {
   def mvnHome
   stage('Checkout') { // for display purposes

        echo "branch is ${branch}"

        def exists = fileExists '${branch}'
        if (!exists){
            new File('$branch').mkdir()
       }

       dir ("${branch}") {
           git branch: '${branch}',
             url: 'https://github.com/srikns/ResourceRetirievalService.git'
     }
      mvnHome = tool 'M2'

   }
   stage('Build the App') {
      echo "Maven Build"

      dir ("${branch}") {
        sh 'mvn clean package'
      }
   }
   stage('Deploy') {
      echo "Deploying the application "

      dir ("${branch}") {
        //wget http://oerth-scx.ca.com:8081/artifactory/repo/com/ca/apm/delivery/agent-noinstaller-tomcat-unix/10.7.0.136/agent-noinstaller-tomcat-unix-10.7.0.136.tar
        sh 'scp target/*.jar root@10.238.238.40:/opt/ca/JenkinsPipelineApp/springBootApp'
       sh "ssh root@10.238.238.40 'sh -c  /opt/ca/JenkinsPipelineApp/springBootApp/runProcess > /dev/null  &'"
      }

   }
    stage('Blazemeter Test') {
      echo "Blazemeter Test"
      sleep(time:60,unit:"SECONDS")
  /*    blazeMeterTest credentialsId: 'b30b0832-001f-4f20-b374-f00e6569ed10',
       getJtl: true,
       getJunit: true,
       testId: '6403714',
       workspaceId: '111614'

*/
   }
   stage('CA APM Plugin') {
      echo "CA APM Plugin ${env.WORKSPACE}"


        caapmplugin "${env.WORKSPACE}/develop/caapm-performance-comparator-1.0/properties/performance-comparator.properties"

   }
      stage ('Publish CA APM Comparison Reports') {
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${env.BUILD_NUMBER}/", reportFiles: 'chart-output.html', reportName: 'CA APM Comparison Reports', reportTitles: ''])
   }
   stage ('Mail Notification') {
       echo "Mail Notification"

       mail to: "srikns@yahoo.com",
       body: "Something Went Wrong in the Build",
       subject: "Jenkins ${currentBuild.fullDisplayName}"
   }
}
