package net.persgroep.aws.cda.model;

public class ProvisionEC2InstanceCommand {
    private String securityGroupIds;

    public String getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(String securityGroupIds) {
        this.securityGroupIds = securityGroupIds;
    }
}