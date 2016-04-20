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

public class part5test {

	@Test
	public void list_gifts() throws UnsupportedEncodingException, IOException, JSONException{

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sob.sob_code", "www.test.com"));
		formparams.add(new BasicNameValuePair("sob.password", "111111"));
		formparams.add(new BasicNameValuePair("sob.hotelgroup_id", "159"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://test.chinapms.com:9001/gateway/list_gifts");
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
