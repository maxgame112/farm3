package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.TypeCattle;
import healthcares.spring.service.TypeCattleService;


public interface TypeCattleDao {
	public void add(TypeCattle typecattle);
	public void edit(TypeCattle typecattle);
	public void delete(int Id);
	public TypeCattle getTypeCattle(int Id);
	public List getAllTypeCattle();
}
