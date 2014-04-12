#Embedded war using Jetty and Gradle

A template Gradle project for creating embedded war using jetty.
Project is based on Fernando Rubbo [http://fernandorubbo.blogspot.no/2013/06/embedded-war-using-gradle.html](http://fernandorubbo.blogspot.no/2013/06/embedded-war-using-gradle.html).

## Examples

Build and run the embedded war:

    $ gradle build
    $ java -jar build/libs/embedded-jetty-gradle.war


Run using gradle-jetty-eclipse-plugin:

    $ gradle jettyElipseRun
