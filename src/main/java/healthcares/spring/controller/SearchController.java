package healthcares.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import healthcares.spring.model.Alert;
import healthcares.spring.model.Breeding;
import healthcares.spring.model.CableDisease;
import healthcares.spring.model.Cattle;
import healthcares.spring.model.CattleStamp;
import healthcares.spring.model.CattleWean;
import healthcares.spring.model.CattleYear;
import healthcares.spring.model.Disease;
import healthcares.spring.model.GroupMedicine;
import healthcares.spring.model.HornDetering;
import healthcares.spring.model.Medicine;
import healthcares.spring.model.Member;
import healthcares.spring.model.Misscarry;
import healthcares.spring.model.Pregnant;
import healthcares.spring.model.Privilege;
import healthcares.spring.model.StatusBreed;
import healthcares.spring.model.Synchronize;
import healthcares.spring.model.TreatmentHistory;
import healthcares.spring.model.TypeHorn;
import healthcares.spring.model.TypeSync;
import healthcares.spring.myapp.PageCount;
import healthcares.spring.service.AlertService;
import healthcares.spring.service.BreedingService;
import healthcares.spring.service.CableDiseaseService;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.CattleStampService;
import healthcares.spring.service.CattleWeanService;
import healthcares.spring.service.CattleYearService;
import healthcares.spring.service.DiseaseService;
import healthcares.spring.service.HornDeteringService;
import healthcares.spring.service.MedicineService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.MisscarryService;
import healthcares.spring.service.PregnantService;
import healthcares.spring.service.StatusBreedService;
import healthcares.spring.service.StatusCattleService;
import healthcares.spring.service.SynchronizeService;
import healthcares.spring.service.TreatmentHistoryService;
import healthcares.spring.service.TypeHornService;

@Controller
public class SearchController {
	
	@Autowired
	private DiseaseService diseaseservice;
	
	@Autowired
	private CableDiseaseService cablediseaseservice;
	
	@Autowired
	private MedicineService medicineservice;
	
	@Autowired
	private CattleService cattleService;
	
	@Autowired
	private StatusBreedService statusbreedservice;
	
	@Autowired
	private BreedingService breedingservice;
	
	@Autowired
	private PregnantService pregnantservice;
	
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
	private MemberService memberservice;
	
	@Autowired
	private SynchronizeService synchronizservice;
	
	@Autowired
	private AlertService alertservice;
	
	@Autowired
	private TreatmentHistoryService treatmenthistoryservice;
	
	@Autowired
	private MisscarryService misscarryservice;
	
	@RequestMapping(value="page") //�Ѻ�ӹǹ paage
	public String page(Map<String, Object> map,@RequestParam("pagePresent") int pagePresent,
			@RequestParam("pageLast") int pageLast){
		PageCount pageCount = new PageCount();
		map.put("page",pageCount.getPage(pagePresent, pageLast));
		return "page/page";
	}
	
	@RequestMapping(value="page1") //นับจำนวน pageสำหรับเบิก
	public String page1(Map<String, Object> map,@RequestParam("pagePresent1") int pagePresent,
			@RequestParam("pageLast1") int pageLast){
		PageCount pageCount = new PageCount();
		map.put("page1",pageCount.getPage(pagePresent, pageLast));
		return "page/page2";
	}
	
	
	@RequestMapping(value="search_disease")
	public String search_disease(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){

		Disease disease = new Disease();
		CableDisease cableDisease = new CableDisease();
		if (id == 1) {
			disease.setNameDisease(value);
		}
		if (id == 2) {
			disease.setSymptomsOfDisease(value);
		//	medicine.setProperties(value);
		}
		if (id == 3) {
			cableDisease.setValue(value);
			disease.setCableDisease(cableDisease);
		}
		
		List<Disease> dis = diseaseservice.getSearch(disease, page);
		int count = diseaseservice.CountAllDisease(disease);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("dis", dis);
		map.put("count", countPage);
		map.put("page", page);
		return "/health/search_disease";
	}
	
	@RequestMapping(value="search_medicine")
	public String search_medicine(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		
		Medicine medicine = new Medicine();
		GroupMedicine groupMedicine = new GroupMedicine();
		
		if (id == 1) {
			medicine.setTradeName(value);
		}if (id == 2) {
			groupMedicine.setValue(value);
			medicine.setGroupMedicine(groupMedicine);
		}
		
		List<Medicine> medicines = medicineservice.getSearch(medicine, page);
		int count = medicineservice.CountAllMedicine(medicine);
		
		int countPage = 0;
		if (count % 10 == 0) {
			countPage = count /10;
		}else {
			countPage = (count/10)+1;
		}
		
		map.put("medi", medicines);
		map.put("page", page);
		map.put("count", countPage);
		
		return "/medicine/search_medicine";
		
	}
	
	/*@RequestMapping(value="search_medicine")
	public String search_medicine(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Medicine medicine = new Medicine();
		GroupMedicine groupmed = new GroupMedicine();
		if (id == 1) {
			medicine.setTradeName(value);
		}
		if (id == 2) {
			groupmed.setValue(value);
			medicine.setGroupMedicine(groupmed);
		}
		
		List<Medicine> med = medicineservice.getSearch(medicine, page);
		int count = medicineservice.CountAllMedicine(medicine);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("medi", med);
		map.put("count", countPage);
		map.put("page", page);
		
		return "/medicine/search_medicine";
	}*/
	
	@RequestMapping(value="search_cattle")
	public String search_cattle(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Cattle cattle = new Cattle();
		StatusBreed statusBreed = new StatusBreed();
		if (id == 1) {
			cattle.setNum(value);
		}
		if (id == 2) {
			statusBreed.setValue(value);
			cattle.setStatusBreed(statusBreed);
		}
		if (id == 3) {
			cattle.setNumDate(value);
		}
		List<Cattle> catt = cattleService.getSearch(cattle, page);
		int count = cattleService.countAllCattle(cattle);
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("cattle", catt);
		map.put("count", countPage);
		map.put("page", page);
		
		return "/cattle/search_cattle";
	}
	
	@RequestMapping(value="search_breeding")
	public String search_breeding(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Breeding breeding = new Breeding();
		Cattle cattle = new Cattle();
		if (id == 1) {
			cattle.setNum(value);
			breeding.setCattleByCattlemaId(cattle);
		}
		List<Breeding> breed = breedingservice.getSearch(breeding, page);
		int count = breedingservice.countAllBreeding(breeding);
		int countPage = 0;
		if (count % 10 == 0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("breeding", breed);
		map.put("count", countPage);
		map.put("page", page);
			
		return "/reproduce/search_breeding";
	}
	
	@RequestMapping(value="search_pregnant")
	public String search_pregnant(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Pregnant pregnant = new Pregnant();
		Cattle cattle = new Cattle();
		Breeding breeding = new Breeding();
		if (id == 1) {
			cattle.setNum(value);
			breeding.setCattleByCattlemaId(cattle);
			pregnant.setBreeding(breeding);
		}
		
		List<Pregnant> prg = pregnantservice.getSearch(pregnant, page);
		int count = pregnantservice.getSearch(pregnant).size();
		int countPage = 0;
		if (count % 10 == 0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("prg", prg);
		map.put("count", countPage);
		map.put("page", page);
			
		return "/reproduce/search_pregnant";
	}
	
	@RequestMapping(value="search_calve")
	public String search_calve(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Cattle cattle = new Cattle();
		if (id == 1) {
			cattle.setMaId(value);
		}
		List<Cattle> catt = cattleService.getSearch(cattle, page);
		int count = cattleService.countAllCattle(cattle);
		int countPage = 0;
		if (count % 10 == 0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		map.put("calve", catt);
		map.put("count", countPage);
		map.put("page", page);
		
		return "/reproduce/search_calve";
		
	}
	
	@RequestMapping(value="search_horndeter")
	public String search_horndeter(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		HornDetering hornder = new HornDetering();
		Cattle cattle = new Cattle();
		TypeHorn typehorn = new TypeHorn();
		if (id == 1) {
			cattle.setNumDate(value);;
			hornder.setCattle(cattle);
			
		}
		if(id == 2){
			typehorn.setValue(value);
			hornder.setTypeHorn(typehorn);
		}
		List<HornDetering> hornList =  horndeteringservice.getSearch(hornder, page);
		int count = horndeteringservice.CountAllHornDetering(hornder);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("hornList", hornList);
		map.put("count", countPage);
		map.put("page", page);
		return "/calves/search_horndeter";
	}
	
	@RequestMapping(value="search_wean")
	public String search_wean(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		
		CattleWean cattlewean = new CattleWean();
		Cattle cattle = new Cattle();
		TypeHorn typehorn = new TypeHorn();
		if (id == 1) {
			cattle.setNumDate(value);;
			cattlewean.setCattle(cattle);
			
		}
		List<CattleWean> Listwean = cattleweanservice.getSearch(cattlewean, page);
		int count = cattleweanservice.CountAllCattleWean(cattlewean);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("Listwean", Listwean);
		map.put("count", countPage);
		map.put("page", page);
		return "/calves/search_wean";
	}
	
	@RequestMapping(value="search_numbercat")
	public String search_numbercat(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		CattleStamp cattlestam = new CattleStamp();
		Cattle cattle = new Cattle();
		if (id == 1) {
			cattle.setNum(value);
			cattlestam.setCattle(cattle);
			
		}
		List<CattleStamp> ListStam = cattlestampservice.getSearch(cattlestam, page);
		int count = cattlestampservice.CountAllCattleStamp(cattlestam);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("ListStam", ListStam);
		map.put("count", countPage);
		map.put("page", page);
		return "/calves/search_numbercat";
	}
	
	@RequestMapping(value="search_weight")
	public String search_weight(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		CattleYear cattleY = new CattleYear();
		Cattle cattle = new Cattle();
		if (id == 1) {
			cattle.setNum(value);
			cattleY.setCattle(cattle);
			
		}
		List<CattleYear> ListYear = cattleyearservice.getSearch(cattleY, page);
		int count = cattleyearservice.CountAllCattleYear(cattleY);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("ListY", ListYear);
		map.put("count", countPage);
		map.put("page", page);
		return "/calves/search_weight";
	}
	
	@RequestMapping(value="search_member")
	public String search_member(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Member mem = new Member();
		Privilege pri = new Privilege();
		
		if(id==1){mem.setFirst(value);}
		if(id==2){mem.setAddress(value);}
		if(id==3){
			pri.setValue(value);
			mem.setPrivilege(pri);
		}
		List memList = memberservice.getSearch(mem, page);
		int count = memberservice.CountAllMember(mem);
		
		int countPage = 0;
		if((count%10)==0){
			countPage=count/10;
		}else{
			countPage=(count/10)+1;
		}
		map.put("memList", memList);
		map.put("count", countPage);
		map.put("page", page);
		
		return "/setting/list_set_member";
	}	
	
	
	@RequestMapping(value="search_synchroniz")
	public String search_synchroniz(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Synchronize synchronize = new Synchronize();
		Cattle cattle = new Cattle();
		TypeSync typeSync = new TypeSync();
		if (id == 1) {
			cattle.setNum(value);
			synchronize.setCattle(cattle);
			
		}
		if (id == 2) {
			typeSync.setValue(value);
			synchronize.setTypeSync(typeSync);
		}
		List<Synchronize> sync = synchronizservice.getSearch(synchronize, page);
		int count = synchronizservice.countAllSynchronize(synchronize);
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("sync", sync);
		map.put("count", countPage);
		map.put("page", page);
		return "/reproduce/search_synchroniz";
	}

	
	@RequestMapping(value="search_alert")
	public String search_alert(@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){

		List<Alert> alertlist = alertservice.getAlloalert(page);
		int count = alertservice.getAllalert().size();
		
		int countPage = 0;
		if((count%10)==0){
			countPage=count/10;
		}else{
			countPage=(count/10)+1;
		}
		
		map.put("num", alertservice.getAlloalert(page).size());
		map.put("alertlist", alertlist);
		map.put("count", countPage);
		map.put("page", page);
		
		return "/alert/search_alert";
	}	

	
	@RequestMapping(value="search_recommend")
	public String search_recommend(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		Medicine medicine = new Medicine();
		Disease disease = new Disease();
		if (id == 1) {
			disease.setSymptomsOfDisease(value);
		//	medicine.setProperties(value);
		}
		
		List<Disease> dis = diseaseservice.getSearch(disease, page);
		int count = diseaseservice.CountAllDisease(disease);
		
		/*List<Medicine> med = medicineservice.getSearch(medicine, page);
		int count1 = medicineservice.CountAllMedicine(medicine);*/
		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		//map.put("medicine", med);
		map.put("disease", dis);
		map.put("count", countPage);
		map.put("page", page);
		return "/health/search_recommend";
	}
	
	@RequestMapping(value="search_recommend1")
	public String search_recommend1(@RequestParam("id") int id,@RequestParam("value") String value,
			@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
		
		Medicine medicine = new Medicine();
		if (id == 1) {
			medicine.setProperties(value);
		}
		
		List<Medicine> med = medicineservice.getSearch(medicine, page);
		int count = medicineservice.CountAllMedicine(medicine);

		
		int countPage = 0;
		if (count % 10 ==0) {
			countPage = count/10;
		}else {
			countPage = (count/10)+1;	
		}
		
		map.put("medicine", med);
		map.put("count1", countPage);
		map.put("page1", page);
		return "/health/search_recommend1";
	}
	
	@RequestMapping(value="search_treat")
	public String search_treat(@RequestParam("id") int id , @RequestParam("value") String value,
								@RequestParam(value="page",defaultValue="1") int page , Map<String, Object>map){
		TreatmentHistory treatmentHistory = new TreatmentHistory();
		Cattle cattle = new Cattle();
		Medicine medicine = new Medicine();
		Disease disease = new Disease();
		
		if (id == 1) {
			cattle.setNum(value);
			treatmentHistory.setCattle(cattle);
		}if (id == 2) {
			medicine.setTradeName(value);
			treatmentHistory.setMedicine(medicine);
		}if (id == 3) {
			disease.setNameDisease(value);
			treatmentHistory.setDisease(disease);
		}
		List<TreatmentHistory> treat = treatmenthistoryservice.getSearch(treatmentHistory, page);
		int count = treatmenthistoryservice.countAllTreatmentHistory(treatmentHistory);
		
		int countPage = 0 ;
		if (count % 10 == 0) {
			countPage = count/10;	
		}else {
			countPage = (count/10)+1;
		}
		map.put("treat", treat);
		map.put("count", countPage);
		map.put("page", page);
		return "/health/search_treat";
	}
	
	

		@RequestMapping("search_report_pdf")
		public String search_report_pdf(@RequestParam("idReport") int idReport,
				@RequestParam("dateStart") String dateStart,
				@RequestParam("dateEnd") String dateEnd,
				Map<String, Object> map){
			
			if(idReport == 1){
				map.put("treat", treatmenthistoryservice.getSearchReport(dateStart, dateEnd));
				int count = treatmenthistoryservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/treatment";
			}
			
			if (idReport == 2) {
				map.put("breed", breedingservice.getSearchReport(dateStart, dateEnd));
				int count = breedingservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/breed";
			}
			
			if (idReport == 3) {
				map.put("preg", pregnantservice.getSearchReport(dateStart, dateEnd));
				int count = pregnantservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/pregnant";
			}
			
			if (idReport == 4) {
				map.put("calve", cattleService.getSearchReport(dateStart, dateEnd));
				int count = cattleService.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/calve";
			}

			if (idReport == 5) {
				map.put("sync", synchronizservice.getSearchReport(dateStart, dateEnd));
				int count = synchronizservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/synchronize";
			}
			
			if (idReport == 6) {
				map.put("horn", horndeteringservice.getSearchReport(dateStart, dateEnd));
				int count = horndeteringservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/horndetering";
			}
			
			if (idReport == 7) {
				map.put("wean", cattleweanservice.getSearchReport(dateStart, dateEnd));
				int count = cattleweanservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/wean";
			}
			
			if (idReport == 8) {
				map.put("numcat", cattleyearservice.getSearchReport(dateStart, dateEnd));
				int count = cattleyearservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/numcat";
			}
			
			if (idReport == 9) {
				map.put("weight", cattleyearservice.getSearchReport(dateStart, dateEnd));
				int count = cattleyearservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/numyear";
			}
			
			if (idReport == 10) {
				map.put("miss", misscarryservice.getSearchReport(dateStart, dateEnd));
				int count = misscarryservice.getSearchReport(dateStart, dateEnd).size();
				map.put("count", count);
				return "/report/search/misscarry";
			}
			
			return null;
		}
		
	
		
		@RequestMapping(value="search_t")
		public String search_t(@RequestParam("id") int id,@RequestParam("value") String value,
				@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
			Medicine medicine = new Medicine();
			Disease disease = new Disease();
			if (id == 1) {
				disease.setSymptomsOfDisease(value);
			}
				

			List<Disease> dis = diseaseservice.getSearch(disease, page);
			int count = diseaseservice.CountAllDisease(disease);
			
			/*List<Medicine> med = medicineservice.getSearch(medicine, page);
			int count1 = medicineservice.CountAllMedicine(medicine);*/
			
			int countPage = 0;
			if (count % 10 ==0) {
				countPage = count/10;
			}else {
				countPage = (count/10)+1;	
			}
			
			//map.put("medicine", med);
			map.put("disease", dis);
			map.put("count", countPage);
			map.put("page", page);
			return "/health/search_recommend";
		}
		
		@RequestMapping(value="search_t1")
		public String search_t1(@RequestParam("id") int id,@RequestParam("value") String value,
				@RequestParam(value="page",defaultValue="1") int page,Map<String, Object> map){
			
			Medicine medicine = new Medicine();
			if (id == 1) {
				medicine.setProperties(value);
			}
				

			
			List<Medicine> med = medicineservice.getSearch(medicine, page);
			int count = medicineservice.CountAllMedicine(medicine);

			
			int countPage = 0;
			if (count % 10 ==0) {
				countPage = count/10;
			}else {
				countPage = (count/10)+1;	
			}
			
			map.put("medicine", med);
			map.put("count1", countPage);
			map.put("page1", page);
			return "/health/search_recommend1";
		}

		@RequestMapping(value="search_misscarry")
		public String search_misscarry(@RequestParam("id") int id , @RequestParam("value") String value,
										@RequestParam(value="page",defaultValue="1") int page,Map<String, Object>map){
			Misscarry misscarry = new Misscarry();
			Cattle cattle = new Cattle();
			if (id == 1) {
				cattle.setNum(value);
				misscarry.setCattle(cattle);
			}
			
			List<Misscarry> miss = misscarryservice.getSearchMiscarry(misscarry, page);
			int count = misscarryservice.CountAllMisscarry(misscarry);
			int countPage = 0;
			if (count % 10 == 0) {
				countPage = count/10;
			}else {
				countPage = (count/10)+1;
			}
			map.put("miss", miss);
			map.put("count", countPage);
			map.put("page", page);
			return "reproduce/search_misscarry";
		}
}
