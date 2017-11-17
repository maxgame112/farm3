package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MisscarryDao;
import healthcares.spring.model.Misscarry;
import healthcares.spring.service.MisscarryService;
@Service
public class MisscarryServiceImpl implements MisscarryService {
	
	@Autowired
	private MisscarryDao misscarrydao;

	@Transactional
	public void add(Misscarry misscarry) {
		// TODO Auto-generated method stub
		misscarrydao.add(misscarry);
	}

	@Transactional
	public void edit(Misscarry misscarry) {
		// TODO Auto-generated method stub
		misscarrydao.edit(misscarry);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		misscarrydao.delete(id);
	}

	@Transactional
	public Misscarry getMisscarry(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List getAllMisscarry() {
		// TODO Auto-generated method stub
		return misscarrydao.getAllMisscarry();
	}

	@Transactional
	public List CheckYearMisscarry(int id, String year) {
		// TODO Auto-generated method stub
		return misscarrydao.CheckYearMisscarry(id, year);
	}

	@Transactional
	public List getSearchMiscarry(Misscarry misscarry, int page) {
		// TODO Auto-generated method stub
		return misscarrydao.getSearchMiscarry(misscarry, page);
	}

	@Transactional
	public int CountAllMisscarry(Misscarry misscarry) {
		// TODO Auto-generated method stub
		return misscarrydao.CountAllMisscarry(misscarry);
	}
	
	@Transactional
	public List<Misscarry> getSearchReport(String Start,String End){
		return misscarrydao.getSearchReport(Start, End);
	}

}
