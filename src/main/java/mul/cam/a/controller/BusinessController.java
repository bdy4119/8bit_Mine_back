package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.BusinessBackDto;
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
	
	
	//명함 디테일
	@GetMapping(value="businessDetail")
	public BusinessDto businessDetail(String id) {
		System.out.println("BusinessController businessDetail " + new Date());
		
		return service.businessDetail(id);
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
	
	
	
	
	
	/* 명함 뒷면 start*/
	@GetMapping(value = "businesscardBack")
	public Map<String, Object> getBusinessback(BusinessBackDto dto) {
		System.out.println("BusinessController businesscardBack " + new Date());
		
		List<BusinessBackDto> list = service.businesscardB(dto);
		System.out.println(list);
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	
	@PostMapping(value="backDel")
	public void deleteBack(int seq){
		System.out.println("BusinessController deleteBack " + new Date() );
		
		service.backDel(seq);
	}
	
	
	@PostMapping(value="backUpdate")
	public String updateBack(BusinessBackDto dto){
		System.out.println("BusinessController updateBack " + new Date());
		
		boolean b = service.backUpdate(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	//명함 디테일
	@GetMapping(value="backDetail")
	public BusinessBackDto backDetail(int seq) {
		System.out.println("BusinessController backDetail " + new Date());
			
		return service.backDetail(seq);
	}
		
	
}
