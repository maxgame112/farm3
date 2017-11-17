package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Disease;
import healthcares.spring.model.GroupMedicine;

public interface DiseaseService {
	public void add(Disease disease);
	public void edit(Disease disease);
	public void delete(int Id);
	public Disease getDisease(int Id);
	public List getAllDisease();
	public List getDiseaseName(String nameDisease);
	public List<Disease> getSearch(Disease disease , int page);
	int CountAllDisease(Disease disease);
}
