#!/bin/groovy

node {
	stage("Build") {
		sh """
		/usr/local/bin/sbt -no-colors test:compile 'set org.romanowski.HoarderKeys.globalStashLocation in Global := (baseDirectory in Global).value / ".hoarder-stash"' stash
		"""
		stash name: "hoarder-stash", include: ".hoarder-stash/**/*"
	}
}
node {
	stage("Test") {
		sh """
		/usr/local/bin/sbt -no-colors 'set org.romanowski.HoarderKeys.globalStashLocation in Global := (baseDirectory in Global).value / ".hoarder-stash"' stashApply p2/test:run
		"""		
	}
}
