#!/usr/bin/env groovy
pipeline {
    agent { docker 'maven:3-alpine' }
    stages{
        stage("Build"){
            steps{
                withMaven(
                        maven: 'mvn',
                        jdk: 'jdk8',
                        publisherStrategy: 'EXPLICIT') {
                    sh "mvn clean install -B -U -e"
                }
            }
        }
        stage ('Archive'){
            steps{
                junit testResults:'target/surefire-reports/**/*.xml', allowEmptyResults: true
                archiveArtifacts artifacts: 'target/**/*.jar'
            }
        }
    }
}