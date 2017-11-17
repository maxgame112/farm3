package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.StatusPregnant;



public interface StatusPregnantService {
	public void add(StatusPregnant statuspregnant);
	public void edit(StatusPregnant statuspregnant);
	public void delete(int Id);
	public StatusPregnant getStatusPregnant(int Id);
	public List getAllStatusPregnant();
}
