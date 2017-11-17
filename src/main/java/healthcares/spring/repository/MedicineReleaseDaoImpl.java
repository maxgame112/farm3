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

import healthcares.spring.dao.MedicineReleaseDao;
import healthcares.spring.model.MedicineImport;
import healthcares.spring.model.MedicineRelease;
@Repository
public class MedicineReleaseDaoImpl implements MedicineReleaseDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(MedicineRelease medicinerelease) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(medicinerelease);
	}

	@Override
	public void edit(MedicineRelease medicinerelease) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(medicinerelease);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMedicineRelease(Id));
	}

	@Override
	public MedicineRelease getMedicineRelease(int Id) {
		// TODO Auto-generated method stub
		return (MedicineRelease) session.getCurrentSession().get(MedicineRelease.class, Id);
	}

	@Override
	public List<MedicineRelease> getAllMedicineRelease() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from MedicineRelease").list();
	}
	@Override
	public List<MedicineRelease> getSearchReport(String Start,String End,int memid){
		if(memid==0){
			return session.getCurrentSession().createQuery("from MedicineRelease where day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
		else{
			return session.getCurrentSession().createQuery
					("from MedicineRelease MedicineRelease where MedicineRelease.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
	}
	@Override
	public List<MedicineRelease> getSearchReportForNextPage(String Start,String End,int memid,int page){
		Query q=null;
		if(memid==0){
			q= session.getCurrentSession().createQuery("from MedicineRelease where day BETWEEN '"+Start+"' and '"+End+"'");
		}
		else{
			q= session.getCurrentSession().createQuery
					("from MedicineRelease MedicineRelease where MedicineRelease.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'");
		}
		q.setFirstResult((page-1)*10);
		q.setMaxResults(10);
		
		return q.list();
	}
	
	@Override
	public List<MedicineRelease> getSearch(MedicineRelease medicinerelease,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineRelease.class);
		if(medicinerelease.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicinerelease.getMedicine().getTradeName()+"%"));
		}
		if(medicinerelease.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicinerelease.getMember().getFirst()+"%"));
		}
		if(medicinerelease.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicinerelease.getDay()+"%"));
		}
		criteria.addOrder(Order.desc("day"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return  criteria.list();
	}
	@Override
	public int CountAllMedicineRelease(MedicineRelease medicinerelease){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineRelease.class);
		if(medicinerelease.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicinerelease.getMedicine().getTradeName()+"%"));
		}
		if(medicinerelease.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicinerelease.getMember().getFirst()+"%"));
		}
		if(medicinerelease.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicinerelease.getDay()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
}
