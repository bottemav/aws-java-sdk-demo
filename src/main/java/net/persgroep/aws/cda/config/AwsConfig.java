package net.persgroep.aws.cda.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Bean
    public AmazonEC2 amazonEC2Client() {
        return AmazonEC2ClientBuilder.standard()
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
    }
}
