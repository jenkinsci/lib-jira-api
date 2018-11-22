#!/usr/bin/env groovy
pipeline {
    agent { docker 'maven:3-alpine' }
    stages{
        stage('Build'){
            steps{
                withMaven(
                        maven: 'mvn',
                        jdk: 'jdk8') {
                    sh "mvn clean install -B -U -e"
                }
            }
        }
    }
}