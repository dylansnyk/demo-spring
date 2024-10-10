pipeline {
    agent any

    stages {
        
        stage('Run Snyk Open Source') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk@latest',
                    snykTokenId: 'dylans-demo-org-token'
                )
            }
        }

        stage('Run Snyk Code') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk@latest',
                    additionalArguments: '--code',
                    snykTokenId: 'dylans-demo-org-token'
                )
            }
        }
    }
}
