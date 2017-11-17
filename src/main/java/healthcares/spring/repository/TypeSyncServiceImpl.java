package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.TypeSyncDao;
import healthcares.spring.model.TypeSync;
import healthcares.spring.service.TypeSyncService;

@Service
public class TypeSyncServiceImpl implements TypeSyncService {

	@Autowired
	private TypeSyncDao typesyncdao;
	
	@Transactional
	public void add(TypeSync typesync) {
		// TODO Auto-generated method stub
		typesyncdao.add(typesync);
	}

	@Transactional
	public void edit(TypeSync typesync) {
		// TODO Auto-generated method stub
		typesyncdao.edit(typesync);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		typesyncdao.delete(Id);
	}

	@Transactional
	public TypeSync getTypeSync(int Id) {
		// TODO Auto-generated method stub
		return typesyncdao.getTypeSync(Id);
	}

	@Transactional
	public List getAllTypeSync() {
		// TODO Auto-generated method stub
		return typesyncdao.getAllTypeSync();
	}

	@Transactional
	public List getAllTypeSyncByName(String value){
		return typesyncdao.getAllTypeSyncByName(value);
	}
}
