// vars/dockerPush.groovy
def call(dockerImage) {
    // Access environment variables
    def dockerRegistry = env.DOCKER_REGISTRY
    def dockerRepo = env.DOCKER_REPO
    def credentialsId = env.HARBOR_CREDENTIALS_ID

    // Ensure required environment variables are set
    if (!dockerRegistry || !dockerRepo || !credentialsId) {
        error "Required environment variables (DOCKER_REGISTRY, DOCKER_REPO, HARBOR_CREDENTIALS_ID) are not set."
    }

    // Perform Docker push within the registry context
    docker.withRegistry("http://${dockerRegistry}", credentialsId) {
        dockerImage.push()
        dockerImage.push("${env.BUILD_ID}")
    }
}
