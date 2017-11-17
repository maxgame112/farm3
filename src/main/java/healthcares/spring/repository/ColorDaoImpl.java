package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.ColorDao;
import healthcares.spring.model.Color;
@Repository
public class ColorDaoImpl implements ColorDao {

	@Autowired
	private SessionFactory sesssion;	
	
	@Override
	public void add(Color color) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(color);
	}

	@Override
	public void edit(Color color) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(color);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getColor(Id));
	}

	@Override
	public Color getColor(int Id) {
		// TODO Auto-generated method stub
		return (Color)sesssion.getCurrentSession().get(Color.class, Id);
	}

	@Override
	public List getAllColor() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Color").list();
	}
	
	@Override
	public List getColoor(String name){
		return sesssion.getCurrentSession().createQuery("from Color where nameColor = '"+name+"'").list();
	}


}
