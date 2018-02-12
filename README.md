## hoarder-jenkins-demo

Sample project showing how to combine SBT, Jenkins and
[hoarder](https://github.com/romanowski/hoarder) and 
Jenkins' `stash/unstash` (https://jenkins.io/doc/pipeline/steps/workflow-basic-steps/#unstash-restore-files-previously-stashed) to reuse compiled classes across different stages of a Jenkins pipeline.

Note that `scalac` is not invoked in the "Test" stage:

```
[info] Stash for pipeline-with-hoarder applied from /Users/jz/.jenkins/workspace/pipeline-with-hoarder/.hoarder-stash/pipeline-with-hoarder/HEAD/2.10 to List(/Users/jz/.jenkins/workspace/pipeline-with-hoarder/target/scala-2.10/classes, /Users/jz/.jenkins/workspace/pipeline-with-hoarder/target/scala-2.10/test-classes)

[info] Stash for p1 applied from /Users/jz/.sbt/0.13/sbt-stash/pipeline-with-hoarder/HEAD/2.10 to List(/Users/jz/.jenkins/workspace/pipeline-with-hoarder/p1/target/scala-2.10/classes, /Users/jz/.jenkins/workspace/pipeline-with-hoarder/p1/target/scala-2.10/test-classes)

[info] Resolving org.scala-lang#scala-compiler;2.10.7 ...

[info] Resolving org.scala-lang#scala-reflect;2.10.7 ...

[info] Resolving org.scala-lang#jline;2.10.7 ...

[info] Resolving org.fusesource.jansi#jansi;1.4 ...

[info] Done updating.

[info] Stash for p2 applied from /Users/jz/.sbt/0.13/sbt-stash/pipeline-with-hoarder/HEAD/2.10 to List(/Users/jz/.jenkins/workspace/pipeline-with-hoarder/p2/target/scala-2.10/classes, /Users/jz/.jenkins/workspace/pipeline-with-hoarder/p2/target/scala-2.10/test-classes)

[success] Total time: 1 s, completed 12/02/2018 5:04:34 PM

[info] Running Test 

P2@35f6bdbe

```