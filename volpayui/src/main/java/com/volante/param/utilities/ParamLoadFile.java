package com.volante.param.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ParamLoadFile {
	public WebDriver driver;
	static Properties prop = new Properties();

	public ParamLoadFile(WebDriver driver) {
		this.driver = driver;

	}

	public ParamLoadFile(String outFile) {
		try {
			FileInputStream fileInput = new FileInputStream(outFile);
			prop.load(fileInput);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}