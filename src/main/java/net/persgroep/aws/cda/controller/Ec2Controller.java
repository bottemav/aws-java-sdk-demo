package net.persgroep.aws.cda.controller;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.SecurityGroup;
import net.persgroep.aws.cda.model.ProvisionEC2InstanceCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/rest/ec2")
@RestController
public class Ec2Controller {

    private final AmazonEC2 amazonEC2ClientFrankfurt;
    private final AmazonEC2 amazonEC2ClientDefaultRegion;

    public Ec2Controller(AmazonEC2 amazonEC2ClientFrankfurt, AmazonEC2 amazonEC2ClientDefaultRegion) {
        this.amazonEC2ClientFrankfurt = amazonEC2ClientFrankfurt;
        this.amazonEC2ClientDefaultRegion = amazonEC2ClientDefaultRegion;
    }


    @GetMapping("/frankfurt/instances")
    public List<Reservation> getInstances() {
        DescribeInstancesResult describeInstancesResult = amazonEC2ClientFrankfurt.describeInstances();
        return describeInstancesResult.getReservations();
    }

    @GetMapping("/frankfurt/securityGroups")
    public List<SecurityGroup> getSecurityGroups() {
        return amazonEC2ClientFrankfurt.describeSecurityGroups().getSecurityGroups();
    }

    @GetMapping("/frankfurt/availabilityZones")
    public DescribeAvailabilityZonesResult getAvailabilityZonesFrankfurt() {
        return amazonEC2ClientFrankfurt.describeAvailabilityZones();
    }

    @PostMapping("/frankfurt/instance")
    public RunInstancesResult provisionEC2Instance(ProvisionEC2InstanceCommand provisionEC2InstanceCommand) {
        RunInstancesRequest request = new RunInstancesRequest("ami-af0fc0c0", 1, 1);
        request.setSecurityGroupIds(Collections.singletonList(provisionEC2InstanceCommand.getSecurityGroupIds()));
       return amazonEC2ClientFrankfurt.runInstances(request);
    }

    @GetMapping("/defaultRegion/availabilityZones")
    public DescribeAvailabilityZonesResult getAvailabilityZonesDefaultRegion() {
        return amazonEC2ClientDefaultRegion.describeAvailabilityZones();
    }
}
