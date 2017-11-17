package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.TypeCattleDao;
import healthcares.spring.model.TypeCattle;
@Repository
public class TypeCattleDaoImpl implements TypeCattleDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(TypeCattle typecattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(typecattle);
	}

	@Override
	public void edit(TypeCattle typecattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(typecattle);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getTypeCattle(Id));
	}

	@Override
	public TypeCattle getTypeCattle(int Id) {
		// TODO Auto-generated method stub
		return (TypeCattle)sesssion.getCurrentSession().get(TypeCattle.class, Id);
	}

	@Override
	public List getAllTypeCattle() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from TypeCattle").list();
	}

}
