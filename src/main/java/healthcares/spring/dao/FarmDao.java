package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Farm;


public interface FarmDao {
	public void add(Farm farm);
	public void edit(Farm farm);
	public void delete(int id);
	public Farm getFarm(int id);
	public List<Farm> getAllFarm();
}
