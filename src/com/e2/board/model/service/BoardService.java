package com.e2.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.e2.board.model.dao.BoardDao;
import com.e2.board.model.vo.Attachment;
import com.e2.board.model.vo.Board;
import com.e2.board.model.vo.BoardAttachment;
import com.e2.board.model.vo.PageInfo;
import com.e2.board.model.vo.Reply;
import com.e2.common.JDBCTemplate;

public class BoardService {
	
	// faq 글삭제 - 추지은
	public int getFaqDelete(int boardNo) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		int result=new BoardDao().getFaqDelete(conn,boardNo);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	// faq 글목록 보여주기 - 추지은
	public ArrayList<Board> getFaqGet(int bCategoryNo) {
			
		Connection conn=JDBCTemplate.getConnection();
		
		ArrayList<Board> list=new BoardDao().getFaqGet(conn,bCategoryNo);
		
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	
	//faq 글추가  - 추지은
	public int getFaqInsert(Board b) {
		Connection conn=JDBCTemplate.getConnection();
		
		int result=new BoardDao().getFaqInsert(conn,b);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//faq 글수정할 내용 가져오기(select) - 추지은
	public Board getFaqUpdateForm(int boardNo) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		
		Board b=new BoardDao().getFaqUpdateForm(conn,boardNo);
		
		JDBCTemplate.close(conn);
		
		return b;
		
	}
	
	//faq 글수정(update)  - 추지은
	public int getFaqUpdate(int boardNo,String boardTitle,String boardContent) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		int result=new BoardDao().getFaqUpdate(conn,boardNo,boardTitle,boardContent);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	
	
	
	//faq 수정
	public ArrayList<Board> faqSearch(String searchContent){
		
		Connection conn=JDBCTemplate.getConnection();
		
		ArrayList<Board> list=new BoardDao().faqSearch(conn,searchContent);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
	
/////////////////////////////////////////////////	
	
	// Notice 글삭제 - 추지은
	public int getNoticeDelete(int boardNo) {
	 
		Connection conn=JDBCTemplate.getConnection();
		
		int result=new BoardDao().getNoticeDelete(conn,boardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	

	
	// Notice 글목록 보여주기 - 추지은
	public ArrayList<Board> getNoticeGet(int bCategoryNo,PageInfo pi) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		ArrayList<Board> list=new BoardDao().getNoticeGet(conn,bCategoryNo,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	
	//글목록 페이징 처리에 필요한 총게시글의 개수구하기(+)추가
	public int selectNListCount() {
	
     Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new BoardDao().selectListCount(conn);
		
		//select문이니까 트랜잭션처리 없음 오직 자원반납만
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//////////////////////////////////////////////////////////////
	
	//조회수 증가기능 (update)
	public int increaseNoticeCount(int boardNo, int bCategoryNo) {
				
	Connection conn=JDBCTemplate.getConnection();
		
	//조회수 증가기능
	int result=new BoardDao().increaseNoticeCount(conn,boardNo,bCategoryNo); //먼저 조회수를 증가
		
		
	if(result>0) {
		JDBCTemplate.commit(conn);
	}else {
		JDBCTemplate.rollback(conn);
	}
	JDBCTemplate.close(conn);
	return result;
	
	}
	

	
	
	// Notice 글상세내용  (+조회수 증가기능+게시글 조회메소드+첨부파일 조회메소드) - 추지은
		public Board getNoticeDetail(int boardNo,int bCategoryNo) {
				
			Connection conn = JDBCTemplate.getConnection();
			
			Board b = new BoardDao().getNoticeDetail(conn,boardNo,bCategoryNo);
						
			JDBCTemplate.close(conn);
		
			
			return b;
		}
		
		
		
		public Attachment selectAttachment(int boardNo) {
						
			Connection conn = JDBCTemplate.getConnection();
			
			Attachment at = new BoardDao().selectAttachment(conn,boardNo);
			
			JDBCTemplate.close(conn);
			
			return at;
		}
	
     //////////////////////////////////////////////////////	
	
	//Notice 글추가  - 추지은 파일도 가져가야함
	public int getNoticeInsert(Board b, Attachment at) {
	     
	    Connection conn = JDBCTemplate.getConnection();	 
	    
	    //1. 게시글정보 먼저 insert
		 int result=new BoardDao().getNoticeInsert(conn,b);
		 
		
		 //첨부파일 추가시 돌아올 변수 선언 및 1로 초기화
		 int result2=1;
		 		 
		 if(at!= null) {
			 result2 = new BoardDao().insertAttachment(conn,at);
		 }
		 
		 int fr = result*result2;
				 
		 if(fr>0) {	
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
				
		 
		 JDBCTemplate.close(conn);		 
		 return fr; //둘중 하나라도 실패하여 0값을 갖게 될경우 돌려주는 값도 실패값을 돌려주기 위해 곱셈결과 리턴 
		 		
	    }
	
		
	//Notice 글수정할 내용 가져오기 - 추지은/////
	public Board getNoticeUpdateForm(int boardNo) {
	    	
         Connection conn = JDBCTemplate.getConnection();
		 Board b = new BoardDao().getNoticeUpdateForm(conn,boardNo);  
		JDBCTemplate.close(conn);
		return b;		
	}
	
	//Notice 글수정  - 추지은
	public int getNoticeUpdate(Board b,Attachment at) {		
     Connection conn=JDBCTemplate.getConnection();
		
		//~ 게시글 정보 수정
		int result=new BoardDao().getNoticeUpdate(conn,b); 
		int result2=1;
					
		//새로운 첨부파일o
		if(at!=null) {
			if(at.getFileNo()!=0) {  //새첨부o 기존o -->파일업뎃	
				 new BoardDao().updateAttachment(conn,at);			
		     }else { //새첨부o 기존x   -->파일추가
		    	 new BoardDao().insertNewAttachment(conn,at);	 //1109수정		
		    }		
		}
		
		int finalResult=result*result2;
		
		if(finalResult>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);	
		
		return finalResult;	
	}
	
	
	//공지검색했을때 총 개수(listCount)
	public int noticeSearchCount(int categoryNo, String searchContent) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		int count=new BoardDao().noticeSearchCount(conn,categoryNo,searchContent);
		
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	
	//검색 리스트 Get
    public ArrayList<Board> noticeSearchGet(PageInfo pi, int categoryNo, String searchContent) {
		
    	Connection conn=JDBCTemplate.getConnection();
    	
    	ArrayList<Board> list=new BoardDao().noticeSearchGet(conn,pi,categoryNo,searchContent); 

    	JDBCTemplate.close(conn);
		
	    return list;
	}
    
    
    
	
/////////////////////////////////////////////////우도균///////////////////////////////////
	
 // Inquiry 글삭제 - 우도균
 	public int InquiryDelete(int bno) {
 	Connection conn = JDBCTemplate.getConnection();
 	int result = new BoardDao().InquiryDelete(conn,bno);
 	
 	if(result>0) {
 		JDBCTemplate.commit(conn);
 	}else {
 		JDBCTemplate.rollback(conn);
 	}
 	
 	return result;
 	}
 	
 	// Inquiry 글상세내용 - 우도균
 	public Board InquiryDetail(int bno) {
 		Connection conn = JDBCTemplate.getConnection();
 		Board b = new BoardDao().InquiryDetail(conn,bno);
 		if(b != null) {
 			new BoardDao().increaseCount(conn,bno);
 		}
 		return b;
 	}
 	
 	// Inquiry 글목록 보여주기 - 우도균
 	public ArrayList<Board> InquiryGet(int categoryNo) {
 		Connection conn = JDBCTemplate.getConnection();
 		ArrayList<Board> list = new BoardDao().InquiryGet(conn,categoryNo);
 				
 		return list;
 	}
 	
 	//Inquiry 글추가  - 우도균
 	public int InquiryInsert(String title, String content, int userNo, BoardAttachment at) {
 		Connection conn = JDBCTemplate.getConnection();
 		
 		//게시글 정보 먼저 board 테이블에 insert 하기 
 		int result = new BoardDao().InquiryInsert(conn,title,content,userNo);
 		//첨부파일 추가시 돌아올 변수 선언 및 1로 초기화
 		int result2 = 1;
 		//첨부파일 객체가 비어있지 않으면 (즉, 첨부파일이 있다면)
 		if(at != null) {
 			System.out.println("ay들어옴");
 			result2 = new BoardDao().attachmentInsert(conn,at);
 		}
 		
 		int fr = result*result2;
 		System.out.println("gr값"+fr);
 		//트랜잭션 처리 
 		if(fr>0) {
 			//첨부파일이 없는 경우에 result2를 0으로 초기화 해둔다면 게시글이 insert가 성공했을 때도 
 			//result2는 여전히 0이라서 rollback처리가 될것이기 때문에
 			//result2의 초기값을 1로 초기화해둔다
 			JDBCTemplate.commit(conn);
 		}else {
 			JDBCTemplate.rollback(conn);
 		}
 		return fr; //둘중 하나라도 실패하여 0값을 갖게 될경우 돌려주는 값도 실패값을 돌려주기 위해 곱셈결과 리턴 
 	}
 	
 	//Inquiry 글수정  - 우도균
 	public int InquiryUpdate(String title, String content,int boardNo) {
 		Connection conn = JDBCTemplate.getConnection();
 		int result = new BoardDao().InquiryUpdate(conn,title,content,boardNo);
 		if(result>0) {
 			JDBCTemplate.commit(conn);
 		}else {
 			JDBCTemplate.rollback(conn);
 		}
 		return result;
 	}
 	
 	//Inquiry 글수정할 내용 가져오기 - 우도균
 	public Board InquiryUpdateForm(int bno) {
 		Connection conn = JDBCTemplate.getConnection();
 		Board b = new BoardDao().InquiryDetail(conn,bno);
 		
 		return b;
 	}
 	
 /////////////////////////////////////////////////
 	//패이징 총개수
 	public int selectListCount() {
 		Connection conn = JDBCTemplate.getConnection();
 		int count = new BoardDao().selectListCount(conn);
 		JDBCTemplate.close(conn);
 		return count;
 	}
 	
 	//패이징 10개단위 끊기
 	public ArrayList<Board> selectList(PageInfo pi,int categoryNo) {
 		Connection conn = JDBCTemplate.getConnection();
 		
 		ArrayList<Board> list = new BoardDao().selectList(conn,pi,categoryNo);
 		
 		JDBCTemplate.close(conn);
 		
 		return list;
 	}

 	//1:1문의 유저가 작성한 게시글 개수
 	public int selectListCount(int userNo) {
 		Connection conn = JDBCTemplate.getConnection();
 		int count = new BoardDao().selectListCount(conn,userNo);
 		
 		JDBCTemplate.close(conn);
 		return count;
 	}
 	
 	//1:1문의 내역 리스트
 	public ArrayList<Board> selectUserList(PageInfo pi, int categoryNo, int userNo) {
 		Connection conn = JDBCTemplate.getConnection();
 		
 		ArrayList<Board> list = new BoardDao().selectUserList(conn,pi,categoryNo,userNo);
 		
 		JDBCTemplate.close(conn);
 		
 		return list;
 	}
 	
 	//관리자가 여러개의 리스트 삭제
 	public int InquiryAdminDelete(String[] selectArrays) {
 		int result = 1;
 		Connection conn = JDBCTemplate.getConnection();
 		for(String s : selectArrays) {
 			result *= new BoardDao().InquiryAdminDelete(conn,s);
 		}
 		if(result >0) {
 			JDBCTemplate.commit(conn);
 		}else {
 			JDBCTemplate.rollback(conn);
 		}
 		JDBCTemplate.close(conn);
 		return result;
 	}
 	
 	//첨부파일 얻기
 	public ArrayList<BoardAttachment> selectAttachmentList(int bno) {
 		Connection conn = JDBCTemplate.getConnection();
 		
 		ArrayList<BoardAttachment> list = new BoardDao().selectAttachmentList(conn,bno);
 		
 		JDBCTemplate.close(conn);
 		return list;
 	}
 	
 	
 	//검색했을때 총 갯수
 	public int selectSearchCount(int categoryNo,String searchText) {
 		Connection conn = JDBCTemplate.getConnection();
 		int count = new BoardDao().selectSearchCount(conn,categoryNo,searchText);
 		JDBCTemplate.close(conn);
 		return count;
 	}
 	
 	//검색 리스트 Get
 	public ArrayList<Board> searchGet(PageInfo pi, int categoryNo, String searchText) {
 		Connection conn = JDBCTemplate.getConnection();
 		ArrayList<Board> list = new BoardDao().searchGet(conn,pi,categoryNo,searchText);
 		JDBCTemplate.close(conn);
 		return list;
 	}
 	
 	//댓글 얻기
 		public ArrayList<Reply> replyGet(int bno) {
 			Connection conn = JDBCTemplate.getConnection();
 			ArrayList<Reply> list = new BoardDao().replyGet(conn,bno);
 			JDBCTemplate.close(conn);
 			return list;
 		}
 		
 	//댓글 추가하기
 	public int ReplyInsert(Reply r) {
 		Connection conn = JDBCTemplate.getConnection();
 		int result = 1 ;
 		if(r.getReplyDepth()==0 && r.getReplySort()==0) {
 			result = new BoardDao().ReplyGroupInsert(conn,r);
 			System.out.println("result1 : "+result);
 		}else {
 			new BoardDao().ReplyIncreaseDepth(conn,r);
 			result = new BoardDao().ReplyInsert(conn,r);
 			System.out.println("result2 : "+result);
 		}
 		if(result >0) {
 			JDBCTemplate.commit(conn);
 		}else {
 			JDBCTemplate.rollback(conn);
 		}
 		
 		JDBCTemplate.close(conn);
 		return result;
 	}
 		
 	//댓글 삭제
 	public int ReplyDelete(Reply r) {
 		Connection conn = JDBCTemplate.getConnection();
 		int result = new BoardDao().ReplyDelete(conn, r);
 		if(result >0) {
 			new BoardDao().ReplyDeleteDepth(conn, r, result);
 			JDBCTemplate.commit(conn);
 		}else {
 			JDBCTemplate.rollback(conn);
 		}
 		return result;
 	}
}
