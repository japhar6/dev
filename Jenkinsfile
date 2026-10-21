pipeline {
    agent any

    tools {
        maven 'Maven-3.9.12'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build et tests Maven') {
            steps {
                bat 'mvn -B clean verify'
            }
        }

        stage('Construction Docker') {
            steps {
                bat 'docker build -t jenkins-tp2:1.0 .'
            }
        }
    }

    post {
        success {
            echo 'Pipeline reussi : Maven, tests et Docker.'
        }
        failure {
            echo 'Echec du pipeline. Consulter la console.'
        }
    }
}