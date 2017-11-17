package healthcares.spring.controller;

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
import healthcares.spring.model.Member;
import healthcares.spring.model.Color;
import healthcares.spring.model.GroupMedicine;
import healthcares.spring.model.StatusBreed;
import healthcares.spring.model.Sync;
import healthcares.spring.model.TypeAlert;
import healthcares.spring.model.TypeSync;
import healthcares.spring.service.ColorService;
import healthcares.spring.service.GroupMedicineService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.PrivilegeService;
import healthcares.spring.service.StatusBreedService;
import healthcares.spring.service.SyncService;
import healthcares.spring.service.TypeAlertService;
import healthcares.spring.service.TypeSyncService;


@Controller
public class SettingController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private GroupMedicineService groupmedicineservice;
	
	@Autowired
	private TypeAlertService typealertservice;
	
	@Autowired
	private StatusBreedService statusbreedservice;
	
	@Autowired
	private ColorService colorservice;
	
	@Autowired
	private PrivilegeService privilegeservice;
	
	@Autowired
	private TypeSyncService typesyncservice;
	
	@Autowired
	private SyncService syncservice;
	
	@RequestMapping(value="set_medicine",method=RequestMethod.GET)
	public String set_medicine(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		GroupMedicine groupmed	= new GroupMedicine();
		map.put("groupm", groupmed);
		map.put("grpm", groupmedicineservice.getAllGroupMedicine());
		return "/setting/set_medicine";
	}
	

	@RequestMapping("/del_group")
	public String del_group(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		groupmedicineservice.delete(id);
		
		return "redirect:set_medicine";
	}
	
	@ResponseBody
	@RequestMapping(value="Checkgroup",method = RequestMethod.POST)
	public String addGroup(@RequestParam("value") String name){
		String msg ="yes";
		int chk = groupmedicineservice.getGroupMed(name).size();
		if(chk>0){
			msg="no";
		}
		return msg; 
	}
	
	@RequestMapping(value="addGroup",method = RequestMethod.POST)
	public String addGroup(@ModelAttribute GroupMedicine groupMedicine, Map<String, Object> map){

			groupmedicineservice.add(groupMedicine);
			return "redirect:set_medicine";
	}
	
	@RequestMapping(value="set_alert",method=RequestMethod.GET)
	public String set_alert(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		TypeAlert typealert = new TypeAlert();
		
		map.put("typealert", typealert);
		map.put("tyalert", typealertservice.getAllTypeAlert());

		return "/setting/set_alert";
	}
	
	@RequestMapping(value="edit_alert",method = RequestMethod.POST)
	public String edit_alert(HttpSession session,Map<String, Object> map,
						@RequestParam("id") int id,
						@RequestParam("name") String name,
						@RequestParam("value") int value,
						@RequestParam("note") String note){
			
		TypeAlert typeAlert = typealertservice.getTypeAlerte(id);
		typeAlert.setId(id);
		typeAlert.setNote(note);
		typeAlert.setName(name);
		typeAlert.setValue(value);
		typealertservice.edit(typeAlert);
		return "redirect:set_alert";
	}

	@RequestMapping(value="set_statusbreed",method=RequestMethod.GET)
	public String set_statusbreed(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		StatusBreed statusBreed = new StatusBreed();
		map.put("statb", statusBreed);
		map.put("stat", statusbreedservice.getAllStatusBreed());
		return "setting/set_statusbreed";
	}
	
	@RequestMapping("/del_statBreed")
	public String del_statBreed(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		statusbreedservice.delete(id);
		
		return "redirect:set_statusbreed";
	}
	
	@ResponseBody
	@RequestMapping(value="Checkbreed",method = RequestMethod.POST)
	public String Checkbreed(@RequestParam("value") String name){
		String msg ="yes";
		int chk = statusbreedservice.getStatBreed(name).size();
		if(chk>0){
			msg="no";
		}
		return msg; 
	}
	
	@RequestMapping(value="addStat",method = RequestMethod.POST)
	public String addStat(@ModelAttribute StatusBreed statusBreed , Map<String, Object>map){
		statusbreedservice.add(statusBreed);
		return "redirect:set_statusbreed";
	}
	
	@RequestMapping(value="set_color",method = RequestMethod.GET)
	public String set_color(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Color color = new Color();
		map.put("color", color);
		map.put("colo", colorservice.getAllColor());
		return "setting/set_color";
	}
	
	@RequestMapping("/del_color")
	public String del_color(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		colorservice.delete(id);
		
		return "redirect:set_color";
	}
	
	@ResponseBody
	@RequestMapping(value="Checkcolorr",method = RequestMethod.POST)
	public String Checkcolorr(@RequestParam("nameColor") String name){
		String msg ="yes";
		int chk = colorservice.getColoor(name).size();
		if(chk>0){
			msg="no";
		}
		return msg; 
	}
	
	@RequestMapping(value="addcolor",method = RequestMethod.POST)
	public String addcolor(@ModelAttribute Color color , Map<String, Object>map){
		colorservice.add(color);
		return "redirect:set_color";
	}
	
	@RequestMapping(value="/member")
	public ModelAndView Member(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		ModelAndView model = new ModelAndView("/setting/Member");
		return model;
	}
	

	@RequestMapping("/set_member") //¨Ñ´¡ÒÃÊÁÒªÔ¡
	public ModelAndView set_member(HttpSession session,Map<String, Object> map) {
		
		String sessionUsername = (String)session.getAttribute("username");
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		map.put("ulist", memberService.getMemberByUsername(sessionUsername)); 
		
		map.put("ulistAll", memberService.getAllMember());
		//map.put("plist", privilegeservice.getAllPrivilege());
		ModelAndView model = new ModelAndView("/setting/set_member");
		return model;
	}
	
	@RequestMapping("/del_member")
	public String del_member(@RequestParam int id){
		memberService.delete(id);
		return "/setting/set_member";
	}
	@RequestMapping("/edit_member")
	public ModelAndView edit_member(HttpSession session,Map<String, Object> map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username");
		
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		map.put("ulist", memberService.getMemberByUsername(sessionUsername)); 
		
		map.put("member", memberService.getMember(id));
		map.put("pri", privilegeservice.getAllPrivilege());
		
		ModelAndView model = new ModelAndView("/setting/edit_member");
		return model;
	}
	
	@RequestMapping("/edited_member")
	public String edited_member(@ModelAttribute Member member, Map<String, Object> map){
		memberService.edit(member);
		return "redirect:set_member";
	}
	
	@RequestMapping("/edit_memberBylogin")
	public ModelAndView edit_memberBylogin(HttpSession session,Map<String, Object> map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username");
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		map.put("ulist", memberService.getMemberByUsername(sessionUsername)); 
		
		map.put("member", memberService.getMember(id));
		map.put("pri", privilegeservice.getAllPrivilege());
		ModelAndView model = new ModelAndView("/setting/edit_memberBylogin");
		return model;
	
	}
	
	@RequestMapping("/edited_memberBylogin")
	public String edited_memberBylogin(@ModelAttribute Member member, Map<String, Object> map){
		memberService.edit(member);
		return "redirect:index";
	}
	
	@RequestMapping(value="set_sync",method=RequestMethod.GET)
	public String set_sync(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		TypeSync typeSync = new TypeSync();
		map.put("typesync",  typeSync);
		map.put("type", typesyncservice.getAllTypeSync());
		
		return "/setting/set_sync";
	}
	
	@ResponseBody
	@RequestMapping(value="checkTypeSync",method = RequestMethod.POST)
	public String checkTypeSync(@RequestParam("value") String value){
		String msg ="yes";
		int chk = typesyncservice.getAllTypeSyncByName(value).size();
		if(chk>0){
			msg="no";
		}
		return msg; 
	}
	
	@RequestMapping(value="AddTypeSync",method = RequestMethod.POST)
	public String AddTypeSync(@ModelAttribute TypeSync typesync, BindingResult result, Map<String, Object> map){

			typesyncservice.add(typesync);
			return "index";
	}
	
	@RequestMapping(value="DelTypeSync",method = RequestMethod.POST)
	public String DelTypeSync(@RequestParam("id") int id){
		
		
			typesyncservice.delete(id);
		
			return "redirect:set_sync";
	}
	
	@RequestMapping(value="/EditSyncSetting",method = RequestMethod.GET)
	public String EditSyncSetting(@RequestParam("TypeId") int id , HttpSession session , Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		Sync sync = new Sync();
		TypeSync typeSync = typesyncservice.getTypeSync(id);
		map.put("sync", sync);
		map.put("nameT", typeSync.getValue());
		map.put("typeId", id);
		map.put("syncL", syncservice.getAllSyncByType(id));
		
		return "/setting/EditSyncSetting";
	}
	
	@RequestMapping(value="AddSync",method = RequestMethod.POST)
	public String AddTypeSync(@ModelAttribute Sync sync, BindingResult result){
			
			syncservice.add(sync);
			return "index";
	}
	
	@RequestMapping(value="saveEditSync",method = RequestMethod.POST)
	public String saveEditSync(@ModelAttribute Sync sync, BindingResult result){
		syncservice.edit(sync);
			return "index";
	}
	
	@RequestMapping(value="DelSync",method = RequestMethod.POST)
	public String DelSync(@RequestParam("idSync") int id,@RequestParam("TypeId") int TypeId){
		
		syncservice.delete(id);
			return "redirect:EditSyncSetting?TypeId="+TypeId;
	}
}
