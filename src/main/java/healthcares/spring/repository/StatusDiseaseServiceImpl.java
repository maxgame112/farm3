package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcares.spring.dao.StatusDiseaseDao;
import healthcares.spring.model.StatusDisease;
import healthcares.spring.service.StatusDiseaseService;

@Service
public class StatusDiseaseServiceImpl implements StatusDiseaseService, StatusDiseaseDao {

	@Autowired
	private StatusDiseaseDao statusdiseasedao;
	
	@Override
	public void add(StatusDisease statusdisease) {
		// TODO Auto-generated method stub
		statusdiseasedao.add(statusdisease);
	}

	@Override
	public void edit(StatusDisease statusdisease) {
		// TODO Auto-generated method stub
		statusdiseasedao.edit(statusdisease);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		statusdiseasedao.delete(Id);
	}

	@Override
	public StatusDisease getStatusDisease(int Id) {
		// TODO Auto-generated method stub
		return statusdiseasedao.getStatusDisease(Id);
	}

	@Override
	public List getAllStatusDisease() {
		// TODO Auto-generated method stub
		return statusdiseasedao.getAllStatusDisease();
	}

}
