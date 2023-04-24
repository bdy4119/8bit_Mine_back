package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.BusinessDto;
import mul.cam.a.service.BusinessService;

@RestController
public class BusinessController {
	@Autowired
	BusinessService service;
	
	@GetMapping(value = "businesscard")
	public Map<String, Object> getBusiness(BusinessDto dto) {
		System.out.println("BusinessController getBusiness " + new Date());
		
		List<BusinessDto> list = service.businesscard(dto);
		System.out.println(list);
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	
	@PostMapping(value="businessWrite")
	public String writeBusiness(BusinessDto dto){
		System.out.println("BusinessController writeBusiness " + new Date());
		
		boolean b =service.writeBusiness(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	
	@PostMapping(value="businessUpdate")
	public String updateBusiness(BusinessDto dto){
		System.out.println("BusinessController updateBusiness " + new Date());
		
		boolean b =service.updateBusiness(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	
	@PostMapping(value="businessDelete")
	public void updateBusiness(int seq){
		System.out.println("BusinessController deleteBusiness " + new Date());
		
		service.deleteBusiness(seq);
	}
	
	
}
