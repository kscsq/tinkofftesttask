def gv
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing app version...'
                    sh 'mvn build-helper:parse-version versions:set \
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                    versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
//         stage('init') {
//             steps {
//                 script {
//                     gv = load "script.groovy"
//                 }
//             }
//         }
        stage('build jar') {
            steps {
                script {
                    echo 'building the application...'
                    sh 'mvn clean package'
                    }
            }
        }
//         stage('build image') {
//             steps {
//                 script {
//                     echo "building the docker image..."
//                     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//                     sh "docker build -t kscsq/tinkofftesttask:$IMAGE_NAME ."
//                     sh "echo $PASS | docker login -u $USER --password-stdin"
//                     sh "docker push kscsq/tinkofftesttask:$IMAGE_NAME"
//                     }
//                 }
//             }
//         }
        stage('deploy') {
            steps {
                script {
                    echo 'deploying the application...'
                }
            }
        }
        stage('commit version update') {
            steps {
                script {
//                         sh 'git config --global user.email "kscsq@mail.ru"'
//                         sh 'git config --global user.name "kscsq"'
                     withCredentials([usernamePassword(credentialsId: 'new_token_0109', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'
                        sh "git remote set-url origin https://github.com/kscsq/tinkofftesttask.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:master'
                    }
                }
            }
        }
    }
}

