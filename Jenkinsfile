import groovy.json.JsonSlurperClassic

// Método para parsear JSON
def jsonParse(def json) {
    return new JsonSlurperClassic().parseText(json)
}

pipeline {
    agent any

    environment {
        app = "variable"  // Definir una variable de entorno
        GRADLE_HOME = tool 'Gradle'  // Definir la variable de entorno GRADLE_HOME
    }

    stages {
        stage('Build') {
            steps {
                echo 'Construyendo el proyecto...'
                script {
                    bat "${GRADLE_HOME}\\gradle build"  // Ejecutar el comando Gradle en Windows
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