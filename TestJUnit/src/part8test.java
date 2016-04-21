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

public class part8test {

	//@Test
	public void get_voucher_type_list() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_voucher_type_list");
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
	
	//@Test     //voucher.card_type_id, voucher.card_no is required
	public void sell_voucher() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("voucher.voucher_type_id", "091106143139016425L"));
		formparams.add(new BasicNameValuePair("voucher.voucher_no", "10088"));
		formparams.add(new BasicNameValuePair("voucher.card_type_id", ""));
		formparams.add(new BasicNameValuePair("voucher.card_no", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/sell_voucher");
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
	public void sell_wechat_voucher() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("voucher_type_id", "091106143139016425L"));
		formparams.add(new BasicNameValuePair("voucher_no", ""));
		formparams.add(new BasicNameValuePair("open_id", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/sell_wechat_voucher");
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
	public void get_wechat_voucher() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("voucher_type_id", "091106143139016425L"));
		formparams.add(new BasicNameValuePair("voucher_no", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/get_wechat_voucher");
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
	public void delete_wechat_voucher() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("voucher_type_id", "091106143139016425L"));
		formparams.add(new BasicNameValuePair("voucher_no", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/delete_wechat_voucher");
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
	public void bind_wechat_voucher() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		formparams.add(new BasicNameValuePair("voucher_type_id", "091106143139016425L"));
		formparams.add(new BasicNameValuePair("wechat_type_id", ""));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/bind_wechat_voucher");
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
