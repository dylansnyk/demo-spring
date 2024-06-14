pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        script {
          docker.build("dylansnyk/demo-spring:latest")
        }
      }
    }
    stage('Install and Run Snyk') {
      steps {
        withCredentials([string(credentialsId: 'snyk-insights-api-token', variable: 'SNYK_TOKEN')]) {
          sh '''
            # Install Snyk
            curl -Lo snyk https://static.snyk.io/cli/latest/snyk-linux
            chmod +x snyk
            mv snyk /usr/local/bin
  
            # Run Snyk
            snyk auth ${SNYK_TOKEN}
            snyk container monitor dylansnyk/demo-spring:latest --tags=component=pkg:dylansnyk/demo-spring@main --file=Dockerfile
          '''
        }
      }
    }
  }
}
