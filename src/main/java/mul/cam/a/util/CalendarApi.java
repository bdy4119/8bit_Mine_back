package mul.cam.a.util;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;

public class CalendarApi {
	
    public static String CalenderApi(String year) {
    	
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getAnniversaryInfo"); /*URL*/
		String holidayDate = "";
		String month = "";
        StringBuilder sb = new StringBuilder();	//리턴값
        try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(APISECRET.calendar_Secret, "UTF-8"));
			/*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("365", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(year, "UTF-8")); /*연*/
	        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode(month, "UTF-8")); /*월*/
	        urlBuilder.append("&" + URLEncoder.encode("isHoliday","UTF-8") + "=" + URLEncoder.encode(holidayDate, "UTF-8")); /*월*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
//	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(XML.toJSONObject(sb.toString()).toString());
		} catch (Exception e) {
			e.printStackTrace();	
		}
        return XML.toJSONObject(sb.toString()).toString();
    }

}