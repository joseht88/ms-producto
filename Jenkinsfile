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
    	//Compila el codigo en formato ejecutable
	    stage('Compile the code to executable format'){
            steps{
                sh 'mvn clean compile'
                echo 'Convirtió el código legible por humanos a legible por máquina'
            }
        }
        //compila los test y los ejecuta
	    stage('Testing the code') {
    	   steps {
				sh 'mvn test'
			  	echo 'Unit Test successfully'
   	    	}
    	}
    	//Revisa la calidad de código
    	stage('Code review to check quality of code'){
            steps{
                sh 'mvn pmd:pmd'
                echo 'Code review done'
            }
        }
        
        stage('Analysis SonarQube') {
           steps {
               	 sh 'mvn sonar:sonar -Dsonar.login=squ_3efe3bdf584ad2a8ef47e1e0ca6d169f77dff6bf -Dsonar.projectKey=sqape -Dsonar.projectName="SQAPE BackEnd" -Dsonar.host.url=http://172.19.231.56:9000'
               
           }
        }
    	//Empaqueta el proyecto y lo dejará en taget/project-1.0-SNAPSHOT.jar
    	stage('Build') {
	       steps {
			   sh 'mvn package -DskipTests'
			   notifyStarted("Error package")
			}
       	}
	}
}
	

//def notifyStarted(String message) {
//		slackSend (
//			color: '#a52019',
//			message: "${message}: JOB '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
//		)
//	}