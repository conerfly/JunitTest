import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class AllTests {
	private String code = "www.test.com";
	private String password = "111111";
	private String hotelGroupid = "159";
	private String tmpUrl = "http://test.chinapms.com:9001/gateway/";
	private String charset = "UTF-8";  
	//private String testurl = "http://test.chinapms.com:9001/gateway";
	

	@Test
   public void search_hotel_rates() throws IOException{
		String check_in_date = "2012-01-28";
		String check_out_date = "2012-02-01";
		String urlstring = "";
        String query = String.format("search_hotel_rates?sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&condition.check_in_date=%scondition.check_out_date=%s", 
        URLEncoder.encode(code, charset), 
        URLEncoder.encode(password, charset),
        URLEncoder.encode(hotelGroupid, charset),
        URLEncoder.encode(check_in_date, charset),
        URLEncoder.encode(check_out_date, charset));
        urlstring = tmpUrl+query;
   URL url = new URL(urlstring);
		//HttpURLConnection conn = null;
		
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
			conn.setDoOutput(true);
			assertEquals(HttpURLConnection.HTTP_OK, conn.getResponseCode());
			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
		    //writer.flush();
		    String line = "";
		    String tmp = "";
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    while ((line = reader.readLine()) != null) {
		    	//line = new String(line.getBytes("UTF-8"));
		        //System.out.println(line);
		    	tmp+=line;
		    }
//		    JSONObject json = new JSONObject(line);
//		    String[] names = JSONObject.getNames(json);
//		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
		    //String tmp = jsonArray.getString("exception_code");
		    //System.out.println(tmp);
		    assertFalse(tmp.contains("exception_code"));
		    //assertNotNull(line);
		    //writer.close();		    
		    conn.disconnect();
		    reader.close();
   }
	   @Test
   //get hotel detail test suite
   public void get_hotel_detail() throws UnsupportedEncodingException, IOException, JSONException{
		String urlstring = "";
        String query = String.format("get_hotel_detail?sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
        URLEncoder.encode(code, charset), 
        URLEncoder.encode(password, charset),
        URLEncoder.encode(hotelGroupid, charset),
        URLEncoder.encode("cnbjbjbfjy", charset));
        urlstring = tmpUrl+query;
   URL url = new URL(urlstring);
		//HttpURLConnection conn = null;
		
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
			conn.setDoOutput(true);
			assertEquals(HttpURLConnection.HTTP_OK, conn.getResponseCode());
			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
		    //writer.flush();
		    String line = "";
		    String tmp = "";
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    while ((line = reader.readLine()) != null) {
		    	//line = new String(line.getBytes("UTF-8"));
		        //System.out.println(line);
		    	tmp+=line;
		    }
//		    JSONObject json = new JSONObject(line);
//		    String[] names = JSONObject.getNames(json);
//		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
		    //String tmp = jsonArray.getString("exception_code");
		    //System.out.println(tmp);
		    assertFalse(tmp.contains("exception_code"));
		    //assertNotNull(line);
		    //writer.close();		    
		    conn.disconnect();
		    reader.close();
   }
	  
   
//   public void get_room_type_list() throws IOException{
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//       String charset = "UTF-8";  
//       String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
//       URLEncoder.encode(code, charset), 
//       URLEncoder.encode(password, charset),
//       URLEncoder.encode(hotelGroupid, charset),
//       URLEncoder.encode("cnbjbjbfjy", charset));
//       urlstring+=query;
//       URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
//   public void get_sub_hotel_list() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
//   public void get_rate_type_list() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
//   public void get_card_type_list() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
//   public void get_room_infos() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset),
//      URLEncoder.encode("cnbjbjbfjy", charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
//   public void get_hotel_payment_list() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset),
//      URLEncoder.encode("cnbjbjbfjy", charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
//   @Test
//   public void get_rate_promotion_list() throws IOException {
//	   String code = "www.test.com";
//		String password = "111111";
//		String hotelGroupid = "159";
//		String urlstring = "http://test.chinapms.com:9001/gateway/get_room_type_list?";
//      String charset = "UTF-8";  
//      String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&brand=%s", 
//      URLEncoder.encode(code, charset), 
//      URLEncoder.encode(password, charset),
//      URLEncoder.encode(hotelGroupid, charset),
//      URLEncoder.encode(" ◊»’∞À’€", charset));
//      urlstring+=query;
//      URL url = new URL(urlstring);
//		//HttpURLConnection conn = null;
//		
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
//			conn.setDoOutput(true);
//			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//		    //writer.flush();
//		    String line = "";
//		    String tmp = "";
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        //System.out.println(line);
//		    	tmp+=line;
//		    }
////		    JSONObject json = new JSONObject(line);
////		    String[] names = JSONObject.getNames(json);
////		    JSONArray jsonArray = json.toJSONArray(new JSONArray(names));
//		    //String tmp = jsonArray.getString("exception_code");
//		    //System.out.println(tmp);
//		    assertFalse(tmp.contains("exception_code"));
//		    //assertNotNull(line);
//		    //writer.close();		    
//		    conn.disconnect();
//		    reader.close();
//   }
   
   
   
}
