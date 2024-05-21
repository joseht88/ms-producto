pipeline {
	agent any
	tools {
	    maven 'MAVEN'
	    nodejs 'NodeJS'
	}
	environment {
        POSTMAN_API_KEY = credentials('POSTMAN_API_KEY')
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
        //Revisa la calidad de código con SonarQube
        stage('Analysis SonarQube') {
           steps {
               	 sh 'mvn sonar:sonar -Dsonar.login=squ_3efe3bdf584ad2a8ef47e1e0ca6d169f77dff6bf -Dsonar.projectKey=sqape -Dsonar.projectName="SQAPE BackEnd" -Dsonar.host.url=http://172.19.231.56:9000'
               	 echo 'SonarQube Code review done'
           }
        }
    	//Empaqueta el proyecto y lo dejará en taget/project-1.0-SNAPSHOT.jar
    	stage('Build') {
	       steps {
			   sh 'mvn package -DskipTests'
			   echo 'Packaging project'
			}
       	}
		
		stage('Install Postman CLI') {
			steps {
				sh 'sudo curl -o- "https://dl-cli.pstmn.io/install/linux64.sh" | sh'
				echo '$POSTMAN_API_KEY'
				echo '${POSTMAN_API_KEY}'
				echo $POSTMAN_API_KEY
				bat 'echo %POSTMAN_API_KEY%'				
				
			}
		}

		stage('Postman CLI Login') {
			steps {
				sh 'postman login --with-api-key ${POSTMAN_API_KEY}'
			}
		}

		stage('Running collection') {
			steps {
				sh 'postman collection run "9353983-8d7d5a24-1f67-4208-9695-9313f5c231a0"-e "9353983-e9145a7a-d1cf-4584-887b-2f9a1393e432"'
			}
		}
	}
}