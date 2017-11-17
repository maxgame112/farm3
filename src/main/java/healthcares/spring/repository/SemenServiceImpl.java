package healthcares.spring.repository;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.SemenDao;
import healthcares.spring.model.Semen;
import healthcares.spring.service.SemenService;

@Service
public class SemenServiceImpl implements SemenService {

	@Autowired
	private SemenDao semendao;
	
	
	@Transactional
	public void add(Semen semen) {
		// TODO Auto-generated method stub
		semendao.add(semen);
	}

	@Transactional
	public void edit(Semen semen) {
		// TODO Auto-generated method stub
		semendao.edit(semen);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		semendao.delete(Id);
	}

	@Transactional
	public Semen getSemen(int Id) {
		// TODO Auto-generated method stub
		return semendao.getSemen(Id);
	}

	@Transactional
	public List<Semen> getAllSemen() {
		// TODO Auto-generated method stub
		return semendao.getAllSemen();
	}

	@Transactional 
	public List<Semen> getSemenByNameCattle(String nameCattle) {
		// TODO Auto-generated method stub
		return semendao.getSemenByNameCattle(nameCattle);
	}

}
