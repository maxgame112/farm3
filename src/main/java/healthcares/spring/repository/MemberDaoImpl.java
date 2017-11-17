package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.MemberDao;
import healthcares.spring.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Member member) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(member);
	}

	@Override
	public void edit(Member member) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(member);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMember(id));
	}

	@Override
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		return (Member) session.getCurrentSession().get(Member.class, id);
	}

	@Override
	public List getAllMember() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Member").list();
	}

	@Override
	public List getMemberByUsername(String username) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Member where username='"+username+"'").list();
	}
	
	@Override
	public Member getMemberByUser(String username){
		return (Member) session.getCurrentSession().createQuery("from Member u where u.username='"+username+"' ").uniqueResult();
	}

	@Override
	public List checkIdCard(String IdCardNo) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Member where idCard='"+IdCardNo+"'").list(); //ถ้าเป็น List ให้ return เป็น createQuey
	}
	
	@Override
	public List getConfirmUser() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Member where privilege = 7").list();
	}
	@Override
	public List getchkUser(String username) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Member where username='"+username+"'").list(); //ถ้าเป็น List ให้ return เป็น createQuey
	}
	
	@Override
	public Member getLogin(String username,String password) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(Member.class); ///เรียกใช้ criteria
		criteria.add(Restrictions.eq("username",username));
		criteria.add(Restrictions.eq("password",password));
		return (Member)criteria.uniqueResult(); ///ถ้า เป็น public Member ต้อง return เป็นแบบ unique
	}
	
	@Override
	public List getSearch(Member member,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(Member.class);
		if(member.getFirst()!=null){
			criteria.add(Restrictions.like("first", "%"+member.getFirst()+"%"));
		}
		if(member.getAddress()!=null){
			criteria.add(Restrictions.like("address", "%"+member.getAddress()+"%"));
		}
		if(member.getPrivilege()!=null){
			criteria.setFetchMode("privilege", FetchMode.JOIN);
			criteria.createAlias("privilege", "pr");
			criteria.add(Restrictions.like("pr.value", "%"+member.getPrivilege().getValue()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return  criteria.list();
	}
	@Override
	public int CountAllMember(Member member){
		Criteria criteria = session.getCurrentSession().createCriteria(Member.class);
		if(member.getFirst()!=null){
			criteria.add(Restrictions.like("first", "%"+member.getFirst()+"%"));
		}
		if(member.getAddress()!=null){
			criteria.add(Restrictions.like("address", "%"+member.getAddress()+"%"));
		}
		if(member.getPrivilege()!=null){
			criteria.setFetchMode("privilege", FetchMode.JOIN);
			criteria.createAlias("privilege", "pr");
			criteria.add(Restrictions.like("pr.value", "%"+member.getPrivilege().getValue()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

}
