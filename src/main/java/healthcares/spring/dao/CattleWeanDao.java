package healthcares.spring.dao;

import java.util.List;


import healthcares.spring.model.CattleWean;



public interface CattleWeanDao {
	public void add(CattleWean cattlewean);
	public void edit(CattleWean cattlewean);
	public void delete(int Id);
	public CattleWean getCattleWean(int Id);
	public List getAllCattleWean();
	public List<CattleWean> getSearch(CattleWean cattlewean , int page);
	int CountAllCattleWean(CattleWean cattlewean);
	public List<CattleWean> getSearchReport(String Start,String End);
}
