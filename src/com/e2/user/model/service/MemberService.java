package com.e2.user.model.service;

import java.sql.Connection;

import com.e2.common.JDBCTemplate;
import com.e2.user.model.dao.MemberDao;
import com.e2.user.model.vo.Member;

public class MemberService {

	public Member MemberLogin(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member u = new MemberDao().MemberLogin(conn, userId, userPwd);
		JDBCTemplate.close(conn);
		return u;

	}

	public String findId(String email) {
		Connection conn = JDBCTemplate.getConnection();
		String userId = new MemberDao().findId(conn, email);
		JDBCTemplate.close(conn);
		return userId;
	}

	public String findPwd(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		String userPwd = new MemberDao().findPwd(conn, userId);
		JDBCTemplate.close(conn);
		return userPwd;
	}

	// 아이디 중복확인 - 이지은
	public int userIdCheck(String checkId) {
		Connection conn = JDBCTemplate.getConnection();
		int count = new MemberDao().userIdCheck(conn, checkId);
		JDBCTemplate.close(conn);
		return count;
	}

	// 회원가입 - 이지은
	public int userInsert(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().userInsert(conn, m);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}
	
	/*
	 * public Member PwdUpdate(String userId, String userPwd, String updatePwd) {
	 * 
	 * Connection conn = JDBCTemplate.getConnection();
	 * 
	 * int result = new MemberDao().PwdUpdate(conn, userId, userPwd, updatePwd);
	 * System.out.println(result);
	 * 
	 * Member u = null;
	 * 
	 * if(result>0) { JDBCTemplate.commit(conn); u = new
	 * MemberDao().selectMember(userId, conn);
	 * 
	 * }else { JDBCTemplate.rollback(conn); }
	 * 
	 * return u; }
	 */
	

	public Member infoUpdate(Member u) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().infoUpdate(conn,u);
		System.out.println("result : "+result);
		Member updateUser = null;		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			updateUser = new MemberDao().selectMember(u.getUserId(),conn);
			System.out.println("upda te"+updateUser);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return updateUser;
	}
	
	//비밀번호 변경 -- 김용건
		public int updatePwd(String userId, String updatePwd) {
			Connection conn = JDBCTemplate.getConnection();
			int result = new MemberDao().updatePwd(conn, userId,updatePwd);

			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);

			return result;
		}

		public int userDelete(String deletePwd, String userId) {
			Connection conn = JDBCTemplate.getConnection();
			int result = new MemberDao().userDelete(conn, deletePwd, userId);
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);

			return result;
		}



}
