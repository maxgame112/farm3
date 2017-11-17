package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.MedicineOrderDao;
import healthcares.spring.model.MedicineImport;
import healthcares.spring.model.MedicineOrder;
@Repository
public class MedicineOrderDaoImpl implements MedicineOrderDao {
@Autowired
private SessionFactory session;
	@Override
	public void add(MedicineOrder medicineorder) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(medicineorder);
	}

	@Override
	public void edit(MedicineOrder medicineorder) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(medicineorder);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMedicineOrder(Id));
	}

	@Override
	public MedicineOrder getMedicineOrder(int Id) {
		// TODO Auto-generated method stub
		return (MedicineOrder) session.getCurrentSession().get(MedicineOrder.class, Id);
	}
	

	@Override
	public List<MedicineOrder> getAllMedicineOrder() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from MedicineOrder").list();
	}
	@Override
	public List<MedicineOrder> getSearchReport(String Start,String End,int memid){
		if(memid==0){
			return session.getCurrentSession().createQuery("from MedicineOrder where day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
		else{
			return session.getCurrentSession().createQuery
					("from MedicineOrder MedicineOrder where MedicineOrder.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
	}
	@Override
	public List<MedicineOrder> getSearchReportForNextPage(String Start,String End,int memid,int page){
		Query q=null;
		if(memid==0){
			q= session.getCurrentSession().createQuery("from MedicineOrder where day BETWEEN '"+Start+"' and '"+End+"'");
		}
		else{
			q= session.getCurrentSession().createQuery
					("from MedicineOrder MedicineOrder where MedicineOrder.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'");
		}
		q.setFirstResult((page-1)*10);
		q.setMaxResults(10);
		
		return q.list();
	}
	@Override
	public List<MedicineOrder> getSearch(MedicineOrder medicineorder,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineOrder.class);
		if(medicineorder.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicineorder.getMedicine().getTradeName()+"%"));
		}
		if(medicineorder.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicineorder.getMember().getFirst()+"%"));
		}
		if(medicineorder.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicineorder.getDay()+"%"));
		}
		criteria.addOrder(Order.desc("day"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return  criteria.list();
	}
	@Override
	public int CountAllMedicineOrder(MedicineOrder medicineorder){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineOrder.class);
		if(medicineorder.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicineorder.getMedicine().getTradeName()+"%"));
		}
		if(medicineorder.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicineorder.getMember().getFirst()+"%"));
		}
		if(medicineorder.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicineorder.getDay()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	
}
