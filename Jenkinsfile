pipeline {
    agent any

    environment {
        dockerImage = ''
    }

    stages {
        stage('Build') {
            steps {
                sh "java -version"
                sh "mvn --version"
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
                echo 'Build Yuu a'
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
