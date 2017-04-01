# aws-java-sdk-demo
Small demo of the EC2 part of the AWS SDK for Java

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

* GET http://localhost:8080/rest/ec2/frankfurt/instances
    * Lists all instances in Frankfurt (eu-central-1)
* GET http://localhost:8080/rest/ec2/frankfurt/securityGroups
    * Lists all security groups in Frankfurt (eu-central-1)
* GET http://localhost:8080/rest/ec2/frankfurt/availabilityZones
    * Lists all availability zones in Frankfurt (eu-central-1)
* POST http://localhost:8080/rest/ec2/frankfurt/instance
    * Provision a new instance in Frankfurt (eu-central-1) based on the AMI ami-af0fc0c0 (t2.small) and with the security specified in the request body.
    * Request body: `{"securityGroupsIds" : "sg-b1234567"}`
* GET http://localhost:8080/rest/ec2/defaultRegion/availabilityZones
    * Lists all availability zones in the default region. See [Automatically Determine the AWS Region from the Environment](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-region-selection.html#automatically-determine-the-aws-region-from-the-environment)
