BBLOGBACK B2
=====================

This project is based from the Spring Tool Suite (STS) Spring MVC project. We've added a bb-manifest.xml and an example of a view that uses the Blackboard Tags to render a page that has the look and feel of other Blackboard Learn pages.
Lastly, we've added code that uses the Logback Java APIs to create log files. 

### Clone to local repo
####bitbucket: 
git clone https://markkauffman2000@bitbucket.org/markkauffman2000/bbdn-bblogback.git bbdn-bblogbackb2

### Building
To build the project, just run:

./gradlew build

### Deploying
To deploy the B2 to your Learn server, run:

./gradlew -Dserver=host:port deployB2

Example: ./gradlew -Dserver=localhost:9876 deployB2

Home URL Example: https://<hostname>/webapps/bbdn-bblogbackb2-BBLEARN/

Continual Logging URL Example: https://<hostname>/webapps/bbdn-bblogbackb2-BBLEARN/logbacklog
