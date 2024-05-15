node {
	//agent any
	tools {
	    mvn 'MAVEN'
	}
	
	stage('Clonar el proyecto'){
		git branch: 'master', url: 'https://github.com/joseht88/ms-producto.git'            
	    }
	    
	stage('Ejecutar Test Unit'){
	    try {
	        sh 'mvn clean test'
	    } catch(e){
	        notifyStarted("Error test unit")
	        throw e
	    }
	}
	
	stage('Build') {
	    try{
	        sh 'mvn clean package -DskipTests'
	    } catch(e){
	        notifyStarted("Error package")
	        throw e
	    }
	}

	stage('Result'){
	    try {
	    archive 'target/*.jar'
	    } catch(e){
	        notifyStarted("Error packaging failed in Jenkins")
	        throw e 
	    }
	}
}


def notifyStarted(String message) {
		slackSend (
			color: '#FFFF00',
			message: "${message}: JOB '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
		)
	}