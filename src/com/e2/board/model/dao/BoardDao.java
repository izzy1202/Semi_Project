package com.e2.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.e2.board.model.vo.Attachment;
import com.e2.board.model.vo.Board;
import com.e2.board.model.vo.BoardAttachment;
import com.e2.board.model.vo.PageInfo;
import com.e2.board.model.vo.Reply;
import com.e2.common.JDBCTemplate;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	// faq 글삭제 - 추지은
	public int getFaqDelete(Connection conn,int boardNo) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("getFaqDelete");
	
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            JDBCTemplate.close(pstmt);			
		}
		
		return result;
	}
	
	
	
	// faq 글목록 보여주기 - 추지은
	public ArrayList<Board> getFaqGet(Connection conn,int bCategoryNo) {
		
		ArrayList<Board> list=new ArrayList<>();
		String sql=prop.getProperty("getFaqGet");		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bCategoryNo);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(
						   rset.getString("BOARD_TITLE")
						  ,rset.getString("BOARD_CONTENT")
						  ,rset.getInt("BOARD_NO")
						  ,rset.getInt("BCATEGORY_NO")
						  ));
			}
	   							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 return list;
	}
	
	
		
	//faq 글추가  - 추지은
	public int getFaqInsert(Connection conn,Board b){
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("getFaqInsert");
	
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,b.getbCategoryNo());
			pstmt.setString(2,b.getBoardTitle());
			pstmt.setString(3,b.getBoardContent());
			
		    result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
	     return result;
	}
	
	
	
	//faq 글수정할 내용 가져오기(select) - 추지은
	public Board getFaqUpdateForm(Connection conn,int boardNo){
		
		Board b=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("getFaqUpdateForm");
		ResultSet rset=null;
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
			//System.out.println("다오 번호"+boardNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				b=new Board(rset.getString("BOARD_TITLE")
						,rset.getString("BOARD_CONTENT")
						,rset.getInt("BOARD_NO")
						,rset.getInt("BCATEGORY_NO")
						);
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}
	
	
	//faq 실제 글수정 (update) - 추지은
	public int getFaqUpdate(Connection conn,int boardNo,String boardTitle,String boardContent) {
		
		int result=0;
		String sql=prop.getProperty("getFaqUpdate");
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,boardTitle);
			pstmt.setString(2,boardContent);
			pstmt.setInt(3,boardNo);
			
			result=pstmt.executeUpdate();
			
			//System.out.println("dao결과 어케나옴"+result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
     //faq 검색	
	public ArrayList<Board> faqSearch(Connection conn,String searchContent) {

	ArrayList<Board> list=new ArrayList<Board>();
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("faqSearch");
	ResultSet rset=null;
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "%"+searchContent+"%");
		rset=pstmt.executeQuery();
	
	    while(rset.next()) {
			list.add(new Board(
					   rset.getString("BOARD_TITLE")
					  ,rset.getString("BOARD_CONTENT")
					  ,rset.getInt("BOARD_NO")
					  ,rset.getInt("BCATEGORY_NO")
					  ));
		}
	  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
      JDBCTemplate.close(rset);
      JDBCTemplate.close(pstmt);
	}
		
	 //System.out.println("dao리스트ㅌ넘어오나요"+list);
	return list;
	}


	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Notice 글삭제 - 추지은
	public int getNoticeDelete(Connection conn,int boardNo) {
			
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("getNoticeDelete");

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
	        result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;		
	}
	
	
	//-------------------------------------글 목록보기-----------------------
	// Notice 글목록 보여주기 - 추지은
	public ArrayList<Board> getNoticeGet(Connection conn,int bCategoryNo,PageInfo pi) {
		
		ArrayList<Board> list=new ArrayList<Board>();
        String sql=prop.getProperty("getNoticeGet");		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bCategoryNo);	
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset=pstmt.executeQuery();
			 			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO")
						  ,rset.getString("USER_ID")
						  ,rset.getString("BOARD_TITLE")
						  ,rset.getString("BOARD_CONTENT")
						  ,rset.getDate("BOARD_DATE")
						  ,rset.getInt("BOARD_COUNT")));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
		
	//글목록 페이징 처리에 필요한 총게시글의 개수구하기(+)추가
	public int selectNListCount(Connection conn) {
		
		//select이지만 결과가 int로 반환된다
		
		int listCount=0;
		ResultSet rset=null;
		PreparedStatement pstmt=null;		
		String sql=prop.getProperty("selectListCount");
	
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   JDBCTemplate.close(rset);
		   JDBCTemplate.close(pstmt);		   
		}	
		return listCount;
	}
	
	//-----------------------------------------글 상세보기-----------------------
	
	
	//Notice 조회수 증가 (추가된 메소드++)  update사용
		public  int  increaseNoticeCount(Connection conn,int boardNo,int bCategoryNo) {
			
			
			PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("increaseNoticeCount");
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,boardNo);
				pstmt.setInt(2,bCategoryNo);
				
				result=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}		
			return result;
		}
		
		
		// Notice 글상세내용 -1 - 추지은
		public Board getNoticeDetail(Connection conn,int boardNo,int bCategoryNo) {
				
			Board b=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			String sql=prop.getProperty("getNoticeDetail");
					
			try {
				pstmt=conn.prepareStatement(sql);			
				
				pstmt.setInt(1,boardNo);
				pstmt.setInt(2,bCategoryNo);
				
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
				  b=new Board(rset.getInt("BOARD_NO")
						  ,rset.getString("USER_ID")
	                      ,rset.getString("BOARD_TITLE")
	                      ,rset.getString("BOARD_CONTENT")
	                      ,rset.getDate("BOARD_DATE")
	                      ,rset.getInt("BOARD_COUNT"));				
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			System.out.println(b);
			return b;
			
		}
		
		// Notice 글상세내용 파일조회 메소드 -2 - 추지은
		public Attachment selectAttachment(Connection conn, int boardNo) {
			
			Attachment at = null;
			ResultSet rset = null;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("selectAttachment");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					at = new Attachment(rset.getInt("FILE_NO")
									   ,rset.getString("ORIGIN_NAME")
									   ,rset.getString("SAVE_NAME")
									   ,rset.getString("FILE_PATH"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return at;	
		}
		

	//-------------------------------------------------------공지글추가--------------------------------------------------------------------------
	
		//Notice 글추가  - 추지은
	public int getNoticeInsert(Connection conn,Board b) {
				
		int result=0;
		String sql=prop.getProperty("getNoticeInsert");		
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardWriter());
			
			//System.out.println("dao확인작업"+b.getBoardTitle());
			//System.out.println(b.getBoardContent());
			//System.out.println(b.getBoardWriter());
			
			result=pstmt.executeUpdate();
									
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	
	//Notice파일 추가 - 추지은(+)
	public int insertAttachment(Connection conn, Attachment at) {		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getSaveName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;	
	}
	
		
	//-------------------------------------------------------공지글수정--------------------------------------------------------------------------		
	
	//Notice 글수정할 내용 수정폼 가져오기 - 추지은
		public Board getNoticeUpdateForm(Connection conn,int boardNo) {						
			Board b=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			String sql=prop.getProperty("getNoticeUpdateForm");
					
			try {
				pstmt=conn.prepareStatement(sql);							
				pstmt.setInt(1,boardNo);
		
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
				  b=new Board(rset.getInt("BOARD_NO")
						  ,rset.getString("USER_ID")
	                      ,rset.getString("BOARD_TITLE")
	                      ,rset.getString("BOARD_CONTENT")
	                      ,rset.getDate("BOARD_DATE")
	                      ,rset.getInt("BOARD_COUNT"));				
				}				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			System.out.println(b);
			
			return b;		
		}
	
	
	 //Notice 글수정 1  - 추지은
	 public int getNoticeUpdate(Connection conn,Board b) {				      
				int result=0;
				PreparedStatement pstmt=null;
				String sql=prop.getProperty("getNoticeUpdate");
				
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, b.getBoardTitle());
					pstmt.setString(2, b.getBoardContent());
					pstmt.setInt(3, b.getBoardNo());
					
		            result=pstmt.executeUpdate();
		            
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}				
				return result;
	}
	
		
	//Notice 글수정-2 파일 업데이트 추지은
	public int updateAttachment(Connection conn, Attachment at) {
      int result=0;
      PreparedStatement pstmt=null;
	  String sql=prop.getProperty("updateAttachment");
	  
	  try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, at.getOriginName());
		pstmt.setString(2, at.getSaveName());
		pstmt.setString(3, at.getFilePath());
		pstmt.setInt(4, at.getFileNo()); 
		
		result=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {		
    JDBCTemplate.close(pstmt);				
	}	  
	  return result;
	}
	
	
	//Notice글수정-파일 업데이트 1109추가메소드
	public int insertNewAttachment(Connection conn, Attachment at) {
		
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertNewAttachment");
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, at.getBoardNo());
			pstmt.setString(2, at.getOriginName());
		    pstmt.setString(3, at.getSaveName());
		    pstmt.setString(4, at.getFilePath());
		    result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		  return result;
	}
	
	
     //공지검색했을때 총 개수(listCount)
	public int noticeSearchCount(Connection conn, int categoryNo,String searchContent) {
	
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("noticeSearchCount");
		int count=0;
		ResultSet rset=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+searchContent+"%");
			pstmt.setInt(2,categoryNo); 
			
			rset=pstmt.executeQuery();
			
			if(rset.next()){  //select 단일행 단일열 
				count=rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	       JDBCTemplate.close(pstmt);		
		}
		return count;
	}
	
   
	//공지검색했을때 검색결과 리스트 띄워주기
	public ArrayList<Board> noticeSearchGet(Connection conn, PageInfo pi, int categoryNo, String searchContent) {
		
		ArrayList<Board> list=new ArrayList<Board>(); 
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("noticeSearchGet");
		
		
		/*
		 * boardLimit이  10이라고 가정하면
		 * currentPage = 1 -> 시작값:1  끝값:10
		 * currentPage = 2 -> 시작값:11 끝값:20
		 * currentPage = 3 -> 시작값:21 끝값:30
		 * 
		 * 시작값 = (currentPage - 1) * boardLimit + 1
		 * 끝값 = currentPage * boardLimit
		 * */
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,categoryNo);
			pstmt.setString(2, "%"+searchContent+"%");
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
						rset.getString("USER_ID"),
						rset.getString("BOARD_TITLE"),
						rset.getDate("BOARD_DATE"),
						rset.getInt("BOARD_COUNT")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		  JDBCTemplate.close(rset);
		  JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
/////////////////////////////////////////////////우도균////////////////////////////////////////////
	
	// Inquiry 글삭제 - 우도균
		public int InquiryDelete(Connection conn, int bno) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("InquiryDelete");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		// Inquiry 글상세내용 - 우도균
		public Board InquiryDetail(Connection conn, int bno) {
			Board b = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql=prop.getProperty("InquiryDetail");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					b = new Board(rset.getInt("BOARD_NO")
							     ,rset.getString("USER_ID")
							     ,rset.getString("BOARD_TITLE")
							     ,rset.getString("BOARD_CONTENT")
							     ,rset.getDate("BOARD_DATE")
							     ,rset.getInt("BOARD_COUNT"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return b;
		}
		// Inquiry 글목록 보여주기 - 우도균
		public ArrayList<Board> InquiryGet(Connection conn, int categoryNo) {
			ArrayList<Board> list = new ArrayList<Board>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("InquiryGet");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, categoryNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Board(rset.getInt("BOARD_NO")
									  ,rset.getString("USER_ID")
									  ,rset.getString("BOARD_TITLE")
									  ,rset.getDate("BOARD_DATE")
									  ,rset.getInt("BOARD_COUNT")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
		}
		//Inquiry 글추가  - 우도균
		//USER_ID를 넘겨야함!!
		//AT에 값 안들어감 확인해라 
		public int InquiryInsert(Connection conn, String title, String content, int userNo) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("InquiryInsert");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				//카테고리와 작성자는 데이터 추가할때는 NUMBER타입이기 때문에 형변환 
				pstmt.setInt(1, userNo);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		
		}
		//Inquiry 글수정  - 우도균
		public int InquiryUpdate(Connection conn, String title, String content,int boardNo) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("InquiryUpdate");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, boardNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		
		
	/////////////////////////////////////////////////
		
		//조회수 증가
		public int increaseCount(Connection conn, int bno) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("increaseCount");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
			
		}
		
		//좋아요 증가
		public void IncreaseLike() {
			
		}
		
		//댓글 작성
		public void Comment() {
			
		}

		//페이징-> 공지사항 갯수
		public int selectListCount(Connection conn) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					//조회된 게시글 개수
					listCount = rset.getInt("COUNT");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return listCount;
		}


		//패이징 -> 사용자 요청 페이지 목록 메소드
			public ArrayList<Board> selectList(Connection conn, PageInfo pi,int categoryNo) {
				
				ResultSet rset = null;
				ArrayList<Board> list = new ArrayList<>();
				PreparedStatement pstmt = null;
				
				String sql = prop.getProperty("selectList");
				
				int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, categoryNo);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Board(rset.getInt("BOARD_NO")
										  ,rset.getString("USER_ID")
										  ,rset.getString("BOARD_TITLE")
										  ,rset.getDate("BOARD_DATE")
										  ,rset.getInt("BOARD_COUNT")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return list;
			}

			//첨부파일 insert
			public int attachmentInsert(Connection conn, BoardAttachment at) {
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("insertAttachment");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, at.getOriginName());
					pstmt.setString(2, at.getSaveName());
					pstmt.setString(3, at.getFilePath());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				
				return result;
			}

			//1:1문의 내역에서 유저 리스트 얻기
			public ArrayList<Board> selectUserList(Connection conn, PageInfo pi, int categoryNo, int userNo) {
				ResultSet rset = null;
				ArrayList<Board> list = new ArrayList<>();
				PreparedStatement pstmt = null;
				
				String sql = prop.getProperty("selectUserList");
				
				int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, categoryNo);
					pstmt.setInt(2, userNo);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Board(rset.getInt("BOARD_NO")
										  ,rset.getString("USER_ID")
										  ,rset.getString("BOARD_TITLE")
										  ,rset.getDate("BOARD_DATE")
										  ,rset.getInt("BOARD_COUNT")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return list;
			}
			
			//유저만의 문의글 보여주기
			public int selectListCount(Connection conn,int userNO) {
				int listCount = 0;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				String sql = prop.getProperty("selectUserListCount");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, userNO);
					rset = pstmt.executeQuery();
					if(rset.next()) {
						//조회된 게시글 개수
						listCount = rset.getInt("COUNT");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return listCount;
			}

			//관리자 여러개 삭제하기
			public int InquiryAdminDelete(Connection conn, String s) {
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("InquiryAdminDelete");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(s));
					
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(pstmt);
				}
				return result;
			}

			//첨부파일 리스트 불러오기
			public ArrayList<BoardAttachment> selectAttachmentList(Connection conn, int bno) {
				ArrayList<BoardAttachment> list = new  ArrayList<BoardAttachment>();
				ResultSet rset = null;
				PreparedStatement pstmt = null;
				
				//일반게시판 첨부파일 조회 sql문 재활용
				String sql = prop.getProperty("selectAttachment");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bno);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new BoardAttachment(rset.getInt("FILE_NO")
								   ,rset.getString("ORIGIN_NAME")
								   ,rset.getString("SAVE_NAME")
								   ,rset.getString("FILE_PATH")));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return list;
			}

			//댓글 리스트 가져오기
			public ArrayList<Reply> replyGet(Connection conn, int bno) {
				ArrayList<Reply> list = new ArrayList<Reply>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				String sql = prop.getProperty("replyGet");
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bno);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Reply(rset.getInt("REPLY_NO")
										  ,rset.getString("USER_NAME")
										  ,rset.getString("REPLY")
										  ,rset.getInt("REPLY_DEPTH")
										  ,rset.getInt("REPLY_SORT")
										  ,rset.getInt("REPLY_GROUP")
										  ,rset.getDate("REPLY_DATE")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return list;
			}
			
			//검색한 내용 갯수
			public int selectSearchCount(Connection conn,int categoryNo, String searchText) {
				
				ResultSet rset = null;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("selectSearchCount");
				int result = 0;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+searchText+"%");
					pstmt.setInt(2, categoryNo);
					rset = pstmt.executeQuery();
					if(rset.next()) {
						result = rset.getInt("COUNT");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(pstmt);
				}
				return result;
			}

			//검색결과 리스트
			public ArrayList<Board> searchGet(Connection conn, PageInfo pi, int categoryNo, String searchText) {
				ResultSet rset = null;
				ArrayList<Board> list = new ArrayList<>();
				PreparedStatement pstmt = null;
				
				String sql = prop.getProperty("searchGet");
				
				int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, categoryNo);
					pstmt.setString(2, "%"+searchText+"%");
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Board(rset.getInt("BOARD_NO")
										  ,rset.getString("USER_ID")
										  ,rset.getString("BOARD_TITLE")
										  ,rset.getDate("BOARD_DATE")
										  ,rset.getInt("BOARD_COUNT")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				return list;
			}

			//댓글 그룹 추가
			public int ReplyGroupInsert(Connection conn, Reply r) {
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("ReplyGroupInsert");

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, r.getRefBno());
					pstmt.setString(2, r.getBoardWriter());
					pstmt.setString(3, r.getReply());
					pstmt.setInt(4, r.getReplyDepth());
					pstmt.setInt(5, r.getReplySort());
					pstmt.setInt(6, r.getRefBno());
					
					result = pstmt.executeUpdate();
					System.out.println("유원호 :"+result);
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				return result;
			}
			
			//댓글 추가
			public int ReplyInsert(Connection conn, Reply r) {
				
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("ReplyInsert");

				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, r.getRefBno());
					pstmt.setString(2, r.getBoardWriter());
					pstmt.setString(3, r.getReply());
					pstmt.setInt(4, r.getReplyDepth());
					pstmt.setInt(5, r.getReplySort());
					pstmt.setInt(6, r.getReplyGroup());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				return result;
			}


			public void ReplyIncreaseDepth(Connection conn, Reply r) {
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("ReplyIncreaseDepth");

				try {
					pstmt = conn.prepareStatement(sql);

					pstmt.setInt(1, r.getReplyDepth());
					pstmt.setInt(2, r.getReplyGroup());
					pstmt.setInt(3, r.getRefBno());
					
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				
			}
			
			public int ReplyDelete(Connection conn, Reply r) {
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("ReplyDelete");

				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, r.getReplyGroup());
					pstmt.setInt(2, r.getReplyDepth());
					pstmt.setInt(3, r.getReplySort());
					pstmt.setInt(4, r.getReplyGroup());
					pstmt.setInt(5, r.getReplyDepth());
					pstmt.setInt(6, r.getReplyGroup());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				return result;
			}


			public void ReplyDeleteDepth(Connection conn, Reply r, int result1) {
				int result = 0;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("ReplyDeleteDepth");

				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, result1);
					pstmt.setInt(2, r.getReplyGroup());
					pstmt.setInt(3, r.getReplyDepth());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				
			}
}
