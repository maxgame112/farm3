package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.AlertDao;
import healthcares.spring.model.Alert;
import healthcares.spring.service.AlertService;
@Service
public class AlertServiceImpl implements AlertService {
	
	@Autowired
	private AlertDao alertdao;

	@Transactional
	public void add(Alert alert) {
		// TODO Auto-generated method stub
		alertdao.add(alert);
	}

	@Transactional
	public void edit(Alert alert) {
		// TODO Auto-generated method stub
		alertdao.edit(alert);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		alertdao.delete(Id);
	}

	@Transactional
	public Alert getalert(int Id) {
		// TODO Auto-generated method stub
		return alertdao.getalert(Id);
	}

	@Transactional
	public List getAllalert() {
		// TODO Auto-generated method stub
		return alertdao.getAllalert();
	}
	
	@Transactional
	public List Date1(){
		return alertdao.Date1();
	}
	
	@Transactional
	public List Date2(){
		return alertdao.Date2();
	}
	
	@Transactional
	public List Date3(){
		return alertdao.Date3();
	}
	
	@Transactional
	public List getAlertId(String cattleId, int i){
		return alertdao.getAlertId(cattleId, i);
	}
	
	@Transactional
	public List getAlloalert(int page){
		return alertdao.getAlloalert(page);
	}

}
