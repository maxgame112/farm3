package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.HornDetering;



public interface HornDeteringDao {
	public void add(HornDetering horndetering);
	public void edit(HornDetering horndetering);
	public void delete(int Id);
	public HornDetering getHornDetering(int Id);
	public List getAllHornDetering();
	
	public List<HornDetering> getSearch(HornDetering horndetering , int page);
	int CountAllHornDetering(HornDetering horndetering);
	public List<HornDetering> getSearchReport(String Start,String End);
}
