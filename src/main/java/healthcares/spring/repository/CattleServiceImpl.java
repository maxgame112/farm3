package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.CattleDao;
import healthcares.spring.model.Cattle;
import healthcares.spring.service.CattleService;
@Service
public class CattleServiceImpl implements CattleService {

	@Autowired
	private CattleDao cattledao;
	
	@Transactional
	public void add(Cattle cattle) {
		// TODO Auto-generated method stub
		cattledao.add(cattle);
	}

	@Transactional
	public void edit(Cattle cattle) {
		// TODO Auto-generated method stub
		cattledao.edit(cattle);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		cattledao.delete(Id);
	}

	@Transactional
	public Cattle getCattle(int Id) {
		// TODO Auto-generated method stub
		return cattledao.getCattle(Id);
	}

	@Transactional
	public List getAllCattle() {
		// TODO Auto-generated method stub
		return cattledao.getAllCattle();
	}
	
	@Transactional
	public List getCattleNum(String num) {
		// TODO Auto-generated method stub
		return cattledao.getCattleNum(num);
	}
	
	@Transactional
	public List GetMomCattle(int s){
		return cattledao.GetMomCattle(s);
	}
	
	@Transactional
	public List GetMomCattle2(int s){
		return cattledao.GetMomCattle2(s);
	}
	
	@Transactional
	public List GetMomCattle3(int s){
		return cattledao.GetMomCattle3(s);
	}	
	
	@Transactional
	public List GetFatCattle(){
		return cattledao.GetFatCattle();
	}
	
	@Transactional
	public List GetCalves(int c){
		return cattledao.GetCalves(c);
	}
	
	@Transactional
	public List GetCalves1(int c){
		return cattledao.GetCalves1(c);
	}
	
	@Transactional
	public List getstaTreatcattle(){
		return cattledao.getstaTreatcattle();
	}
	
	@Transactional
	public List<Cattle> getSearch(Cattle cattle,int page){
		
		return cattledao.getSearch(cattle, page);
	}
	
	@Transactional
	public int countAllCattle(Cattle cattle){
		return cattledao.countAllCattle(cattle);
	}

	@Transactional
	public Cattle getCattleId(String num){
		return cattledao.getCattleId(num);
	}
	
	@Transactional
	public List<Cattle> getSearchReport(String Start,String End){
		return cattledao.getSearchReport(Start, End);
	}
	
	@Transactional
	public List getCattleT(){
		return cattledao.getCattleT();
	}
}
