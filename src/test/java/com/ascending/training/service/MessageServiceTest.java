package com.ascending.training.service;

import com.amazonaws.services.mediaconvert.model.GetQueueResult;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.ascending.training.ApplicationBootstrap;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Autowired
    private AmazonSQS sqsClient;

    @After
    public void tearDown(){
        reset(sqsClient);
    }

    @Test
    public void getQueueUrlTest(){
        messageService.getQueueUrl("123");
        verify(sqsClient,times(1)).getQueueUrl("123");
    }


    @Test
    public void sendMessageTest(){
        messageService.sendMessage("test",1);
//        assertTrue(false);
    }

}
