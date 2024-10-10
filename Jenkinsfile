pipeline {
    agent any

    stages {

        stage('Install jq') {
            steps {
                sh 'sudo apt-get update && sudo apt-get install -y jq'
            }
        }
        
        stage('Run Snyk Open Source') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk@latest',
                    snykTokenId: 'dylans-demo-org-token',
                    additionalArguments: '--json-file-output=sca.json'
                )
            }
        }

        stage('Run Snyk Code') {
            steps {
                snykSecurity(
                    failOnIssues: false,
                    monitorProjectOnBuild: false,
                    snykInstallation: 'snyk@latest',
                    snykTokenId: 'dylans-demo-org-token',
                    additionalArguments: '--code --json-file-output=sast.json'
                )
            }
        }

        stage('Post scan validation') {
            steps {
                sh '''
                    SCA_COUNT=$(cat sca.json | jq '.uniqueCount')
                    echo "There are $SCA_COUNT unique vulnerabilities. The limit is 10."
                    [ $SCA_COUNT -lt 10 ]
                '''
            }
        }
    }
}
