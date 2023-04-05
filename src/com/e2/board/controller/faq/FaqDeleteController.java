package com.e2.board.controller.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;
import com.google.gson.Gson;

/**
 * Servlet implementation class FaqDeleteController
 */
//faq삭제- 추지은
@WebServlet("/FaqDelete.bd")
public class FaqDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDeleteController() {
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
	
		 String[] sArr = request.getParameterValues("bno"); //문자열배열
	
		ArrayList<Board> list=new ArrayList<>();
		
		 int boardNo=0;
		 int result=0;
	
	       if(sArr!=null) {
	    	   for(int i=0; i<sArr.length;i++){
	    		   boardNo=Integer.parseInt(sArr[i]);
	    		   result=new BoardService().getFaqDelete(boardNo);
	    	   }
	       }
		 

		  response.setContentType("application/json:charset=UTF-8");
		 
		   new Gson().toJson(result,response.getWriter());
		
	}

}
