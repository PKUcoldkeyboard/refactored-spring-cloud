package com.cuterwrite;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.cuterwrite.result.Result;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;

/**  
 * @author Pang S.Z.
 * @create 2021-07-15 23:20:57 
 */
@RestController
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
@RequestMapping("/api/v1/picx")
public class UploadController {
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Value("${branch}")
	private String branch;
	
	@Value("${message}")
	private String message;
	
	@Value("${token}")
	private String token;
	
	@PutMapping("")
	public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
		//获取文件的base64值
		String fileName = file.getOriginalFilename();
		
		File temp = File.createTempFile("tem", null);
		file.transferTo(temp);
		temp.deleteOnExit();
		
		FileInputStream inputStream = new FileInputStream(temp);
		byte[] buffer = new byte[(int)temp.length()];
		inputStream.read(buffer);
		inputStream.close();
		
		String base64 = Base64.encode(buffer);
		
		//向github服务器发送REST请求
		RestTemplate restTemplate = restTemplateBuilder.build();
		String url = "https://api.github.com/repos/PKUcoldkeyboard/image-hosting/contents/store/" + fileName;
		//设置请求头
		HttpHeaders headers = new HttpHeaders();
		headers.add("authorization", "token " + token);
		headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
		//请求参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", message);
		map.put("content", base64);
		map.put("branch", branch);
		
		String body = JSONUtil.toJsonStr(map);
		
		HttpEntity<String> entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
		
		String cdn = "https://cdn.jsdelivr.net/gh/PKUcoldkeyboard/image-hosting@master/store/" + fileName;
		return Result.ok(cdn);
	}
	
}
