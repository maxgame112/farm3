package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.DiseaseDao;
import healthcares.spring.dao.GroupMedicineDao;
import healthcares.spring.model.Disease;
import healthcares.spring.service.DiseaseService;
@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	private DiseaseDao diseaseDao;
	
	@Transactional
	public void add(Disease disease) {
		// TODO Auto-generated method stub
		diseaseDao.add(disease);
	}

	@Transactional
	public void edit(Disease disease) {
		// TODO Auto-generated method stub
		diseaseDao.edit(disease);
	}
	
	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		diseaseDao.delete(Id);
	}

	@Transactional
	public Disease getDisease(int Id) {
		// TODO Auto-generated method stub
		return diseaseDao.getDisease(Id);
	}

	@Transactional
	public List getAllDisease() {
		// TODO Auto-generated method stub
		return diseaseDao.getAllDisease();
	}

	@Transactional
	public List getDiseaseName(String nameDisease) {
		// TODO Auto-generated method stub
		return diseaseDao.getDiseaseName(nameDisease);
	}
	
	@Transactional
	public List<Disease> getSearch(Disease disease , int page){
		return diseaseDao.getSearch(disease, page);
	}
	
	@Transactional
	public int CountAllDisease(Disease disease){
		return diseaseDao.CountAllDisease(disease);
	}
	
}
