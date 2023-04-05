<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>

<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<meta charset="UTF-8">
<!-- [회원] 회원정보수정 및 탈퇴: 김용건 -->
<title>내 정보수정</title>
<style>
        div{
            box-sizing: border-box;
        }

        .outer{
            width: 1400px;
            height: 850px;
            margin: auto;
            border: 2px solid #82ae46;
            border-radius: 12px;
            background-color: #f9fbfc;
        }
        .left-bar{
            width: 25%;
            height: 100%;
            float: left;
        }

        .left-barContent{
            width: 90%;
            height: 90%;
            margin: 5% 5% 5% 5%;
            border: 1px solid #e3e9ed;
            border-radius: 12px;
            background-color: #fff;
            box-shadow: 5px 1px 8px 0 rgb(0 0 0 / 6%);
        }

        .right-outer{
            width: 75%;
            height: 100%;
            float: right;
        }   

        .userId-update{
            margin-top: 50px;
            margin-left: 5%;
            height: 120px;
            width: 40%;
            padding: 16px 17px 0;
            border-radius: 12px;
            box-shadow: 2px 2px 14px 0 rgb(0 164 73 / 8%);
            border: solid 1px rgba(3,213,128,.8);
            background-color: #fff;
            box-sizing: border-box;
            font-size: 18px;
        }

        .userInfo-update{
            margin-top: 100px;
            margin-left: 5%;
            height: 300px;
            width: 70%;
            padding: 16px 17px;
            border-radius: 12px;
            box-shadow: 1px 1px 10px 0 rgb(72 75 108 / 8%);
            border: solid 1px #e3e9ed;
            background-color: #fff;
            box-sizing: border-box;
            font-size: 20px;
        }

        .user-delete{
            margin-top: 100px;
            margin-left: 5%;
            height: 80px;
            width: 30%;
            padding: 19px 17px 18px;
            border-radius: 12px;
            box-shadow: 1px 1px 10px 0 rgb(72 75 108 / 8%);
            border: solid 1px #e3e9ed;
            background-color: #fff;
            font-size: 20px;
            font-weight: 700;
            line-height: 24px;
        }

        .update-confirm{
            padding: 2px 9px 3px;
            border-radius: 15px;
            text-align: center;
            margin-left: 80%;
        }


        .btn-modal{
            margin-left: 500px;
        }
        
        .login-update{
        	margin-left: 150px;
        	cursor: pointer;
        }
        
        .updateBtn{
        	cursor: pointer;
        }
        
        .deleteBtn{
        	margin-left:120px;
        	cursor: pointer;
        }
	
        #modal.modal-overlay,#modal2.modal-overlay {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: none;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);
        }
        #modal .delete-window{
            background: rgba(242, 243, 240, 0.925);
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 3px solid rgba(240, 10, 10, 0.61);
            width: 400px;
            height: 500px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal2 .update-window {
            background: rgba(242, 243, 240, 0.925);
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 3px solid rgba(37, 199, 150, 0.712);
            width: 400px;
            height: 500px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal .title,#modal2 .title {
            margin-left: 15px;
            margin-top: 20px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: rgb(12, 14, 39);

        }
        #modal .title h2,#modal2 .title h2 {
            display: inline;
        }
        #modal .close-area,#modal2 .close-area2 {
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }

        #modal .delete1-area {
            margin-top: 30px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: black;
        }

        #modal .delete2-area {
            margin-top: 50px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: black;
        }
        
        #modal2 .pwdUpdate1-area {
            margin-top: 30px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: black;
        }

        #modal2 .pwdUpdate2-area {
            margin-top: 50px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: black;
        }
        #modal2 .pwdUpdate3-area {
            margin-top: 50px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: black;
        }
        #modal .delete-commit {
            position : absolute;
            left: 270px;
            bottom : 40px;
        }
        #modal .delete-btn{
            background-color: red;
            color: white; border: none;
            border-radius: 5px;
            width: 100px;
            height: 30px;
            cursor: pointer;
        }
        #modal2 .update-commit {
            position : absolute;
            left: 300px;
            bottom : 40px;
        }
        #modal2 .update-btn{
            background-color: rgb(134, 219, 148);
            color: white; border: none;
            border-radius: 5px;
            width: 80px;
            height: 40px;
            cursor: pointer;
        }

    </style>
</head>
<body  class="goto-here" style="font-family: NanumBarunGothicYetHangul">

<header>
 <%@ include file="/view/common/header.jsp" %>
</header>

    <div class="outer">
        
        <div class="left-bar">
            <div class="left-barContent"></div>
        </div>
    
    <div class="right-outer">
        <div class="userId-update" id="container">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="userId" value="<%=loginUser.getUserId() %>" required disabled></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><button id="btn-modal2" class="login-update" data-toggle="modal" data-target="#modal2">수정</button></td>
            </tr>
        </table>
            
    </div> 
    
    <div id="modal2" class="modal-overlay">
    <form action="<%=contextPath %>/MemberPwdUpdate.member" method="post" id="updateMember">
    		<input type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
            <div class="update-window">
                <div class="title">
                    <h2>비밀번호 변경</h2>
                </div>
                <div class="close-area2">X</div>
                
                <div class="pwdUpdate1-area">
                    <p>현재 비밀번호</p>
                    <input type="text" id="inputPwd" name="userPwd"  style="width: 250px; height: 30px; font-size : 20px">
                </div>
        
                <div class="pwdUpdate2-area">
                    <p>변경하실 비밀번호를 입력해주세요</p>
                    <input type="text" id="updatePwd" style="width: 250px; height: 30px; font-size : 20px" name="updatePwd">
                </div>
                
                <div class="pwdUpdate3-area">
                    <p>변경할 비밀번호를 다시한번 입력해주세요</p>
                    <input type="text" id="updatePwd2" style="width: 250px; height: 30px; font-size : 20px" name="pwdCheck">
                </div>
                <div class="update-commit">
                    <button type="submit" class="update-btn" onclick="return invalidate();document.getElementById('#updateMember').submit();">변경 확인</button>
                </div>
                </div>
      	</form>        
      			<script>
      			function invalidate(){
	         		
	         		var originPwd = "<%=loginUser.getUserPwd()%>"; //세션에 담겨있는 로그인 정보
	         		var inputPwd = document.querySelector("#inputPwd").value;
	         		
					if(originPwd != inputPwd){
						alert("현재 비밀번호를 잘못입력하셨습니다.");
						return false;
					}
	         		
					var updatePwd = document.querySelector("input[name=updatePwd]").value;
	         		var pwdCheck = document.querySelector("input[name=pwdCheck]").value;
	         	
					if(updatePwd!=pwdCheck){
						alert("변경할 비밀번호와 확인 일치하지 않습니다.");
						return false;
					}
	         	}
      			</script>  
                
                
            </div>
    
     
    <div class="userInfo-update"> 
        <table>
            <tr>
                <td>이름</td>
                <td><input type="text" name="userName" id="userName" value="<%=loginUser.getUserName()%>" required></td>
                <td></td>
            </tr>
            <tr style="margin-top: 50px;">
                <td>전화번호</td>
                <td><input type="text" name="phone" id="phone" value="<%=loginUser.getPhone() %>" placeholder="-포함하여 입력"></td>
                <td></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="email" name="email" id="email" value="<%=loginUser.getEmail() %>"></td>
                <td></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="address" id="address" value="<%=loginUser.getAddress() %>"></td>
                <td></td>
            </tr>
        </table>
        <div class="update-confirm">
            <button type="submit" id="update-confirm" class="updateBtn" onclick="userUpdate();">정보수정</button>
        </div>
    </div>

    <div id="container" class="user-delete">
        <span>회원 탈퇴 </span><button id="btn-modal" class="deleteBtn">탈퇴</button>
        
        <div id="modal" class="modal-overlay">
            <div class="delete-window">
                <form action="<%=contextPath %>/userDelete.member" method="post">
                <input type=hidden name= "userId" value="<%=loginUser.getUserId()%>">
                <div class="title">
                    <h2>회원 탈퇴</h2>
                </div>
                <div class="close-area">X</div>
                <div class="delete1-area">
                    <p>회원 탈퇴를 원하시면 비밀번호를 입력해주세요</p>
                    <input type="password" style="width: 250px; height: 30px; font-size : 20px" name="deletePwd">
                </div>
                
                <div class="delete-commit">
                    <button type="submit" class="delete-btn">회원 탈퇴</button>
                </div>
                
                </form>
            </div>
    
        </div>
    </div>
</div>
</div>
    	
    
    <script>
    
    function userUpdate(){
    	
		
		var userName = $("#userName").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var address = $("#address").val();
		
		
		$.ajax({
			url : "<%=request.getContextPath()%>/InfoUpdate.member",
			data : {
				userName : userName
				,phone : phone
				,email : email
				,address : address
			},
			type : "post",
			success : function(result){
				if(result == 'Y'){
					alert("회원 정보수정이 완료되었습니다.");
				}else{
					alert("회원 정보수정에 실패하였습니다.")
				}
				
			},
			error : function(){
				alert("fail");
			}
			
		});
    
    }
    
    
    
    
    let modal2 = document.querySelector("#modal2")

    //모달 기능
                
    function modalOn() {
        modal.style.display = "flex"
    }
    function modalOn2() {
        modal2.style.display = "flex"
    }
    function isModalOn() {  
        return modal.style.display === "flex"
    }
    function isModalOn2() {  
        return modal2.style.display === "flex"
    }
    function modalOff() {
        modal.style.display = "none"
    }
    function modalOff2() {
        modal2.style.display = "none"
    }           
    //모달창 띄우기
    const btnModal = document.getElementById("btn-modal")
    btnModal.addEventListener("click", e => {
        modalOn()
    })
    const btnModal2 = document.getElementById("btn-modal2")
    btnModal2.addEventListener("click", e => {
        modalOn2()
    })
    // X버튼 클로즈
    const closeBtn = modal.querySelector(".close-area")
    closeBtn.addEventListener("click", e => {
        modalOff()
    })
    const closeBtn2 = modal2.querySelector(".close-area2")
    closeBtn2.addEventListener("click", e => {
        modalOff2()
    });
    //영역바깥 클로즈
    modal.addEventListener("click", e => {
        const evTarget = e.target
        if(evTarget.classList.contains("modal-overlay")) {
            modalOff()
        }
    })
    
    modal2.addEventListener("click", e => {
        const evTarget = e.target
        if(evTarget.classList.contains("modal-overlay")) {
            modalOff2()
        }
    })
    //esc버튼 클로즈
    window.addEventListener("keyup", e => {
        if((isModalOn() && e.key === "Escape") || (isModalOn2() && e.key === "Escape")) {
            modalOff()
            modalOff2()
        }
    })
    
    //msg alert 해주기
    var msg = "<%=msg%>";
	if(msg != "null"){
		alert(msg);
		<%session.removeAttribute("msg");%>
	}
        </script>
    </body>
</html>

<!--수정하기 힘들어서 밑에 뒀습니다 수정 노노염  -->
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/animate.css">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/magnific-popup.css">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/aos.css">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/ionicons.min.css">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/jquery.timepicker.css">

<link rel="stylesheet" href="<%=contextPath %>/resources/css/flaticon.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/icomoon.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/style.css">