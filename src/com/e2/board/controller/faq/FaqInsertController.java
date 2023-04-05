package com.e2.board.controller.faq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;

/**
 * Servlet implementation class FqaInsertController
 */
//faq 글작성-추지은
@WebServlet("/FaqInsert.bd")
public class FaqInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertController() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		//>> 카테고리 글제목 글내용
		String categoryName=request.getParameter("category");
		String faqTitle=request.getParameter("title");
		String faqContent=request.getParameter("content");
		//System.out.println("asd"+categoryName);
		//System.out.println(faqTitle);
		//System.out.println(faqContent);
		
		
		//넘겨온 카테고리제목을 카테고리 번호로 바꿔줌
		int bCategoryNo=0;
		
		switch(categoryName) {
			
		case "결제환불" : bCategoryNo=3; break;
		case "정기구독" : bCategoryNo=4; break;
		case "회원": bCategoryNo=5; break;
		case "서비스": bCategoryNo=6; break;
		case "리더기" : bCategoryNo=7; break;
		case "내서재" : bCategoryNo=9; break;
			}
		
		Board b=new Board();
		b.setbCategoryNo(bCategoryNo);
		b.setBoardTitle(faqTitle);
		b.setBoardContent(faqContent);
		
		int result=new BoardService().getFaqInsert(b);
		
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/FaqGet.bd?bcate="+bCategoryNo); //카테에 따라서 다른 화면 띄워주기
		}
		
		
	}

}
