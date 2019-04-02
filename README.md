WildFly Rest for OPENSHIFT
==========================
Technologies: CDI, JAX-RS, HTML5  
Summary: Demonstrates the use of CDI 1.1 and JAX-RS using the HTML5 architecture and RESTful services on the backend  
Target Product: WFK  

What is it?
-----------
This example demonstrates the use of *CDI 1.1* and *JAX-RS* in *JBoss WildFly* using the HTML5 + REST architecture.
The application is basically a smart, HTML5+CSS3+JavaScript front-end using RESTful services on the backend.
The example can be deployed using Maven from the command line or from Eclipse using JBoss Tools.

System requirements
-------------------
Java 7.0 (Java SDK 1.7) or better, Maven 3.0 or better.
The application this project produces is designed to be run on JBoss WildFly.


Deploying the application
-------------------------
### Deploying locally
First you need to start the JBoss container. To do this, run
    $JBOSS_HOME/bin/standalone.sh
or if you are using windows
    $JBOSS_HOME/bin/standalone.bat
To deploy the application, you first need to produce the archive to deploy using
the following Maven goal:
    mvn package
You can now deploy the artifact by executing the following command:
    mvn wildfly:deploy
This will deploy both the client and service applications.
The application will be running at the following URL <http://wild-dx-wild-dx.7e14.starter-us-west-2.openshiftapps.com/dx//>.
To undeploy run this command:
    mvn wildfly:undeploy
You can also start the JBoss container and deploy the project using JBoss Tools. See the
<a href="https://github.com/wildfly/quickstart/guide/Introduction/" title="Getting Started Developing Applications Guide">Getting Started Developing Applications Guide</a>
for more information.

Importing the project into an IDE
=================================
Detailed instructions for using Eclipse / JBoss Tools with are provided in the
<a href="https://github.com/wildfly/quickstart/guide/Introduction/" title="Getting Started Developing Applications Guide">Getting Started Developing Applications Guide</a>.
If you created the project from the commandline using archetype:generate, then
you need to import the project into your IDE. If you are using NetBeans 6.8 or
IntelliJ IDEA 9, then all you have to do is open the project as an existing
project. Both of these IDEs recognize Maven projects natively.

Copyright headers
-----------------
To update the copyright headers, just run `mvn license:format -Dyear=<current year>`


