package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.CableDisease;
import healthcares.spring.model.Disease;

public interface CableDiseaseService {
	public void add(CableDisease cabledisease);
	public void edit(CableDisease cabledisease);
	public void delete(int Id);
	public CableDisease getCableDisease(int Id);
	public List getAllCableDisease();
}
