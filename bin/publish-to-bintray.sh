#!/bin/bash

clear

if [ "$1" = "" ]
then
 echo "Usage: $0 <release> <api key>"
 exit
fi
if [ "$2" = "" ]
then
 echo "Usage: $0 <release> <api key>"
 exit
fi
RELEASE=$1
KEY=$2

curl --include --request DELETE --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/packages/kurron/maven/java-tools/versions/${RELEASE} 

curl --include --request POST --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/packages/kurron/maven/java-tools/versions --data "{ \"name\": \"${RELEASE}\", \"desc\": \"New bits!\" }" 

curl --include --request PUT --user "kurron:${KEY}" --header "X-Bintray-Package:java-tools" --header "X-Bintray-Version:${RELEASE}" --header "Content-Type: application/octet-stream" --header "Accept:application/json" --data-binary @build/libs/tools-java-0.0.0-SNAPSHOT.jar https://api.bintray.com/maven/kurron/maven/java-tools/org/kurron/tools-java/${RELEASE}/tools-java-${RELEASE}.jar

curl --include --request PUT --user "kurron:${KEY}" --header "X-Bintray-Package:java-tools" --header "X-Bintray-Version:${RELEASE}" --header "Content-Type: application/octet-stream" --header "Accept:application/json" --data-binary @build/libs/tools-java-0.0.0-SNAPSHOT-sources.jar https://api.bintray.com/maven/kurron/maven/java-tools/org/kurron/tools-java/${RELEASE}/tools-java-${RELEASE}-sources.jar

curl --include --request POST --user "kurron:${KEY}" --header "Content-Type: application/json" https://api.bintray.com/content/kurron/maven/java-tools/${RELEASE}/publish 
