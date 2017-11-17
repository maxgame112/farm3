package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.TypeHornDao;
import healthcares.spring.model.TypeHorn;
import healthcares.spring.service.TypeHornService;
@Service
public class TypeHornServiceImpl implements TypeHornService {

	@Autowired
	private TypeHornDao typehorndao;
	
	@Transactional
	public void add(TypeHorn typehorn) {
		// TODO Auto-generated method stub
		typehorndao.add(typehorn);
	}

	@Override
	public void edit(TypeHorn typehorn) {
		// TODO Auto-generated method stub
		typehorndao.edit(typehorn);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		typehorndao.delete(Id);
	}

	@Override
	public TypeHorn getTypeHorn(int Id) {
		// TODO Auto-generated method stub
		return typehorndao.getTypeHorn(Id);
	}

	@Override
	public List getAllTypeHorn() {
		// TODO Auto-generated method stub
		return typehorndao.getAllTypeHorn();
	}

}
