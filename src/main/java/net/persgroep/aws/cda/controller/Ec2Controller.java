package net.persgroep.aws.cda.controller;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.SecurityGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/rest/ec2")
@RestController
public class Ec2Controller {

    private final AmazonEC2 amazonEC2Client;

    public Ec2Controller(AmazonEC2 amazonEC2Client) {
        this.amazonEC2Client = amazonEC2Client;
    }


    @GetMapping("/instances")
    public List<Reservation> getInstances() {
        DescribeInstancesResult describeInstancesResult = amazonEC2Client.describeInstances();
        return describeInstancesResult.getReservations();
    }

    @GetMapping("/securityGroups")
    public List<SecurityGroup> getSecurityGroups() {
        return amazonEC2Client.describeSecurityGroups().getSecurityGroups();
    }

    @PostMapping("/instance")
    public RunInstancesResult provisionEC2Instance() {
        RunInstancesRequest request = new RunInstancesRequest("ami-af0fc0c0", 1, 1);
        request.setSecurityGroupIds(Collections.singletonList("sg-b95786d2"));
       return amazonEC2Client.runInstances(request);
    }
}
