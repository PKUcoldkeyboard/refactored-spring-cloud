package com.cuterwite.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cuterwrite.service.IOssService;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**  
 * @author Pang S.Z.
 * @create 2021-03-02 00:45:11 
 */
@DubboService(cluster = "failfast")
@Slf4j
public class OssService implements IOssService{
	
	@Autowired
	private OSSClient ossClient;
	
	private static final String BUCKET_NAME = "cuterwrite";
	
	@Override
	public String uploadFile(byte[] bytes,String fileName) {		
		//设置存储对象名称
		String objectName = "refactored-spring-cloud/" + DateUtil.format(new Date(), "yyyyMMdd") + "-" + fileName;		
		InputStream inputStream = new ByteArrayInputStream(bytes);
		PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, inputStream);
		
		//上传文件
		ossClient.putObject(putObjectRequest);
		
		//ossClient.shutdown();
		
		log.info("上传文件成功");
		
		//返回URI链接，过期时间设定一年
		Date expiration = new Date(System.currentTimeMillis() + 3600 * 24 * 365);
		return ossClient.generatePresignedUrl(BUCKET_NAME, objectName, expiration).toString();
	}

}
