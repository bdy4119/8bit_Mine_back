package mul.cam.a;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APIS {

	// 네이버 책 검색 API
	public static String naverBook(String search, int page) {

		String clientId = APIKEY.book_Id; //애플리케이션 클라이언트 아이디
		String clientSecret = APIKEY.book_Secret; //애플리케이션 클라이언트 시크릿


		String apiURL = "https://openapi.naver.com/v1/search/book?query=" + search + "&start=" + (page * 5 + 1) + "&display=" + 5;    // JSON 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL,requestHeaders);

		return responseBody;
	}


	private static String get(String apiUrl, Map<String, String> requestHeaders){
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}


			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}


	private static HttpURLConnection connect(String apiUrl){
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}


	private static String readBody(InputStream body){
		InputStreamReader streamReader = new InputStreamReader(body);


		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();


			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

	// 네이버 STT API
	public static String stt(String filepath) {

		String clientId = APIKEY.stt_Id;             // Application Client ID";
		String clientSecret = APIKEY.stt_Secret;     // Application Client Secret";
		StringBuffer response = new StringBuffer();

		try {
			String imgFile = filepath;
			File voiceFile = new File(imgFile);

			String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
			String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
			URL url = new URL(apiURL);

			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

			OutputStream outputStream = conn.getOutputStream();
			FileInputStream inputStream = new FileInputStream(voiceFile);
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.flush();
			inputStream.close();
			BufferedReader br = null;
			int responseCode = conn.getResponseCode();
			if(responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {  // 오류 발생
				System.out.println("error!!!!!!! responseCode= " + responseCode);
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String inputLine;

			if(br != null) {

				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return response.toString();
	}

	// Kakao local
	public static Map kakaoLocal(String query, int page) throws Exception {
		String api_key = APIKEY.kakao_Key; 
		String api_url = "https://dapi.kakao.com/v2/local/search/keyword.json?size=10&query=";
		URL obj;

//		String place = URLEncoder.encode(query, "UTF-8");

		obj = new URL(api_url + query + "&page=" + page);

		HttpURLConnection con = (HttpURLConnection)obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", api_key);
		con.setRequestProperty("content-type", "application/json");
		con.setDoOutput(true);
		con.setUseCaches(false);
		con.setDefaultUseCaches(false);

		Charset charset = Charset.forName("UTF-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		JSONParser jp = new JSONParser();	
		JSONObject jo = (JSONObject) jp.parse(response.toString());

		return jo;

	}

	// TMDB Search(Movie, Drama)
	public static Map tmdb(String kind, String query, int page) throws Exception {

		String api_key = APIKEY.tmdb_Key;
		String api_url = "";

		if(kind.equals("movie")) {
			api_url = "https://api.themoviedb.org/3/search/movie";
		} else {
			api_url = "https://api.themoviedb.org/3/search/tv";
		}

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		String uriString = api_url + "?api_key=" + api_key + "&language=ko-KR&query=" + query + "&page=" + page;
		URI uri = new URI(uriString);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				String.class);

		JSONParser jp = new JSONParser();	
		JSONObject jo = (JSONObject) jp.parse(response.getBody());
		System.out.println(jo.toString());
		return jo;
	}

	// Youtube Search
	public static Map ytSearch(String query) throws Exception {

		String api_key = APIKEY.yt_Key;
		String api_url = "https://www.googleapis.com/youtube/v3/search";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		String uriString = api_url + "?part=snippet&q=" + query + "&maxResults=10&key=" + api_key;
		URI uri = new URI(uriString);
		
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				String.class);

		JSONParser jp = new JSONParser();	
		JSONObject jo = (JSONObject) jp.parse(response.getBody());

		return jo;
	}

	// ChatGPT : Youtube URL에서 가수/노래 제목 구분
	public static String ChatGptBgm(String prompt, float temperature, int maxTokens) throws Exception {

		String API_KEY = APIKEY.gpt_Key;
		String ENDPOINT = "https://api.openai.com/v1/completions";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + API_KEY);

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("model","text-davinci-003");
		requestBody.put("prompt", URLDecoder.decode(prompt));
		requestBody.put("temperature", temperature);
		requestBody.put("max_tokens", maxTokens);


		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(ENDPOINT, requestEntity, String.class);

		try {
			JSONParser jp = new JSONParser();	
			JSONObject jo = (JSONObject) jp.parse(response.getBody());
			System.out.println(jo.toString());

			JSONArray choices = (JSONArray) jo.get("choices");
			JSONObject song = (JSONObject) choices.get(0);

			String resp = song.get("text").toString();
			return resp;
		} catch (Exception e) {
			return "";
		}

	}
	
	

}