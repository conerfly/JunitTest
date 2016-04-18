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

public class part4test {
	
	//@Test
	public void register_card() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card.card_type_id ", "100847"));
		formparams.add(new BasicNameValuePair("card.card_no", "1459"));
		formparams.add(new BasicNameValuePair("card.password", "123456"));
		formparams.add(new BasicNameValuePair("card.consume_password", "123456"));
		formparams.add(new BasicNameValuePair("card.user_name", "johnny"));
		formparams.add(new BasicNameValuePair("card.gender", "0"));
		formparams.add(new BasicNameValuePair("card.id_card_type_id", "11"));
		formparams.add(new BasicNameValuePair("card.id_card_no", "511702197409284963"));
		formparams.add(new BasicNameValuePair("card.is_actived", "1"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/register_card");
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
	public void active_card() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1458"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/active_card");
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
	public void card_login() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("password", "123456"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/card_login");
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
	public void modify_card_profile() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card.card_no", "1459"));
		formparams.add(new BasicNameValuePair("card.card_type_id", "100847"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/modify_card_profile");
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
	public void get_card_detail() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_card_detail");
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
	public void list_card_check_records() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("condition.card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("condition.card_no", "1459"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/list_card_check_records");
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
	public void modify_card_password() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("new_password", "654321"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/modify_card_password");
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
	public void modify_card_consume_password() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("password", "654321"));	
		formparams.add(new BasicNameValuePair("new_consume_password", "654321"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/modify_card_consume_password");
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
	public void list_card_score_logs() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("condition.card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("condition.card_no", "1459"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/list_card_score_logs");
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
	public void list_card_deposit_logs() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("condition.card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("condition.card_no", "1459"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/list_card_deposit_logs");
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
	public void modify_card_score() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("score", "10"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/modify_card_score");
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
	public void query_cards() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("condition.card_no", "1459"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/query_cards");
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
	
	//@Test     //did not set the mobile number at the first method
	public void reset_card_password() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("mobile", ""));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/reset_card_password");
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
	
	//@Test  //third party binding, not available for testing
	public void get_binding_card() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("qq", ""));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_binding_card");
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
	public void get_card_vouchers() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_card_vouchers");
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
	
	//@Test     //third party test, currently not available
	public void binding_exist_card() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("qq", ""));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/binding_exist_card");
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
	
	//@Test     //third party test currently not available
	public void delete_card_binding() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("binding_type", "1"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/delete_card_binding");
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
	
	@Test
	public void deposit_card() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("card_type_id", "100847"));
		formparams.add(new BasicNameValuePair("card_no", "1459"));
		formparams.add(new BasicNameValuePair("payment.money", "100"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/deposit_card");
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
