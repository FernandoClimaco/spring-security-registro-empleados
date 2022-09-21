package com.registro.util;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class RestResponse {

	public static final String SERVICE_CODE="service-code";
	public static final String TRANSACTION_DATE="transaction-date";
	public static final String SERVICE_DESCRIPTION ="service-description";
	public static final String UNKNOWN_ERROR = "Unknown error";
	
	public <T> ResponseEntity<T> createOkResponse(T body,String serviceCode, String serviceDescription){
		return createResponse(body, HttpStatus.OK,serviceCode,serviceDescription);
	}
	
	public <T> ResponseEntity<T> createFailResponse(T body, String serviceCode, String serviceDescription) {
		
		if(serviceCode.equals("403") || serviceCode.equals("401")) {
			return createResponse(body, HttpStatus.UNAUTHORIZED, serviceCode,serviceDescription);
		}else if(serviceCode.equals("404")){
			return createResponse(body, HttpStatus.NOT_FOUND, serviceCode, serviceDescription);
			
		}else 
			return createResponse(body, HttpStatus.CONFLICT, serviceCode,serviceDescription);
		
	}
	
	public <T> ResponseEntity<T> createSecurityResponse(T body, String serviceCode, String serviceDescription) {
		return createResponse(body, HttpStatus.UNAUTHORIZED, serviceCode,serviceDescription);
	}
	
	public <T> ResponseEntity<T> createNotDataResponse(T body,String serviceCode, String serviceDescription) {
		return createResponse(body, HttpStatus.NOT_FOUND, serviceCode, serviceDescription);
	}
	
	
	
	public <T> ResponseEntity<T> createCustomizedResponse(T body, Integer statusCode,String serviceCode, String serviceDescription) {
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode.intValue());
		return createResponse(body, httpStatus, serviceCode, serviceDescription);
	}
	
	 
	private <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus,String serviceCode, String serviceDescription) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(SERVICE_CODE,serviceCode);
		headers.set(SERVICE_DESCRIPTION,serviceDescription!=null?serviceDescription:UNKNOWN_ERROR);
		headers.set(TRANSACTION_DATE,new Date().toString());
		headers.set("Access-Control-Expose-Headers", "*");
		headers.set("Access-Control-Allow-Headers", "*");
		if (body == null) 
			return new ResponseEntity<>(headers, httpStatus);
		else
			return new ResponseEntity<>(body, headers, httpStatus);
	}
	
	 
	
}
