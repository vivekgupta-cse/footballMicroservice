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
	        	sh "docker container stop myfootballservice"
	        	sh "docker container rm myfootballservice"
				sh "docker run -p 9001:9000 -d --name myfootballservice vivek/footballservice"
	        }
	    }
	    stage('Integration Test') {
	        steps {
				echo "Integration Test"
	        }
	    }
	} 
	
	post {
	      always {
	          echo 'I am awesome. I run always'
	      }
	      success {
	          echo 'I run when you are successful'
	      }
	      failure {
	          echo 'I run when you fail'
	      }
	  }
}
