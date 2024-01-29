<!-- pipeline {
    agent any
    
    environment {
        DEPLOY_DIR = "/path/to/deployment/directory"
        MYSQL_HOST = "localhost"
        MYSQL_PORT = "3306"
        MYSQL_DATABASE = "tse"
        MYSQL_USERNAME = "your_username"
        MYSQL_PASSWORD = "your_password"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Build the Maven project
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run tests if needed
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Define the deployment directory
                    dir(DEPLOY_DIR) {
                        // Copy the JAR file to the deployment directory
                        sh 'cp ../target/your-spring-boot-app.jar .'
                        
                        // Optionally, start the Spring Boot application
                        sh 'java -jar your-spring-boot-app.jar'
                    }
                }
            }
        }

        stage('Database Setup') {
            steps {
                script {
                    // Wait for MySQL to be ready
                    sh 'while ! nc -z $MYSQL_HOST $MYSQL_PORT; do sleep 1; done'
                    
                    // Run database setup scripts or migrations if needed
                    // Example: sh 'mysql -h $MYSQL_HOST -P $MYSQL_PORT -u $MYSQL_USERNAME -p$MYSQL_PASSWORD $MYSQL_DATABASE < db-setup.sql'
                }
            }
        }
    }
}
 -->