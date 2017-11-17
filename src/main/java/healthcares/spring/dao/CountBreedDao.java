package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.CountBreed;



public interface CountBreedDao {
	public void add(CountBreed countbreed);
	public void edit(CountBreed countbreed);
	public void delete(int Id);
	public CountBreed getCountBreed(int Id);
	public List getAllCountBreed();
	public CountBreed getCountBreedByPriNo(int id);
	public List getAllCountBreedById(int id);
}
