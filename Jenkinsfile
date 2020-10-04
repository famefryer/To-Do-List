pipeline {
    agent any

    environment {
        dockerImage = ''
        registry = "famefryer12/todolist"
        registryCredential = 'dockerhub'
    }

    stages {
        stage('Download file'){
            steps{
                waitUntil{
                    script{
                        def r = sh script: 'curl --location --request GET https://get.station307.com/7QPOceD2gY5/test.txt -O src/main/resources/data/test.txt', returnStdout: true
                        sh 'cat src/main/resources/data/test.txt'
                        return (r == 0);
                    }
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Build project'
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
                echo 'Build Image Yuu a'
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
