<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/navigation.jsp"%>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/home-bg.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>상세 정보</h1>
					<span class="subheading">케이크에 대한 자세한 내용입니다 :)</span>
				</div>
			</div>
		</div>
	</div>
</header>

<!-- Page Content -->
<div class="container">

	<!-- Portfolio Item Heading -->
	<h1 class="my-4">
		${dto.itemname} <small>언제든 예약가능 합니다!</small>
	</h1>

	<!-- Portfolio Item Row -->
	<div class="row">

		<div class="col-md-8">
			<img class="img-fluid" src="${dto.image}"
				style="width: 100%; height: 100%">
		</div>

		<div class="col-md-4">
			<h3 class="my-3">제품 상세 설명</h3>
			<p>${dto.content}</p>
			<h3 class="my-3">상세 정보</h3>
			<ul>
				<li>제조원 : ${dto.make}</li>
				<li>칼로리 : ${dto.calorie}</li>
				<li>유통기한 : ${dto.sellByDate}</li>
				<li>알레르기 성분 : ${dto.material}</li>
			</ul>
			<h4 class="my-3">가격 : ${dto.price}원</h4><a class="btn btn-primary" href="cart.jsp">장바구니에 담기</a>
		</div>

	</div>
	<!-- /.row -->

	<!-- Related Projects Row -->
	<h3 class="my-4">베스트 상품</h3>

	<div class="d-flex justify-content-center">
		<c:forEach var="bestItem" items="${listDto}">
			<div class="col-md-3 col-sm-6 mb-4">
				<a href="item?cmd=detail&id=${bestItem.id}"><img
					class="img-fluid" src="${bestItem.image}">
					<h6 class="d-flex justify-content-center">
					${bestItem.itemname}
					</h6>
				</a>
			</div>
		</c:forEach>
	</div>
	<!-- /.row -->

</div>


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

</body>
</html>