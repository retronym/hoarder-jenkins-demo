lazy val root: Project = (project in file(".")).settings(name := "stash").aggregate(p1, p2)
val p1 = project
val p2 = project.dependsOn(p1)
