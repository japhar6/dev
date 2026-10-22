// Test du webhook GitHub - 22/10/2026
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
        post {
        failure {
            emailext(
                subject: "ECHEC du pipeline Jenkins : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """Le pipeline Jenkins a échoué.

Job : ${env.JOB_NAME}
Build : #${env.BUILD_NUMBER}
Consultez les logs : ${env.BUILD_URL}""",
                to: "TON_ADRESSE_GMAIL"
            )
        }
    }
}
