package com.e2.board.controller.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Attachment;
import com.e2.board.model.vo.Board;
import com.e2.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */

//공지사항 글작성-추지은
@WebServlet("/NoticeInsert.bd")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeInsertController() {
        // TODO Auto-generated constructor stub
    }

	/**O
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		
			int maxSize = 10 * 1024 * 1024; 
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
			
	        
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String boardWriter = multiRequest.getParameter("userNo");
			//System.out.println("공지작성 제목넘?"+boardTitle);
			//System.out.println("공지작성 콘텐츠넘?"+boardContent);
			//System.out.println("공지작성 작성자넘?"+boardWriter);
			
			Board b = new Board();			
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setBoardWriter(boardWriter);
			
		
			Attachment at = null; 
		
			
			
			if(multiRequest.getOriginalFileName("upfile") != null) { //만약 첨부파일이 있다면
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));//원본명
				at.setSaveName(multiRequest.getFilesystemName("upfile"));//실제 서버에 업로드되어있는 파일명
				at.setFilePath("resources/board_upfiles/");
			}
			
			
			//~서비스 요청
			int result = new BoardService().getNoticeInsert(b,at);
			
			if(result>0) {
				response.sendRedirect(request.getContextPath()+"/NoticeGetController.bd?currentPage=1&bcate=1");
			}else {
				//실패시에는 업로드된 첨부파일 삭제
				if(at != null) {
					new File(savePath+at.getSaveName()).delete();
				  }
			  }
			
			}
			
	   
	  
	}

}
