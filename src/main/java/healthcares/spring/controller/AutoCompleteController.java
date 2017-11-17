package healthcares.spring.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import healthcares.spring.model.Disease;
import healthcares.spring.service.CableDiseaseService;
import healthcares.spring.service.CattleService;
import healthcares.spring.service.DiseaseService;
import healthcares.spring.service.GroupMedicineService;
import healthcares.spring.service.MedicineService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.PrivilegeService;
import healthcares.spring.service.StatusMedicineService;
import healthcares.spring.service.TreatmentHistoryService;
import healthcares.spring.service.TypeMedicineService;
import healthcares.spring.service.UnitMedicineService;


@Controller
public class AutoCompleteController {
	
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
	private TreatmentHistoryService treatmenthistoryservice;
	
	@Autowired
	private TypeMedicineService typemedicineservice;
	
	@Autowired
	private UnitMedicineService unitmedicineservice;
	
	@Autowired
	private GroupMedicineService groupmedicineservice;
	
	@Autowired
	private StatusMedicineService statusmedicineservice;
	
	
	
	
	@ResponseBody
    @RequestMapping(value = "/auto", method = RequestMethod.GET)
    public List<String> autoGroup1(@RequestParam("term") String text){
	
	List<String> matchName = getidCow(text);

	return matchName;
    }
	
	
	
	private List<String> getidCow(String text) {
		
		String msg = AddMSG();
		List<String> returnMatch = new ArrayList<String>();
		String [] data =msg.toString().split(",");	
		for (String string : data) {
		    if (string.toUpperCase().indexOf(text.toUpperCase())!= -1) {
		    	returnMatch.add(string);
		    }
		}
		
		return returnMatch;
		
	}
	
	
	private String AddMSG(){
		int num = diseaseService.getAllDisease().size(), i = 0 ,a =0;
				
				//cattleinfoService.getAllCattleInfo().size(),num1 = calfService.getAllCalf("มีชีวิต").size(),i=0,a=0;
		String[] data=new String[num+1];
		//String[] data1=new String[num1+1];
		String total="";
		List<Disease> diseaselist = diseaseService.getAllDisease();
		
		for(Disease get : diseaselist){
			data[i] = get.getSymptomsOfDisease();
			total = total + get.getSymptomsOfDisease()+",";
			i+=1;
		}


		int last = total.length();
		String result = total.substring(0,last);
		return result;

	}

}
