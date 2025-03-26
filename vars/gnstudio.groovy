// vars/gitClone.groovy
def call() {
    def gitCredentialsId = env.GIT_CREDENTIALS_ID

    withCredentials([string(credentialsId: gitCredentialsId, variable: 'MY_GIT_TOKEN')]) {
        def gitRepoUrl = "https://digvijaynath:${env.MY_GIT_TOKEN}@bitbucket.org/thppython/gnstudio.git"

        git url: gitRepoUrl, branch: 'master' 
    }
}
