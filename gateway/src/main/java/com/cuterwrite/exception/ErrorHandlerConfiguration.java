package com.cuterwrite.exception;

import java.util.List;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

/**  
 * @author Pang S.Z.
 * @create 2021-03-04 15:35:28 
 */
@Configuration
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class ErrorHandlerConfiguration {

	private final ServerProperties serverProperties;
	private final ApplicationContext applicationContext;
	private final ResourceProperties resourceProperties;
	private final List<ViewResolver> viewResolvers;
	private final ServerCodecConfigurer serverCodecConfigurer;
	
	public ErrorHandlerConfiguration(ServerProperties serverProperties, ApplicationContext applicationContext,
			ResourceProperties resourceProperties, List<ViewResolver> viewResolvers,
			ServerCodecConfigurer serverCodecConfigurer) {
		
		this.serverProperties = serverProperties;
		this.applicationContext = applicationContext;
		this.resourceProperties = resourceProperties;
		this.viewResolvers = viewResolvers;
		this.serverCodecConfigurer = serverCodecConfigurer;
	}
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes) {
		GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler(errorAttributes, resourceProperties, 
				this.serverProperties.getError(), applicationContext);
		exceptionHandler.setViewResolvers(viewResolvers);
		exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
		exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
		return exceptionHandler;
	}
     
     
}
