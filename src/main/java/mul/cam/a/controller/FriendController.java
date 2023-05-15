package mul.cam.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.FriendDto;
import mul.cam.a.dto.MineDto;
import mul.cam.a.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	FriendService service;
	
	@PostMapping(value = "acceptfriend")
	public String acceptfriend(FriendDto dto){
		System.out.println("acceptfriend " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.acceptfriend(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "friendlist")
	public List<FriendDto> friendlist(FriendDto dto){
		System.out.println("friendlist " + new Date());
		
		return service.friendlist(dto);
	}
	
	@PostMapping(value = "friendCount")
	public int friendCount(String id) {
		
		return service.friendCount(id);
	}
	
	@PostMapping(value = "deletefriend")
	public String deletefriend(int seq){
		System.out.println("deletefriend " + new Date());
		
		boolean b = service.deletefriend(seq);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}

}
