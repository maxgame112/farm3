package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Privilege;
import healthcares.spring.model.Stall;

public interface StallDao {
	public void add(Stall stall);
	public void edit(Stall stall);
	public void delete(int id);
	public Stall getStall(int id);
	public List getAllStall();
}
