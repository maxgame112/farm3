package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.SynchronizeDao;
import healthcares.spring.model.Synchronize;
import healthcares.spring.service.SynchronizeService;
@Service
public class SynchronizeServiceImpl implements SynchronizeService {

	@Autowired
	private SynchronizeDao synchronizedao;
	
	@Transactional
	public void add(Synchronize synchrnize) {
		// TODO Auto-generated method stub
		synchronizedao.add(synchrnize);
	}

	@Transactional
	public void edit(Synchronize synchrnize) {
		// TODO Auto-generated method stub
		synchronizedao.edit(synchrnize);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		synchronizedao.delete(Id);
	}

	@Transactional
	public Synchronize getSynchronize(int Id) {
		// TODO Auto-generated method stub
		return synchronizedao.getSynchronize(Id);
	}

	@Transactional
	public List getAllSynchronize() {
		// TODO Auto-generated method stub
		return synchronizedao.getAllSynchronize();
	}
	
	@Transactional
	public List<Synchronize> getSearch(Synchronize synchronize,int page){
		return synchronizedao.getSearch(synchronize, page);
	}
	
	@Transactional
	public int countAllSynchronize(Synchronize synchronize){
		return synchronizedao.countAllSynchronize(synchronize);
	}

	@Transactional
	public List<Synchronize> getSearchReport(String Start,String End){
		return synchronizedao.getSearchReport(Start, End);
	}
}
