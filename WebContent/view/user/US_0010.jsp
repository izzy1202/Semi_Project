<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [회원] 회원가입: 이지은 -->
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body class="goto-here">
	<%@ include file="/view/common/header.jsp" %>

	<div class="hero-wrap hero-bread" style="background-image: url('resources/images/books.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center fadeInUp ftco-animated">
          <p class="breadcrumbs"><span class="mr-2"><span>join</span></span></p>
            <h1 class="mb-0 bread">회원가입</h1>
          </div>
        </div>
      </div>
    </div>

	<section class="ftco-section contact-section bg-light">
		<div class="container">
			<div class="row block-9" id="joinform1">
				<div class="col-md-6 order-md-last d-flex" id="joinform2">
					<form action="<%=contextPath%>/MemberInsert.do" name="frm"
						method="post" class="bg-white p-5 contact-form userInfo"
						onsubmit="return checked()">
						<div class="form-group d-flex">
							<input type="text" class="form-control" id="joinId" name="userId" placeholder="아이디" onkeyup="inputIdChk();" required> 
								<input type="button" value="중복확인" class="submit px-3"
								onclick="idcheck();" style="background: #82ae46 !important; border: none; color: #fff; cursor: pointer;">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="joinPwd" name="userPwd" placeholder="비밀번호" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="pwdChk" placeholder="비밀번호 확인" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="userName" placeholder="이름" required>
						</div>
						<div class="form-group">
							<input type="hidden" name="phone"> 
							<select name="phone1" id="phone1" class="form-control" style="width: 120px; float: left;">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
							</select>
							<p style="float: left; padding-top: 10px; padding-left: 11.5px; padding-right: 11.5px;">-</p>
							<input type="text" class="form-control" name="phone2" id="phone2"
								maxlength="4" style="width: 130px; float: left;" required>
							<p style="float: left; padding-top: 10px; padding-left: 11.5px; padding-right: 11.5px;">-</p>
							<input type="text" class="form-control" name="phone3" id="phone3"
								maxlength="4" style="width: 130.5px" required>
						</div>
						<div class="form-group">
							<input type="hidden" name="email"> <input type="text"
								class="form-control" name="email1" id="email1"
								style="width: 120px; float: left;" required>
							<p style="float: left; padding-top: 10px; padding-left: 11.5px; padding-right: 11.5px;">@</p>
							<input type="text" class="form-control" name="email2" id="email2"
								style="width: 130px; float: left;" required>
							<p style="float: left; padding-top: 10px; padding-left: 10px; padding-right: 10px;">&nbsp;</p>
							<select name="email3" id="email3" class="form-control" style="width: 130px;">
								<option value="직접입력">직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="google.com">google.com</option>
								<option value="daum.net">daum.net</option>
							</select>
						</div>
						<div class="form-group">
							<input type="hidden" name="address">
							<div class="d-flex">
								<input type="text" class="form-control" id="postcode"
									placeholder="우편번호" style="width: 120px; float: left;" required>
								<input type="button" value="우편번호 찾기" class="submit px-3"
									onclick="Postcode()" style="background: #82ae46 !important; border: none; color: #fff; cursor: pointer;">
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="address1" placeholder="주소" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="address2" placeholder="상세주소" style="width: 180px; float: left;" required>
							<p style="float: left; padding-top: 10px; padding-left: 10px; padding-right: 10px;">&nbsp;</p>
							<input type="text" class="form-control" id="address3" placeholder="참고항목" style="width: 180px;">
						</div>
						<br>
						<div class="form-group" align="center">
							<input type="submit" id="joinBtn" value="회원가입" class="btn btn-primary py-3 px-5">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script>
    
    idCheck = 0;
    
    <!--아이디 중복 확인-->
   	function idcheck(){
   		
   		var userId = $("#joinId").val();
   		var idRegExp = /^[a-zA-Z0-9]{5,12}$/;
   		
   			//아이디 공백 막기
	   		 if(userId==""){
	   			alert("아이디를 입력해주세요.")
	   			$("#joinId").focus();
	   			return false;
	   		}
   			//아이디 정규식
	   		 else if(!idRegExp.test(userId)){
	   	    		alert("아이디는 영문 대소문자와 숫자 5~12자리로 입력해야 합니다.")
	   	    		$("#joinId").val("");
	   	    		$("#joinId").focus();
	   	    		return false;
	   	    	}
	   		
	   		$.ajax({
	   			url : "MemberIdCheck.do",
	   			data : {checkId : userId},
	   			success : function(result){
	   				if(result=="NNNNN"){
	   					alert("이미 존재하거나 탈퇴한 아이디입니다.");
	   					idCheck = 0;
	   					$("#joinId").val("");
	   					$("#joinId").focus();
	   				}else if(result=="NNNNY"){
	   					alert("사용 가능한 아이디입니다.");
	   					idCheck = 1;
	   				}
	   			}, 
	   			error : function(){
	   				console.log("통신 실패");
	   			},
	   			
	   		});
    	}
    	
    //아이디 중복확인 후 아이디 수정시 아이디 중복여부 다시 확인
    function inputIdChk(){
		idCheck = 0;
		return false;
	}
    
    //이메일 정규식
    $("#email3").on("change", function () {
        const email = $("[name=email2]");
        const selectMail = $(this).val();
        if (selectMail != "직접입력") {
            $("[name=email2]").val(selectMail);
        } else {
            $("[name=email2]").val(" ");
        }
    });
    
    //주소 우편번호
    function Postcode(){
    	 new daum.Postcode({
             oncomplete: function(data) {
                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                 var addr = ''; // 주소 변수
                 var extraAddr = ''; // 참고항목 변수

                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                     addr = data.roadAddress;
                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
                     addr = data.jibunAddress;
                 }

                 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                 if(data.userSelectedType === 'R'){
                     // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                     // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                     if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                         extraAddr += data.bname;
                     }
                     // 건물명이 있고, 공동주택일 경우 추가한다.
                     if(data.buildingName !== '' && data.apartment === 'Y'){
                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                     }
                     // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                     if(extraAddr !== ''){
                         extraAddr = ' (' + extraAddr + ')';
                     }
                     // 조합된 참고항목을 해당 필드에 넣는다.
                     document.getElementById("address3").value = extraAddr;
                 
                 } else {
                     document.getElementById("address3").value = '';
                 }

                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
                 document.getElementById('postcode').value = data.zonecode;
                 document.getElementById("address1").value = addr;
                 // 커서를 상세주소 필드로 이동한다.
                 document.getElementById("address2").focus();
             }
         }).open();
    }
    
    
    <!--회원가입 전체 유효성 검사-->
    function checked(){
    	
   		var p1 = document.getElementById('joinPwd');
   		var p2 = document.getElementById('pwdChk');
    	var pw = $("#joinPwd").val();
    	var num = pw.search(/[0-9]/g);
    	var eng = pw.search(/[a-z]/ig);
    	var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
    	var pnum1 = $("#phone2").val();
    	var pnum1RegExp = /^[0-9]{3,4}$/;
    	var pnum2 = $("#phone3").val();
    	var pnum2RegExp = /^[0-9]{4}$/;
   		
    	//휴대폰 번호 합치기
    	var f = document.frm;
    	f.phone.value = phone1.options[phone1.selectedIndex].value +"-"+ f.phone2.value +"-"+ f.phone3.value;
 
    	//이메일 합치기
    	f.email.value = f.email1.value + "@" + f.email2.value;
   		
    	//주소 합치기
    	f.address.value = "(" + f.postcode.value + ") " + f.address1.value + " " + f.address2.value + " " + f.address3.value;
    	
    	//비밀번호 정규식
    	if(pw.length < 8 || pw.length > 20){
    	  alert("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");
    	  p1.value="";
    	  p2.value="";
 		  p1.focus();
    	  return false;
    	 }else if(pw.search(/\s/) != -1){
    	  alert("비밀번호는 공백 없이 입력해주세요.");
    	  p1.value="";
    	  p2.value="";
 		  p1.focus();
    	  return false;
    	 }else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
    	  alert("비밀번호는 영문,숫자,특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
    	  p1.value="";
    	  p2.value="";
 		  p1.focus();
    	  return false;
    	 }
    	
    	//휴대폰번호 정규식
    	 else if(!pnum1RegExp.test(pnum1)){
    		 alert("휴대폰 번호 두번째 자리는 숫자 3~4자리여야 합니다.");
    		 $("#phone2").val("");
	    	 $("#phone2").focus();
    		 return false;
    	 }
    	 else if(!pnum2RegExp.test(pnum2)){
    		 alert("휴대폰 번호 마지막 자리는 숫자 4자리여야 합니다.");
    		 $("#phone3").val("");
	    	 $("#phone3").focus();
    		 return false;
    	 }
    	
   		//아이디 중복확인 여부 확인 
   		else if(idCheck == 0){
			alert("아이디 중복확인을 해주세요.");
			return false;
		}  		
    	
		//비밀번호 일치 확인
		else if(p1.value != p2.value){
   			alert("비밀번호가 일치하지 않습니다.");
   			p2.value="";
   			p2.focus();
   			return false;
   		}
   		else{
   			return true;
   		}
    }
    
    </script>
	 <script>
		
		var msg = "<%=alertMsg%>";
			
		
		if(msg != "null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	
	</script>
    
<%@ include file="/view/common/footer.jsp" %>
</body>
</html>