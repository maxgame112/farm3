package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MemberDao;
import healthcares.spring.model.Member;
import healthcares.spring.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	

	@Transactional
	public void add(Member member) {
		// TODO Auto-generated method stub
		memberDao.add(member);
	}


	@Transactional
	public void edit(Member member) {
		// TODO Auto-generated method stub
		memberDao.edit(member);
	}


	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		memberDao.delete(id);
	}

	@Transactional
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		return memberDao.getMember(id);
	}


	@Transactional
	public List getAllMember() {
		// TODO Auto-generated method stub
		return memberDao.getAllMember();
	}


	@Transactional
	public List getMemberByUsername(String username) {
		// TODO Auto-generated method stub
		return memberDao.getMemberByUsername(username);
	}
	
	@Transactional
	public Member getMemberByUser(String username){
		return memberDao.getMemberByUser(username);
	}


	@Transactional
	public List checkIdCard(String IdCardNo) {
		// TODO Auto-generated method stub
		return memberDao.checkIdCard(IdCardNo);
	}
	
	@Transactional
	public List getchkUser(String username) {
		// TODO Auto-generated method stub
		return memberDao.checkIdCard(username);
	}

	public List getConfirmUser() {
		// TODO Auto-generated method stub
		return memberDao.getConfirmUser();
	}
	
	@Transactional
	public Member getLogin(String username , String password) {
		// TODO Auto-generated method stub
		return memberDao.getLogin(username,password);
	}
	
	@Transactional
	public List getSearch(Member member,int page){
		return memberDao.getSearch(member, page);
	}
	@Transactional
	public int CountAllMember(Member member){
		return memberDao.CountAllMember(member);
	}

}
