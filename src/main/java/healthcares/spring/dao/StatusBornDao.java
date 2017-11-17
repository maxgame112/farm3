package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.StatusBorn;



public interface StatusBornDao {
	public void add(StatusBorn statusborn);
	public void edit(StatusBorn statusborn);
	public void delete(int id);
	public StatusBorn getStatusBorn(int id);
	public List getAllStatusBorn();
}
