<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp"%>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/about-bg.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="page-heading">
					<h1>장바구니</h1>
					<span class="subheading"></span>
				</div>
			</div>
		</div>
	</div>
</header>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading -->
	<h1 class="my-4">
		장바구니 목록 <small>케이크를 한번에 주문하세요!</small>
	</h1>

	<!-- Project -->
	<c:forEach var="cartItem" items="${dto}">
		<hr>
		<div class="row">
			<div class="col-md-7">
				<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0"
					src="${cartItem.image}" style="padding-left: 30%">
				</a>
			</div>
			<div class="col-md-5 d-flex align-items-center" >
				<div>
				<h3>${cartItem.itemname}</h3>
				<h5>가격 : ${cartItem.price}</h5>
				<ul >
					<li>제조원 : ${cartItem.make}</li>
					<li>칼로리 : ${cartItem.calorie}</li>
					<li>유통기한 : ${cartItem.sellByDate}</li>
					<li>알레르기 성분 : ${cartItem.material}</li>
				</ul>
				<!-- 자바스크립트와 분리를 위해서 함수에 매개변수를 통해서 전달 받아야 합니다. -->
				<a class="btn btn-danger"
					onclick="deleteById(${cartItem.itemId}, ${sessionScope.principal.id})">삭제하기</a>
				</div>
			</div>
		</div>
		<hr>
	</c:forEach>
	
	<!-- /.row -->
	<div class="d-flex justify-content-around">
			<h2>총 금액 : ${totalPrice}원 </h2>
			<a class="btn btn-primary" href="payForm.jsp">결제하기</a>
	</div>

</div>
<!-- /.container -->

<hr>

<!-- Footer -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<ul class="list-inline text-center">
					<li class="list-inline-item"><a href="#"> <span
							class="fa-stack fa-lg"> <i
								class="fas fa-circle fa-stack-2x"></i> <i
								class="fab fa-twitter fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li class="list-inline-item"><a href="#"> <span
							class="fa-stack fa-lg"> <i
								class="fas fa-circle fa-stack-2x"></i> <i
								class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li class="list-inline-item"><a href="#"> <span
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

<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>


<!-- 자동 스크롤 업 버튼 -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

<!-- 장바구니 삭제를 위한 스크립트 -->
<script src="js/deleteCartList.js"></script>
</body>

</html>
