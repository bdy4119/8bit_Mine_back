package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.APIS;
import mul.cam.a.dto.KakaoToken;
import mul.cam.a.dto.LoginDto;
import mul.cam.a.dto.OAuthToken;
import mul.cam.a.service.LoginService;
import mul.cam.a.util.FileUtil;


@RestController
public class LoginController {
	@Autowired
	LoginService service;
	
	@GetMapping(value = "/callback/kakao")
	public String kakaologin(String code) {
		String social = "kakao";
		
		// 인가 코드 출력
		System.out.println("인가 코드: " + code);
		
		// API 키
		String apiKey = "746d748ae3421ccabe20af6703c55dac";
		
		// 인가 코드로 토큰 정보 받기
		RestTemplate rt = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", apiKey);
		params.add("redirect_uri", "http://localhost:9001/callback/kakao");
		params.add("code", code);
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaorequest = new HttpEntity<>(params, headers);
		
		// exchange()는 HttpEntity<>라는 오브젝트를 담음
		// post 방식으로 Http 요청하기 - response 변수에 응답 받음
		ResponseEntity<String> response = rt.exchange(
			"https://kauth.kakao.com/oauth/token",
			HttpMethod.POST,
			kakaorequest,
			String.class
		);
		
		// 토큰 정보 출력
		System.out.println("토큰 정보: " + response.getBody());
		
		// 받은 토큰 정보에서 액세스 토큰 추출
		ObjectMapper objectmapper = new ObjectMapper();
		OAuthToken oauthtoken = null;
		
		try {
			oauthtoken = objectmapper.readValue(response.getBody(), OAuthToken.class);
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// 액세스 토큰 출력
		System.out.println("액세스 토큰: " + oauthtoken.getAccess_token());
		
		// 액세스 토큰으로 회원 정보 받기
		RestTemplate rt2 = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oauthtoken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpHeader 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaorequest2 = new HttpEntity<>(headers2);
		
		// exchange()는 HttpEntity<>라는 오브젝트를 담음
		// post 방식으로 Http 요청하기 - response 변수에 응답 받음
		ResponseEntity<String> response2 = rt2.exchange(
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.POST,
			kakaorequest2,
			String.class
		);
		
		// 회원 정보 출력
		System.out.println("회원 정보: " + response2.getBody());
		
		// 회원 정보 추출
		ObjectMapper objectmapper2 = new ObjectMapper();
		KakaoToken kakaotoken = null;
		
		try {
			kakaotoken = objectmapper2.readValue(response2.getBody(), KakaoToken.class);
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// 회원의 이메일 정보 출력
		System.out.println("이메일: " + kakaotoken.getKakao_account().getEmail());
		
		// 서버 jwt 발행 (pom.xml에 jwt 세팅 필요)
		// jwt 안에 회원의 아이디 정보 넣기
		String jsonstring = kakaotoken.getKakao_account().getEmail();
		
		// 암호키 (256비트 이상)
		String secretkey = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";
		
		String jwt = Jwts.builder()
				.setSubject(jsonstring)
				//.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 유효기간 1H
				.signWith(SignatureAlgorithm.HS256, secretkey)
				.compact();
		
		// jwt 출력
		System.out.println("JWT: " + jwt);
		
		// 가입 여부 체크
		String email = kakaotoken.getKakao_account().getEmail();
		boolean emailCheckB = service.emailCheck(email);

		// 최초 로그인시 DB에 회원등록
		if (emailCheckB) {
			System.out.println("회원 등록 진행");
			
			// DB에 회원등록 (id, email, jwt 등록)
			String id = kakaotoken.getId();
			String profPic = null;
			String profMsg = null;
			String job = null;
			String birthdate = null;
			String address = null;
			
			boolean regiUserB = service.regiUser(id, email, social, jwt, profPic, profMsg, job, birthdate, address);
			
			if (regiUserB) {
				System.out.println("회원 등록 성공");
			}
			else {
				System.out.println("회원 등록 실패");
			}
		}
		else {
			System.out.println("회원 존재");
		}
		
		// id값으로 DB에서 jwt값 불러오기
		String userJwt = service.getJwt(email);
		
		// 로그인한 회원의 jwt값 출력
		System.out.println("회원 JWT: " + userJwt);
		
		// json web token 프론트엔드로 전달
		return userJwt;
	}
	
	@PostMapping(value = "/withdrawal")
	public String kakaoWithdrawal(String token) {
		// 토큰 출력
		System.out.println(token);
		
		// 사용자 아이디 가져오기
		String id = service.getId(token);
		
		// 아이디 출력
		System.out.println(id);
		
		// 어드민 키
		String adminKey = "1597a3e5e976105a7dd92b592d0c61b9";
		
		// 카카오와 연결 끊기
		RestTemplate rt = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded");
		headers.add("Authorization", "KakaoAK " + adminKey);
		
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", id);
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaorequest = new HttpEntity<>(params, headers);
		
		// exchange()는 HttpEntity<>라는 오브젝트를 담음
		// post 방식으로 Http 요청하기
		rt.exchange(
			"https://kauth.kakao.com/oauth/token",
			HttpMethod.POST,
			kakaorequest,
			String.class
		);
		
		// DB에 회원삭제
		boolean b = service.withdrawalUser(id);
		
		if (b) {
			return "탈퇴 완료";
		}
		
		return "오류 발생";
	}
	
	@GetMapping(value = "/show")
	public Map<String, Object> show(String token){
		// 토큰을 통해 사용자 DB 불러오기
		LoginDto dto = service.showUser(token);
		
		// 사용자 정보 출력
		System.out.println(dto);
		
		// hashmap에 데이터 담기
		Map<String, Object> map = new HashMap<>();
		map.put("email", dto.getEmail());
		map.put("name", dto.getName());
		map.put("regidate", dto.getRegidate());
		map.put("social", dto.getSocial());
		map.put("profPic", dto.getProfPic());
		map.put("profMsg", dto.getProfMsg());
		map.put("job", dto.getJob());
		map.put("birthdate", dto.getBirthdate());
		map.put("address", dto.getAddress());

		// 사용자 정보 보내기
		return map;
	}
	
	
	@PostMapping(value = "/edit")
	public String edit(@RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest req, LoginDto dto) {
		
		String uploadpath = req.getServletContext().getRealPath("/upload");
		
		String filename = uploadFile.getOriginalFilename();
		System.out.println(filename);
		String newfilename = FileUtil.getNewFileName(filename);
		String filepath = uploadpath + "/" + newfilename;
		
		String publicpath = "C:/Final_MINE_FRONT/8bit_Mine_Front/public/profPic";
		String publicUpload = publicpath + "/" + newfilename;
		dto.setProfPic(newfilename);
		
		boolean b = service.editUser(dto);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			bos.write(uploadFile.getBytes());
			bos.close();
			
			BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(new File(publicUpload)));
			bos2.write(uploadFile.getBytes());
			bos2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (b) {
			return "수정 완료";
		}
		
		return "오류 발생";
	}
	
	@GetMapping(value = "/jwtcheck")
	public String jwtcheck(String token) {
		
		// jwt 검증
		boolean b = service.jwtCheck(token);
		
		// 검증 통과
		if (b) {
			System.out.println("검증 통과");
			
			return "pass";
		}
		
		// 검증 탈락
		System.out.println("검증 탈락");
		
		return "faild";
	}
	
	@GetMapping(value = "/authcheck")
	public int authcheck(String token) {
		// auth 값 가져오기
		int i = service.authCheck(token);
		
		System.out.println("auth 값: " + i);
		
		return i;
	}
	
	@GetMapping(value = "/callback/google")
	public String googlelogin(String id, String email) {
		String social = "google";
		
		// 사용자 정보 출력
		System.out.println("아이디: " + id);
		System.out.println("이메일: " + email);
		
		// 서버 jwt 발행 (pom.xml에 jwt 세팅 필요)
		// jwt 안에 회원의 아이디 정보 넣기
		String jsonstring = email;
		
		// 암호키 (256비트 이상)
		String secretkey = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";
		
		String jwt = Jwts.builder()
				.setSubject(jsonstring)
				//.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 유효기간 1H
				.signWith(SignatureAlgorithm.HS256, secretkey)
				.compact();
		
		// jwt 출력
		System.out.println("JWT: " + jwt);
		
		// 가입 여부 체크
		boolean emailCheckB = service.emailCheck(email);

		// 최초 로그인시 DB에 회원등록
		if (emailCheckB) {
			System.out.println("회원 등록 진행");
			String profPic = null;
			String profMsg = null;
			String job = null;
			String birthdate = null;
			String address = null;
			
			// DB에 회원등록 (id, email, jwt 등록)
			boolean regiUserB = service.regiUser(id, email, social, jwt, profPic, profMsg, job, birthdate, address);
			
			if (regiUserB) {
				System.out.println("회원 등록 성공");
			}
			else {
				System.out.println("회원 등록 실패");
			}
		}
		else {
			System.out.println("회원 존재");
		}
		
		// id값으로 DB에서 jwt값 불러오기
		String userJwt = service.getJwt(email);
		
		// 로그인한 회원의 jwt값 출력
		System.out.println("회원 JWT: " + userJwt);
		
		// json web token 프론트엔드로 전달
		return userJwt;
	}
	
	@GetMapping(value = "/callback/microsoft")
	public String microsoftlogin(String id, String email) {
		String social = "microsoft";
		
		// 사용자 정보 출력
		System.out.println("아이디: " + id);
		System.out.println("이메일: " + email);
		
		// 서버 jwt 발행 (pom.xml에 jwt 세팅 필요)
		// jwt 안에 회원의 아이디 정보 넣기
		String jsonstring = email;
		
		// 암호키 (256비트 이상)
		String secretkey = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";
		
		String jwt = Jwts.builder()
				.setSubject(jsonstring)
				//.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 유효기간 1H
				.signWith(SignatureAlgorithm.HS256, secretkey)
				.compact();
		
		// jwt 출력
		System.out.println("JWT: " + jwt);
		
		// 가입 여부 체크
		boolean emailCheckB = service.emailCheck(email);
		
		// 최초 로그인시 DB에 회원등록
		if (emailCheckB) {
			System.out.println("회원 등록 진행");
			String profPic = null;
			String profMsg = null;
			String job = null;
			String birthdate = null;
			String address = null;
			
			// DB에 회원등록 (id, email, jwt 등록)
			boolean regiUserB = service.regiUser(id, email, social, jwt, profPic, profMsg, job, birthdate, address);
			
			if (regiUserB) {
				System.out.println("회원 등록 성공");
			}
			else {
				System.out.println("회원 등록 실패");
			}
		}
		else {
			System.out.println("회원 존재");
		}
		
		// id값으로 DB에서 jwt값 불러오기
		String userJwt = service.getJwt(email);
		
		// 로그인한 회원의 jwt값 출력
		System.out.println("회원 JWT: " + userJwt);
		
		// json web token 프론트엔드로 전달
		return userJwt;
	}
	
	@GetMapping(value = "/userlist")
	public Map<String, Object> userlist(){
		List<LoginDto> list = service.userList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
}
































