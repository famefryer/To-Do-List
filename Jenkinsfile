pipeline {
    agent any

    environment {
        dockerImage = ''
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests -X clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build image') {
            steps {
                script {
                    dockerImage = docker.build("phayao/my-app")
                }
            }
        }
        stage('Deployment') {
            steps {
                sh 'kubectl apply -f myapp-deployment.yml';
            }
        }
    }
}
