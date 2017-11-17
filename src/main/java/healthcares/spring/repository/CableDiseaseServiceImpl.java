package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.CableDiseaseDao;
import healthcares.spring.dao.DiseaseDao;
import healthcares.spring.model.CableDisease;
import healthcares.spring.model.Disease;
import healthcares.spring.service.CableDiseaseService;
@Service
public class CableDiseaseServiceImpl implements CableDiseaseService {

	@Autowired
	private CableDiseaseDao cablediseasedao;
	
	@Transactional
	public void add(CableDisease cabledisease) {
		// TODO Auto-generated method stub
		cablediseasedao.add(cabledisease);
	}

	@Transactional
	public void edit(CableDisease cabledisease) {
		// TODO Auto-generated method stub
		cablediseasedao.edit(cabledisease);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		cablediseasedao.delete(Id);
	}

	@Transactional
	public CableDisease getCableDisease(int Id) {
		// TODO Auto-generated method stub
		return cablediseasedao.getCableDisease(Id);
	}

	@Transactional
	public List getAllCableDisease() {
		// TODO Auto-generated method stub
		return cablediseasedao.getAllCableDisease();
	}

}
