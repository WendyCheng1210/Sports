package com.ascending.training.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import javax.print.DocFlavor;

@Configuration
@Profile({"dev","prod"})
public class AWSConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public AmazonS3 getAmazonS3(){

        String myAWSAccessKeyId = "AKIAT3KGNQVZH262SLZZ";
        String myAWSSecretKey = "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";

//        String myAWSAccessKeyId = System.getProperty("accessKeyId");
//        String myAWSSecretKey = System.getProperty("secretKey");

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(myAWSAccessKeyId, myAWSSecretKey);

        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard().withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(Regions.US_EAST_1)
                .build();
        return s3Client;
    }
}
