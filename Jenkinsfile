#!/bin/groovy

node {
	def javaHome = tool 'jdk 1.8.0'
	stage("Build") {
		checkout scm
		withEnv(["JAVA_HOME=${javaHome}"]) {
			sh """
			/usr/local/bin/sbt -no-colors update test:compile
			"""
		}
		stash name: "workspace-stash", include: "**/*"
	}
}
node {
    ws (dir: "/tmp/different-dir") {
		def javaHome = tool 'jdk 1.8.0'
		stage("Test") {
			unstash name: "workspace-stash"
			withEnv(["JAVA_HOME=${javaHome}"]) {
				sh """
				pwd
				/usr/local/bin/sbt -no-colors 'set skip in compile in ThisBuild := true' 'show p2/test:fullClasspath' 'p2/test:runMain Test'
				"""		
			}
		}
	}
}
