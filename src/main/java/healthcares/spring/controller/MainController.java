package healthcares.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import healthcares.spring.model.Cattle;
import healthcares.spring.model.Farm;
import healthcares.spring.model.Member;
import healthcares.spring.myapp.MD5;
import healthcares.spring.service.FarmService;
import healthcares.spring.service.MemberService;
import healthcares.spring.service.PrivilegeService;



@Controller
public class MainController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired 
	private FarmService farmService;
	
	MD5 md5 = new MD5();
	//�ԧ��˹�� index
	@RequestMapping("/")
		public String home(HttpSession session,Map<String, Object> map) {
			
			String sessionUsername = (String)session.getAttribute("username");
			map.put("ulist", memberService.getMemberByUsername(sessionUsername));

			return "index";
		}
	
	@RequestMapping("/index")
	public String index(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));

		return "index";
	}
	
	
	//�ԧ��˹����Ѥ���Ҫԡ
	@RequestMapping("/register") //�����ԧ��
	public String register(HttpSession session,Map<String, Object> map) {
		String sessionUsername = (String)session.getAttribute("username");
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		Member member = new Member();
		map.put("member", member); //map�ҵ���� ����觤���
		return "page/register"; //����������
	}
	//login
	@RequestMapping(value = "login",method = RequestMethod.POST)
		public String login(Map<String, Object> map,HttpSession session,@RequestParam("username") 
			String username, @RequestParam("password") String password){ //���¡�� session�ҵ�Ǩ�ͺ
			String link;
			String newpassword = md5.getMD5(password); //����¹pass�� MD5
			Member member = memberService.getLogin(username, newpassword);
			if(member != null){
				session.setAttribute("username", member.getUsername()); //���� session �����Ҩ��� ����� user ����������
				session.setAttribute("privilege", member.getPrivilege().getId()); //�� session ������ privilege ���Ţ������
				link = "index"; //���login finish go to member page
				
			}else{
				link = "index"; //if no login finish goto index page
			}
		return "redirect:"+link;		
	} 
	@RequestMapping(value="/logout") //logout
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}
	
	@ResponseBody  //ત username���
	@RequestMapping(value="checkUser")
	public String check(@RequestParam("username") String username){
		int chk = memberService.getMemberByUsername(username).size();
		String msg="yes";
		if(chk>0){
			msg = "no";
		}
	
		return msg;
	}
	
	@ResponseBody //ત���ʺѵû�ЪҪ�
	@RequestMapping(value="/checkIdCardNo")
	public String checkIdCardNo(Map<String, Object>map, @RequestParam("idCardNo") String idCardNo){
		String result = "false",check="true";
		int size = idCardNo.length();
		int chk = memberService.checkIdCard(idCardNo).size();
		try { 
			Double.parseDouble(idCardNo);
			
		} catch (Exception e) {
			// TODO: handle exception
			check="false";
		}
		if(size==13 && check.equals("true")){
			int sum=0;
			int num = 0;
			for(int i=13;i>=2;i--){
				sum += (Integer.parseInt(idCardNo.substring(num,num+1))*i);
				num++;
			}
			if(((11-(sum%11))%10)==Integer.parseInt(idCardNo.substring(num,num+1))){
				result="true";
			}
			if(chk>0){
				result="duplicate";
			}
		}else{
			result="false";
		}
		return result;
	}
	//save��Ѥ���Ҫԡŧ�ҵ���� add ������ŧ�ҵ����
	@RequestMapping(value="SaveRegister",method = RequestMethod.POST)
	public String saveRegister(@ModelAttribute Member member, Map<String, Object> map){
		String newpass = md5.getMD5(member.getPassword()); //�������� md5
		member.setPassword(newpass);// set password �� MD5
		member.setPrivilege(privilegeService.getPrivilege(7)); //��駤���Է��� ��˹��ء����������դ��������Ѥ�������Ҥ��¡�˹��Է�����蹷���ѧ
		memberService.add(member); //add ����������
		return "redirect:index";
	}
	
	
	@RequestMapping("/set_brand")
	public ModelAndView set_brand(HttpSession session,Map<String, Object> map){
		String sessionUsername = (String)session.getAttribute("username");
		if(sessionUsername==null){
			ModelAndView model = new ModelAndView("no_login");
			return model;
		}
		map.put("ulist", memberService.getMemberByUsername(sessionUsername));
		map.put("farm",farmService.getFarm(1));
		ModelAndView model = new ModelAndView("/page/set_brand");
		return model;
	}
	@RequestMapping(value="saveBrand",method=RequestMethod.POST)
	public String saveBrand(@RequestParam( value="file", required=false) MultipartFile file,
						@RequestParam("nameThai") String nameThai,@RequestParam("nameEng") String nameEng,
						@RequestParam("shotName") String shotName,@RequestParam("phone") String phone,
						@RequestParam("address") String address,
						Map<String, Object> map){
		String logo = "logo.jpg";
		
		Farm farm = farmService.getFarm(1);
		farm.setNameThai(nameThai);
		farm.setNameEng(nameEng);
		farm.setShotName(shotName);
		farm.setAddress(address);
		farm.setPhone(phone);
		farmService.edit(farm);
		if (!file.isEmpty()) {
            try {  
            	byte[] bytes = file.getBytes();

            	String uploadPath = context.getRealPath("")+File.separator+"img/img_brand";
            	File dir = new File(uploadPath);
            /*    File dir2 = new File("monitoring/WEB-INF/classes/img/img_brand");*/
            
                  String result=dir.getAbsolutePath() + File.separator+logo;
   
            	  
            	  if (!dir.exists())
                  {   dir.mkdirs(); }
                  BufferedOutputStream stream =
                          new BufferedOutputStream(new FileOutputStream(new File(result)));

                  
                  stream.write(bytes);
                  stream.close();
                  System.out.println(result);
     
            } catch (Exception e) {
            	
            	return "page/error";
            }
		}
		
		return "page/success";
	}
}
