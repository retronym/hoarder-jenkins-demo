#!/bin/groovy

node {
	stage("Build") {
		sh """
		sbt test:compile 'set org.romanowski.HoarderKeys.globalStashLocation in Global := (baseDirectory in Global).value / ".hoarder-stash"' stash
		"""
		stash name: "hoarder-stash", include: ".hoarder-stash/**/*"
	}
}
node {
	stage("Test") {
		sh """
		sbt 'set org.romanowski.HoarderKeys.globalStashLocation in Global := (baseDirectory in Global).value / ".hoarder-stash"' stashApply p2/test:run
		"""		
	}
}
