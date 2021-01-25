<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp" %>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/contact-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>회원가입</h1>
						<span class="subheading">Have questions? I have answers.</span>
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

						<form class="form-signin" action="/breadReservation/user?cmd=join" method="post" onsubmit="return valid()">

							<div class="d-flex justify-content-end">
								<button type="button" class="btn btn-info"
									onClick="usernameCheck()">중복체크</button>
							</div>
							<div class="form-label-group">
								<input type="text" name="username" id="username" class="form-control"
									placeholder="Username" required autofocus> <label
									for="inputUserame">Username</label>
							</div>

							<div class="form-label-group">
								<input type="email" name="email" id="email" class="form-control"
									placeholder="Email address" required> <label
									for="inputEmail">Email address</label>
							</div>

							<hr>

							<div class="form-label-group">
								<input type="password" name="password" id="password" class="form-control"
									placeholder="Password" required> <label
									for="inputPassword">Password</label>
							</div>

							<div class="d-flex justify-content-end">
								<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
							</div>
							<div class="form-label-group">
								<input type="text" name="address" id="address" class="form-control"
									placeholder="Enter Address" required readonly> <label>click
									SearchAddress</label>
							</div>

							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">가입하기</button>
								
							<a class="d-block text-center mt-2 small" href="#">Sign In</a>
							<hr class="my-4">
							<button class="btn btn-lg btn-google btn-block text-uppercase"
								type="submit">
								<i class="fab fa-google mr-2"></i> 네이버 아이디로 회원가입 하기
							</button>
							<button class="btn btn-lg btn-facebook btn-block text-uppercase"
								type="submit">
								<i class="fab fa-facebook-f mr-2"></i> Sign up with Facebook
							</button>
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

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/clean-blog.min.js"></script>
	
	<!-- 주소 팝업 자바스크립트 -->
	<script src="js/jusoPopup.js"></script>

</body>
</html>
