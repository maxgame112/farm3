package healthcares.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import healthcares.spring.service.MemberService;
import healthcares.spring.service.StatusBreedService;

import healthcares.spring.model.Semen;


import healthcares.spring.service.SemenService;



@Controller
public class SemenbucketController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private StatusBreedService breedservice;
	@Autowired
	private SemenService semenservice;



	@RequestMapping("/view_semen") // ข้อมูลน้ำเชื้อ
	public String view_semen(HttpSession session, Map<String, Object> map) {

		String sessionUsername = (String) session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		Semen semen = new Semen();
		map.put("semen", semenservice.getAllSemen());
		return "/semen_bucket/view_semen";
	}

	@RequestMapping("/add_semen") // ลงทะเบียนน้ำเชื้อ
	public String add_semen(HttpSession session, Map<String, Object> map) {

		String sessionUsername = (String) session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		Semen semen = new Semen();
		map.put("semen", semen);
		map.put("breed", breedservice.getAllStatusBreed()); // dropdown list สายพันธุ์
		return "/semen_bucket/add_semen";
	}

	@ResponseBody // add ข้อมูลน้ำเชื้อและบันทึก
	@RequestMapping(value = "addsemen", method = RequestMethod.POST)
	public String addsemen(@ModelAttribute Semen Semen, Map<String, Object> map) {
		semenservice.add(Semen);
		return null;
	}
	
	


	// น้ำเชื้อ---------------------------------------------------------------
	@RequestMapping("/edit_semen")
	public String edit_semen(HttpSession session, Map<String, Object> map, @RequestParam int id) {

		String sessionUsername = (String) session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		Semen semen = semenservice.getSemen(id);
		map.put("semen", semen);
		map.put("breed", breedservice.getAllStatusBreed());
		return "/semen_bucket/edit_semen";
	}

	@RequestMapping("/edited_semen")
	public String edited_semen(HttpSession session, Map<String, Object> map, @ModelAttribute Semen semen) {
		
	//if (semen == null ) {
	//	System.out.println("nullllll");
	//}
		semenservice.edit(semen);
		return "redirect:view_semen";
	}

	@RequestMapping("/del_semen")
	public String del_semen(HttpSession session, Map<String, Object> map, @RequestParam int id) {
		String sessionUsername = (String) session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		semenservice.delete(id);
		return "redirect:view_semen";
	}

}
