pipeline {
    agent any

    stages {
        stage('Run UI Tests') {
            steps {
                sh 'mvn clean test -Dselenium.hub.url=http://localhost:57544/wd/hub'
            }
        }
    }
}