package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.SexDao;
import healthcares.spring.model.Sex;
import healthcares.spring.service.SexService;
@Service
public class SexServiceImpl implements SexService {
	
	@Autowired
	private SexDao sexdao;

	@Transactional
	public void add(Sex sex) {
		// TODO Auto-generated method stub
		sexdao.add(sex);
	}

	@Transactional
	public void edit(Sex sex) {
		// TODO Auto-generated method stub
		sexdao.edit(sex);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		sexdao.delete(id);
	}

	@Transactional
	public Sex getSex(int id) {
		// TODO Auto-generated method stub
		return sexdao.getSex(id);
	}

	@Transactional
	public List getAllSex() {
		// TODO Auto-generated method stub
		return sexdao.getAllSex();
	}

}
