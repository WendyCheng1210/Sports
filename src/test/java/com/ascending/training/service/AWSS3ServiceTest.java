package com.ascending.training.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ascending.training.ApplicationBootstrap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)
public class AWSS3ServiceTest {

    @Autowired
    private AWSS3Service awss3Service;

    @Autowired
    private AmazonS3 client;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void testCreateBucket() {
        String bucketName = "wendycheng-s3-bucket-4";
        Bucket bucket = awss3Service.createBucket(bucketName);
        Assert.assertNotNull(bucket);
    }

    @Test
    public void uploadFileTest() throws IOException {
        awss3Service.uploadFile(new File("/Users/Wendy/Desktop/Yanwen(Wendy) Cheng resume.pdf"));//behavior verification
        verify(client,times(1)).putObject(any(PutObjectRequest.class));
    }


//    Examples of correct usage of argument matchers:
//    when(mock.get(anyInt())).thenReturn(null);
//    doThrow(new RuntimeException()).when(mock).someVoidMethod(anyObject());
//    verify(mock).someMethod(contains("foo"))
//    @Test
////    public void getUrlTest(){
////        when(client.getUrl(anyString(),anyString())).thenReturn(mock(URL.class));
////        awss3Service.getUrl("WendyCheng");
////        verify(client,times(1)).getUrl(anyString(),anyString());
////    }

}
