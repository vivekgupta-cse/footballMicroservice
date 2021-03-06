pipeline {
	agent any
	
	environment {
	    dockerHome = tool 'myDocker'
	    mavenHome = tool 'myMaven'
	    PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}

	stages {
	    stage('Checkout') {
	        steps {
	            echo "Build"
	            echo "PATH - $PATH"
	            echo "BUILD_NUMBER - $env.$BUILD_NUMBER"
	            echo "BUILD_ID - $env.$BUILD_ID"
	            echo "JOB_NAME - $env.$BUILD_NUMBER"
	            echo "BUILD_TAG - $env.$BUILD_TAG"
	            echo "BUILD_URL - $env.$BUILD_URL"
	            sh 'mvn --version'
	        	sh 'docker version'
	        }
	    }
	    stage('Compile') {
	        steps {
	            sh "mvn -f pom.xml clean package"
	        }
	    }

		stage('Test') {
	        steps {
				sh "mvn test"
	        }
	    }
	    stage('Deploy') {
	        steps {
				/*
	        		This command will start the container in the daemon mode
	        	*/
	        	//sh '''#!/bin/bash
                // docker ps -q --filter 'name=myfootballservice'| grep -q . && docker stop myfootballservice && docker rm -fv myfootballservice 
         		//''' 
				
				/*
	        		This command will check if there is a docker container 
	        		with given name already running, then stop it and delete the container
	        	*/
				sh "docker run -p 9001:9000 -d --name myfootballservice vivek/footballservice"
	        }
	    }
	    stage('Integration Test') {
	        steps {
				sh "mvn failsafe:integration-test failsafe:verify"
	        }
	    }
	} 
	
	post {
	      always {
	          echo 'ALL STAGES COMPLETED RUNNING :) '
	      }
	      success {
	          echo 'SUCCESS :D'
	      }
	      failure {
	          echo 'FAILURE :('
	      }
	  }
}
