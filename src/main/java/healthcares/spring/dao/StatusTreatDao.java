package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.StatusTreat;



public interface StatusTreatDao {
	public void add(StatusTreat statustreat);
	public void edit(StatusTreat statustreat);
	public void delete(int Id);
	public StatusTreat getStatusTreat(int Id);
	public List getAllStatusTreat();
}
