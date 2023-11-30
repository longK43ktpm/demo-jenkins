pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Checkout code') {
            steps {
                git 'https://github.com/longK43ktpm/demo-jenkins.git'
            }
        }
        
        stage('Static Code Analysis') {
            steps {
                bat "mvn pmd:pmd"
                bat "mvn checkstyle:checkstyle" 
            }
        }
        
        stage('compile and Unit test') {
            steps {
                bat "mvn clean compile test"
            }
        }
        
        stage('Check for pom.xml') {
          steps {
            fileExists 'pom.xml'
          }
        }
    
        stage('Build Spring Boot JAR file') {
            steps {
                bat "mvn clean package spring-boot:repackage"
            }
        }
        
        stage('Build Docker Image') {
              steps {
                bat "docker build -t longk43ktpm/demo-springboot-image:latest ."
              }
        }
        
        stage('Deploy to DockerHub') {
            steps {
                script {
                    withCredentials ([usernamePassword (credentialsId: 'dockerhub-credentials', 
                    usernameVariable: 'USERNAME', 
                    passwordVariable: 'PASSWORD')]) {
                        bat "docker login --username $USERNAME --password $PASSWORD" 
                        bat "docker push longk43ktpm/demo-springboot-image:latest"
                    }
                }
            }
        }
    }
}
