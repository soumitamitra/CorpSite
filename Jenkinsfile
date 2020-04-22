pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('CI') {
            steps {
                snDevOpsStep()
                sh 'mvn compile'
                sh 'mvn verify'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
        }
        stage('UAT deploy') {
            steps {
                snDevOpsStep()
                sh 'mvn package'
            }
        }
        stage('UAT test') {
            steps {
                snDevOpsStep()
                sh 'mvn compile'
                sh 'mvn verify'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Prod deploy') {
            steps {
                snDevOpsStep()
                snDevOpsChange()
                echo "Deploying to Prod"
                sleep 10
                echo "Deployment successful"
            }
        }
    }
}
