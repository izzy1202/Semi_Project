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
import com.e2.board.model.vo.BoardAttachment;
import com.e2.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InquiryInsertController
 */
//1대1문의 글작성-우도균
@WebServlet("/InquiryInsert.bd")
public class InquiryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryInsertController() {
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
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/images/board_upfiles");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8",new MyFileRenamePolicy() );
			
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			content=content.replace("\r\n","<br/>");
			BoardAttachment at = null;
			
			//사진 올리면 controller단으로 넘어와서 막기위해 title,content가 빈값일때 실행 안함

				if(multiRequest.getOriginalFileName("upfile") != null) {
					//첨부파일이 있는 경우
					at = new BoardAttachment();
					at.setOriginName(multiRequest.getOriginalFileName("upfile"));//원본명
					at.setSaveName(multiRequest.getFilesystemName("upfile"));//실제 서버에 업로드되어있는 파일명
					at.setFilePath("resources/images/board_upfiles/");
				}
				System.out.println("wqkdpawokdo"+at);
				int result = new BoardService().InquiryInsert(title,content,userNo,at);
				if (result > 0) {
					// 성공시에는 가장 최신글로 등록이 될테니 게시글 목록 첫페이지 띄워주기
					request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
					response.sendRedirect(request.getContextPath() + "/InquiryGet.bd?currentPage=1");
	
				} else {
					// 실패시에는 업로드된 첨부파일을 가지고 있을 필요가 없기때문에 삭제작업을 해줘야한다.
					if (at != null) {// 첨부파일이 있을때 (즉,db서비스 요청에 실패했는데 첨부파일이 있을때)
						// 삭제하고자 하는 파일 객체를 생성하여 delete 메소드를 호출해서 삭제한다.
						new File(savePath + at.getSaveName()).delete();
					}
	
					// 실패시 에러페이지에 에러메세지와 함께 보내주기
					request.setAttribute("errorPage", "게시글 작성 실패");
					request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
				}
			
//			
//			if(result>0) {
//				response.sendRedirect(request.getContextPath()+"/InquiryGet.bd?currentPage=1");
//			}else {
//				request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
//			}
		}
		
	}

}
