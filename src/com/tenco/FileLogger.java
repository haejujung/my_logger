package com.tenco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {

	private String fileName;
	private SimpleDateFormat dateFormat;

	public FileLogger(String fileName) {
		this.fileName = fileName;
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	}

	public void log(String message) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			// 현재 시간
			String now = dateFormat.format(new Date());
			writer.write(now + " ::  " + message);
			writer.newLine();
			writer.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readLogs() {

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
