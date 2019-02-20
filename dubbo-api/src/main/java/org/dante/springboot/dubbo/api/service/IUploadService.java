package org.dante.springboot.dubbo.api.service;

import java.io.InputStream;

public interface IUploadService {
	 public String upload(String filename, InputStream is);
}
