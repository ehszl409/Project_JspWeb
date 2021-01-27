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
					<h1>예약하기</h1>
					<span class="subheading">매일매일 신선한 케이크!!</span>
				</div>
			</div>
		</div>
	</div>
</header>

<!-- Page Content -->
<div class="container">

	<!-- Page Heading -->
	<h1 class="my-4">
		제품 목록 <small>제품을 선택해 주세요:)</small>
	</h1>

	<div class="row">
		<c:forEach var="item" items="${itemDto}">
			<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
				<div class="card h-100">
					<a href="item?cmd=detail&id=${item.id}"><img class="card-img-top"
						src="${item.image}" style=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="item?cmd=detail&id=${item.id}">${item.itemname}</a>
						</h4>
						<p class="card-text">${item.subcontent}</p>
						<p class="card-text">가격 : ${item.price}원</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- /.row -->

	<!-- Pagination -->
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${empty param.keyword}">
				<c:set var="pagePrev" value="item?cmd=list&page=${param.page-1}"></c:set>
				<c:set var="pageNext" value="item?cmd=list&page=${param.page+1}"></c:set>		
			</c:when>
			
			<c:otherwise>
				<c:set var="pagePrev" value="item?cmd=list&page=${param.page-1}&keyword=${param.keyword}"></c:set>
				<c:set var="pageNext" value="item?cmd=list&page=${param.page+1}&keyword=${param.keyword}"></c:set>
			</c:otherwise>	
		</c:choose>
	
		<c:choose>
			<c:when test="${param.page == 0}">
				<li class="page-item disabled"><a class="page-link" href="item?cmd=list&page=${param.page-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="${pageScope.pagePrev}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${lastPage == param.page}">
				<li class="page-item disabled"><a class="page-link" href="item?cmd=list&page=${param.page+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="${pageScope.pageNext}">Next</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>


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

</body>

</html>
