package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.CattleYear;



public interface CattleYearDao {
	public void add(CattleYear cattleyear);
	public void edit(CattleYear cattleyear);
	public void delete(int Id);
	public CattleYear getCattleYear(int Id);
	public List getAllCattleYear();
	public List<CattleYear> getSearch(CattleYear cattleyear , int page);
	int CountAllCattleYear(CattleYear cattleyear);
	public List<CattleYear> getSearchReport(String Start,String End);
}
