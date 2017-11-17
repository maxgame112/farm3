package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.BreedingDao;
import healthcares.spring.model.Breeding;
import healthcares.spring.model.TreatmentHistory;
import healthcares.spring.service.BreedingService;
@Service
public class BreedingServiceImpl implements BreedingService {

	@Autowired
	private BreedingDao breedingdao;
	
	@Transactional
	public void add(Breeding breeding) {
		// TODO Auto-generated method stub
		breedingdao.add(breeding);
	}

	@Transactional
	public void edit(Breeding breeding) {
		// TODO Auto-generated method stub
		breedingdao.edit(breeding);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		breedingdao.delete(Id);
	}

	@Transactional
	public Breeding getBreeding(int Id) {
		// TODO Auto-generated method stub
		return breedingdao.getBreeding(Id);
	}

	@Transactional
	public List getAllBreeding() {
		// TODO Auto-generated method stub
		return breedingdao.getAllBreeding();
	}
	
	@Transactional
	public List<Breeding> getSearch(Breeding breeding,int page){
		return breedingdao.getSearch(breeding, page);
	}

	@Transactional
	public int countAllBreeding(Breeding breeding){
		return breedingdao.countAllBreeding(breeding);
	}
	
	@Transactional
	public List<Breeding> getSearchReport(String Start,String End){
		return breedingdao.getSearchReport(Start, End);
	}
}
