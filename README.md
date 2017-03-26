# aws-java-sdk-demo
Small demo of the EC2 part of the AWS Java SDK

## To compile
````
$ ./gradlew clean build
````

## To run

Make sure you have configured the access key locally. See [Getting Started with the AWS SDK for Java](https://aws.amazon.com/developers/getting-started/java/#Configure_the_Access_Keys) for more information.

````
$ ./gradlew service:bootRun
````

## Endpoints

* GET http://localhost:8080/rest/ec2/instances
    * Lists all instances
* GET http://localhost:8080/rest/ec2/securityGroups
    * Lists all security groups
* POST http://localhost:8080/rest/ec2/instance
    * Provision a new instance in EU (Frankfurt) based on the AMI ami-af0fc0c0 (t2.small) and with the security specified in the request body.
    * Request body: `{"securityGroupsIds" : "sg-b1234567"}`
