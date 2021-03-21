package com.cuterwrite.exception;

import com.cuterwrite.result.IResultCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**  
 * @author Pang S.Z.
 * @create 2021-03-03 21:38:25 
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException{
	
	private String code;
	
	public CustomException(String code, String msg) {
		super(msg);
		this.code = code;
	}
	
	public CustomException(IResultCode resultCode) {
		super(resultCode.getMsg());
		this.code = resultCode.getCode();
	}
}
