name := """play-mongo-template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

resolvers += "Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository"

resolvers += "Secured Central Repository" at "http://repo1.maven.org/maven2"

resolvers += "Spring Staging Repository" at "https://repo.springsource.org/libs-staging-local"

resolvers += "Spring Milestone Repository" at "http://repo.springsource.org/libs-milestone"

resolvers += "Spring Snapshot Repository" at "https://repo.springsource.org/libs-snapshot"

resolvers += "Spring Release Repository" at "https://repo.springsource.org/libs-release"

libraryDependencies ++= Seq(
  	javaJdbc,
  	cache,
  	javaWs,
  	"org.springframework" % "spring-context" % "4.1.6.RELEASE",
	"org.springframework.data" % "spring-data-mongodb" % "1.7.2.RELEASE"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true