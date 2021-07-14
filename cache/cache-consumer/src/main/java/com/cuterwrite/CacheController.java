package com.cuterwrite;


import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuterwrite.result.Result;
import com.cuterwrite.service.ICacheService;
import com.cuterwrite.service.IQueryCacheService;

/**  
 * @author Pang S.Z.
 * @create 2021-07-11 20:57:32 
 */
@RestController
@RequestMapping("/api/v1/cache")
public class CacheController {
	@DubboReference
	ICacheService service;
	
	@DubboReference
	IQueryCacheService queryService;
	
	@GetMapping("/addCache")
	public Result add(@RequestParam String text){
		service.put("text", text);
		return Result.ok();
	}
	
	@GetMapping("/query")
	public Result get(@RequestParam String key) {
		return Result.ok(queryService.get(key));
	}
}
