package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.StatusTreatDao;
import healthcares.spring.model.StatusTreat;
import healthcares.spring.service.StatusTreatService;
@Service
public class StatusTreatServiceImpl implements StatusTreatService {

	@Autowired
	private StatusTreatDao statustreatdao;
	
	@Transactional
	public void add(StatusTreat statustreat) {
		// TODO Auto-generated method stub
		statustreatdao.add(statustreat);
	}

	@Transactional
	public void edit(StatusTreat statustreat) {
		// TODO Auto-generated method stub
		statustreatdao.edit(statustreat);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		statustreatdao.delete(Id);
	}

	@Transactional
	public StatusTreat getStatusTreat(int Id) {
		// TODO Auto-generated method stub
		return statustreatdao.getStatusTreat(Id);
	}

	@Transactional
	public List getAllStatusTreat() {
		// TODO Auto-generated method stub
		return statustreatdao.getAllStatusTreat();
	}

}
