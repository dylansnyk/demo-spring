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
                    additionalArguments: '--code --json-file-output=sca.json',
                )
            }
        }

        stage('Run Snyk Code') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk@latest',
                    snykTokenId: 'dylans-demo-org-token'
                    additionalArguments: '--code --json-file-output=sast.json'
                )
            }
        }
    }
}
