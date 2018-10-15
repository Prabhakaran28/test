package com.pabbu.selLearn;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.opencsv.CSVReader;

public class selTest {

	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();

		try {

			FileReader filereader = new FileReader("D:\\test.csv");

			CSVReader csvReader = new CSVReader(filereader, ',', '\'', 1);
			String[] nextRecord;
			StringBuffer buf = new StringBuffer();
			buf.append("URL CHECKED,STATUS \n");
			while ((nextRecord = csvReader.readNext()) != null) {
				buf.append(new selTest().checkStatus(driver, nextRecord[0]));
			}

			Files.write(Paths.get("d://output.csv"), buf.toString().getBytes());
			System.out.println(buf.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}
	}

	public synchronized String checkStatus(WebDriver driver, String url) {

		driver.get(url);

		String src = driver.getPageSource();
		String status = "";
		if (src.contains("https://d10lpsik1i8c69.cloudfront.net/w.js")) {
			status = "LO";
		} else if (src.contains("twakchat-status-message")) {
			status = status + "TWAK";
		} else {
			status = status + "Nothing";
		}
		System.out.println(status);

		return url + "," + status + "\n";

	}

}
