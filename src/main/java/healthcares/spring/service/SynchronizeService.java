package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Synchronize;



public interface SynchronizeService {
	public void add(Synchronize synchrnize);
	public void edit(Synchronize synchrnize);
	public void delete(int Id);
	public Synchronize getSynchronize(int Id);
	public List getAllSynchronize();
	public List<Synchronize> getSearch(Synchronize synchronize,int page);
	int countAllSynchronize(Synchronize synchronize);
	public List<Synchronize> getSearchReport(String Start,String End);
}
