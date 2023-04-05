package com.e2.user.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.e2.common.JDBCTemplate;
import com.e2.user.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();

	public MemberDao() {

		String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

public Member MemberLogin(Connection conn, String userId, String userPwd) {
		
		Member u = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("MemberLogin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				u = new Member(rset.getInt("USER_NO")
							  ,rset.getString("USER_ID")
							  ,rset.getString("USER_PWD")
							  ,rset.getString("USER_NAME")
							  ,rset.getString("PHONE")
							  ,rset.getString("EMAIL")
							  ,rset.getString("ADDRESS")
							  ,rset.getDate("JOIN_DATE")
							  ,rset.getDate("MODIFY_DATE")
							  ,rset.getString("STATUS")
							  ,rset.getInt("USER_ROLE"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return u;
	}
	
	public String findId(Connection conn, String email) {

		String userId = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("findId");
		
	
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, email);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					userId = rset.getString("USER_ID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
		return userId;
	}

	public String findPwd(Connection conn, String userId) {

		String userPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userPwd = rset.getString("USER_PWD");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userPwd;
		
	}

	// 아이디 중복확인 - 이지은
	public int userIdCheck(Connection conn, String checkId) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("userIdCheck");
		int count = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
	public int infoUpdate(Connection conn, Member u) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("infoUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getPhone());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member selectMember(String userId, Connection conn) {

		Member u = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectMember");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new Member(rset.getInt("USER_NO")
							  ,rset.getString("USER_ID")
							  ,rset.getString("USER_PWD")
							  ,rset.getString("USER_NAME")
							  ,rset.getString("PHONE")
							  ,rset.getString("EMAIL")
							  ,rset.getString("ADDRESS")
							  ,rset.getDate("JOIN_DATE")
							  ,rset.getDate("MODIFY_DATE")
							  ,rset.getString("STATUS")
							  ,rset.getInt("USER_ROLE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	
	// 회원가입 - 이지은
	public int userInsert(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("userInsert");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updatePwd(Connection conn, String userId, String updatePwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwd");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int userDelete(Connection conn, String deletePwd, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("userDelete");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, deletePwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
