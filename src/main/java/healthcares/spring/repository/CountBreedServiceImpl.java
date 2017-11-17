package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.CountBreedDao;
import healthcares.spring.model.CountBreed;
import healthcares.spring.service.CountBreedService;
@Service
public class CountBreedServiceImpl implements CountBreedService {

	@Autowired
	private CountBreedDao countbreeddao;
	
	@Transactional
	public void add(CountBreed countbreed) {
		// TODO Auto-generated method stub
		countbreeddao.add(countbreed);
	}

	@Transactional
	public void edit(CountBreed countbreed) {
		// TODO Auto-generated method stub
		countbreeddao.edit(countbreed);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		countbreeddao.delete(Id);
	}

	@Transactional
	public CountBreed getCountBreed(int Id) {
		// TODO Auto-generated method stub
		return countbreeddao.getCountBreed(Id);
	}

	@Transactional
	public List getAllCountBreed() {
		// TODO Auto-generated method stub
		return countbreeddao.getAllCountBreed();
	}
	
	@Transactional
	public CountBreed getCountBreedByPriNo(int id) {
		return countbreeddao.getCountBreedByPriNo(id);
	}
	
	@Transactional
	public List getAllCountBreedById(int id) {
		// TODO Auto-generated method stub
		return countbreeddao.getAllCountBreedById(id);
	}

}
