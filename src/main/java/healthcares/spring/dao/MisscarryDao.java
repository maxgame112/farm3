package healthcares.spring.dao;

import java.util.List;


import healthcares.spring.model.Misscarry;



public interface MisscarryDao {
	public void add(Misscarry misscarry);
	public void edit(Misscarry misscarry);
	public void delete(int id);
	public Misscarry getMisscarry(int id);
	public List getAllMisscarry();
	public List CheckYearMisscarry(int id,String year);
	public List getSearchMiscarry(Misscarry misscarry, int page);
	int CountAllMisscarry(Misscarry misscarry);
	public List<Misscarry> getSearchReport(String Start,String End);
}
