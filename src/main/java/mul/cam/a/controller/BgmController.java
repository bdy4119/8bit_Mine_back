package mul.cam.a.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.APIS;
import mul.cam.a.dto.BgmDto;
import mul.cam.a.service.BgmService;


@RestController
public class BgmController {

	@Autowired
	BgmService service;

	@GetMapping(value = "bgm_list")
	public List<BgmDto> bgm_list(String id) {
		System.out.println("BgmController bgm_list() : " + new Date());

		return service.bgm_list(id);
	}
	
	@GetMapping(value = "bgm_detail")
	public BgmDto bgm_detail(int seq) {
		System.out.println("BgmController bgm_detail() : " + new Date());
		
		return service.bgm_detail(seq);
	}
	
	@GetMapping(value = "bgm_del")
	public String bgm_del(int seq) {

		System.out.println("BgmController bgm_del() : " + new Date());
		
		if(service.bgm_del(seq)) {
			return "bgm_del_OK";
		} else {
			return "bgm_del_NO";
		}
	}
	
	@GetMapping(value = "bgm_add")
	public String bgm_add(BgmDto dto) {
		System.out.println("BgmController bgm_add() : " + new Date());
		
		if(service.bgm_add(dto)) {
			return "bgm_add_OK";
		} else {
			return "bgm_add_NO";
		}
	}
	
	@GetMapping(value = "ytSearch")
	public Map ytSearch(String query) throws Exception {
		System.out.println("BGMController ytSearch() : " + new Date());
		
		return APIS.ytSearch(query);
	}
	
	@GetMapping(value = "chatgpt_bgm")
	public String chatgpt_bgm(String prompt) throws Exception {
		System.out.println("BgmController chatgpt_bgm() : " + new Date());
			
		String basic = "Just pick the singer and song title from the next YouTube title. Leave out all the additional information. "
				+ "Print it out in JSON form of {\"artist\":, \"title\":}.";
		String query = basic + prompt;
		
		
		return APIS.ChatGptBgm(query, 0, 500);
	
	}

}
