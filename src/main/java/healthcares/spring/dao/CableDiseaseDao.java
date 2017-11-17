package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.CableDisease;
import healthcares.spring.model.Disease;

public interface CableDiseaseDao {
	public void add(CableDisease cabledisease);
	public void edit(CableDisease cabledisease);
	public void delete(int Id);
	public CableDisease getCableDisease(int Id);
	public List getAllCableDisease();
}
