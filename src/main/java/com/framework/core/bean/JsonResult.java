package com.framework.core.bean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonResult {
	
	/*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
	public transient static final JsonResult SUCCESS = new JsonResult(Boolean.TRUE, "success", "0000");
	public transient static final JsonResult FAILURE = new JsonResult(Boolean.FALSE, "failure", "0001");
	
	/*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/
	private Boolean success = Boolean.TRUE;
	
	private Object data;
	
	private Long total = 0L;
	
	private String message;
	
	private String code;
	
	private Map<String, Object> other;
	
	/*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/
	public JsonResult() {
		super();
	}
	
	public JsonResult(Boolean success) {
		super();
		this.success = success;
	}
	
	public JsonResult(Object data) {
		super();
		this.data = data;
	}
	
	public JsonResult(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public JsonResult(Boolean success, String message, String code) {
		super();
		this.success = success;
		this.message = message;
		this.code = code;
	}
	
	public JsonResult(List<?> data, Long total) {
		super();
		this.data = data;
		this.total = total;
	}
	
	public JsonResult(Boolean success, Object data, Long total, String message,
					  String code, Map<String, Object> other) {
		super();
		this.success = success;
		this.data = data;
		this.total = total;
		this.message = message;
		this.code = code;
		this.other = other;
	}

	/*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/
	public JsonResult putKeyValue(String key, Object value) {
		if(other == null) {
			this.other = new LinkedHashMap<String, Object>();
		}
		this.other.put(key, value);
		return this;
	}
	
	public JsonResult putKeyValueMap(Map<String, Object> keyValueMap) {
		if(other == null) {
			this.other = new LinkedHashMap<String, Object>();
		}
		this.other.putAll(keyValueMap);
		return this;
	}
	
	/*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getOther() {
		return other;
	}

	public void setOther(Map<String, Object> other) {
		this.other = other;
	}
}
