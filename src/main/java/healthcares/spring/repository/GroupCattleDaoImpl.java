package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.GroupCattleDao;
import healthcares.spring.model.GroupCattle;
@Repository
public class GroupCattleDaoImpl implements GroupCattleDao {

	@Autowired
	private SessionFactory sesssion;		
	
	@Override
	public void add(GroupCattle groupcattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(groupcattle);
	}

	@Override
	public void edit(GroupCattle groupcattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(groupcattle);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getGroupCattle(Id));
	}

	@Override
	public GroupCattle getGroupCattle(int Id) {
		// TODO Auto-generated method stub
		return (GroupCattle)sesssion.getCurrentSession().get(GroupCattle.class, Id);
	}

	@Override
	public List getAllGroupCattle() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from GroupCattle").list();
	}

}
