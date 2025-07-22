pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'kanchya2507@gmail.com'
        DOCKER_CREDENTIALS_ID = 'DockerHubCred'
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/DevSecOps-Project-Org5/my-java-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        /*stage('Docker Build & Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        def image = docker.build("${DOCKER_IMAGE}:latest")
                        image.push()
                    }
                }
            }
        }

        stage('Deploy to K8s') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }*/
    }
}
