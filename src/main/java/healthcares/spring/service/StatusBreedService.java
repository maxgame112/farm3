package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.StatusBreed;



public interface StatusBreedService {
	public void add(StatusBreed statusbreed);
	public void edit(StatusBreed statusbreed);
	public void delete(int id);
	public StatusBreed getStatusBreed(int id);
	public List getAllStatusBreed();
	public List getStatBreed(String name);
}
