pipeline {
	agent any
	tools {
	    mvn 'MAVEN'
	}
	stages {
	    stage('Clonar el proyecto') {
    	   steps {
   	       	git branch: 'master', url: 'https://github.com/joseht88/ms-producto.git'
   	    	}
    	}
	    
	    stage('Initiation Test') {
    	   steps {
	   	        try {
		        	sh 'mvn clean test'
			    } catch(e){
			        notifyStarted("Error test unit")
			        throw e
			    }
   	    	}
    	}
    	
    	stage('Build') {
	       steps {
			    try{
			        sh 'mvn clean package -DskipTests'
			    } catch(e){
			        notifyStarted("Error package")
			        throw e
			    }
			}
       	}
	}
}
	

def notifyStarted(String message) {
		slackSend (
			color: '#FFFF00',
			message: "${message}: JOB '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
		)
	}