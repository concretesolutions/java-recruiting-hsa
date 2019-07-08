# Starting off with the Jenkins base Image
FROM jenkins/jenkins:latest

#Copy all the necessary elements.
COPY jobs /usr/share/jenkins/ref/jobs
COPY workspace /usr/share/jenkins/ref/workspace
COPY credentials.xml /usr/share/jenkins/ref/credentials.xml

# Start-up scripts to set number of executors and creating the admin user
COPY addTomcatCredential.groovy /usr/share/jenkins/ref/init.groovy.d/

# Add/Remove  the plugins you want  
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
 
# Setting up environment variables for Jenkins admin user
ENV JENKINS_USER admin
ENV JENKINS_PASS admin
 
# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Start-up scripts to set number of executors and creating the admin user
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/


VOLUME $JENKINS_HOME