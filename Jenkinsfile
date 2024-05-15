pipeline {
	agent any
	tools {
	    maven 'MAVEN'
	}
	stages {
	    stage('Preparation') {
    	   steps {
   	      		git 'https://github.com/joseht88/ms-producto.git'
   	       		echo 'Pulled from github successfully'
   	    	}
    	}
    	
	    stage('compile the code to executable format'){
            steps{
                sh 'mvn clean compile'
                echo 'converted the code from human readable to machine readable '
            }
        }
        
	    stage('Initiation Test') {
    	   steps {
				sh 'mvn test'
			  	echo 'Unit Test successfully'
   	    	}
    	}
    	
    	stage('code review to check quality of code'){
            steps{
                sh 'mvn pmd:pmd'
                echo 'code review done'
            }
        }
    	
    	stage('Build') {
	       steps {
			   sh 'mvn clean package -DskipTests'
			   notifyStarted("Error package")
			}
       	}
	}
}
	

def notifyStarted(String message) {
		slackSend (
			color: '#a52019',
			message: "${message}: JOB '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
		)
	}