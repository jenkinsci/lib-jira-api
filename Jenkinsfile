#!/usr/bin/env groovy
node("linux") {
    timestamps {
        stage('Checkout') {
            checkout scm
        }

        stage('Build') {
            withEnv([
                    "JAVA_HOME=${tool 'jdk8'}",
                    "PATH+MVN=${tool 'mvn'}/bin",
                    'PATH+JDK=$JAVA_HOME/bin',
            ]) {
                timeout(60) {
                    sh 'mvn --batch-mode clean install -Dmaven.test.failure.ignore=true'
                }
            }
        }

        stage('Archive') {
            junit testResults: '**/target/surefire-reports/TEST-*.xml', allowEmptyResults: true
            archiveArtifacts artifacts: '**/target/**/*.jar'
            findbugs pattern: '**/target/findbugsXml.xml'
        }
    }
}
