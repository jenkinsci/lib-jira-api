#!/usr/bin/env groovy
pipeline {
    agent { docker 'maven:3-alpine' }
    stages{
        stage('Build'){
            steps{
                withMaven(
                        maven: 'mvn',
                        jdk: 'jdk8',
                        options: [junitPublisher(disabled: false),artifactsPublisher(disabled: true)],
                        publisherStrategy: 'EXPLICIT') {
                    sh "mvn clean install -B -U -e"
                }
            }
        }
    }
}