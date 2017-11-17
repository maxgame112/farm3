package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Sex;



public interface SexService {
	public void add(Sex sex);
	public void edit(Sex sex);
	public void delete(int id);
	public Sex getSex(int id);
	public List getAllSex();
}
