package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
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
	public BusinessDto businessDetail(String email) {
		System.out.println("BusinessController businessDetail " + new Date());
		
		return service.businessDetail(email);
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
	
	
	
	
	
	/* 명함 뒷면 start-------------------------------------------------*/
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
	
	
	@PostMapping(value="backWrite")
	public String writeback(BusinessBackDto dto){
		System.out.println("BusinessController writeBack " + new Date());
		
		boolean b = service.backWrite(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	

	
	
	
	
	// upload *****************************
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String fileUpload(BusinessDto dto, @RequestParam("uploadFile")
								MultipartFile uploadFile, HttpServletRequest req) {
			System.out.println("HelloController fileUpload" + new Date());
			System.out.println(dto.toString());
			
			//경로 얻어오기
			String path = req.getServletContext().getRealPath("/Upload");
		//	String path = "c:\temp";	-> 여기 올리면 서버껐다가 켜도 사라지지않음(연습용)
			
			//기본파일명 -> 시간파일명
			//파일이 없을 경우 아래 코드들 실행되면 안됨
			String filename = uploadFile.getOriginalFilename();
			String filepath = "C:/Final_MINE_FRONT/8bit_Mine_Front/public/Business-img/" + filename;	//실제경로 + 원본파일명	
			
			//다연 경로
//			String filepath = "C:\\Users\\PC\\Desktop\\_multicam\\_final-project\\_react-front\\8bit_Mine_Front\\public\\Business-img\\" + filename;	//실제경로 + 원본파일명
			
			System.out.println(filepath);
			
//			String publicpath = "C:\\Users\\PC\\Desktop\\_multicam\\_final-project\\_react-front\\8bit_Mine_Front\\public\\Business-img";
//			String publicUpload = publicpath + "\\" + filename;
			
		//	System.out.println(publicUpload);
			
			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				bos.write(uploadFile.getBytes());
				bos.close(); //꼭 닫아주기!
				
//				BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(new File(publicUpload)));
//				bos2.write(uploadFile.getBytes());
//				bos2.close();
			} catch (Exception e) {
				return "file upload fail";
			}
			return "file upload success";
		}
	
	
	
	
	
}

