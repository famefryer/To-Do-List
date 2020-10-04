pipeline {
    agent any

    environment {
        dockerImage = ''
        registry = "famefryer12/todolist"
        registryCredential = 'dockerhub'
    }

    stages {
        stage('Build') {
            steps {
                sh pwd
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
                    dockerImage = docker.build("famefryer12/todolist")
                }
            }
        }
        stage('Push image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deployment') {
            steps {
                sh 'kubectl apply -f deployment.yml';
            }
        }
    }
}
