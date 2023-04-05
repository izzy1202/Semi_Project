package com.e2.board.controller.inquiry;

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
 * Servlet implementation class InquiryUpdateController
 */
//1대1문의 글 수정버튼 클릭시 세부내용 페이지- 우도균
@WebServlet("/InquiryUpdate.bd")
public class InquiryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
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
//		int boardNo = Integer.parseInt(request.getParameter("bno"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		int result = new BoardService().InquiryUpdate(title,content,boardNo);
//		
//		if(result>0) {
//			response.sendRedirect(request.getContextPath()+"/InquiryGet.bd?currentPage=1");
//		}else {
//			request.setAttribute("errorMsg", "InquiryDetailController 문제입니다.");
//			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
//		}
		
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize=10*1024*1024;
			String savePath=request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			MultipartRequest multiRequest=new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
					
			int boardNo=Integer.parseInt(multiRequest.getParameter("bno"));
			String boardTitle=multiRequest.getParameter("title");
			String boardContent=multiRequest.getParameter("content");
			boardContent=boardContent.replace("\r\n","<br/>");
			
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
			int result=new BoardService().getNoticeUpdate(b,at);
			
			if(result>0) {
				response.sendRedirect(request.getContextPath()+"/InquiryGet.bd?currentPage=1");
			}
		}
	}

}
