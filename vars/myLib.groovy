// vars/myLib.groovy
def call() {
    // Access environment variables
    def dockerRegistry = env.DOCKER_REGISTRY
    def dockerRepo = env.DOCKER_REPO
    def imageName = "${dockerRegistry}/${dockerRepo}:latest"
    def credentialsId = env.HARBOR_CREDENTIALS_ID

    // Ensure all required environment variables are set
    if (!dockerRegistry || !dockerRepo || !credentialsId) {
        error "Required environment variables (DOCKER_REGISTRY, DOCKER_REPO, HARBOR_CREDENTIALS_ID) are not set."
    }

    // Perform Docker pull within the registry context
    docker.withRegistry("http://${dockerRegistry}", credentialsId) {
        def appImage = docker.image(imageName)
        appImage.pull()
    }
}
