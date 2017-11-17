package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.Member;

public interface MemberDao {
	public void add(Member member);
	public void edit(Member member);
	public void delete(int id);
	public Member getMember(int id);
	public List getAllMember();
	public List getMemberByUsername(String username); //ત user ��ҫ������
	public Member getMemberByUser(String username);
	public List checkIdCard(String IdCardNo); //ત user ��ҫ������
	public List getchkUser(String username);
	public List getConfirmUser();
	public Member getLogin(String surename,String password);
	public List getSearch(Member member,int page);
	int CountAllMember(Member member);
	
}
