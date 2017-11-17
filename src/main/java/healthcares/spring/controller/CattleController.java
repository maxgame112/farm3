package healthcares.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.functors.IfClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import healthcares.spring.model.Cattle;
import healthcares.spring.model.Disease;
import healthcares.spring.model.StatusBreed;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.ColorService;
import healthcares.spring.service.GroupCattleService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.SexService;
import healthcares.spring.service.StallService;
import healthcares.spring.service.StatusBreedService;
import healthcares.spring.service.StatusCattleService;
import healthcares.spring.service.StatusTreatService;
import healthcares.spring.service.TypeCattleService;

@Controller
public class CattleController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CattleService cattleservice;
	
	@Autowired
	private TypeCattleService typrcattleservice;
	
	@Autowired
	private StatusBreedService statusbreedservice;
	
	@Autowired
	private StatusCattleService statuscattleservice;
	
	@Autowired
	private ColorService colorservice;
	
	@Autowired
	private GroupCattleService groupcattleservice;
	
	@Autowired
	private StallService stallservice;
	
	@Autowired
	private SexService sexservice;
	
	@Autowired
	private StatusTreatService statustreatservice;
	
	@RequestMapping(value="cattle",method=RequestMethod.GET)
	public String cattle(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Cattle cattle = new Cattle();
		map.put("sh", cattle);
		map.put("type", typrcattleservice.getAllTypeCattle());
		map.put("stabreed", statusbreedservice.getAllStatusBreed());
		map.put("stacattle", statuscattleservice.getAllStatusCattle());
		map.put("colo", colorservice.getAllColor());
		map.put("groupcattle", groupcattleservice.getAllGroupCattle());
		map.put("stal", stallservice.getAllStall());
		/*cattle.setStatusCattle(statuscattleservice.getStatusCattle(2));*/
		//map.put("sex", sexservice.getAllSex());
		return "/cattle/cattle"; 
	
	}
	
	@ResponseBody
	@RequestMapping(value="addcattle",method = RequestMethod.POST)
	public String addcattle(@ModelAttribute Cattle cattle, Map<String, Object> map){
		cattle.setStatusCattle(statuscattleservice.getStatusCattle(2));
		cattle.setStatusTreat(statustreatservice.getStatusTreat(0));
		cattle.setTeeth(0);
		cattleservice.add(cattle);//add ข้อมูลเข้าไป
		return "redirect:index";
	}
	
	@RequestMapping(value="cattlelist",method=RequestMethod.GET)
	public String cattlelist(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
/*		Cattle cattle = new Cattle();
		map.put("sh", cattle);*/
		map.put("cattle", cattleservice.getAllCattle());
/*		map.put("type", typrcattleservice.getAllTypeCattle());
		map.put("stabreed", statusbreedservice.getAllStatusBreed());
		map.put("stacattle", statuscattleservice.getAllStatusCattle());
		map.put("colo", colorservice.getAllColor());
		map.put("groupcattle", groupcattleservice.getAllGroupCattle());
		map.put("stal", stallservice.getAllStall());*/
		return "/cattle/cattle_list";  												
	}
		
	@RequestMapping(value="cattleDetail",method=RequestMethod.POST)
	public String cattleDetail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Cattle cattle = new Cattle();
		/*map.put("sh", cattle);*/
		map.put("cattle", cattleservice.getCattle(id));
		return "/cattle/cattle_detail";  												
	}


	@RequestMapping(value="edit_cattle",method=RequestMethod.POST)
	public String edit_cattle(HttpSession session,Map<String, Object> map,@RequestParam int id) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		Cattle cattle = cattleservice.getCattle(id);
		map.put("shc", cattle);
/*		map.put("cattle", cattleservice.getAllCattle());*/
		map.put("type", typrcattleservice.getAllTypeCattle());
		map.put("stabreed", statusbreedservice.getAllStatusBreed());
		map.put("stacattle", statuscattleservice.getAllStatusCattle());
		map.put("colo", colorservice.getAllColor());
		map.put("groupcattle", groupcattleservice.getAllGroupCattle());
		map.put("stal", stallservice.getAllStall());
		map.put("statT", statustreatservice.getAllStatusTreat());
		return "/cattle/edit_cattle";  												
	}	
	
	@RequestMapping("/edited_cattle")
	public String edited_cattle(HttpSession session,Map<String, Object>map,@ModelAttribute Cattle cattle){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		if(cattle.getGroupCattle().getId() == 1){
			cattle.setTeeth(1);
		}
		
		cattleservice.edit(cattle);
		return "redirect:cattlelist";
		
	}
	@RequestMapping("/del_cattle")
	public String delete_cattle(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		cattleservice.delete(id);
		
		return "redirect:cattlelist";
	}
	
	
	/* @RequestMapping(value="groupcattle",method=RequestMethod.POST)
	public String groupcattle(HttpSession session,Map<String, Object> map,@RequestParam int id) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		
		Cattle cattle = cattleservice.getCattle(id);
		map.put("shc", cattle);
		map.put("gcattle", cattleservice.getAllCattle());
		map.put("groupcattle", groupcattleservice.getAllGroupCattle());
		return "/cattle/groupcattle"; 
	
	}
	
	
	@RequestMapping("/editgroup")
	public String editgroup(HttpSession session,Map<String, Object>map,@ModelAttribute Cattle cattle){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		if (cattle.getGroupCattle().getId() == 1) {
			cattle.setTeeth(1);
		}
		
		cattleservice.edit(cattle);
		return "redirect:index";
	}*/
	
	/*@RequestMapping("/editgroup")
	public String editgroup(HttpSession session,Map<String, Object>map,
			@RequestParam("catl") String cattle,
			@RequestParam("groupCattleid") int groupCattleid){
			
		Cattle cattle1 = new Cattle();
		cattle1.setNum(cattle);
		cattle1.setGroupCattle(groupcattleservice.getGroupCattle(groupCattleid));
		cattle1.setTeeth(1);
		
		System.out.println(cattle);
		System.out.println(groupCattleid);
		System.out.println(1);                   
		
	
		
			if (groupCattleid == 1) {
				cattle1.setNum(cattle);
				cattle1.setGroupCattle(groupcattleservice.getGroupCattle(groupCattleid));
				cattle1.setTeeth(1);
				//System.out.println(cattle);
				//System.out.println(groupCattleid);
				//System.out.println(1); 
			}else{
				cattle1.setNum(cattle);
				cattle1.setGroupCattle(groupcattleservice.getGroupCattle(groupCattleid));
				//System.out.println(cattle);
				//System.out.println(groupCattleid);
			}
			
			cattleservice.edit(cattle1);
		
		return "redirect:index";
	}*/
	
}

