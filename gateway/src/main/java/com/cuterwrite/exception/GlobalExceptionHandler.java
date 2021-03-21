package com.cuterwrite.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cuterwrite.result.ResultCode;

import reactor.core.publisher.Mono;


/**  
 * 自定义异常处理
 * @author Pang S.Z.
 * @create 2021-03-04 15:25:00 
 */
public class GlobalExceptionHandler extends DefaultErrorWebExceptionHandler{
	

	public GlobalExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
			ErrorProperties errorProperties, ApplicationContext applicationContext) {
		super(errorAttributes, resourceProperties, errorProperties, applicationContext);
	}
	
	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return null;
	}

}
