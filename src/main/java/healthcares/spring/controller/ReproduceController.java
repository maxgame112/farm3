package healthcares.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import healthcares.spring.service.AlertService;
import healthcares.spring.service.BreedingService;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.ColorService;
import healthcares.spring.service.CountBreedService;
import healthcares.spring.service.GroupCattleService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.MisscarryService;
import healthcares.spring.service.PregnantService;
import healthcares.spring.service.SexService;
import healthcares.spring.service.StatusAlertService;
import healthcares.spring.service.StatusBornService;
import healthcares.spring.service.StatusBreedService;
import healthcares.spring.service.StatusCattleService;
import healthcares.spring.service.StatusPregnantService;
import healthcares.spring.service.SyncService;
import healthcares.spring.service.SynchronizeService;
import healthcares.spring.service.TypeAlertService;
import healthcares.spring.service.TypeCattleService;
import healthcares.spring.service.TypeSyncService;
import healthcares.string.Util;
import healthcares.spring.model.Alert;
import healthcares.spring.model.Breeding;
import healthcares.spring.model.Cattle;
import healthcares.spring.model.CountBreed;
import healthcares.spring.model.Disease;
import healthcares.spring.model.Member;
import healthcares.spring.model.Misscarry;
import healthcares.spring.model.Pregnant;
import healthcares.spring.model.Sync;
import healthcares.spring.model.Synchronize;
import healthcares.spring.model.TypeSync;

@Controller
public class ReproduceController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CattleService cattleservice;
	
	@Autowired
	private StatusPregnantService statuspregnantservice;
	
	@Autowired
	private TypeAlertService typealertservice;
	
	@Autowired
	private BreedingService breedingservice;
	
	@Autowired
	private CountBreedService countbreedservice;
	
	@Autowired
	private PregnantService pregnantservice;
	
	@Autowired
	private StatusBornService statusbornservice;
	
	@Autowired
	private ColorService colorservice;
	
	@Autowired
	private SexService sexservice;
	
	@Autowired
	private TypeCattleService typecattleservice;
	
	@Autowired
	private StatusBreedService statusbreedserive;
	
	@Autowired
	private TypeSyncService typesyncservice;
	
	@Autowired
	private StatusBreedService statusbreedservice;
	
	@Autowired
	private StatusCattleService statuscattleservice;
	
	@Autowired
	private SyncService syncservice;
	
	@Autowired
	private AlertService alerservice;
	
	@Autowired
	private StatusAlertService statusalertservice;
	
	@Autowired
	private SynchronizeService synchronizeservice;
	
	@Autowired
	private GroupCattleService groupcattleservice;
	
	@Autowired
	private MisscarryService misscarryservice;
	
/*	@SuppressWarnings("unchecked")
	private Map<String, String> getMomList(int s) {
		Map<String, String> map = new HashMap<>();
		List<Cattle> List = cattleservice.GetMomCattle(s);
		for (Cattle cattle : List) {
			map.put(cattle.getId()+"", cattle.getNum());
		}
		return map;
	}*/
	
	@RequestMapping(value="breeding",method=RequestMethod.GET)
	public String breeding(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Breeding breeding = new Breeding();
		map.put("breeding", breeding);
		//map.put("memcat",getMomList(1));
		map.put("memcat",cattleservice.GetMomCattle(1));
		map.put("fatcat", cattleservice.GetFatCattle());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(2));
		return "/reproduce/breeding";  												
	}
	
	
	@ResponseBody
	@RequestMapping(value="getCountBreed",method = RequestMethod.GET)
	public String getCountBreed(@ModelAttribute CountBreed countbreed,@RequestParam("q") int q,Map<String, Object> map){
		CountBreed count = countbreedservice.getCountBreedByPriNo(q);
		
		 Date dt = new Date();
		 DateFormat fmt3 = new SimpleDateFormat("yyyy");
		 
		 String msg="";
		
		 String yn = fmt3.format(dt);
		 if(count != null){
			 String resultYear= count.getYear();
			 if(resultYear==null||!yn.equals(resultYear)){
					
				 	resultYear = yn;
				 }
			 int n = count.getCount();
			 String a = Integer.toString(n);
			 msg=a+"/"+resultYear;
			
		 }
		 else{
			 msg="1/"+yn;
		 }
		

		return msg;
	}
	
	@RequestMapping(value="/saveBreed",method = RequestMethod.POST)
	public String saveBreed(@RequestParam("momcatl") int mom,
			@RequestParam("fatcatl") int fat,
			@RequestParam("count") String count,
			@RequestParam("memberid") int member,
			@RequestParam("day_input") int dayId,
			@RequestParam("note") String note,
			@RequestParam("date") String date,
			@RequestParam("time") String time,HttpSession session,Map<String, Object> map){
		
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		 DateFormat fmt3 = new SimpleDateFormat("yyyy");
		 DateTime dt = new DateTime();
		 String DTnow = fmt1.print(dt);
		 String TimeNow = fmt2.print(dt);
		
			//breeding
			Breeding breeding = new Breeding();
			breeding.setNote(note);
			breeding.setTime(time);
			breeding.setDate(date);
			breeding.setCattleByCattlefaId(cattleservice.getCattle(fat));
			breeding.setCattleByCattlemaId(cattleservice.getCattle(mom));
			breeding.setCountBreed(countbreedservice.getCountBreed(dayId));
			breeding.setMember(memberService.getMember(member));
			breedingservice.add(breeding);
			int p = breeding.getId();
			
			Cattle cattle5 = cattleservice.getCattle(mom);
			String numCattle = cattle5.getNum();
			
			//pregnant
			Pregnant pregnant = new Pregnant();
			pregnant.setBreeding(breedingservice.getBreeding(p));
/*			pregnant.setCattle(numCattle);
			pregnant.setStat(2);*/
			pregnant.setStatusPregnant(statuspregnantservice.getStatusPregnant(3));
			pregnant.setDatePreg(date);
			pregnant.setMember(memberService.getMember(member));
			 	pregnantservice.add(pregnant);
			

			Cattle cattle = cattleservice.getCattle(mom);
			cattle.setTeeth(2);
			String numCatt = cattle.getNum();
			//**********************************************//
				 DateTime dtOrg1 = new DateTime(date);
				 DateTime dtPlusOne1 = dtOrg1.plusDays(311);
				 String DayAlert1 = fmt.print(dtPlusOne1);
				 cattle.setAlert1(DayAlert1);
				//**********************************************//
				 DateTime dtOrg2 = new DateTime(date);
				 DateTime dtPlsOne2 = dtOrg1.plusDays(318);
				 String DayAlert2 = fmt.print(dtPlsOne2);
				 cattle.setAlert2(DayAlert2);
				//**********************************************//
				 DateTime dtOrg3 = new DateTime(date);
				 DateTime dtPlusOne3 = dtOrg1.plusDays(304);
				 String DayAlert3 = fmt.print(dtPlusOne3);
				 cattle.setAlert3(DayAlert3);
				//**********************************************//
				 DateTime dtOrg4 = new DateTime(date);
				 DateTime dtPlusOne4 = dtOrg1.plusDays(46);
				 String DayAlert4 = fmt.print(dtPlusOne4);
				 pregnant.setDateAlertdao3(DayAlert4);
				 cattle.setAlert4(DayAlert4);
				//**********************************************//
			cattleservice.edit(cattle);
			
			//alert
			Alert alert = new Alert();
			 DateTime dtOrg = new DateTime(date);
			 DateTime dtPlusOne = dtOrg.plusDays(dayId);
			 String DayAlert = fmt.print(dtPlusOne);
			alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			alert.setTypeAlert(typealertservice.getTypeAlerte(2));
			alert.setMember(memberService.getMember(member));
			alert.setCattle(cattleservice.getCattle(mom));
			alert.setCattle_1(numCatt);
			alert.setDatealert(DayAlert);
			alert.setTimealert(time);
			alert.setDayinput(DTnow);
			alert.setTimeinput(TimeNow);
			alert.setNote(note);
			alerservice.add(alert);
			      
			//countbreeed
			String cattlemom = Integer.toString(mom);
			CountBreed countBreed = countbreedservice.getCountBreedByPriNo(mom);
			
			if (countBreed == null) {
				Date dn = new Date();
				String yn = fmt3.format(dn);
				CountBreed countBreed1 = new CountBreed();
				countBreed1.setCattle(cattleservice.getCattle(mom));
				countBreed1.setCount(1);
				countBreed1.setYear(yn);
				countbreedservice.add(countBreed1);
			}
			
			List<Alert> alertList = alerservice.getAlertId(numCatt, 1);
				for (Alert closeAlert : alertList) {
				closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
				closeAlert.setMember(memberService.getMember(member));
				alerservice.edit(closeAlert);
			}
			List<Alert> alertList2 = alerservice.getAlertId(numCatt, 1);
				for (Alert closeAlert2 : alertList2) {
					closeAlert2.setStatusAlert(statusalertservice.getStatusAlert(2));
					closeAlert2.setMember(memberService.getMember(member));
					alerservice.edit(closeAlert2);
				}
		 return "redirect:index";
	}
	
	
	
	@RequestMapping(value="breeding_list",method=RequestMethod.GET)
	public String breeding_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		map.put("breeding", breedingservice.getAllBreeding());
		map.put("alt", typealertservice.getTypeAlerte(2));
/*		String as = typealertservice.getTypeAlerte(2).getValue();
		System.out.println(as);*/
/*		map.put("momcat", cattleservice.GetMomCattle());
		map.put("fatcat", cattleservice.GetFatCattle());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(2));*/
		return "/reproduce/breeding_list";  												
	}
	
	@RequestMapping(value="breed_edit",method=RequestMethod.POST)
	public String breed_edit(HttpSession session,Map<String, Object> map,@RequestParam int id) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("breeding", breedingservice.getAllBreeding());
		map.put("alt", typealertservice.getTypeAlerte(2));
		map.put("breed", breedingservice.getBreeding(id));
		
		return "/reproduce/breed_edit";  												
	}	

	@RequestMapping("/edited_breed")
	public String edited_breed(HttpSession session,Map<String, Object>map,@ModelAttribute Breeding breeding){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		
		
		
		breedingservice.edit(breeding);
		return "redirect:breeding_list";
		
	}

	@RequestMapping(value="breed_detail",method=RequestMethod.POST)
	public String breed_detail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Breeding breeding = new Breeding();
		map.put("breed", breedingservice.getBreeding(id));
		return "/reproduce/breed_detail";  												
	}

	@RequestMapping("/del_breed")
	public String del_breed(HttpSession session,Map<String, Object>map,@RequestParam int id){
		String sessionUsername = (String)session.getAttribute("username"); 
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		breedingservice.delete(id);
		
		return "redirect:cattlelist";
	}
	
	@RequestMapping(value="pregnant",method=RequestMethod.GET)
	public String pregnant(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		Pregnant pregnant = new Pregnant();
		map.put("pregnant", pregnant);
		map.put("memcat", cattleservice.GetMomCattle(2));
		//map.put("memcat", pregnantservice.getPregnantBynum(2));
		map.put("statprege", statuspregnantservice.getAllStatusPregnant());
		map.put("dAlertList", typealertservice.getAllTypeAlertById(3));
		map.put("NdAlertList", typealertservice.getAllTypeAlertById(1));
		return "/reproduce/pregnant";  												
	}
		
	@RequestMapping(value="pregnant_detail",method=RequestMethod.POST)
	public String preg_detail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Pregnant pregnant = new Pregnant();
		map.put("pregnant", pregnantservice.getPregnant(id));
		map.put("memcat", cattleservice.GetMomCattle(2));
		return "/reproduce/pregnant_detail";  												
	}

	
	@RequestMapping("/listValue5")
	public @ResponseBody String listValue5(@RequestParam int id) {

		Cattle cattle = cattleservice.getCattle(id);
		//Breeding breeding = breedingservice.getBreeding(id);
	
		System.out.println(id);
		/*System.out.println(breedingid);*/
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = Util.encodeUnicode(gson.toJson(cattle));
	 return json;
	}
	
	@RequestMapping(value="/savePreg",method = RequestMethod.POST)
	public String savePreg(@RequestParam("momcatl") int mom,
			@RequestParam("ststuspreg") int ststus,
			@RequestParam("memberid") int member,
			@RequestParam("day_input") int dayId,
			@RequestParam("note") String note,
			@RequestParam("datePreg") String date,
			@RequestParam("timePreg") String time,
				HttpSession session,Map<String, Object> map){
		
		     DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
			 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
			 DateTime dt = new DateTime();
			 String DTnow = fmt1.print(dt);
			 String TimeNow = fmt2.print(dt);
			 
			 int id = pregnantservice.getPregnantByCattle(mom);
			 
			//pregnant
			 Pregnant pregnant = pregnantservice.getPregnant(id);
			 pregnant.setStatusPregnant(statuspregnantservice.getStatusPregnant(ststus));
			 pregnant.setMember(memberService.getMember(member));
		/*	 pregnant.setStat(0);*/
			 pregnant.setDatePreg(date);
			 pregnant.setNote(note);
			 pregnant.setDateSchedule(DTnow);
			 pregnantservice.edit(pregnant);
			 String momcatl = pregnant.getBreeding().getCattleByCattlemaId().getNum();
			 int momid = pregnant.getBreeding().getCattleByCattlemaId().getId();
			 String motherid = Integer.toString(momid);
			 if (ststus  == 1) {
				//cattle-
				 Cattle cattle = cattleservice.getCattle(momid);
				 cattle.setTeeth(3);
				 cattle.setGroupCattle(groupcattleservice.getGroupCattle(2));
				 cattleservice.edit(cattle);
				 
				 //alert
				 DateTime dtOrg = new DateTime(date);
				 DateTime dtPlusOne = dtOrg.plusDays(dayId);
				 String DayAlert = fmt.print(dtPlusOne);
				 Alert alert = new Alert();
				 alert.setStatusAlert(statusalertservice.getStatusAlert(1));
				 alert.setTypeAlert(typealertservice.getTypeAlerte(3));
				 alert.setCattle(cattleservice.getCattle(mom));
				 alert.setMember(memberService.getMember(member));
				 alert.setCattle_1(momcatl);
				 alert.setDatealert(DayAlert);
				 alert.setTimealert(time);
				 alert.setDayinput(DTnow);
				 alert.setTimeinput(TimeNow);
				 alert.setNote(note);
				 alerservice.add(alert);
				 
				 CountBreed countBreed = countbreedservice.getCountBreedByPriNo(momid);
				 int countId = countBreed.getId();
				 countbreedservice.delete(countId);
			}
			 
			if (ststus == 2) {
				//cattle-
				 Cattle cattle = cattleservice.getCattle(momid);
				 cattle.setTeeth(1);
				 cattle.setGroupCattle(groupcattleservice.getGroupCattle(1));
				 cattleservice.edit(cattle);
				 
				 //alert
				 DateTime dtOrg = new DateTime(date);
				 DateTime dtPlusOne = dtOrg.plusDays(dayId);
				 String DayAlert = fmt.print(dtPlusOne);
				 Alert alert = new Alert();
				 alert.setStatusAlert(statusalertservice.getStatusAlert(1));
				 alert.setTypeAlert(typealertservice.getTypeAlerte(1));
				 alert.setCattle_1(momcatl);
				 alert.setDatealert(DayAlert);
				 alert.setTimealert(time);
				 alert.setDayinput(DTnow);
				 alert.setTimeinput(TimeNow);
				 if (note=="") {
					note="ผสมพันธุ์ไม่ติด";
				}
				 alert.setNote(note);
				 alerservice.add(alert);
				 
				 Date dt2 = new Date();
				 DateFormat fmt3 = new SimpleDateFormat("yyyy");
				 String yn = fmt3.format(dt2);
				 CountBreed countBreed = countbreedservice.getCountBreedByPriNo(momid);
				 String yb = countBreed.getYear();
				 if (!yn.equals(yb) || yb == null) {
					countBreed.setYear(yn);
				}
				 int count = countBreed.getCount();
				 count = count+1;
				 countBreed.setCount(count);
				 countbreedservice.edit(countBreed);
			}
		
/*			//pregnant
			Pregnant pregnant = new Pregnant();
			pregnant.setNote(note);
			pregnant.setDatePreg(date);
			pregnant.setMember(memberService.getMember(member));
			pregnant.setCattle(cattleservice.getCattle(mom));
			pregnant.setStatusPregnant(statuspregnantservice.getStatusPregnant(ststus));
			pregnantservice.add(pregnant);*/
			
			List<Alert> alertList = alerservice.getAlertId(momcatl, 2);
			for (Alert closeAlert : alertList) {
				closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
				closeAlert.setMember(memberService.getMember(member));
				alerservice.edit(closeAlert);
			}
			
		 return "redirect:index";
	}
	
	@RequestMapping(value="pregnant_list",method=RequestMethod.GET)
	public String pregnant_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("pregnant", pregnantservice.getAllPregnant());
		return "/reproduce/pregnant_list";  									
		
	}
	
	@RequestMapping(value="calve",method=RequestMethod.GET)
	public String calve(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));		
		Cattle cattle = new Cattle();
		map.put("cattle", cattle);
		map.put("memcat", cattleservice.GetMomCattle2(3));
		map.put("fatcat", cattleservice.GetFatCattle());
		map.put("statborn", statusbornservice.getAllStatusBorn());
		map.put("statusbreed", statusbreedserive.getAllStatusBreed());
		map.put("color", colorservice.getAllColor());
		map.put("sex", sexservice.getAllSex());
		return "/reproduce/calve";  												
	}
	
	@ResponseBody
	@RequestMapping(value="getFatherId",method = RequestMethod.GET)
	public String getFatherId(@RequestParam("q") int q,Map<String, Object> map){	
		int idMax = pregnantservice.getFartherIdByMomId(q);
		Pregnant pregnant = pregnantservice.getPregnant(idMax);		
		String num = pregnant.getBreeding().getCattleByCattlefaId().getNum();
		
		return num;
	}
	
	@RequestMapping(value="/saveCalve",method = RequestMethod.POST)
	public String saveCalve(@RequestParam("momcatl") String mom,
							@RequestParam("fatcatl") String fat,
							@RequestParam("calved")  String calved,
							@RequestParam("statusborn") int statborn,
							@RequestParam("numDate") String[] numDate,
							@RequestParam("name") String[] name,
							@RequestParam("statusbreed") int[] statusbreed,
							@RequestParam("color") int[] color,
							@RequestParam("sex") int[] sex,
							@RequestParam("weightBirth") String[] weightBirth,
								HttpSession session,Map<String,Object> map){
		
		int DAlertSync = typealertservice.getTypeAlerte(5).getValue();
		int DAlertHorn = typealertservice.getTypeAlerte(6).getValue();
		int DAlertWean = typealertservice.getTypeAlerte(7).getValue();
		int DAlertStamp = typealertservice.getTypeAlerte(8).getValue();
		int DAlertWeight = typealertservice.getTypeAlerte(9).getValue();
		
		//Alert
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		 DateTime dt = new DateTime();
		 String DTnow = fmt1.print(dt);
		 String TimeNow = fmt2.print(dt);
		
		 //day sync alert
		 DateTime dtOrg = new DateTime(calved); ///เวลาหรือวันที่
		 DateTime dtOrgPlusDAlertSync = dtOrg.plusDays(DAlertSync);
		 String DayAlertSync = fmt.print(dtOrgPlusDAlertSync); 
		 
		 	//day horn alert
		 DateTime dtOrgPlusDAlertHorn = dtOrg.plusDays(DAlertHorn);
		 String DayAlertHorn = fmt.print(dtOrgPlusDAlertHorn);
		 
		 //day wean alert
		 DateTime dtOrgPlusDAlertWean = dtOrg.plusDays(DAlertWean);
		 String DayAlertDAlertWean = fmt.print(dtOrgPlusDAlertWean);
		 
		 //day stamp alert
		 DateTime dtOrgPlusDAlertStamp = dtOrg.plusDays(DAlertStamp);
		 String DayAlertDAlertStamp = fmt.print(dtOrgPlusDAlertStamp);
		 
		 //day weight 1 year alert 
		 DateTime dtOrgPlusDAlertWeight = dtOrg.plusDays(DAlertWeight);
		 String DayAlertDAlertWeight = fmt.print(dtOrgPlusDAlertWeight);
		 
/*		 //pregnant
		 int idMax = pregnantservice.getFartherIdByMomId(mom);
		 Pregnant pregnant = pregnantservice.getPregnant(idMax);
		 pregnantservice.edit(pregnant); */
		 
		 Alert alert = new Alert();
 
		 // alert sync cattlemom
		 alert.setStatusAlert(statusalertservice.getStatusAlert(1));
		 alert.setTypeAlert(typealertservice.getTypeAlerte(5));
		 alert.setCattle_1(mom);
		 alert.setDatealert(DayAlertSync);
		 alert.setTimealert(TimeNow);
		 alert.setDayinput(DTnow);
		 alert.setTimeinput(TimeNow);
		 alerservice.add(alert);
		 
		 
		
			for (int i = 0; i < statborn ; i++) {
				Cattle cattle = new Cattle();
				cattle.setNumDate(numDate[i]);
				cattle.setName(name[i]);
				cattle.setStatusBreed(statusbreedserive.getStatusBreed(statusbreed[i]));
				cattle.setColor(colorservice.getColor(color[i]));
				cattle.setSex(sexservice.getSex(sex[i]));
				cattle.setWeightBirth(weightBirth[i]);
				cattle.setAge(1);
				cattle.setTeeth(0);
				cattle.setAgeWean(0);
				cattle.setMaId(mom);
				cattle.setFaId(fat);
				cattle.setStatusBorn(statusbornservice.getStatusBorn(statborn));
				cattle.setCalved(calved);
				cattle.setGroupCattle(groupcattleservice.getGroupCattle(8));
				cattle.setStatusCattle(statuscattleservice.getStatusCattle(1));
				cattle.setNum(" ");
				cattleservice.add(cattle);
				
				Alert alert1 = new Alert();
				Alert alert2 = new Alert();
				Alert alert3 = new Alert();
				Alert alert4 = new Alert();
				
				//alert horn
				alert1.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert1.setTypeAlert(typealertservice.getTypeAlerte(6));
				alert1.setCattle_1(numDate[i]);
				alert1.setDatealert(DayAlertHorn);
				alert1.setTimealert(TimeNow);
				alert1.setDayinput(DTnow);
				alert1.setTimeinput(TimeNow);
				alerservice.add(alert1);
				
				//alert wean
				alert2.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert2.setTypeAlert(typealertservice.getTypeAlerte(7));
				alert2.setCattle_1(numDate[i]);
				alert2.setDatealert(DayAlertDAlertWean);
				alert2.setTimealert(TimeNow);
				alert2.setDayinput(DTnow);
				alert2.setTimeinput(TimeNow);
				alerservice.add(alert2);
				
				//alert stamp
				alert3.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert3.setTypeAlert(typealertservice.getTypeAlerte(8));
				alert3.setCattle_1(numDate[i]);
				alert3.setDatealert(DayAlertDAlertStamp);
				alert3.setTimealert(TimeNow);
				alert3.setDayinput(DTnow);
				alert3.setTimeinput(TimeNow);
				alerservice.add(alert3);
				
				//alert weight 1 year
				alert4.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert4.setTypeAlert(typealertservice.getTypeAlerte(9));
				alert4.setCattle_1(numDate[i]);
				alert4.setDatealert(DayAlertDAlertWeight);
				alert4.setTimealert(TimeNow);
				alert4.setDayinput(DTnow);
				alert4.setTimeinput(TimeNow);
				alerservice.add(alert4);
			}
			
			//status cattle
			Cattle cattle1 = cattleservice.getCattleId(mom);
			cattle1.setTeeth(4);
			cattle1.setGroupCattle(groupcattleservice.getGroupCattle(10));
			cattleservice.edit(cattle1);
			
			List<Alert> alertlist = alerservice.getAlertId(cattle1.getNum(),3);
			for (Alert alertclose : alertlist) {
				alertclose.setStatusAlert(statusalertservice.getStatusAlert(2));
			/*	alertclose.setMember(memberService.getMember(member));*/
				alerservice.edit(alertclose);
			}
			
		return "redirect:index";
	}
	
	
/*	@RequestMapping(value="saveCalve",method = RequestMethod.POST)
	public String saveCalve(@RequestParam("momcatl") int mom,
							@RequestParam("dadId") String fat,
							@RequestParam("member") int member,
							@RequestParam("calved")  String calved,
							@RequestParam("statusborn") int statborn,
							@RequestParam("numDate") String[] numDate,
							@RequestParam("name") String[] name,
							@RequestParam("statusbreed") int[] statusbreed,
							@RequestParam("color") int[] color,
							@RequestParam("sex") int[] sex,
							@RequestParam("weightBirth") String[] weightBirth,
								HttpSession session,Map<String,Object> map){
		
			String sessionUsername = (String)session.getAttribute("username");  
			Member m = memberService.getMemberByUsername(sessionUsername);
			int member = m.getId()
		
			int DAlertSync = typealertservice.getTypeAlerte(5).getValue();
			int DAlertHorn = typealertservice.getTypeAlerte(6).getValue();
			int DAlertWean = typealertservice.getTypeAlerte(7).getValue();
			int DAlertStamp = typealertservice.getTypeAlerte(8).getValue();
			int DAlertWeight = typealertservice.getTypeAlerte(9).getValue();
			
			//Alert
			 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
			 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
			 DateTime dt = new DateTime();
			 String DTnow = fmt1.print(dt);
			 String TimeNow = fmt2.print(dt);
			
			 //day sync alert
			 DateTime dtOrg = new DateTime(calved);
			 DateTime dtOrgPlusDAlertSync = dtOrg.plusDays(DAlertSync);
			 String DayAlertSync = fmt.print(dtOrgPlusDAlertSync);
			 
			 //day horn alert
			 DateTime dtOrgPlusDAlertHorn = dtOrg.plusDays(DAlertHorn);
			 String DayAlertHorn = fmt.print(dtOrgPlusDAlertHorn);
			 
			 //day wean alert
			 DateTime dtOrgPlusDAlertWean = dtOrg.plusDays(DAlertWean);
			 String DayAlertDAlertWean = fmt.print(dtOrgPlusDAlertWean);
			 
			 //day stamp alert
			 DateTime dtOrgPlusDAlertStamp = dtOrg.plusDays(DAlertStamp);
			 String DayAlertDAlertStamp = fmt.print(dtOrgPlusDAlertStamp);
			 
			 //day weight 1 year alert 
			 DateTime dtOrgPlusDAlertWeight = dtOrg.plusDays(DAlertWeight);
			 String DayAlertDAlertWeight = fmt.print(dtOrgPlusDAlertWeight);
			 
			 //pregnant
			 int idMax = pregnantservice.getFartherIdByMomId(mom);
			 Pregnant pregnant = pregnantservice.getPregnant(idMax);
			 pregnantservice.edit(pregnant);
			 
			 Alert alert = new Alert();
			 
			 // alert sync cattlemom
			 alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			 alert.setTypeAlert(typealertservice.getTypeAlerte(5));
			 alert.setCattle_1(cattleservice.getCattle(mom).getNum());
			 alert.setMember(memberService.getMember(member));
			 alert.setDatealert(DayAlertSync);
			 alert.setTimealert(TimeNow);
			 alert.setDayinput(DTnow);
			 alert.setTimeinput(TimeNow);
			 alerservice.add(alert);
			 
			 //cattle
			 int dadId = cattleservice.getCattleId(fat).getId();
			 String dadnum = cattleservice.getCattleId(fat).getNum();
			 String momnum = cattleservice.getCattle(mom).getNum();
			 
		
			for (int i = 0; i < statborn ; i++) {
				Cattle cattle = new Cattle();
				cattle.setNumDate(numDate[i]);
				cattle.setName(name[i]);
				cattle.setStatusBreed(statusbreedserive.getStatusBreed(statusbreed[i]));
				cattle.setColor(colorservice.getColor(color[i]));
				cattle.setSex(sexservice.getSex(sex[i]));
				cattle.setWeightBirth(weightBirth[i]);
				cattle.setMaId(momnum);
				cattle.setFaId(dadnum);
				cattle.setStatusBorn(statusbornservice.getStatusBorn(statborn));
				cattle.setCalved(calved);
				cattle.setStatusCattle(statuscattleservice.getStatusCattle(1));
				cattle.setNum(" ");
				cattleservice.add(cattle);
				
				Alert alert1 = new Alert();
				Alert alert2 = new Alert();
				Alert alert3 = new Alert();
				Alert alert4 = new Alert();
				
				//alert horn
				alert1.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert1.setTypeAlert(typealertservice.getTypeAlerte(6));
				alert1.setMember(memberService.getMember(member));
				alert1.setCattle_1(numDate[i]);
				alert1.setDatealert(DayAlertHorn);
				alert1.setTimealert(TimeNow);
				alert1.setDayinput(DTnow);
				alert1.setTimeinput(TimeNow);
				alerservice.add(alert1);
				
				//alert wean
				alert2.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert2.setTypeAlert(typealertservice.getTypeAlerte(7));
				alert2.setMember(memberService.getMember(member));
				alert2.setCattle_1(numDate[i]);
				alert2.setDatealert(DayAlertDAlertWean);
				alert2.setTimealert(TimeNow);
				alert2.setDayinput(DTnow);
				alert2.setTimeinput(TimeNow);
				alerservice.add(alert2);
				
				//alert stamp
				alert3.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert3.setTypeAlert(typealertservice.getTypeAlerte(8));
				alert3.setMember(memberService.getMember(member));
				alert3.setCattle_1(numDate[i]);
				alert3.setDatealert(DayAlertDAlertStamp);
				alert3.setTimealert(TimeNow);
				alert3.setDayinput(DTnow);
				alert3.setTimeinput(TimeNow);
				alerservice.add(alert3);
				
				//alert weight 1 year
				alert4.setStatusAlert(statusalertservice.getStatusAlert(1));
				alert4.setTypeAlert(typealertservice.getTypeAlerte(9));
				alert4.setMember(memberService.getMember(member));
				alert4.setCattle_1(numDate[i]);
				alert4.setDatealert(DayAlertDAlertWeight);
				alert4.setTimealert(TimeNow);
				alert4.setDayinput(DTnow);
				alert4.setTimeinput(TimeNow);
				alerservice.add(alert4);
			}
			
			//status cattle
			Cattle cattle1 = cattleservice.getCattle(mom);
			cattle1.setTeeth(4);
			cattleservice.edit(cattle1);
			
			List<Alert> alertlist = alerservice.getAlertId(cattle1.getNum(),3);
			for (Alert alertclose : alertlist) {
				alertclose.setStatusAlert(statusalertservice.getStatusAlert(2));
				alertclose.setMember(memberService.getMember(member));
				alerservice.edit(alertclose);
			}
			
		return "redirect:index";
	}*/
	
	@RequestMapping(value="calve_list",method=RequestMethod.GET)
	public String calve_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("calve", cattleservice.GetCalves(0));
		return "/reproduce/calve_list";  												
	}	
	
	@RequestMapping(value="calve_detail",method=RequestMethod.POST)
	public String calve_detail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		
		map.put("calve",cattleservice.GetCalves(id));
		return "/reproduce/calve_detail";  												
	}
	
	@RequestMapping(value="synchroniz",method=RequestMethod.GET)
	public String synchroniz(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));		
		TypeSync typesync = new TypeSync();
		Sync sync = new Sync();
		Synchronize synchronize = new Synchronize();
		map.put("synchronize", synchronize);
		map.put("typesync", typesync);
		map.put("sync", sync);
		map.put("momcat", cattleservice.GetMomCattle3(4));
		map.put("typesync", typesyncservice.getAllTypeSync());
		return "/reproduce/synchroniz";  												
	}
	
	@RequestMapping(value="/getSynchroniz",method = RequestMethod.GET)
	public String getSynchroniz(@RequestParam("q") String q,Map<String, Object> map){
		int typesyncid = Integer.parseInt(q);
		TypeSync typesync = typesyncservice.getTypeSync(typesyncid);
		String typename = typesync.getValue();
		map.put("syncList",syncservice.getSyncByq(q) );
		map.put("Typesync", typename);
		return "/reproduce/getsynchroniz";
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getTypeSyncList(){
		Map<String, String> map = new HashMap<>();
		List<TypeSync> List = typesyncservice.getAllTypeSync();
		for (TypeSync typesync : List) {
			map.put(typesync.getId() + "", typesync.getValue());
		}
		return map;
	}
	
	@RequestMapping(value="synchroniz_list",method=RequestMethod.GET)
	public String synchroniz_list(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		map.put("synchroniz", synchronizeservice.getAllSynchronize());
		return "/reproduce/synchroniz_list";  												
	}
	
	
	@RequestMapping(value="/saveSynchroniz",method = RequestMethod.POST)
	public String saveSynchroniz(Map<String, Object> map,@ModelAttribute Synchronize synchronize,HttpSession session,
			   @RequestParam("cattle.id") int mom,
			   @RequestParam("member.id") int member,
			   @RequestParam("typeSync.id") int typesynd,
			   @RequestParam("dateSync") String date,
			   @RequestParam("namesync") String[] namesync,
			   @RequestParam("dayalert") int[] dayalert,
			   @RequestParam("timealert") String[] timealert,
			   @RequestParam("num") int num){
			
/*			Synchronize synchronize = new Synchronize();
			synchronize.setCattle(cattleservice.getCattle(mom));
			synchronize.setMember(memberService.getMember(member));
			synchronize.setTypeSync(typesyncservice.getTypeSync(typesynd));
			synchronize.setDateSync(date);*/
			synchronizeservice.add(synchronize);
			
			Cattle cattle = cattleservice.getCattle(mom);
			cattle.setTeeth(1);
			cattleservice.edit(cattle);
			String num1 = cattle.getNum();
			
			 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
			 DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			 DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
			 DateTime dt = new DateTime();
			 String DTnow = fmt1.print(dt);
			 String DateNow = fmt.print(dt);
			 String TimeNow = fmt2.print(dt);
			 DateTime dtOrg = new DateTime(date);
			 
			 Alert alert = new Alert();
			 alert.setCattle_1(num1);
			 /*alert.setNote(typealertservice.getTypeAlerte(12).getNote(""));*/
			 alert.setMember(memberService.getMember(member));
			 alert.setTypeAlert(typealertservice.getTypeAlerte(12));
			 alert.setStatusAlert(statusalertservice.getStatusAlert(1));
			 List<Sync> slist = syncservice.LastSync(typesynd);
			 for (Sync s : slist) {
				int breedDay = s.getDayalert()+14;
				DateTime dtPlusDay = dtOrg.plusDays(breedDay);
				String DayAlertBreed = fmt.print(dtPlusDay);
				alert.setDatealert(DayAlertBreed);
				alert.setTimealert(s.getTimealert());
				alert.setDayinput(DTnow);
				alert.setTimeinput(TimeNow);
			}
			 alerservice.add(alert);
			 for (int i = 0; i < num ; i++) {
				int status = 1;
				Alert alert1 = new Alert();
				DateTime dtPlusOne = dtOrg.plusDays(dayalert[i]);
				String DayAlert = fmt.print(dtPlusOne);
				alert1.setCattle_1(num1);
				alert.setNote(namesync[i]);
				if (timealert[i] == "") {
					timealert[i] = TimeNow;
				}
				if (dayalert.equals(DateNow)) {
					status = 0;
					alert1.setMember(memberService.getMember(member));
				}
				alert1.setDatealert(DayAlert);
				alert1.setTimealert(timealert[i]);
				alert1.setDayinput(DTnow);
				alert1.setTimeinput(TimeNow);
				alert1.setStatusAlert(statusalertservice.getStatusAlert(status));
				alert1.setTypeAlert(typealertservice.getTypeAlerte(11));
				alert1.setMember(memberService.getMember(member));
				alert1.setNote(typealertservice.getTypeAlerte(11).getNote());
				alerservice.add(alert1);
			}
			 List<Alert> alertList = alerservice.getAlertId(num1, 5);
			 	for (Alert closeAlert : alertList) {
					closeAlert.setStatusAlert(statusalertservice.getStatusAlert(2));
					closeAlert.setMember(memberService.getMember(member));
					alerservice.edit(closeAlert);
				}
			 List<Alert> alertList2 = alerservice.getAlertId(num1, 10);
			 	for (Alert closeAlert2 : alertList2) {
					closeAlert2.setStatusAlert(statusalertservice.getStatusAlert(2));
					closeAlert2.setMember(memberService.getMember(member));
					alerservice.edit(closeAlert2);
				}
		return "redirect:index";
	}
	
	@RequestMapping(value="misscarry",method=RequestMethod.GET)
	public String misscarry(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		Misscarry misscarry = new Misscarry();
		map.put("misscarry", misscarry);
		map.put("memcat", cattleservice.GetMomCattle2(3));
		map.put("dAlertList", typealertservice.getAllTypeAlertById(10));
		return "/reproduce/misscarry";
	}
	
	@RequestMapping(value="misscarry_detail",method=RequestMethod.POST)
	public String misscarry_detail(Map<String, Object> map,@RequestParam("id") int id,HttpSession session) {
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));	
		map.put("miss", misscarryservice.getAllMisscarry());
	
		map.put("memcat", cattleservice.GetMomCattle(2));
		return "/reproduce/misscarry_detail";  												
	}
	
	@RequestMapping(value="/Savemisscarry",method=RequestMethod.POST)
	public String misscarry(HttpSession session,Map<String, Object>map,
			@RequestParam("cattle.id") int momcatl,
			@RequestParam("day") String day,
			@RequestParam("day_input") int dayId,
			@RequestParam("note") String note,
			@RequestParam("member.id") int member,
			@ModelAttribute Misscarry misscarry){
		
		/*System.out.println(momcatl);*/
		
		DateTime dtOrg = new DateTime(day);
		DateTime dt = new DateTime();
		DateTimeFormatter fmy = DateTimeFormat.forPattern("yyyy");
		String year = fmy.print(dtOrg);
		
		int n = misscarryservice.CheckYearMisscarry(momcatl, year).size();
		int sum = n+1;
		int year_th = Integer.parseInt(year)+543;
		String Result = Integer.toString(sum)+"/"+Integer.toString(year_th);
		misscarry.setCountMisscarry(Result);
		//System.out.println(member);
		misscarryservice.add(misscarry);
		
		Cattle cattle = cattleservice.getCattle(momcatl);
		cattle.setTeeth(4);
		cattleservice.edit(cattle);
		String numCatt = cattle.getNum();
		
		DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTimeFormatter fmt2 = DateTimeFormat.forPattern("HH:mm:ss");
		String Dnow = fmt1.print(dt);
		String Tnow = fmt2.print(dt);
		
		DateTime getD = new DateTime(day);
		DateTime Dplus = getD.plusDays(dayId);
		String Dsave = fmt1.print(Dplus);
		
		
		Alert alert = new Alert();
		alert.setCattle_1(numCatt);
		alert.setCattle(cattleservice.getCattle(momcatl));
		alert.setNote(note);
		alert.setTypeAlert(typealertservice.getTypeAlerte(10));
		alert.setStatusAlert(statusalertservice.getStatusAlert(1));
		
		alert.setDayinput(day);
		alert.setTimeinput(Tnow);
		alert.setDatealert(Dsave);
		alert.setTimealert(Tnow);
		alerservice.add(alert);
		
		return "redirect:index";
	}
	
	@RequestMapping(value="misscarry_list",method = RequestMethod.GET)
	public String misscarry_list(Map<String, Object>map,HttpSession session){
		String sessionUsername = (String)session.getAttribute("username");  
		map.put("ulist",memberService.getMemberByUsername(sessionUsername));
		map.put("miss", misscarryservice.getAllMisscarry());
		return "/reproduce/misscarry_list";
	}

	/*
	@RequestMapping(value="saveSynchroniz",method = RequestMethod.POST)
	public String saveSynchroniz(Map<String, Object> map,@ModelAttribute Synchronize synchronize,
			   @RequestParam("momcatl") int mom,
			   @RequestParam("memberid") int member,
			   @RequestParam("Typesync.id") int typesynd,
			   @RequestParam("dateSync") String date,
			   @RequestParam("namesync") String[] namesync,
			   @RequestParam("dayalert") int[] dayalert,
			   @RequestParam("TAlert") String[] TAlert,
			   @RequestParam("num") int num){
			
		System.out.println(mom);
		System.out.println(member);	
		
		return "redirect:index";
	}*/

}
