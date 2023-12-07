#!/usr/bin/env groovy
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t abendong/group-pipeline:jma-1.3 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push abendong/group-pipeline:jma-1.3'
    }
} 
