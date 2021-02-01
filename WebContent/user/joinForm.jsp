<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp"%>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/join.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="page-heading">
					<h1>회원가입</h1>
					<span class="subheading">회원가입 후 서비스를 이용하실 수 있습니다.</span>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div class="row">
		<div class="col-lg-10 col-xl-9 mx-auto" style="margin-top: 100px">
			<div class="card card-signin flex-row my-5">
				<div class="card-img-left d-none d-md-flex">
					<!-- Background image for card set in CSS! -->
				</div>
				<div class="card-body">
					<h5 class="card-title text-center">회원가입을 해주세요 :)</h5>

					<form class="form-signin" action="/breadReservation/user?cmd=join"
						method="post" onsubmit="return valid()">

						<div class="d-flex justify-content-end">
							<button type="button" class="btn btn-info"
								onClick="usernameCheck()">중복체크</button>
						</div>
						<div class="form-label-group">
							<input type="text" name="username" id="username"
								class="form-control" placeholder="Username" required autofocus>
							<label for="inputUserame">아이디를 입력해주세요.</label>
						</div>

						<div class="form-label-group">
							<input type="email" name="email" id="email" class="form-control"
								placeholder="Email address" required> <label
								for="inputEmail">이메일을 입력해주세요.</label>
						</div>

						<hr>

						<div class="form-label-group">
							<input type="password" name="password" id="password"
								class="form-control" placeholder="Password" required> <label
								for="inputPassword">비밀번호를 입력해주세요.</label>
						</div>

						<div class="d-flex justify-content-end">
							<button type="button" class="btn btn-info" onClick="goPopup()">주소검색</button>
						</div>
						<div class="form-label-group">
							<input type="text" name="address" id="address"
								class="form-control" placeholder="Enter Address" required
								readonly> <label>주소 검색 버튼을 눌러주세요.</label>
						</div>

						<button class="btn btn-lg btn-primary btn-block text-uppercase"
							type="submit">가입하기</button>

						<script>

						// 회원가입 버튼을 아이디 중복체크를 하지 않고 동작하지 않도록 하기 위한 변수
							var isChecking = false;
							// valid()는 회원가입 버튼이 동작하기전 무조건 실행된다.
							function valid() {
								// false 상태라면 아이디 중복체크를 해라고 알림 창을 띄우고 
								// 계속해서 false 상태를 유지해 회원가입을 못하도록 한다.
								if (isChecking == false) {
									alert("아이디 중복체크를 해주세요");
								}
								return isChecking;
							}

							// 아이디 중복 체크를 하는 함수
							// 중복 체크버튼을 누르면 무조건 실행된다.
							function usernameCheck() {
								// DB에서 확인해서 정상이면 isChecking = true
								// username의 값을 JQuery로 가져와서 변수에 담는다.
								var username = $("#username").val();
								// ajax통신을 하기위한 정보를 명시한다
								$.ajax({
									type : "POST", // 요청하는 방식
									url : "/breadReservation/user?cmd=usernameCheck", // 요청하는 주소
									data : username, // 요청하는 데이터
									contentType : "text/plain; charset=utf-8", // 요청하는 데이터 타입
									dataType : "text" // 응답 받을 데이터의 타입을 적으면 자바스크립트 오브젝트로 파싱해줌.
								}).done(function(data) { // ajax통신이 정상적으로 완료되고 응답 받은 데이터값이 done함수 속 으로에 들어가서 호출된다. 
									if (data === 'ok') { // 유저네임이 중복된다. 
										isChecking = false;
										alert('유저네임이 중복되었습니다.')
									} else {
										isChecking = true;
										$("#username").attr("readonly", "readonly");
										alert("해당 유저네임을 사용할 수 있습니다.")
									}
								});
							}

							function goPopup() {
								// 주소검색을 수행할 팝업 페이지를 호출합니다.
								// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
								var pop = window.open("/breadReservation/user/jusoPopup.jsp", "pop",
										"width=570,height=420, scrollbars=yes, resizable=yes");
							}
							function jusoCallBack(roadFullAddr) {
								var addressEl = document.querySelector("#address");
								addressEl.value = roadFullAddr;
							}
</script>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<ul class="list-inline text-center">
					<li class="list-inline-item"><a href="https://blog.naver.com/ehszl409"> <span
							class="fa-stack fa-lg"> <i
								class="fas fa-circle fa-stack-2x"></i> <i
								class="fas fa-blog fa-stack-1x fa-inverse"></i>
						</span>
						
					</a></li>
					<li class="list-inline-item"><a href="https://github.com/ehszl409/Project_JspWeb"> <span
							class="fa-stack fa-lg"> <i
								class="fas fa-circle fa-stack-2x"></i> <i
								class="fab fa-github fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
				</ul>
				<p class="copyright text-muted">Copyright &copy; Your Website
					2020</p>
			</div>
		</div>
	</div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

<!-- 주소 팝업 자바스크립트 -->
<!-- <script src="js/jusoPopup.js"></script> -->
</body>
</html>
