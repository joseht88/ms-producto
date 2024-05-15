pipeline {
	agent any
	tools {
	    maven 'MAVEN'
	}
	stages {
	    stage('Checkout from github') {
    	   steps {
   	      // 	git 'https://github.com/joseht88/ms-producto.git',
   	      // 	notifyStarted("Checkout from github ----------------")
   	       	echo 'Pulled from github successfully'
   	    	}
    	}
	    
	    stage('Initiation Test') {
    	   steps {
	   	       
		        	sh 'mvn clean test'
			  echo 'Unit Test successfully'
   	    	}
    	}
    	
    	stage('Build') {
	       steps {
			   // try{
			   //     sh 'mvn clean package -DskipTests'
			   // } catch(e){
			        notifyStarted("Error package")
			     //   throw e
			   // }
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