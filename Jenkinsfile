#!/bin/groovy

def setupHoarder = """set org.romanowski.HoarderKeys.globalStashLocation in ThisBuild := (baseDirectory in LocalRootProject).value / ".hoarder-stash" """

node {
	def javaHome = tool 'jdk 1.8.0'
	stage("Build") {
		checkout scm
		withEnv(["JAVA_HOME=${javaHome}"]) {
			sh """
			/usr/local/bin/sbt -no-colors test:compile '${setupHoarder}' stash
			"""
		}
		stash name: "hoarder-stash", include: ".hoarder-stash/**/*"
	}
}
node {
	def javaHome = tool 'jdk 1.8.0'
	stage("Test") {
		checkout scm
		withEnv(["JAVA_HOME=${javaHome}"]) {
			sh """
			/usr/local/bin/sbt -no-colors clean '${setupHoarder}' stashApply p2/test:run
			"""		
		}
	}
}
