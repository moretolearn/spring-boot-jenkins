pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }
    
    //environment{
    //    SCANNER_HOME= tool 'sonar-scanner'
    //}

    stages {
        stage('Git Checkout') {
            steps {
                git 'https://github.com/moretolearn/spring-boot-jenkins.git'
            }
        }
        
        stage('Maven Compile') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean compile -DskipTests=true'
            }
        }
        
        // stage('Maven Test') {
        //     steps {
        //         bat 'mvn test'
        //     }
        // }
        
        stage('Maven Package') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
        
        //stage('OWASP Scan') {
        //   steps {
        //        dependencyCheck additionalArguments: '--scan ./ ', odcInstallation: 'DC'
        //        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
        //    }
        //}
        
        //stage('Sonar Scanner') {
        //    steps {
        //        withSonarQubeEnv('sonar') {
        //            bat "${SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectName=SpringBootJenkins  -Dsonar.java.binaries=.  -Dsonar.projectKey=SpringBootJenkins"
        //        }
        //    }
        //}
        
        stage('Deploye') {
            steps {
                //deploy adapters: [tomcat9(credentialsId: '2699a4a6-d5ea-4533-bca8-1dccf0d2a29b', path: '', url: 'http://localhost:8080')], war: '**/*.war'
                deploy adapters: [tomcat9(credentialsId: 'tomcat-cred', path: '', url: 'http://13.127.85.60/')], war: '**/*.war'
            }
        }
    }
}
