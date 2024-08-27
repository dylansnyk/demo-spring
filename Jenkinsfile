pipeline {
  agent any

  environment {
      NODE_TLS_REJECT_UNAUTHORIZED = 0
  }

  stages {
    stage('Prepare') {
      steps {
        sh '''
          sudo apt-get install -y ca-certificates
        '''
      }
    }
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

            env
            
            docker image ls
  
            # Run Snyk
            ./snyk auth ${SNYK_TOKEN}
            ./snyk container monitor dylansnyk/demo-spring:latest --tags="component=pkg:dylansnyk/demo-spring@main" --file=Dockerfile -d
          '''
        }
      }
    }
  }
}
