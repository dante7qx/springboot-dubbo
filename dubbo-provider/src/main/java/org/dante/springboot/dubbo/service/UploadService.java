package org.dante.springboot.dubbo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.dante.springboot.dubbo.api.service.IUploadService;

import com.alibaba.dubbo.config.annotation.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(protocol = "hessian")
public class UploadService implements IUploadService {

	@Override
	public String upload(String filename, InputStream file) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("/Users/dante/Documents/Project/spring/springboot-dubbo/dubbo-provider/" + filename));
			IOUtils.copy(file, fos);
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException", e);
			return "Failure";
		} catch (IOException e) {
			log.error("IOException", e);
			return "Failure";
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "SUCESS";
	}

}
