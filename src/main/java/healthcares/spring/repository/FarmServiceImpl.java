package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.FarmDao;
import healthcares.spring.model.Farm;
import healthcares.spring.service.FarmService;
@Service
public class FarmServiceImpl implements FarmService {
@Autowired
private FarmDao farmdao;
	@Transactional
	public void add(Farm farm) {
		// TODO Auto-generated method stub
		farmdao.add(farm);
	}

	@Transactional
	public void edit(Farm farm) {
		// TODO Auto-generated method stub
		farmdao.edit(farm);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		farmdao.delete(id);
	}

	@Transactional
	public Farm getFarm(int id) {
		// TODO Auto-generated method stub
		return farmdao.getFarm(id);
	}

	@Transactional
	public List<Farm> getAllFarm() {
		// TODO Auto-generated method stub
		return farmdao.getAllFarm();
	}

}
