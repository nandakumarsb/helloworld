package com.play;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class Processor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			String data = new String(Files.readAllBytes(Paths.get("C:\\MyWorks\\TestSoap.txt")));

			System.out.println(
					new String(
			Request.Post("http://localhost:8080/WebServiceProject/services/OrderSOAP")
			.setHeader("soapaction", "http://www.nandabookstore.org/order/NewOperation")
	        .useExpectContinue()
	        .bodyString(data, ContentType.DEFAULT_TEXT)
	        .execute().returnContent().asBytes()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
