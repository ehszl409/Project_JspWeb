<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp"%>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/myPage.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="post-heading">
					<h1>마이 페이지</h1>
					<h2 class="subheading">예약 정보와 결제 정보를 확인할 수 있어요!</h2>
				</div>
			</div>
		</div>
	</div>
</header>

<!-- Post Content -->
<article>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<h2 class="section-heading">${userInfo.username} 님의 정보입니다. :)</h2>
				<a href="#"> <img class="img-fluid"
					src="img/mypage2.jpg" alt="">
				</a>
				<hr>
				<div class="d-flex align-items-center">
					<div>
						<h3>유저 정보</h3>
						<%-- <blockquote class="blockquote">결제 금액 : ${payInfo.payAmount}원</blockquote> --%>
						<ul>
							<li>이름 : ${userInfo.username}</li>
							<li>비밀번호 : ${userInfo.password}</li>
							<li>이메일 : ${userInfo.email}</li>
							<li>생성일 : ${userInfo.createDate}</li>
						</ul>
						<hr>
						<c:forEach var="payInfo" items="${MyPageInfo}">
							<h3>${payInfo.payCreateDate}의결제 내역</h3>
							<blockquote class="blockquote">결제 금액 :
								${payInfo.payAmount}원</blockquote>
							<ul>
								<li>구매자 이름 : ${payInfo.buyer_name}</li>
								<li>구매자 이메일 : ${payInfo.buyer_email}</li>
								<li>구매자 번호 : ${payInfo.buyer_tel}</li>
								<li>결제 방식 : ${payInfo.pay_method}</li>
								<li>결제 시간 : ${payInfo.payCreateDate}</li>
							</ul>
							<h3>픽업 매장 정보</h3>
							<ul>
								<li>매장 이름 : ${payInfo.name}</li>
								<li>매장 도로명주소 : ${payInfo.roadAddress}</li>
								<li>매장 지번 주소 : ${payInfo.address}</li>
								<li>매장 번호 : ${payInfo.phone}</li>
								<li>픽업 날짜와 시간 : ${payInfo.pickup}</li>
								<li>추가 요청 사항 : ${payInfo.message}</li>
							</ul>
							<a class="btn btn-Success" onclick="comingSoon()">주문 제품 보기</a>
							<hr>
						</c:forEach>
						<script>
							function comingSoon() {
								alert("추후에 업데이트될 예정입니다. "+"\n"+"지금은 고객센터로 문의해주세요."+"\n"+"죄송합니다.")
							}
						</script>
					</div>
				</div>

				<!-- 자바스크립트와 분리를 위해서 함수에 매개변수를 통해서 전달 받아야 합니다. -->
				<div class="d-flex justify-content-around">
					<a class="btn btn-dark" href="index.jsp">메인으로</a>
				</div>


			</div>
		</div>
	</div>
</article>

<hr>
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

</body>

</html>
