package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.StatusMedicineDao;
import healthcares.spring.model.StatusMedicine;
import healthcares.spring.service.StatusMedicineService;

@Service
public class StatusMedicineServiceImpl implements StatusMedicineService {

	@Autowired
	private StatusMedicineDao statusmedicinedao;
	
	
	@Transactional
	public void add(StatusMedicine statusmedicine) {
		// TODO Auto-generated method stub
		statusmedicinedao.add(statusmedicine);
	}

	@Transactional
	public void edit(StatusMedicine statusmedicine) {
		// TODO Auto-generated method stub
		statusmedicinedao.edit(statusmedicine);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		statusmedicinedao.delete(Id);
	}

	@Transactional
	public StatusMedicine getStatusMedicine(int Id) {
		// TODO Auto-generated method stub
		return statusmedicinedao.getStatusMedicine(Id);
	}

	@Transactional
	public List getAllStatusMedicine() {
		// TODO Auto-generated method stub
		return statusmedicinedao.getAllStatusMedicine();
	}

}
