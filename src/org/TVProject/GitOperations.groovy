package org.TVProject  // Define the package

class GitOperations implements Serializable {
    def steps
    def env

    GitOperations(steps, env) {  
        this.steps = steps
        this.env = env
    }

    def cloneRepository() {
        def gitCredentialsId = env.GIT_CREDENTIALS_ID  // Get credentials from env

        steps.withCredentials([steps.string(credentialsId: gitCredentialsId, variable: 'MY_GIT_TOKEN')]) {
            def gitRepoUrl = "https://digvijaynath:${env.MY_GIT_TOKEN}@bitbucket.org/thppython/tv.git"
            steps.git url: gitRepoUrl, branch: 'master'
        }
    }
}
