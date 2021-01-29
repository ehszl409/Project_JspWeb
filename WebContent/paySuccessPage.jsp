<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/navigation.jsp" %>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1>결제가 완료 되었습니다!!</h1>
            <h2 class="subheading">예약 정보와 결제 정보를 확인 하세요!</h2>
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
        <h2 class="section-heading">감사합니다:)</h2>
        <a href="#">
            <img class="img-fluid" src="img/post-sample-image.jpg" alt="">
          </a>
          <hr>
          <div class="d-flex align-items-center" >
				<div>
				<h3>결제 내역</h3>
				<blockquote class="blockquote">결제 금액 : $${payInfo.payAmount}원</blockquote>
				<ul >
					<li>구매자 이름 : ${payInfo.buyer_name}</li>
					<li>구매자 이메일 : ${payInfo.buyer_email}</li>
					<li>구매자 번호 : ${payInfo.buyer_tel}</li>
					<li>결제 시간 : ${payInfo.createDate}</li>
					<li>결제 방식 : ${payInfo.pay_method}</li>
					<li>픽업하시는 장소 : ${payInfo.buyer_addr}</li>
					<li>픽업 날짜와 시간 : ${payInfo.pickup}</li>
					<li>추가 요청 사항 : ${payInfo.message}</li>
				</ul>
				</div>
			</div>
				<hr>
				<!-- 자바스크립트와 분리를 위해서 함수에 매개변수를 통해서 전달 받아야 합니다. -->
				<div class="d-flex justify-content-around">
				<a class="btn btn-Success" href="index.jsp">더 주문하기!</a>
				<a class="btn btn-dark" href="<%=request.getContextPath()%>/item?cmd=list&page=0">마이페이지로!</a>				
				</div>
        
         <%--  <p>구매자 이름 : ${payInfo.buyer_name}</p>
          <p>구매자 이메일 : ${payInfo.buyer_email}</p>
          <p>구매자 번호 : ${payInfo.buyer_tel}</p>
          <p>결제금액 : ${payInfo.payAmount}원</p>
          <p>결제 방식 : ${payInfo.pay_method}</p>
          <p>결제 시간 : ${payInfo.createDate}</p>
          <p>픽업하시는 장소 : ${payInfo.buyer_addr}</p>
          <p>픽업 날짜와 시간 : ${payInfo.pickup}</p>
          <p>추가 요청 사항 : ${payInfo.message}</p>
          <p>id : ${payInfo.id}</p>
          <p>userId : ${payInfo.userId}</p>
          <p>payName : ${payInfo.payName}</p>
          <p>merchant_uid : ${payInfo.merchant_uid}</p>
          <p>pg_tid : ${payInfo.pg_tid}</p>
          <p>imp_uid : ${payInfo.imp_uid}</p>
          <p>paid_at : ${payInfo.paid_at}</p> --%>

         <!--  <h2 class="section-heading">The Final Frontier</h2>

          <blockquote class="blockquote">The dreams of yesterday are the hopes of today and the reality of tomorrow. Science has not yet mastered prophecy. We predict too much for the next year and yet far too little for the next ten.</blockquote>

          
          
          <span class="caption text-muted">To go places and do things that have never been done before – that’s what living is all about.</span>

          <p>Placeholder text by
            <a href="http://spaceipsum.com/">Space Ipsum</a>. Photographs by
            <a href="https://www.flickr.com/photos/nasacommons/">NASA on The Commons</a>.</p> -->
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
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; Your Website 2020</p>
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
