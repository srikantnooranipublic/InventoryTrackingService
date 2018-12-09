properties([pipelineTriggers([githubPush()])])

node {
   def mvnHome
   stage('Checkin') { // for display purposes

        echo "branch is ${branch}"

        def exists = fileExists '${branch}'
        if (!exists){
            new File('$branch').mkdir()
       }

       dir ("${branch}") {
          git branch: '${branch}',
             //url: 'https://github.com/srikns/InventoryTrackingService.git'
             url: 'git@github.com:srikns/InventoryTrackingService.git'
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
        //sh 'scp target/*.jar root@10.238.238.40:/opt/ca/JenkinsPipelineApp/springBootApp'
       //#sh "ssh root@10.238.238.40 'sh -c  /opt/ca/JenkinsPipelineApp/springBootApp/runProcess > /dev/null  &'"

	dir ("docker") {
		echo "its pwd  $PWD"
		sh "sudo ./clean.sh"
		sh "sudo ./build.sh"
		sh "sudo ./run.sh"
		
	}
	
      }

   }
}
