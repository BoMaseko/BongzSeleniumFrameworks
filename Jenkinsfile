pipeline {
    agent any

    environment {
        REPO = "https://github.com/BoMaseko/BongzSeleniumFrameworks.git"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
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
