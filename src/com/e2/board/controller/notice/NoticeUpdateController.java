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
 * Servlet implementation class NoticeUpdateController
 */

//공지사항 수정버튼 완료시(update)- 추지은 
@WebServlet("/NoticeUpdate.bd")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


         request.setCharacterEncoding("UTF-8"); 
		
		if(ServletFileUpload.isMultipartContent(request)) {
		
	        int maxSize=10*1024*1024;
			String savePath=request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			MultipartRequest multiRequest=new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
					
			int boardNo=Integer.parseInt(multiRequest.getParameter("bno"));
			String boardTitle=multiRequest.getParameter("title");
			String boardContent=multiRequest.getParameter("content");
			Board b=new Board();		
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setBoardNo(boardNo);
		
	
			Attachment at=null;
			
			if(multiRequest.getOriginalFileName("reUpfile")!=null) {
				at=new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reUpfile"));
				at.setSaveName(multiRequest.getFilesystemName("reUpfile"));
				at.setFilePath("/resources/board_upfiles/"); 
				
			
				if(multiRequest.getParameter("originFileNo")!=null) { 
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")) );
				    
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
		
				}else {
					at.setBoardNo(boardNo);
				}
			}
				
			
			//확인작업용
			//System.out.println(b);
			//System.out.println(at);
			
			int result=new BoardService().getNoticeUpdate(b,at);
			
			if(result>0) {
				response.sendRedirect(request.getContextPath()+"/NoticeDetail.bd?bcate=1&bno="+boardNo);
			}
			
		 }
		
			
		}
		
		
	
		
	}


