package healthcares.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*import com.fasterxml.jackson.databind.util.JSONPObject;*/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import healthcares.spring.dao.DiseaseDao;
import healthcares.spring.dao.StatusTreatDao;
import healthcares.spring.model.Alert;
import healthcares.spring.model.Cattle;
import healthcares.spring.model.Disease;
import healthcares.spring.model.HornDetering;
import healthcares.spring.model.Medicine;
import healthcares.spring.model.Member;
import healthcares.spring.model.StatusTreat;
import healthcares.spring.model.TreatmentHistory;
import healthcares.spring.service.AlertService;
import healthcares.spring.service.CableDiseaseService;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.DiseaseService;
import healthcares.spring.service.GroupMedicineService;
import healthcares.spring.service.HornDeteringService;
import healthcares.spring.service.MedicineService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.PrivilegeService;
import healthcares.spring.service.StatusAlertService;
import healthcares.spring.service.StatusMedicineService;
import healthcares.spring.service.StatusTreatService;
import healthcares.spring.service.TreatmentHistoryService;
import healthcares.spring.service.TypeAlertService;
import healthcares.spring.service.TypeHornService;
import healthcares.spring.service.TypeMedicineService;
import healthcares.spring.service.UnitMedicineService;
import healthcares.string.Util;



@Controller
public class HealthController {
	
	@Autowired
	private MedicineService medicineservice;
	
	@Autowired
	private DiseaseService diseaseService;
	
	@Autowired
	private CableDiseaseService cableDiseaseService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private CattleService cattleservice;
	
	@Autowired 
	private TypeHornService typehornservice;
	
	@Autowired
	private HornDeteringService horndeteringservice;
	
	@Autowired
	private TreatmentHistoryService treatmenthistoryservice;
	
	@Autowired
	private TypeMedicineService typemedicineservice;
	
	@Autowired
	private UnitMedicineService unitmedicineservice;
	
	@Autowired
	private GroupMedicineService groupmedicineservice;
	
	@Autowired
	private StatusMedicineService statusmedicineservice;
	
	@Autowired
	private TypeAlertService typealertservice;
	
	@Autowired
	private StatusTreatService statustreatservice;
	
	@Autowired 
	private AlertService alertservice;
	
	@Autowired
	private StatusAlertService statusalertservice;
	

	@RequestMapping(value="treat",method=RequestMethod.GET)
	public String Treat(HttpSession session,Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		TreatmentHistory treatmentHistory = new TreatmentHistory();
		map.put("treat", treatmentHistory);
		map.put("cattle", cattleservice.getCattleT());
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("disease", diseaseService.getAllDisease());
		map.put("statusmedicine", statusmedicineservice.getAllStatusMedicine());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(13));
		return "/health/Treat";
	}
	
	
	
	@RequestMapping("/listmed") //listunit raw
	public @ResponseBody String listmed(Model model,@RequestParam int id,Map<String, Object> map) {
		
		Medicine med = medicineservice.getMedicine(id);
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(med));
	 return json;
	}
	
	
	@RequestMapping("/cowlist")
	public @ResponseBody String listValue(@RequestParam int id) {

		Cattle cattle = cattleservice.getCattle(id);
		
		//System.out.println();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(cattle));
	 return json;
	}
	
	@RequestMapping("/diseaselist")
	public @ResponseBody String diseaselist(@RequestParam int id) {

		Disease disease = diseaseService.getDisease(id);
		
		//System.out.println();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(disease));
	 return json;
	}
	
	
	@RequestMapping(value="/saveTreat",method=RequestMethod.POST)
	public String saveTreat(HttpSession session,Map<String, Object> map,
							@RequestParam("cattle") int cattle,
							@RequestParam("causeOfIllness") String causeOfIllness,
							@RequestParam("medicine") int[] medicine,
							@RequestParam("medicine") int med,
							@RequestParam("date") String dateTreat,
							@RequestParam("disease") int disease,
							@RequestParam("memberid") int member,
							@RequestParam("statusmedicine") int stat,
							@RequestParam("doseUsesage") int[] doseUsesage,
							@RequestParam("day_input") int dayId,
							@RequestParam("dateEndTreat") String time){
		
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		 DateFormat fmt3 = new SimpleDateFormat("yyyy");
		 DateTime dt = new DateTime();
		 String DTnow = fmt1.print(dt);
		 String TimeNow = fmt2.print(dt);
		 
		 Cattle cattle1 = cattleservice.getCattle(cattle);
		 String numCatt = cattle1.getNum();
		 
		 //alert
			Alert alert = new Alert();
			 DateTime dtOrg = new DateTime(dateTreat);
			 DateTime dtPlusOne = dtOrg.plusDays(dayId);
			 String DayAlert = fmt.print(dtPlusOne);
			alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			alert.setTypeAlert(typealertservice.getTypeAlerte(13));
			alert.setMember(memberService.getMember(member));
			alert.setCattle(cattleservice.getCattle(cattle));
			alert.setCattle_1(numCatt);
			alert.setDatealert(DayAlert);
			alert.setTimealert(time);
			alert.setDayinput(DTnow);
			alert.setTimeinput(TimeNow);
		/*	alert.setNote(note);*/
			alertservice.add(alert);
			
		 
		 Cattle cattlee = cattleservice.getCattle(cattle);
		 cattlee.setStatusTreat(statustreatservice.getStatusTreat(2));
		 cattleservice.edit(cattlee);
		 
/*		 Medicine medicine2 = medicineservice.getMedicine2(medicine);
		 int[] success = medicine2.getMedicineSuccess();
		 success = success + 1;
		medicine2.setMedicineSuccess(success);
			System.out.println(success);
		medicineservice.edit(medicine2);*/
		 
	
		 
		for (int i = 0; i < stat ; i++) {
			
			Medicine medicine2 = medicineservice.getMedicine(med);
			int s = medicine2.getMedicineSuccess();
			s = s+1;
			medicine2.setMedicineSuccess(s);
			//System.out.println(s);
			medicineservice.edit(medicine2);
			
			TreatmentHistory treatmentHistory = new TreatmentHistory();
			treatmentHistory.setCattle(cattleservice.getCattle(cattle));
			treatmentHistory.setDisease(diseaseService.getDisease(disease));
			treatmentHistory.setMember(memberService.getMember(member));
			treatmentHistory.setStatusMedicine(statusmedicineservice.getStatusMedicine(stat));
			treatmentHistory.setMedicine(medicineservice.getMedicine(medicine[i]));
			treatmentHistory.setCauseOfIllness(causeOfIllness);
			treatmentHistory.setDateTreat(dateTreat);
			treatmentHistory.setDateEndTreat(time);
			treatmentHistory.setDoseUsesage(doseUsesage[i]);
			treatmentHistory.setStatusTreat(statustreatservice.getStatusTreat(2));
			treatmenthistoryservice.add(treatmentHistory);

/*			
			 Medicine medicine2 = medicineservice.getMedicine2(medicine);
			 int A = medicine2.getMedicineSuccess();
			 A = A+1;
			medicine2.setMedicineSuccess(A);
			medicineservice.edit(medicine2);*/
			
		}
		
/*		List<Alert> alertList = alertservice.getAlertId(numCatt, 13);
			for(Alert alertclose : alertList){
				alertclose.setStatusAlert(statusalertservice.getStatusAlert(2));
				alertclose.setMember(memberService.getMember(member));
				alertservice.edit(alertclose);
			}*/
		return "redirect:index";
	}
	
	@RequestMapping(value="treathis",method=RequestMethod.GET)
	public String Treathis(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));		
		
		return "/health/Treat_his";  												
	}
	
	
	
	@RequestMapping(value="disease",method=RequestMethod.GET)
	public String disease(HttpSession session,Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Disease disease = new Disease();
		map.put("sh", disease);
		map.put("disease", diseaseService.getAllDisease());
		map.put("user",memberService.getAllMember());
		map.put("cabledisease",cableDiseaseService.getAllCableDisease());
	
		
		return "/health/disease";
	}
	
	
	@ResponseBody
	@RequestMapping(value="adddisease",method = RequestMethod.POST)
	public String adddisease(@ModelAttribute Disease Disease, Map<String, Object> map){
		diseaseService.add(Disease);//add ข้อมูลเข้าไป
		return "1";
	}
	
	@RequestMapping(value="diseasesh")
	public String diseasesh(HttpSession session,Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Medicine medicine = new Medicine();
		Disease disease = new Disease();
		map.put("sh", disease);
		map.put("disease", diseaseService.getAllDisease());
		map.put("user",memberService.getAllMember());
		map.put("cabledisease",cableDiseaseService.getAllCableDisease());

		return "/health/diseasesh";
	}
	
	@RequestMapping(value="diseasedetail",method=RequestMethod.POST)
	public String diseasedetail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Disease disease = new Disease();
		map.put("sh", disease);
		map.put("dis", diseaseService.getDisease(id));
		return "/health/disease_detail";  												
	}
	
	@RequestMapping(value="edit_disase")
	public String edit_disase(HttpSession session,Map<String, Object> map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Disease disease = diseaseService.getDisease(id);
		map.put("disease", disease);
		map.put("calble", cableDiseaseService.getAllCableDisease());
		
		return "/health/edit_disase";
	}
	
	@RequestMapping("/disease_edited")
	public String disease_edited(HttpSession session,Map<String, Object>map,@ModelAttribute Disease disease){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		diseaseService.edit(disease);
		return "redirect:diseasesh";
	}
	
	@RequestMapping("/del_disease")
	public String delete_dis(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		diseaseService.delete(id);
		
		return "redirect:diseasesh";
	}

	@RequestMapping(value="list_recommend")
	public String list_recommend(HttpSession session,Map<String, Object>map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Medicine medicine = new Medicine();
		Disease disease = new Disease();
		map.put("disease", diseaseService.getAllDisease());
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("user",memberService.getAllMember());
		map.put("cabledisease",cableDiseaseService.getAllCableDisease());
		
		return "/health/list_recommend";
	}
	

	@RequestMapping(value="treat_horn",method=RequestMethod.GET)
	public String treat_horn(HttpSession session,Map<String,Object>map){
		
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		TreatmentHistory treatment = new TreatmentHistory();
		map.put("treat", treatment);
		map.put("cattletreat", cattleservice.getstaTreatcattle());
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("disease", diseaseService.getAllDisease());
		map.put("statusmedicine", statusmedicineservice.getAllStatusMedicine());
		map.put("stattreat", statustreatservice.getAllStatusTreat());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(13));;
		map.put("calves", cattleservice.GetCalves1(1));
		return "health/treat_horn";
	}
	
	@RequestMapping(value="treat_num",method=RequestMethod.GET)
	public String treat_num(HttpSession session,Map<String,Object>map){
		
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("cattletreat", cattleservice.getstaTreatcattle());
		/*map.put("calves", cattleservice.GetCalves1(1));*/
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("disease", diseaseService.getAllDisease());
		map.put("statusmedicine", statusmedicineservice.getAllStatusMedicine());
		map.put("stattreat", statustreatservice.getAllStatusTreat());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(13));
		return "health/treat_num";
	}
	
	@RequestMapping(value="treat_birth",method=RequestMethod.GET)
	public String treat_birth(HttpSession session,Map<String,Object>map){
		
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("cattletreat", cattleservice.getstaTreatcattle());
		/*map.put("calves", cattleservice.GetCalves1(1));*/
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("disease", diseaseService.getAllDisease());
		map.put("statusmedicine", statusmedicineservice.getAllStatusMedicine());
		map.put("stattreat", statustreatservice.getAllStatusTreat());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(13));
		return "health/treat_birth";
	}
	
	
	@RequestMapping(value="treat_health",method=RequestMethod.GET)
	public String treat_health(HttpSession session,Map<String,Object>map){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		TreatmentHistory treatment = new TreatmentHistory();
		map.put("treat", treatment);
		map.put("cattletreat", cattleservice.getstaTreatcattle());
		map.put("medicine", medicineservice.getAllMedicine());
		map.put("disease", diseaseService.getAllDisease());
		map.put("statusmedicine", statusmedicineservice.getAllStatusMedicine());
		map.put("stattreat", statustreatservice.getAllStatusTreat());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(13));
		return "health/treat_health";
	}
	
	@RequestMapping("/listcattle1")
	public @ResponseBody String listcattle1(@RequestParam int id) {

		Cattle cattle = cattleservice.getCattle(id);
		
		//System.out.println();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(cattle));
	 return json;
	}
	

	
	@RequestMapping(value="savehealth",method=RequestMethod.POST)
	public String savehealth(HttpSession session,Map<String, Object> map,
							@RequestParam("cattle") int cattle,	
							@RequestParam("causeOfIllness") String causeOfIllness,
							@RequestParam("medicine") int[] medicine,
							@RequestParam("medicine") int med,
							@RequestParam("date") String dateTreat,
							@RequestParam("disease") int disease,
							@RequestParam("memberid") int member,
							@RequestParam("statusmedicine") int stat,
							@RequestParam("doseUsesage") int[] doseUsesage,
							@RequestParam("day_input") int dayId,
							@RequestParam("dateEndTreat") String time){
		
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		 DateFormat fmt3 = new SimpleDateFormat("yyyy");
		 DateTime dt = new DateTime();
		 String DTnow = fmt1.print(dt);
		 String TimeNow = fmt2.print(dt);
		 
		 Cattle cattle1 = cattleservice.getCattle(cattle);
		 String numCatt = cattle1.getNum();

		 TreatmentHistory treatmentHistory = new TreatmentHistory();
		 
	/*	 if (statusTreat == 1 ) {
			 cattle1.setStatusTreat(statustreatservice.getStatusTreat(1));
			 cattleservice.edit(cattle1);
			 
		
					
					treatmentHistory.setCattle(cattleservice.getCattle(cattle));
					treatmentHistory.setDisease(diseaseService.getDisease(0));
					treatmentHistory.setMember(memberService.getMember(0));
					treatmentHistory.setStatusMedicine(statusmedicineservice.getStatusMedicine(0));
					treatmentHistory.setMedicine(medicineservice.getMedicine(0));
					treatmentHistory.setCauseOfIllness(null);
					treatmentHistory.setDateTreat(dateTreat);
					treatmentHistory.setDateEndTreat(time);
					treatmentHistory.setDoseUsesage(0);
					treatmentHistory.setStatusTreat(statustreatservice.getStatusTreat(2));
					treatmenthistoryservice.add(treatmentHistory);
	



		}if (statusTreat == 3){
			 
			cattle1.setStatusTreat(statustreatservice.getStatusTreat(3));
			 cattleservice.edit(cattle1);	
				
			 
		}*/
		
			List<Alert> alertList = alertservice.getAlertId(numCatt, 13);
			for (Alert closeAlert : alertList) {
			closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
			closeAlert.setMember(memberService.getMember(member));
			alertservice.edit(closeAlert);
		}
		
		//if (statusTreat == 2){
			
			 //alert
			Alert alert = new Alert();
			 DateTime dtOrg = new DateTime(dateTreat);
			 DateTime dtPlusOne = dtOrg.plusDays(dayId);
			 String DayAlert = fmt.print(dtPlusOne);
			alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			alert.setTypeAlert(typealertservice.getTypeAlerte(13));
			alert.setMember(memberService.getMember(member));
			alert.setCattle(cattleservice.getCattle(cattle));
		
			alert.setCattle_1(numCatt);
			alert.setDatealert(DayAlert);
			alert.setTimealert(time);
			alert.setDayinput(DTnow);
			alert.setTimeinput(TimeNow);
			//alert.setNote(note);
			alertservice.add(alert);
	
			 cattle1.setStatusTreat(statustreatservice.getStatusTreat(2));
			 cattleservice.edit(cattle1);


			 
			for (int i = 0; i < stat ; i++) {
				
				Medicine medicine2 = medicineservice.getMedicine(med);
				int s = medicine2.getMedicineSuccess();
				s = s+1;
				medicine2.setMedicineSuccess(s);
				//System.out.println(s);
				medicineservice.edit(medicine2);
				
				treatmentHistory.setCattle(cattleservice.getCattle(cattle));
				
				treatmentHistory.setDisease(diseaseService.getDisease(disease));
				treatmentHistory.setMember(memberService.getMember(member));
				treatmentHistory.setStatusMedicine(statusmedicineservice.getStatusMedicine(stat));
				treatmentHistory.setMedicine(medicineservice.getMedicine(medicine[i]));
				treatmentHistory.setCauseOfIllness(causeOfIllness);
				treatmentHistory.setDateTreat(dateTreat);
				treatmentHistory.setDateEndTreat(time);
				treatmentHistory.setDoseUsesage(doseUsesage[i]);
				treatmentHistory.setStatusTreat(statustreatservice.getStatusTreat(2));
				treatmenthistoryservice.add(treatmentHistory);
				
			}
		//}
		

		 

		return "redirect:index";
	}
	
	/*@RequestMapping(value="savehealth",method=RequestMethod.POST)
	public String savehealth(HttpSession session,Map<String, Object> map,
							@RequestParam("cattle") int cattle,
							@RequestParam("causeOfIllness") String causeOfIllness,
							@RequestParam("medicine") int[] medicine,
							@RequestParam("medicine") int med,
							@RequestParam("date") String dateTreat,
							@RequestParam("disease") int disease,
							@RequestParam("memberid") int member,
							@RequestParam("statusmedicine") int stat,
							@RequestParam("doseUsesage") int[] doseUsesage,
							@RequestParam("day_input") int dayId,
							@RequestParam("dateEndTreat") String time){
		
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		 DateFormat fmt3 = new SimpleDateFormat("yyyy");
		 DateTime dt = new DateTime();
		 String DTnow = fmt1.print(dt);
		 String TimeNow = fmt2.print(dt);
		 
		 Cattle cattle1 = cattleservice.getCattle(cattle);
		 String numCatt = cattle1.getNum();

		 TreatmentHistory treatmentHistory = new TreatmentHistory();
		 
		 if (statusTreat == 1 ) {
			 cattle1.setStatusTreat(statustreatservice.getStatusTreat(1));
			 cattleservice.edit(cattle1);
			 
		
					
					treatmentHistory.setCattle(cattleservice.getCattle(cattle));
					treatmentHistory.setDisease(diseaseService.getDisease(0));
					treatmentHistory.setMember(memberService.getMember(0));
					treatmentHistory.setStatusMedicine(statusmedicineservice.getStatusMedicine(0));
					treatmentHistory.setMedicine(medicineservice.getMedicine(0));
					treatmentHistory.setCauseOfIllness(null);
					treatmentHistory.setDateTreat(dateTreat);
					treatmentHistory.setDateEndTreat(time);
					treatmentHistory.setDoseUsesage(0);
					treatmentHistory.setStatusTreat(statustreatservice.getStatusTreat(2));
					treatmenthistoryservice.add(treatmentHistory);
	



		}if (statusTreat == 3){
			 
			cattle1.setStatusTreat(statustreatservice.getStatusTreat(3));
			 cattleservice.edit(cattle1);	
				
			 
		}
		
			List<Alert> alertList = alertservice.getAlertId(numCatt, 13);
			for (Alert closeAlert : alertList) {
			closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
			closeAlert.setMember(memberService.getMember(member));
			alertservice.edit(closeAlert);
		}
		
		//if (statusTreat == 2){
			
			 //alert
			Alert alert = new Alert();
			 DateTime dtOrg = new DateTime(dateTreat);
			 DateTime dtPlusOne = dtOrg.plusDays(dayId);
			 String DayAlert = fmt.print(dtPlusOne);
			alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			alert.setTypeAlert(typealertservice.getTypeAlerte(13));
			alert.setMember(memberService.getMember(member));
			alert.setCattle(cattleservice.getCattle(cattle));
			alert.setCattle_1(numCatt);
			alert.setDatealert(DayAlert);
			alert.setTimealert(time);
			alert.setDayinput(DTnow);
			alert.setTimeinput(TimeNow);
			//alert.setNote(note);
			alertservice.add(alert);
	
			 cattle1.setStatusTreat(statustreatservice.getStatusTreat(2));
			 cattleservice.edit(cattle1);


			 
			for (int i = 0; i < stat ; i++) {
				
				Medicine medicine2 = medicineservice.getMedicine(med);
				int s = medicine2.getMedicineSuccess();
				s = s+1;
				medicine2.setMedicineSuccess(s);
				//System.out.println(s);
				medicineservice.edit(medicine2);
				
				treatmentHistory.setCattle(cattleservice.getCattle(cattle));
				treatmentHistory.setDisease(diseaseService.getDisease(disease));
				treatmentHistory.setMember(memberService.getMember(member));
				treatmentHistory.setStatusMedicine(statusmedicineservice.getStatusMedicine(stat));
				treatmentHistory.setMedicine(medicineservice.getMedicine(medicine[i]));
				treatmentHistory.setCauseOfIllness(causeOfIllness);
				treatmentHistory.setDateTreat(dateTreat);
				treatmentHistory.setDateEndTreat(time);
				treatmentHistory.setDoseUsesage(doseUsesage[i]);
				treatmentHistory.setStatusTreat(statustreatservice.getStatusTreat(2));
				treatmenthistoryservice.add(treatmentHistory);
			}
		//}
		

		 

		return "redirect:index";
	}*/
	
}
