package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Breeding;
import healthcares.spring.model.Cattle;



public interface CattleDao {
	public void add(Cattle cattle);
	public void edit(Cattle cattle);
	public void delete(int Id);
	public Cattle getCattle(int Id);
	public List getAllCattle();
	public List getCattleNum(String num);
	public List GetMomCattle(int s);
	public List GetMomCattle2(int s);
	public List GetMomCattle3(int s);
	public List GetFatCattle();
	public List GetCalves(int c);
	public List GetCalves1(int c);
	public List getstaTreatcattle();
	public List<Cattle> getSearch(Cattle cattle,int page);
	int countAllCattle(Cattle cattle);
	public Cattle getCattleId(String num);
	public List<Cattle> getSearchReport(String Start,String End);
	public List getCattleT();
}
