package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Breeding;
import healthcares.spring.model.TreatmentHistory;



public interface BreedingDao {
	public void add(Breeding breeding);
	public void edit(Breeding breeding);
	public void delete(int Id);
	public Breeding getBreeding(int Id);
	public List getAllBreeding();
	public List<Breeding> getSearch(Breeding breeding,int page);
	int countAllBreeding(Breeding breeding);
	public List<Breeding> getSearchReport(String Start,String End);
}
