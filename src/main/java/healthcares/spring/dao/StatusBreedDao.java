package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.StatusBreed;



public interface StatusBreedDao {
	public void add(StatusBreed statusbreed);
	public void edit(StatusBreed statusbreed);
	public void delete(int id);
	public StatusBreed getStatusBreed(int id);
	public List getAllStatusBreed();
	public List getStatBreed(String name);
}
