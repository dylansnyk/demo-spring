pipeline {
    agent any

    stages {
        
        stage('Run Snyk Open Source') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk-plugin',
                    snykTokenId: 'dylans-demo-org-token'
                )
            }
        }

        stage('Run Snyk Code') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk-plugin',
                    additionalArguments: '--code',
                    snykTokenId: 'dylans-demo-org-token'
                )
            }
        }
    }
}
