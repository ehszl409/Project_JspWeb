<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp"%>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/login.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="page-heading">
					<h1>로그인</h1>
					<span class="subheading">로그인을 하신 후 서비스를 이용하실 수 있습니다.</span>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto"
			style="margin-top: 100px">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">환영합니다 :)</h5>
					<form class="form-signin" action="/breadReservation/user?cmd=login"
						method="post">
						<div class="form-label-group">
							<input type="text" name="username" id="username"
								class="form-control" placeholder="Username" required autofocus>
							<label for="inputUserame">Username</label>
						</div>

						<div class="form-label-group">
							<input type="password" name="password" id="password"
								class="form-control" placeholder="Password" required> <label
								for="inputPassword">Password</label>
						</div>

						<button class="btn btn-lg btn-success btn-block text-uppercase"
							type="submit">로그인</button>
						<hr class="my-4">
						<div class="d-flex justify-content-around">
							<a class="btn btn-lg btn-primary" href="<%=request.getContextPath()%>/user?cmd=joinForm">회원가입</a>
						</div>
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

</body>
</html>