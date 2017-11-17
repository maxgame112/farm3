package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.CattleStamp;
import healthcares.spring.model.CattleYear;



public interface CattleStampDao {
	public void add(CattleStamp cattlestamp);
	public void edit(CattleStamp cattlestamp);
	public void delete(int Id);
	public CattleStamp getCattleStamp(int Id);
	public List getAllCattleStamp();
	public List<CattleStamp> getSearch(CattleStamp cattlestamp , int page);
	int CountAllCattleStamp(CattleStamp cattlestamp);
	public List<CattleStamp> getSearchReport(String Start,String End);
}
