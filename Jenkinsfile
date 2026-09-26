pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t myspringbootproject-newzen:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop MySpringBootProject-NewZen || true
                    docker rm MySpringBootProject-NewZen || true

                    docker run -d \
                      --name MySpringBootProject-NewZen \
                      --add-host=host.docker.internal:host-gateway \
                      -p 8081:8081 \
                      -e DB_URL="jdbc:mysql://host.docker.internal:3306/test" \
                      -e DB_USERNAME="root" \
                      -e DB_PASSWORD="root" \
                      MySpringBootProject-NewZen:latest

                    echo "Waiting for application to start..."
                    sleep 15

                    echo "Container status:"
                    docker ps -a --filter "name=MySpringBootProject-NewZen"

                    if [ "$(docker inspect -f '{{.State.Running}}' MySpringBootProject-NewZen)" != "true" ]; then
                        echo "Container failed to start!"
                        echo "Container logs:"
                        docker logs MySpringBootProject-NewZen
                        exit 1
                    fi

                    echo "Container is running successfully!"
                '''
            }
        }
    }

    post {
        success {
            echo 'Build, Test, Docker Build and Deployment completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
