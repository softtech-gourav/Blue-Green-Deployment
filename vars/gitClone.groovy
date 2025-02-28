def call(String credentialsId, String repoUrl, String branch = 'master') {
    withCredentials([string(credentialsId: credentialsId, variable: 'GIT_TOKEN']) {
        // Construct the Git URL with the token
        def fullRepoUrl = "https://${GIT_TOKEN}@${repoUrl}"
        
        // Clone the repository
        git url: fullRepoUrl, branch: branch
    }
}
