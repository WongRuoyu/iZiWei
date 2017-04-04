name := "iZiWei"

version := "0.1"

organization := "com.wong"

scalaVersion := "2.10.6"

resolvers ++= Seq("snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
                  "staging"       at "https://oss.sonatype.org/content/repositories/staging",
                  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
                 )

seq(webSettings :_*)


unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "compile",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile",
    "net.liftmodules"   %% "lift-jquery-module_2.6" % "2.9" % "compile",
    "net.liftmodules"   % "imaging_2.10" % "2.5-M4-1.2" % "compile",
    "net.liftmodules"   % "machine_2.10" %"2.5-M4-1.2"  % "compile",
    "net.liftmodules"   % "mongoauth_2.10" %"2.5-M4-0.3"  % "compile",
    "net.liftmodules"   % "widgets_2.6_2.10" %"1.3" % "compile",    
    "org.eclipse.jetty" % "jetty-webapp"        % "8.1.17.v20150415"  % "container,test",
    "org.eclipse.jetty" % "jetty-plus"          % "8.1.17.v20150415"  % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.1.3",
    "org.specs2"        %% "specs2-core"        % "3.6.4"           % "test",
    "com.h2database"    % "h2"                  % "1.4.187"
  )
}

scalacOptions in Test ++= Seq("-Yrangepos")
