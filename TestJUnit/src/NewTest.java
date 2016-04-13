import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.Test;
import org.apache.http.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class NewTest {
	private String code = "www.test.com";
	private String password = "111111";
	private String hotelGroupid = "159";
	private String tmpUrl = "http://test.chinapms.com:9001/gateway/";
	private String charset = "UTF-8";  

	@Test
	   public void get_hotel_detail() throws UnsupportedEncodingException, IOException, JSONException{
		NameValuePair nameValuePair1 = new BasicNameValuePair("name", "yang");
		NameValuePair nameValuePair2 = new BasicNameValuePair("pwd","123123");
		List nameValuePairs = new ArrayList();
		nameValuePairs.add(nameValuePair1);
		nameValuePairs.add(nameValuePair2);
		String validateURL = "http://test.chinapms.com:9001/gateway/";
		try {
	        HttpParams httpParams = new BasicHttpParams();
	        HttpConnectionParams.setConnectionTimeout(httpParams,5000); //�������ӳ�ʱΪ5��
	        HttpClient client = new DefaultHttpClient(httpParams); // ����һ��http�ͻ��˷����������
	        HttpPost httpPost = new HttpPost(urlString); //�趨����ʽ
	          if (nameValuePairs!=null && nameValuePairs.size()!=0) {
	              //�Ѽ�ֵ�Խ��б������������HttpEntity������
	              httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,HTTP.UTF_8));
	           }
	        HttpResponse httpResponse = client.execute(httpPost); // �������󲢵ȴ���Ӧ
	          // �ж����������Ƿ�ɹ�
	          if (httpResponse.getStatusLine().getStatusCode() != 200) {
	             System.out.println("��������쳣��!!!");
	             return false;
	           }
	        HttpEntity entity = httpResponse.getEntity(); // ��ȡ��Ӧ���������
	        inputStream = entity.getContent();  // �õ��������˷��ص���Ӧ�����ݣ�����һ�������棩
	        // �õ��������˷��ص���Ӧ�����ݣ�����һ���ַ������棩
	        // String strResult = EntityUtils.toString(entity); 
	      } catch (Exception e) {
	   System.out.println("�����쳣��");
	  }
//			String urlstring = "";
//	        String query = String.format("get_hotel_detail?sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
//	        URLEncoder.encode(code, charset), 
//	        URLEncoder.encode(password, charset),
//	        URLEncoder.encode(hotelGroupid, charset),
//	        URLEncoder.encode("cnbjbjbfjy", charset));
//	        urlstring = tmpUrl+query;
//	   URL url = new URL(urlstring);
//			//HttpURLConnection conn = null;
//			
//			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//				conn.setDoOutput(true);
//				assertEquals(HttpURLConnection.HTTP_OK, conn.getResponseCode());
//				//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//			    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//			    //writer.flush();
//			    String line = "";
//			    String tmp = "";
//			    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			    while ((line = reader.readLine()) != null) {
//			    	//line = new String(line.getBytes("UTF-8"));
//			        //System.out.println(line);
//			    	tmp+=line;
//			    }
////			    JSONObject json = new JSONObject(line);
////			    String[] names = JSONObject.getNames(json);
////			    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//			    //String tmp = jsonArray.getString("exception_code");
//			    //System.out.println(tmp);
//			    assertFalse(tmp.contains("exception_code"));
//			    //assertNotNull(line);
//			    //writer.close();		    
//			    conn.disconnect();
//			    reader.close();
	   }

}
