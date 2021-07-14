package com.cuterwrite;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuterwrite.result.Result;
import com.cuterwrite.service.IProductService;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:03:20 
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	@DubboReference
	private IProductService productService;
	
	@GetMapping("/send")
	public Result<String> send(@RequestParam String message){
		productService.sendMessage(message);
		return Result.ok();
	}
}
