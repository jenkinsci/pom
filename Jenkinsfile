#!/usr/bin/env groovy

node('java') {
        timestamps {
                stage('Checkout') {
                        checkout scm
                }

                stage('Build') {
                        withEnv([
                                "JAVA_HOME=${tool 'jdk25'}",
                                "PATH+MVN=${tool 'mvn'}/bin",
                                'PATH+JDK=$JAVA_HOME/bin',
                        ]) {
                                timeout(30) {
                                        sh 'mvn clean install versions:display-plugin-updates'
                                }
                        }
                }
        }
}
