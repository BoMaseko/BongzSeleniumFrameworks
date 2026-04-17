pipeline {
    agent {
        kubernetes {
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3.9.6-eclipse-temurin-17
    command: ["sleep"]
    args: ["infinity"]
    resources:
      requests:
        memory: "512Mi"
        cpu: "500m"
      limits:
        memory: "1Gi"
        cpu: "1"
'''
            defaultContainer 'maven'
        }
    }

    environment {
        REPO = "https://github.com/BoMaseko/BongzSeleniumFrameworks.git"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
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
            archiveArtifacts artifacts: '**/extent-test-output/**', allowEmptyArchive: true
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}
