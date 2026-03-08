pipeline {
    agent  {
        docker{
           image 'maven:3.9.9-eclipse-temurin-17'
        }

    }

    stages {
        stage('Run UI Tests') {
            steps {
                 sh 'mvn clean test -Dselenium.hub.url=http://localhost:57544/wd/hub'
            }
        }
    }
}