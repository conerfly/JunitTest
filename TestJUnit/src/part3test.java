import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class part3test {

	//@Test    //room_order_id":"O1604181741107132634S
	public void create_order() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("order.hotel_id", "cnbjbjcgmz"));
		formparams.add(new BasicNameValuePair("order.room_type_id", "1837"));
		formparams.add(new BasicNameValuePair("order.room_quantity", "1"));
		formparams.add(new BasicNameValuePair("order.check_in_date", "2016-04-28"));
		formparams.add(new BasicNameValuePair("order.check_out_date", "2016-05-01"));
		formparams.add(new BasicNameValuePair("order.rate_code", "WEB"));
		formparams.add(new BasicNameValuePair("order.contacter", "Johnny"));
		formparams.add(new BasicNameValuePair("order.name", "Johnny"));	
		formparams.add(new BasicNameValuePair("order.total_order_money", "900"));
		formparams.add(new BasicNameValuePair("order.mobile","13310453245"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/create_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void cancel_order() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		//formparams.add(new BasicNameValuePair("hotel_id", "cnbjbjcgmz"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("mobile_or_email", "13310453245"));
		//formparams.add(new BasicNameValuePair("room_type_id", "1837"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/cancel_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}

	//@Test
	public void get_order_detail() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("mobile_or_email", "13310453245"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_order_detail");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test					//"exception_description":"订单已经入住完成，被取消或者NoShow，不能付款"
	public void deposit_order() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("deposit_account.room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("deposit_account.money", "1000"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/deposit_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void get_card_orders() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_card_orders");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test                          //"exception_description":"订单已经入住完成，被取消或者NoShow，不能付款"
	public void card_deposit_pay_order() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("deposit", "1000"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/card_deposit_pay_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test                //"exception_description":"预付款金额错误"
	public void card_score_pay_order() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("deposit", "1000"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("password", "654321"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/card_score_pay_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void get_avail_rooms() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_type_id", "1837"));
		formparams.add(new BasicNameValuePair("check_in_date", "2016-04-28"));
		formparams.add(new BasicNameValuePair("check_out_date", "2016-05-01"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_avail_rooms");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void assign_order_rooms() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("room_ids", "303"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/assign_order_rooms");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void reassign_order_rooms() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_id", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("room_ids", "304"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/reassign_order_rooms");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void search_orders() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("condition.card_no", "1459"));
		formparams.add(new BasicNameValuePair("condition.card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("condition.hotel_id", "cnbjbjcgmz"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/search_orders");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void get_order_by_ids() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("order_ids", "O1604181741107132634S"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_order_by_ids");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test 							//need to fill out the voucher_no, and voucher_type_id
	public void voucher_pay_order() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("room_order_ids", "O1604181741107132634S"));
		formparams.add(new BasicNameValuePair("voucher_no", ""));
		formparams.add(new BasicNameValuePair("voucher_type_id", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/voucher_pay_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test
	public void get_order_by_date() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("mobile_or_email", "13310453245"));
		formparams.add(new BasicNameValuePair("check_in_date", "2016-04-28"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_order_by_date");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
	//@Test				//enter the correct room rate before testing
	public void create_clock_order() throws UnsupportedEncodingException, IOException, JSONException{
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("order.hotel_id", "cnbjbjcgmz"));
		formparams.add(new BasicNameValuePair("order.room_type_id", "1837"));
		formparams.add(new BasicNameValuePair("order.room_quantity", "1"));
		formparams.add(new BasicNameValuePair("order.check_in_date", "2016-04-28"));
		formparams.add(new BasicNameValuePair("order.check_out_date", "2016-05-01"));
		formparams.add(new BasicNameValuePair("order.adult_quantity", "1"));
		formparams.add(new BasicNameValuePair("order.rate_code", "WEB"));
		formparams.add(new BasicNameValuePair("order.contacter", "Johnny"));
		formparams.add(new BasicNameValuePair("order.name", "Johnny"));	
		formparams.add(new BasicNameValuePair("order.total_order_money", "0"));
		formparams.add(new BasicNameValuePair("order.mobile","13310453245"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/create_clock_order");
		httppost.setEntity(entity);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httppost); 
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		HttpEntity result = httpResponse.getEntity(); 
		String strResult = EntityUtils.toString(result); 
		System.out.println(strResult);
		JSONObject json = new JSONObject(strResult);
		assertFalse(json.has("exception_code"));
	}
	
}
