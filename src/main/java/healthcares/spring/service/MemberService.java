package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Member;

public interface MemberService {
	public void add(Member member);
	public void edit(Member member);
	public void delete(int id);
	public Member getMember(int id);
	public List getAllMember();
	public List getMemberByUsername(String username); //àª¤ user ÇèÒ«éÓÁÑéÂ
	public Member getMemberByUser(String username); //àª¤ user ÇèÒ«éÓÁÑéÂ
	public List checkIdCard(String IdCardNo); //àª¤ user ÇèÒ«éÓÁÑéÂ
	public List getchkUser(String username);
	public List getConfirmUser();
	public Member getLogin(String username,String password);
	public List getSearch(Member member,int page);
	int CountAllMember(Member member);
}
