package org.dante.springboot.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO implements java.io.Serializable {
	private static final long serialVersionUID = 8480182546953709998L;
	
	private String account;
	private String pwd;
	
	public UserVO() {}
	
}
