package com.cuterwrite.result;

import java.io.Serializable;

import lombok.Data;

/**  
 * 请求响应封装类
 * @author Pang S.Z.
 * @create 2021-03-02 23:12:57 
 */
@SuppressWarnings("serial")
@Data
public class Result<T> implements Serializable {
	
	private String code;
	private T data;
	private String msg;
	
	public static <T> Result<T> ok(){
		return ok(null);
	}
	
	public static <T> Result<T> ok(T data){
		ResultCode resultCode = ResultCode.SUCCESS;
		if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
			resultCode = ResultCode.SYSTEM_EXECUTION_ERROR;
		}
		return result(resultCode,data);
	}
	
	public static <T> Result<T> error(){
		return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMsg(), null);
	}
	
	public static <T> Result<T> error(String msg){
		return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
	}
	
	public static <T> Result<T> error(IResultCode resultCode){
		return result(resultCode);
	}
	
	private static <T> Result<T> result(IResultCode resultCode){
		return result(resultCode.getCode(), resultCode.getMsg(), null);
	}
	
	private static <T> Result<T> result(IResultCode resultCode,T data){
		return result(resultCode.getCode(), resultCode.getMsg(), data);
	}
	
	private static <T> Result<T> result(String code,String msg,T data){
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}
