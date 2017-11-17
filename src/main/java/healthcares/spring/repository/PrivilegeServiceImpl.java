package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.PrivilegeDao;
import healthcares.spring.model.Privilege;
import healthcares.spring.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeDao privilegeDao;
	
	@Transactional
	public void add(Privilege privilege) {
		// TODO Auto-generated method stub
		privilegeDao.add(privilege);
	}

	@Transactional
	public void edit(Privilege privilege) {
		// TODO Auto-generated method stub
		privilegeDao.edit(privilege);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		privilegeDao.delete(id);
	}

	@Transactional
	public Privilege getPrivilege(int id) {
		// TODO Auto-generated method stub
		return privilegeDao.getPrivilege(id);
	}

	@Transactional
	public List getAllPrivilege() {
		// TODO Auto-generated method stub
		return privilegeDao.getAllPrivilege();
	}

}
