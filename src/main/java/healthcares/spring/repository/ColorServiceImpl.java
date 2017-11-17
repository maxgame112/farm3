package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.ColorDao;
import healthcares.spring.model.Color;
import healthcares.spring.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorDao colordao;

	@Transactional
	public void add(Color color) {
		// TODO Auto-generated method stub
		colordao.add(color);
	}

	@Transactional
	public void edit(Color color) {
		// TODO Auto-generated method stub
		colordao.edit(color);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		colordao.delete(Id);
	}

	@Transactional
	public Color getColor(int Id) {
		// TODO Auto-generated method stub
		return colordao.getColor(Id);
	}

	@Transactional
	public List getAllColor() {
		// TODO Auto-generated method stub
		return colordao.getAllColor();
	}
	
	@Transactional
	public List getColoor(String name){
		return colordao.getColoor(name);
	}

}
