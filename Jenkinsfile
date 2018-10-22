node("docker") {
    ansiColor("xterm") {
        docker.image("runmymind/docker-android-sdk:ubuntu-standalone").inside("-u 0:0") {
            stage('Preparation') {
                git branch: 'master', url: 'git@github.com:bitbar/flash-screen-app.git', credentialsId: 'f652697e-beb7-4724-b1b5-4913a2bf45f5'
            }
            stage('Gradle') {
                sh "/opt/android-sdk-linux/tools/bin/sdkmanager --install 'platforms;android-22' 'build-tools;25.0.3'"
                sh "./gradlew clean assemble"
            }
            stage('Archive artifacts') {
                archiveArtifacts "app/build/outputs/apk/app-debug.apk"
            }
        }
    }
}
