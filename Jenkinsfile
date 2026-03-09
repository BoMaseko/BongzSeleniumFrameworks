pipeline {
    agent {
        kubernetes {
            yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3.9.9-eclipse-temurin-17
    command:
    - cat
    tty: true
"""
        }
    }

    stages {
        stage('Run UI Tests') {
            steps {
                container('maven') {
                    sh 'mvn clean test -Dselenium.hub.url=http://selenium-hub.selenium:4444/wd/hub'
                }
            }
        }
    }
}