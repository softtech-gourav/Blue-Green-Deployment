// src/org/TVProject/gitClone.groovy
package org.TVProject

import hudson.model.*
import jenkins.model.*

class GitClone {
    static void execute(script) {
        def gitCredentialsId = script.env.GIT_CREDENTIALS_ID

        script.withCredentials([script.string(credentialsId: gitCredentialsId, variable: 'MY_GIT_TOKEN')]) {
            def gitRepoUrl = "https://digvijaynath:${script.env.MY_GIT_TOKEN}@bitbucket.org/thppython/tv.git"

            script.git url: gitRepoUrl, branch: 'master'
        }
    }
}
