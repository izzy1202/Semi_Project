<%@page import="com.e2.user.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.e2.board.model.vo.*,java.util.ArrayList" %>
    
  <% 
    ArrayList<Board> list=(ArrayList<Board>)session.getAttribute("list");
  	Member loginUser = (Member)session.getAttribute("loginUser");
  	
  %>  


                    <div class="accordion-item">
                                <!--첫번째 질문-->
                                <% for (Board b : list) { %>
                                            <!--아코디언제목란 -->
                                    <div class="accordion-item-header">
                                         <!-- 체크박스 -->
                                         <%if(loginUser != null && loginUser.getUserNo() == 1) {%>
                                      <div>
                                        <input type="checkbox" class="ckbox" id="ckbox" name="ckbox" value=<%=b.getBoardNo()%>>
                                      </div>
                                      <%} %>
                                        &nbsp; <%=b.getBoardTitle()%>
                                    </div>
                                          <!-- 아코디언내용란 -->                                    
                                    <div class="accordion-item-body">
                                        <div class="accordion-item-body-content">
                                            <%=b.getBoardContent()%>
                                        </div>
                                    </div>
                                    <% } %>
                            </div>    
                            
                                          