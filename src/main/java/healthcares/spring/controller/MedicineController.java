package healthcares.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import healthcares.spring.model.Cattle;
import healthcares.spring.model.Disease;
import healthcares.spring.model.Medicine;
import healthcares.spring.model.MedicineOrder;
import healthcares.spring.model.Member;
import healthcares.spring.service.GroupMedicineService;
import healthcares.spring.service.MedicineOrderService;
import healthcares.spring.service.MedicineService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.PrivilegeService;
import healthcares.spring.service.TypeMedicineService;
import healthcares.spring.service.UnitMedicineService;


@Controller
public class MedicineController {
	
	@Autowired
	MedicineService medicineservice;
	
	@Autowired
	GroupMedicineService groupmedicineservice;
	
	@Autowired
	TypeMedicineService typemedicineservice;
	
	@Autowired
	UnitMedicineService unitmedicineservice;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="medicine",method=RequestMethod.GET)
	public String Medi(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Medicine medicine = new Medicine();
		map.put("show", medicine);
		map.put("medicinelist", medicineservice.getAllMedicine());
		map.put("groupmed", groupmedicineservice.getAllGroupMedicine());
		map.put("typemed",groupmedicineservice.getAllGroupMedicine());
		map.put("un", unitmedicineservice.getAllUnitMedicine());
		
		return "/medicine/medicine";
	}

	@ResponseBody
	@RequestMapping(value="addmedi",method = RequestMethod.POST)
	public String addmedi(@ModelAttribute Medicine Medicine, Map<String, Object> map){
		Medicine.setMedicineSuccess(1);
		medicineservice.add(Medicine); //add ข้อมูลเข้าไป
		return "1";
	}
	
	@RequestMapping(value="medicinesh")
	public String medicinesh(HttpSession session,Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Medicine medicine = new Medicine();
		map.put("show", medicine);
		map.put("list", medicineservice.getAllMedicine());
		map.put("group", groupmedicineservice.getAllGroupMedicine());
		map.put("unit", unitmedicineservice.getAllUnitMedicine());
		return "/medicine/medicinesh";
	}

	@RequestMapping(value="medicinedetail",method=RequestMethod.POST)
	public String medicinedetail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Medicine medicine = new Medicine();
		map.put("sh", medicine);
		map.put("medicine", medicineservice.getMedicine(id));
		return "/medicine/medicine_detail";  												
	}	
	
	@RequestMapping(value="edit_medicine",method=RequestMethod.POST)
	public String edit_medicine(HttpSession session,Map<String, Object> map,@RequestParam int id) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Medicine medicine = medicineservice.getMedicine(id);
		map.put("sh", medicine);
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("groupmed", groupmedicineservice.getAllGroupMedicine());
		return "/medicine/edit_medicine";  												
	}	
	
	@RequestMapping("/medicine_edited")
	public String medicine_edited(HttpSession session,Map<String, Object>map,@ModelAttribute Medicine medicine){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		medicineservice.edit(medicine);
		return "redirect:medicinesh";
	}
	
	@RequestMapping("/del_medicine")
	public String delete_medi(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		medicineservice.delete(id);
		
		return "redirect:medicinesh";
	}
	
	
	@RequestMapping("/import_medicine") //นำเข้ายา
	public String import_medicine(HttpSession session,Map<String, Object> map) {
		
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		
		return "medicine/import_medicine";
	}
	
	@RequestMapping("/release_medicine")//เบิกยา
	public String release_medicine(HttpSession session,Map<String, Object> map) {
		
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		
		return "/medicine/release_medicine";
	}
	
	@RequestMapping("/order_medicine")//��觫�����
	public ModelAndView order_medicine(HttpSession session,Map<String, Object> map) {
		
		String sessionUsername = (String)session.getAttribute("username");
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		MedicineOrder mediorder = new MedicineOrder();
		map.put("ordermed",mediorder);
		map.put("medicine", medicineservice.getAllMedicine());
	
		Date date = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	    String day = sdfDate.format(date);
		map.put("day", day);
		ModelAndView model = new ModelAndView("/medicine/order_medicine");
		return model;
	}
}
