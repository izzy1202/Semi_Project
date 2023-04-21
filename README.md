# 지은이
전 연령층이 쉽게 이용 가능한 도서 구매 사이트 - Semi Project

맡은 역할 : 헤더, 푸터, 메인 페이지, 회원가입, 마이 페이지 메인

## 헤더
![image](https://user-images.githubusercontent.com/106478906/229981012-1e87aa85-ea6c-4bc4-a302-258ca7f8d8d4.png)

## 롤링 배너, 베스트셀러 TOP5(조회수 순)
![image](https://user-images.githubusercontent.com/106478906/229981142-cda7b814-a782-46ab-97fb-c8bb2adfc4bd.png)
- TOP5 순위는 ajax로 실시간 반영되게 구현했습니다.

## 푸터
![image](https://user-images.githubusercontent.com/106478906/229982540-82985063-2bcb-4237-8a44-50e8cc9a2f92.png)
- 모달창으로 구현했습니다.

## 마이 페이지
![KakaoTalk_20230405_152211182](https://user-images.githubusercontent.com/106478906/229998429-7ac9d338-7146-424e-93a7-f0ba24c65106.png)
- 주문 내역 받아와서 띄워주었습니다.

## 회원가입 페이지
![image](https://user-images.githubusercontent.com/106478906/229983594-7fca7fc8-9a79-46cb-9caf-e76aae227e7d.png)
- 아이디 중복 확인 버튼에 onclick으로 idcheck() 이벤트를 걸어주어서 공백 막아주기, 아이디 정규식, ajax 아이디 중복확인 기능을 넣었습니다.
  - 아이디 중복 확인 후 아이디를 다시 수정할 경우, 아이디 중복 확인을 다시 하도록 하였습니다.
- 이메일의 경우 아이디칸과 도메인칸을 분리하여 셀렉트 박스를 직접 입력을 선택할 경우 도메인칸을 빈칸으로 설정하고,
  셀렉트 박스의 값을 선택할 경우 같은 값이 도메인칸에 출력되도록 구현했습니다.
- 회원가입폼에 onsubmit="return checked()"로 전체 유효성 검사를 걸어주었습니다.
  - 입력한 휴대폰 번호, 이메일, 주소에 특수문자를 합한 형태로 DB로 넘어가도록 구현했습니다.
  - 비밀번호와 휴대폰 번호의 정규 표현식을 넣어주었습니다.
  - 아이디 중복확인 여부와 비밀번호 일치 여부를 확인하도록 구현했습니다.
  
  
### 다음 주소 API
![image](https://user-images.githubusercontent.com/106478906/229986700-8201592e-680b-4eb5-8d82-c71386bd66be.png)
- 주소는 다음 주소 API를 넣어주었습니다.
