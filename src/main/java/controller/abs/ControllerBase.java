package controller.abs;

import java.util.HashMap;
import java.util.Map;

public class ControllerBase {
	public Object returnSuccess(Object o) {
		Map<String,Object> head=new HashMap<String,Object>();
		Map<String,Object> success=new HashMap<String,Object>();
		head.put("code", "1");
		head.put("message","success");
		success.put("head", head);
		success.put("value", o);
		return success;
	}
	public Object returnFailure(String msg) {
		Map<String,Object> head=new HashMap<String,Object>();
		Map<String,Object> failure=new HashMap<String,Object>();
		head.put("code", "2");
		head.put("message", msg);
		failure.put("head", head);
		return failure;
	}
}
