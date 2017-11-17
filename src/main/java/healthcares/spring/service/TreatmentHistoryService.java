package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.TreatmentHistory;



public interface TreatmentHistoryService {
	public void add(TreatmentHistory treamenthistory);
	public void edit(TreatmentHistory treamenthistory);
	public void delete(int id);
	public TreatmentHistory getTreatmentHistory(int id);
	public List getAllTreatmentHistory();
	/*public List getstaTreatcattle();*/
	public List<TreatmentHistory> getSearch(TreatmentHistory treatmentHistory,int page);
	int countAllTreatmentHistory(TreatmentHistory treatmentHistory);
	public List<TreatmentHistory> getSearchReport(String Start,String End);
}
