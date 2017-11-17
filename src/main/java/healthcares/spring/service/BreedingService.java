package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Breeding;
import healthcares.spring.model.Pregnant;
import healthcares.spring.model.TreatmentHistory;



public interface BreedingService {
	public void add(Breeding breeding);
	public void edit(Breeding breeding);
	public void delete(int Id);
	public Breeding getBreeding(int Id);
	public List getAllBreeding();
	public List<Breeding> getSearch(Breeding breeding,int page);
	int countAllBreeding(Breeding breeding);
	public List<Breeding> getSearchReport(String Start,String End);
}
