def call(String branch = 'master') {
    def repoUrl = 'https://digvijaynath:GsbMfY7XXxy6vPFWsNzU@bitbucket.org/thppython/tv.git'
    return [url: repoUrl, branch: branch]
}
