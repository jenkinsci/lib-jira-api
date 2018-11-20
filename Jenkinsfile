#!/usr/bin/env groovy
pipeline {
    agent { docker 'maven:3-alpine' }
    stages{
        stage("Build"){
            withMaven(
                    maven: 'mvn',
                    jdk: 'jdk8',
                    publisherStrategy: 'EXPLICIT') {
                sh "mvn clean install -B -U -e"
            }
        }
        stage ('Archive'){
            steps{
                junit 'target/surefire-reports/**/*.xml'
                archiveArtifacts artifacts: 'target/**/*.jar'
            }
        }
    }
}