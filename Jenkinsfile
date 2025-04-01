import groovy.json.JsonSlurperClassic

def jsonParse(def json) {
    return new JsonSlurperClassic().parseText(json)
}

pipeline {
    agent any

    environment {
        app = "variable"
        GRADLE_HOME = tool 'Gradle'
         JAVA_HOME = tool name: 'JDK', type: 'JDK'
         PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Construyendo el proyecto...'
                script {
                    bat "${GRADLE_HOME}\\gradle clean build"
                }
            }
        }
    }

    post {
        always {
            echo 'Este bloque se ejecuta siempre, independientemente del resultado.'
        }
        success {
            echo 'El pipeline se ejecutó con éxito.'
        }
        failure {
            echo 'El pipeline falló.'
        }
    }
}