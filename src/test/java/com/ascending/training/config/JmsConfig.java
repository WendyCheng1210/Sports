//package com.ascending.training.config;
//
//
//import com.amazon.sqs.javamessaging.ProviderConfiguration;
//import com.amazon.sqs.javamessaging.SQSConnectionFactory;
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
//import io.lettuce.core.dynamic.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.management.DynamicMBean;
//
//@Configuration
//public class JmsConfig {
//    @Value("${aws.region}")
//    private String region;
//
//    @Bean(name = "connectionFactory")
//    public SQSConnectionFactory getSQSConnectionFactory(){
//        AmazonSQS amazonSQSClient = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).withRegion(region).build();
//        SQSConnectionFactory factory = new SQSConnectionFactory(new ProviderConfiguration(), amazonSQSClient);
//        return factory;
//    }
//
//    @Bean
//    public JmsTemplate getJmsTemplate(@Autowired SQSConnectionFactory connectionFactory){
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        return jmsTemplate;
//    }
//
//    @Bean("dynamicResolver")
//    public DynamicMBean
//
//}
