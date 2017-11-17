package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Semen;

public interface SemenService {
	public void add(Semen semen);
	public void edit(Semen semen);
	public void delete(int Id);
	public Semen getSemen(int Id);
	public List<Semen> getAllSemen();
	public List<Semen> getSemenByNameCattle(String nameCattle);//ત���
}
