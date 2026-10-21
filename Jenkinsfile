
pipeline {
    agent any

    tools {
        maven 'Maven-3.10.0'
    }

    stages {
        stage('git checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/japhar6/dev.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B compile'
            }
        }

        stage('Unit Test Execution') {
            steps {
                bat 'mvn -B test'
            }
        }

        stage('Build the docker image') {
            steps {
                bat 'mvn -B package -DskipTests'
                bat 'docker build --tag japhar06/jenkins-tp2:1.0.0 .'
            }
        }

        stage('Push the docker image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKERHUB_USER',
                    passwordVariable: 'DOCKERHUB_TOKEN'
                )]) {
                    bat '''
                        @echo off
                        echo %DOCKERHUB_TOKEN%| docker login -u %DOCKERHUB_USER% --password-stdin
                        docker push %DOCKERHUB_USER%/jenkins-tp2:1.0.0
                    '''
                }
            }
        }
    }
}
