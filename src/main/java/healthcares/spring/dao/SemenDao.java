package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Semen;


public interface SemenDao {
	public void add(Semen semen);
	public void edit(Semen semen);
	public void delete(int Id);
	public Semen getSemen(int Id);
	public List<Semen> getAllSemen();
	public List<Semen> getSemenByNameCattle(String nameCattle);//àª¤«éÓ
}
