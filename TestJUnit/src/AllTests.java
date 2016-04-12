import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
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

@RunWith(Suite.class)
@SuiteClasses({})
//not sure password's type
public class AllTests {
	private String code;
	private String password;
	private String hotelGroupid;
	
   @Test
   public void inittest(String code, String password, String hotelGroupid) throws IOException{
	   this.code = code;
	   this.password = password;
	   this.hotelGroupid = hotelGroupid;
//	   URL url = new URL("http://test.chinapms.com:9001/gateway/get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//	    URLConnection conn = null;
//		try {
//			conn = url.openConnection();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    conn.setDoOutput(true);
//	    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//
//	    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
//	    //writer.flush();
//	    String line;
//	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	    while ((line = reader.readLine()) != null) {
//	      System.out.println(line);
//	    }
//	    assertNotNull(line);
//	    //writer.close();
//	    reader.close();
   }
   public void testAdd() {
      String str= "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }
   
   public void search_hotel_rates(){
	   
   }
   //get hotel detail test suite
   public void get_hotel_detail(String id) throws UnsupportedEncodingException, IOException, JSONException{
	    String code = "www.test.com";
		String password = "111111";
		String hotelGroupid = "159";
		String urlstring = "http://test.chinapms.com:9001/gateway/get_hotel_detail?";
        String charset = "UTF-8";  
        String query = String.format("sob.sob_code=%s&sob.password=%s&sob.hotelgroup_id=%s&hotel_id=%s", 
        URLEncoder.encode(code, charset), 
        URLEncoder.encode(password, charset),
        URLEncoder.encode(hotelGroupid, charset),
        URLEncoder.encode("cnbjbjbfjy", charset));
        urlstring+=query;
   URL url = new URL(urlstring);
		//HttpURLConnection conn = null;
		
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//assertEquals((conn.getResponseCode()==HttpURLConnection.HTTP_OK),true);
			conn.setDoOutput(true);
			//OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    //writer.write("get_hotelgroup_detail?sob.sob_code=www.test.com&sob.password=111111&sob.hotelgroup_id=159&hotelgroup_id=159");
		    //writer.flush();
		    String line = "";
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    while ((line = reader.readLine()) != null) {
//		    	//line = new String(line.getBytes("UTF-8"));
//		        System.out.println(line);
//		    }
		    JSONObject json = new JSONObject(line);
		    String tmp = json.getString("exception_code");
		    System.out.println(tmp);
		    assertFalse(json.has("exception_code"));
		    //assertNotNull(line);
		    //writer.close();
		    
		    conn.disconnect();
		    reader.close();
   }
}
