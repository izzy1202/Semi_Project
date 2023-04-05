package com.e2.board.controller.reply;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Reply;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/ReplyInsert.bd")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
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
		int bno = Integer.parseInt(request.getParameter("bno")); //게시판번호
		int depth = Integer.parseInt(request.getParameter("depth")); 
		int sort = Integer.parseInt(request.getParameter("sort")); 
		int group = Integer.parseInt(request.getParameter("group"));
		String userNo = request.getParameter("userNo");
		String reply = request.getParameter("reply");
		Reply r = new Reply(bno,userNo,reply,depth,sort,group);
		
		int result = new BoardService().ReplyInsert(r); // insert 결과
		ArrayList<Reply> list = null;
		if(result >0) {
			list = new BoardService().replyGet(bno);
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/view/board/reply.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "댓글 insert실패");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		}
		
	}

}
