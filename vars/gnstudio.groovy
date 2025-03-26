def call() {
    def gitCredentialsId = env.GIT_CREDENTIALS_ID

    if (!gitCredentialsId) {
        error "GIT_CREDENTIALS_ID is not set in the environment."
    }

    def gitRepoUrl = 'https://bitbucket.org/thppython/gnstudio.git'

    git url: gitRepoUrl, branch: 'master', credentialsId: gitCredentialsId
}
