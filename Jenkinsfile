pipeline {
    agent any

    environment {
        SNYK_TOKEN = credentials('dylans-demo-org-token')
    }

    stages {
        
        stage('Run Snyk Open Source') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk-plugin'
                )
            }
        }

        stage('Run Snyk Code') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk-plugin',
                    additionalArguments: '--code'
                )
            }
        }
    }
}
