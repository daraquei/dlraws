package com.dlr.aws.lambda;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.dlr.aws.dto.DlrInfo;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DlInfoLambda {
	
	AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
	ObjectMapper objectMapper = new ObjectMapper();
	AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();
	
	public void handler(S3Event event) {
		event.getRecords().forEach(record -> {
			 S3ObjectInputStream inputStream = s3.getObject(record.getS3().getBucket().getName(), 
					 record.getS3().getObject().getKey()).getObjectContent() ;
			 try {
				 DlrInfo dlrInfo = objectMapper.readValue(inputStream, DlrInfo.class);
				 System.out.println(dlrInfo.getDlNumber());
				 System.out.println("DLR_INFO_TOPIC="+System.getenv("DLR_INFO_TOPIC"));
				 sns.publish(System.getenv("DLR_INFO_TOPIC"),dlrInfo.getDlNumber());
			} catch (StreamReadException e) {
				e.printStackTrace();
			} catch (DatabindException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	

}
