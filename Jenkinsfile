pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    environment {
        REPO = "https://github.com/BoMaseko/BongzSeleniumFrameworks.git"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                        credentialsId: 'github-selenium',
                        url: "${REPO}"
            }
        }

        stage('Build Project') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests on Grid') {
            steps {
                sh 'mvn test'
            }
        }

    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}