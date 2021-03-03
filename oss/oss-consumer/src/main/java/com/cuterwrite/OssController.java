package com.cuterwrite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cuterwrite.result.Result;
import com.cuterwrite.service.IOssService;

/**  
 * @author Pang S.Z.
 * @create 2021-03-02 02:08:23 
 */
@RestController
@RequestMapping("/api/v1/oss")
public class OssController {
	
	@DubboReference
	IOssService ossService;
	
	@PostMapping("/upload")
	public Result<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		String fileName = file.getOriginalFilename();
		String uri = ossService.uploadFile(bytes, fileName);
		Map<String, String> map = new HashMap<>();
		map.put("imageUri", uri);
		return Result.ok(map);
	}
}
