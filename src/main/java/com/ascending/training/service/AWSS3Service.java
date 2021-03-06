package com.ascending.training.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class AWSS3Service {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AmazonS3 amazonS3;

    private String bucketName = "wendycheng-s3-bucket-2";

    public AWSS3Service(@Autowired AmazonS3 amazonS3){
        this.amazonS3 = amazonS3;
    }

//
//    public AWSS3Service(){
//        amazonS3 = getS3ClientWithSuppliedCredentials();
//    }
//
//    private String myAWSAccessKeyId = System.getProperty("aws.accessKeyId");
//    private String myAWSSecretKey = System.getProperty("aws.secretKey");
//
//    private AmazonS3 getS3ClientWithSuppliedCredentials() {
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials(myAWSAccessKeyId, myAWSSecretKey);
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                .withRegion("us-east-1")
//                .build();
//        return s3Client;
//    }


    public void uploadFile(File f) throws IOException{
        PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(),f);
        amazonS3.putObject(request);
    }

    public String getUrl(String filename){
        return amazonS3.getUrl(bucketName,filename).toExternalForm();
    }

    public Bucket createBucket(String bucketName) {
        Bucket bucket = null;
        if(!amazonS3.doesBucketExistV2(bucketName)) {
            bucket = amazonS3.createBucket(bucketName);
        } else {
            logger.info("bucket name: {} is not available."
                    + " Try again with a different Bucket name.", bucketName);
        }
        return bucket;
    }

    public String uploadFile(String bucketName, MultipartFile file) throws IOException{
        try{
            String uuid = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String newFileName = uuid + "." + Files.getFileExtension(originalFilename);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            amazonS3.putObject(bucketName, newFileName, file.getInputStream(), objectMetadata);
            logger.info(String.format("The file name =%s was uploaded to bucket %s", newFileName,bucketName));
            return newFileName;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
