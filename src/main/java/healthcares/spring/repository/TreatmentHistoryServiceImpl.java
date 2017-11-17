package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.TreatmentHistoryDao;
import healthcares.spring.model.TreatmentHistory;
import healthcares.spring.service.TreatmentHistoryService;
@Service
public class TreatmentHistoryServiceImpl implements TreatmentHistoryService {

	@Autowired
	private TreatmentHistoryDao treatmenthistorydao;
	
	@Transactional
	public void add(TreatmentHistory treamenthistory) {
		// TODO Auto-generated method stub
		treatmenthistorydao.add(treamenthistory);
	}

	@Transactional
	public void edit(TreatmentHistory treamenthistory) {
		// TODO Auto-generated method stub
		treatmenthistorydao.edit(treamenthistory);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		treatmenthistorydao.delete(id);
	}

	@Transactional
	public TreatmentHistory getTreatmentHistory(int id) {
		// TODO Auto-generated method stub
		return treatmenthistorydao.getTreatmentHistory(id);
	}

	@Transactional
	public List getAllTreatmentHistory() {
		// TODO Auto-generated method stub
		return treatmenthistorydao.getAllTreatmentHistory();
	}
	
/*	@Transactional
	public List getstaTreatcattle(){
		return treatmenthistorydao.getstaTreatcattle();
	}*/
	
	
	@Transactional
	public List<TreatmentHistory> getSearch(TreatmentHistory treatmentHistory,int page){
		return treatmenthistorydao.getSearch(treatmentHistory, page);
	}
	
	@Transactional
	public int countAllTreatmentHistory(TreatmentHistory treatmentHistory){
		return treatmenthistorydao.countAllTreatmentHistory(treatmentHistory);
	}
	
	
	@Transactional
	public List<TreatmentHistory> getSearchReport(String Start,String End){
		return treatmenthistorydao.getSearchReport(Start, End);
	}

}
