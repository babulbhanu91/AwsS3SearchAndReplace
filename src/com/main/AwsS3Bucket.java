package com.main;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;
public class AwsS3Bucket {

	public void createBucket() {
		
		AWSCredentials credentials = new BasicAWSCredentials(
				  "AKIAI3BCSIYMP3CEUSBA", 
				  "70kHXCYnzVVW5PPbvTbzsCr3LfM0z1JJ0kF3aeWP"
				);
		try{
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		
		String bucketName = "baeldung-bucket";
		 
		if(s3client.doesBucketExistV2(bucketName)) {
		    System.out.println("Bucket name is not available."
		      + " Try again with a different Bucket name.");
		    return;
		}
		 
		s3client.createBucket(bucketName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
