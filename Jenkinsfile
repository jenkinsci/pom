properties([
  buildDiscarder(logRotator(numToKeepStr: '10')),
  disableConcurrentBuilds(abortPrevious: true)
])

node('maven-8') {
  stage('Checkout') {
    infra.checkoutSCM()
  }

  stage('Build') {
    timeout(time: 30, unit: 'MINUTES') {
      def mavenOptions = [
        '-Dset.changelist',
        'clean',
        'install',
        'versions:display-plugin-updates',
      ]
      infra.runMaven(mavenOptions, 8)
      infra.prepareToPublishIncrementals()
    }
  }
}

infra.maybePublishIncrementals()
