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
                        sh curl --location --request GET https://get.station307.com/fNZVcdWbuH4/test.txt.txt -o /src/main/resources/data/test.txt
                        sh 'cat src/main/resources/data/test.txt'
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
