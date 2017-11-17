package healthcares.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import healthcares.spring.model.Alert;
import healthcares.spring.model.Cattle;
import healthcares.spring.model.CattleStamp;
import healthcares.spring.model.CattleWean;
import healthcares.spring.model.CattleYear;
import healthcares.spring.model.HornDetering;
import healthcares.spring.service.AlertService;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.CattleStampService;
import healthcares.spring.service.CattleWeanService;
import healthcares.spring.service.CattleYearService;
import healthcares.spring.service.GroupCattleService;
import healthcares.spring.service.HornDeteringService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.StatusAlertService;
import healthcares.spring.service.StatusCattleService;
import healthcares.spring.service.TypeAlertService;
import healthcares.spring.service.TypeHornService;
import healthcares.string.Util;

@Controller
public class CalvesController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired 
	private CattleService cattleservice;
	
	@Autowired 
	private TypeHornService typehornservice;
	
	@Autowired
	private HornDeteringService horndeteringservice;
	
	@Autowired
	private CattleWeanService cattleweanservice;
	
	@Autowired
	private StatusCattleService statuscattleservice;
	
	@Autowired 
	private CattleYearService cattleyearservice;
	
	@Autowired
	private CattleStampService cattlestampservice;
	
	@Autowired
	private AlertService alertservice;
	
	@Autowired
	private StatusAlertService statusalertservice;
	
	@Autowired
	private TypeAlertService typealertservice;
	
	@Autowired
	private GroupCattleService groupcattleservice;
	
	@RequestMapping(value="horndeter",method=RequestMethod.GET)
	public String horndeter(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
	
		HornDetering horndetering = new HornDetering();
		map.put("horn", horndetering);
		map.put("calves", cattleservice.GetCalves1(1));
		map.put("typehorn", typehornservice.getAllTypeHorn());
		return "/calves/horndeter";  												
	}
	
	@RequestMapping(value="/saveHorn",method = RequestMethod.POST)
	public String saveHorn(HttpSession session,Map<String, Object> map,
							@RequestParam("calves.id") int calves,
							@RequestParam("date") String date,
							@RequestParam("note") String note,
							@RequestParam("typehorn.id") int typehorn,
							@RequestParam("memberid") int member){
							
		
		//@RequestParam("ageHornDetering") String hornn
		
		Cattle cattle1 = cattleservice.getCattle(calves);
		cattle1.setAgeHornDetering("สูญเขาแล้ว");
		cattle1.setAge(2);
		cattleservice.edit(cattle1);
		
		HornDetering hornDetering = new HornDetering();
		hornDetering.setCattle(cattleservice.getCattle(calves));
		hornDetering.setDate(date);
		hornDetering.setNote(note);
		hornDetering.setTypeHorn(typehornservice.getTypeHorn(typehorn));	
		hornDetering.setMember(memberService.getMember(member));
		horndeteringservice.add(hornDetering);
		
		Cattle cattle = cattleservice.getCattle(calves);
		String numdate = cattle.getNumDate();
		List<Alert> alertList = alertservice.getAlertId(numdate, 6);
			for (Alert closeAlert : alertList) {
				closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
				closeAlert.setMember(memberService.getMember(member));
				alertservice.edit(closeAlert);
			}
		return "redirect:index";
	}
	
	@RequestMapping(value="horndeter_list",method=RequestMethod.GET)
	public String horndeter_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		/*HornDetering horndetering = new HornDetering();*/
	/*	map.put("sh", horndetering);*/
		map.put("horn", horndeteringservice.getAllHornDetering());
		map.put("cattle", cattleservice.getAllCattle());
		map.put("typehorn", typehornservice.getAllTypeHorn());
		return "/calves/horndeter_list";  												
	}
	
	@RequestMapping(value="wean",method=RequestMethod.GET)
	public String wean(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		CattleWean cattlewean = new CattleWean();
		map.put("cattlewean", cattlewean);
		map.put("calves", cattleservice.GetCalves1(2));
		
		return "/calves/wean";  												
	}
	
	@RequestMapping(value="/saveWean",method = RequestMethod.POST)
	public String saveWean(HttpSession session,Map<String, Object>map,
			@RequestParam("calvesid") int calves,
			@RequestParam("date") String date,
			@RequestParam("weigthwean") String weigthwean,
			@RequestParam("memberid") int member,
			@RequestParam("note") String note){
		
/*		System.out.println(calves);
		System.out.println(date);
		System.out.println(weigthwean);
		System.out.println(member);
		System.out.println(note);*/

		Cattle cattle = cattleservice.getCattle(calves);
		cattle.setWeightWean(weigthwean);
		cattle.setAge(3);
		cattle.setGroupCattle(groupcattleservice.getGroupCattle(7));
		cattleservice.edit(cattle);
	
		CattleWean cattlewean = new CattleWean();
	
		cattlewean.setCattle(cattleservice.getCattle(calves));
		cattlewean.setDate(date);
		cattlewean.setWeigthwean(weigthwean);
		cattlewean.setNote(note);
		cattlewean.setMember(memberService.getMember(member));
		cattleweanservice.add(cattlewean);
		
		String numdate = cattle.getNumDate();
		List<Alert> alertlist = alertservice.getAlertId(numdate, 7);
			for(Alert closeAlert : alertlist){
				closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
				closeAlert.setMember(memberService.getMember(member));
				alertservice.edit(closeAlert);
			}
		return "redirect:index";
	}
	
	
	@RequestMapping(value="wean_list",method=RequestMethod.GET)
	public String wean_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		map.put("wean", cattleweanservice.getAllCattleWean());
		return "/calves/wean_list";  												
	}
	
	@RequestMapping(value="weight",method=RequestMethod.GET)
	public String weight(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		CattleYear cattleYear = new CattleYear();
		map.put("calves", cattleservice.GetCalves1(4));
		return "/calves/weight";  												
	}
	
	
	@RequestMapping("/listValue")
	public @ResponseBody String listValue(@RequestParam int id) {

		Cattle cattle = cattleservice.getCattle(id);
		
		//System.out.println();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(cattle));
	 return json;
	}
	
	@RequestMapping(value="/saveWeight",method = RequestMethod.POST)
	public String saveWeight(HttpSession session,Map<String, Object> map,
								@RequestParam("calvesid") int calves,
								@RequestParam("date") String date,
								@RequestParam("weightyear") String weight,
								@RequestParam("memberid") int member){

		
/*		System.out.println(calves);
		System.out.println(date);
		System.out.println(weight);
		System.out.println(member);*/
		
			Cattle cattle = cattleservice.getCattle(calves);
			cattle.setWeight(weight);
			cattle.setStatusCattle(statuscattleservice.getStatusCattle(2));
			cattle.setGroupCattle(groupcattleservice.getGroupCattle(9));
			cattle.setAge(0);
			cattleservice.edit(cattle);
		
			CattleYear cattleyear = new CattleYear();
			cattleyear.setCattle(cattleservice.getCattle(calves));
			cattleyear.setMember(memberService.getMember(member));
			cattleyear.setDate(date);
			cattleyear.setWeightyear(weight);
		
			cattleyearservice.add(cattleyear);
			
/*			CattleWean cattlewean = new CattleWean();
			cattlewean.setCattle(cattleservice.getCattle(calves));
			cattlewean.setDate(date);
			cattlewean.setMember(memberService.getMember(member));

			cattleweanservice.add(cattlewean);*/
			

			
			String numDate = cattle.getNumDate();
			List<Alert> alertList = alertservice.getAlertId(numDate, 9);
			for(Alert closeAlert : alertList){
				closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
				closeAlert.setMember(memberService.getMember(member));
				alertservice.edit(closeAlert);
			}
			
		return "redirect:index";
	}
	
	
	@RequestMapping(value="weight_list",method=RequestMethod.GET)
	public String weight_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("weight", cattleyearservice.getAllCattleYear());
		return "/calves/weight_list";  												
	}
	
	@RequestMapping(value="numbercat",method=RequestMethod.GET)
	public String numbercat(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		CattleStamp cattlestamp = new CattleStamp();
		map.put("cattlestm",cattlestamp);
		map.put("calve", cattleservice.GetCalves1(3));
		return "/calves/numbercat";  												
	}
	
	@RequestMapping(value="/saveNumber",method = RequestMethod.POST)
	public String saveNumber(HttpSession session,Map<String, Object> map,
							@RequestParam("calves.id") int calves,
							@RequestParam("date") String date,
							@RequestParam("note") String note,
							@RequestParam("stampNumber") String stamp,
							@RequestParam("memberid") int member){
		
		Cattle cattle = cattleservice.getCattle(calves);
		cattle.setNum(stamp);
		cattle.setAge(4);
		cattleservice.edit(cattle);
		
		CattleStamp cattlestamp = new CattleStamp();
		cattlestamp.setCattle(cattleservice.getCattle(calves));
		cattlestamp.setMember(memberService.getMember(member));
		cattlestamp.setDate(date);
		cattlestamp.setNote(note);
		cattlestamp.setStampNumber(stamp);
		
		cattlestampservice.add(cattlestamp);
		
		String numDate = cattle.getNumDate();
		List<Alert> alertList = alertservice.getAlertId(numDate, 8);
		for(Alert closeAlert : alertList){
			closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
			closeAlert.setMember(memberService.getMember(member));
			alertservice.edit(closeAlert);
		}
		
		return "redirect:index";
	}
	
	@RequestMapping(value="numbercat_list",method=RequestMethod.GET)
		public String numbercat_list(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("number", cattlestampservice.getAllCattleStamp());
		return "/calves/numbercat_list";
	}
}
