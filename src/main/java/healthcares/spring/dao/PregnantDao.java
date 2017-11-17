package healthcares.spring.dao;

import java.util.List;


import healthcares.spring.model.Pregnant;
import healthcares.spring.model.TreatmentHistory;



public interface PregnantDao {
	public void add(Pregnant pregnant);
	public void edit(Pregnant pregnant);
	public void delete(int Id);
	public Pregnant getPregnant(int Id);
	public List getAllPregnant();
	/*public List getPregnantBynum(int s);*/
	public List getSearch(Pregnant pregnant,int page);
	public List getSearch(Pregnant pregnant);
	public int getPregnantByCattle(int id);
	public int getFartherIdByMomId(int id);
	public List<Pregnant> getSearchReport(String Start,String End);
}
