package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.HornDeteringDao;
import healthcares.spring.model.HornDetering;
import healthcares.spring.service.HornDeteringService;

@Service
public class HornDeteringServiceImpl implements HornDeteringService {

	@Autowired
	private HornDeteringDao horndeteringdao;
	
	@Transactional
	public void add(HornDetering horndetering) {
		// TODO Auto-generated method stub
		horndeteringdao.add(horndetering);
	}

	@Transactional
	public void edit(HornDetering horndetering) {
		// TODO Auto-generated method stub
		horndeteringdao.edit(horndetering);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		horndeteringdao.delete(Id);
	}

	@Transactional
	public HornDetering getHornDetering(int Id) {
		// TODO Auto-generated method stub
		return horndeteringdao.getHornDetering(Id);
	}

	@Transactional
	public List getAllHornDetering() {
		// TODO Auto-generated method stub
		return horndeteringdao.getAllHornDetering();
	}
	@Transactional
	public List<HornDetering> getSearch(HornDetering horndetering , int page){
		return horndeteringdao.getSearch(horndetering, page);
	}
	@Transactional
	public int CountAllHornDetering(HornDetering horndetering){
		return horndeteringdao.CountAllHornDetering(horndetering);
	}
	
	@Transactional
	public List<HornDetering> getSearchReport(String Start,String End){
		return horndeteringdao.getSearchReport(Start, End);
	}

}
