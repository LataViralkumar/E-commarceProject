package com.ecommerce.paytem;

import java.net.URL;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paytm.pg.merchant.PaytmChecksum;

@RestController
@RequestMapping("/payment")
public class Payment {
	
	Random random = new Random();
	@PostMapping("/start")
	public Map<String, Object> startPayment(
			@RequestBody Map<String,Object>data
	){
		
		String orderID = "ORDER"+random.nextInt(10000000);
		JSONObject paytmParams = new JSONObject();

		JSONObject body = new JSONObject();
		body.put("requestType", "Payment");
		body.put("mid", PayConfig.MID);
		body.put("websiteName", PayConfig.website);
		body.put("orderId", orderID);
		body.put("callbackUrl", "http://localhost:8080/index");

		JSONObject txnAmount = new JSONObject();	
		txnAmount.put("value", "1.00");
		txnAmount.put("currency", "INR");

		JSONObject userInfo = new JSONObject();
		userInfo.put("custId", "CUST_001");
		body.put("txnAmount", txnAmount);
		body.put("userInfo", userInfo);
		
//		String responseData = "";
		ResponseEntity<Map> response = null;
		
		try {
			
			String checksum = PaytmChecksum.generateSignature(body.toString(), PayConfig.MKEY);
//			System.out.println(checksum);
			
			JSONObject head = new JSONObject();
			head.put("signature", checksum);

			paytmParams.put("body", body);
			paytmParams.put("head", head);
			

//			String post_data = paytmParams.toString();
			
//			https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=ORDERID_98765
			URL url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid="+ PayConfig.MID +"&orderId="+orderID+"");
			
//			System.out.println( "U+++++++++++++++++++++++++"+ url.toString());
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Map<String,Object>> httpEntity = new HttpEntity<>(paytmParams.toMap() , headers);
			
			//calling api
			
			RestTemplate restTemplate = new RestTemplate();
			response =  restTemplate.postForEntity(url.toString(), httpEntity, Map.class);
			
			
			System.out.println(response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		Map body1 = response.getBody();
//		body1.put("orderId", orderID);
//		body1.put("Amount", txnAmount.get("value"));
		
		return body1;
		
	}
	
}
