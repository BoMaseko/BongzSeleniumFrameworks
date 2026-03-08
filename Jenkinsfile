pipeline {
    agent any

    environment {
        GRID_URL = "http://localhost:57544/wd/hub"
    }

    stages {
        stage('Run UI Tests') {
            steps {
                // if Python
                //sh 'pip install -r requirements.txt'
                //sh "python run_tests.py --hub ${GRID_URL}"

                // OR if Java framework
                 sh 'mvn clean test -Dselenium.hub.url=${GRID_URL}'
            }
        }
    }
}