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
					<h1>주문하기</h1>
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
		주문 목록 <small>픽업하실 매장과 추가사항을 입력해주세요 :)</small>
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
			<div class="col-md-5 d-flex align-items-center">
				<div>
					<h3>${cartItem.itemname}</h3>
					<h5>가격 : ${cartItem.price}</h5>
					<ul>
						<li>제조원 : ${cartItem.make}</li>
						<li>칼로리 : ${cartItem.calorie}</li>
						<li>유통기한 : ${cartItem.sellByDate}</li>
						<li>알레르기 성분 : ${cartItem.material}</li>
					</ul>
				</div>
			</div>
		</div>
		<hr>
	</c:forEach>

	<!-- /.row -->
	<div class="d-flex justify-content-around">
		<h2>총 금액 : ${totalPrice}원</h2>
	</div>

</div>

<main id="main">

	<!-- ======= Contact Us Section ======= -->
	<section id="contact-us" class="contact-us">
		<div class="container">

			<div>
				<iframe style="border: 0; width: 100%; height: 270px;"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3875.5509865227164!2d129.08668770794876!3d35.23293998370657!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb36a7f7afaabda34!2z7YyM66as67CU6rKM65yoIOu2gOyCsOuMgA!5e0!3m2!1sko!2skr!4v1611240191389!5m2!1sko!2skr"
					frameborder="0" allowfullscreen></iframe>
			</div>





			<div class="row mt-5">

				<div class="col-lg-4">
					<div class="info">
						<div class="address">
							<i class="icofont-google-map"></i>
							<h4>Location:</h4>
							<p>A108 Adam Street, New York, NY 535022</p>
						</div>

						<div class="email">
							<i class="icofont-envelope"></i>
							<h4>Email:</h4>
							<p>info@example.com</p>
						</div>

						<div class="phone">
							<i class="icofont-phone"></i>
							<h4>Call:</h4>
							<p>+1 5589 55488 55s</p>
						</div>

					</div>

				</div>

				<div class="col-lg-8 mt-5 mt-lg-0">

					<form action="#" method="post" role="form" class="php-email-form">
						<div class="form-row">
							<div class="col-md-6 form-group">
								<input type="text" name="name" class="form-control" id="name"
									placeholder="받으실 분의 이름을 입력해주세요." data-rule="minlen:2"
									data-msg="이름을 입력해주세요." />
								<div class="validate"></div>
							</div>
							<div class="col-md-6 form-group">
								<input type="number" class="form-control" name="phone"
									id="phone" placeholder="핸드폰 번호를 - 뺴고 입력해 주세요."
									data-rule="required" data-msg="핸드폰 번호를 - 뺴고 입력해 주세요." />
								<div class="validate"></div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="pickup" id="pickup"
								placeholder="픽업 날짜와 시간을 적어주세요." data-rule="required"
								data-msg="픽업 날짜와 시간을 적어주세요." />
							<div class="validate"></div>
						</div>
						<div class="form-group">
							<textarea class="form-control" name="message" id="message"
								rows="5" placeholder="추가적인 요청사항이 있으면 자유롭게 적어주세요!"></textarea>
							<div class="validate"></div>
						</div>
						<div class="mb-3">
							<div class="loading">Loading</div>
							<div class="error-message"></div>
							<div class="sent-message">Your message has been sent. Thank
								you!</div>
						</div>
						<div class="text-center">
							<button type="submit"
								onclick="importStart(${totalPrice}, '${sessionScope.principal.email}', '${sessionScope.principal.address}', '${sessionScope.principal.id}' )">결제하기</button>
						</div>
					</form>

				</div>


			</div>

			<script>
			function importStart(totalPrice, userEmail, userAddress, userId) {
				
				var userAddress = userAddress;
				var userEmail = userEmail;
				var totalPrice = totalPrice;
				var name = $("#name").val();
				var phone = $("#phone").val();
						 
				console.log("totalPrice: " + totalPrice);
				console.log("userEmail: " + userEmail);
				console.log("userAddress: " + userAddress);
				console.log("name: " + name);
				console.log("phone: " + phone);
					
				
		var IMP = window.IMP; // 생략가능
		IMP.init('imp02842140');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
			pg : 'html5_inicis', // version 1.1.0부터 지원.
			/*
			 'kakao':카카오페이,
			 'html5_inicis':이니시스(웹표준결제)
			 'nice':나이스페이
			 'jtnet':제이티넷
			 'uplus':LG유플러스
			 'danal':다날
			 'payco':페이코
			 'syrup':시럽페이
			 'paypal':페이팔
			 */

			pay_method : 'card',
			/*
			 'samsung':삼성페이,
			 'card':신용카드,
			 'trans':실시간계좌이체,
			 'vbank':가상계좌,
			 'phone':휴대폰소액결제
			 */
			merchant_uid : 'merchant_' + new Date().getTime(),
			/*
			 merchant_uid에 경우
			 https://docs.iamport.kr/implementation/payment
			 위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			 참고하세요.
			 나중에 포스팅 해볼게요.
			 */
			name : '주문명:결제테스트',
			//결제창에서 보여질 이름
			amount : totalPrice,
			//가격
			buyer_email : userEmail,
			buyer_name : name,
			buyer_tel : phone,
			buyer_addr : userAddress,
			m_redirect_url : 'https://www.yourdomain.com/payments/complete'
		/*
		 모바일 결제시,
		 결제가 끝나고 랜딩되는 URL을 지정
		 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
		 */
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				
				var payInfo = {
						payName: rsp.name,
						payAmount: rsp.paid_amount,
						buyer_email: rsp.buyer_email,
						buyer_name: rsp.buyer_name,
						buyer_tel: rsp.buyer_tel,
						buyer_addr: rsp.buyer_addr,
						pay_method: rsp.pay_method,
						merchant_uid: rsp.merchant_uid,
						pg_tid: rsp.pg_tid,
						imp_uid: rsp.imp_uid,
						paid_at: rsp.paid_at,
						pickup: $("#pickup").val(),
						message: $("#message").val(),
						userId: userId,
				}
				
				$.ajax({
					type: "POST",
					url: "/breadReservation/pay?cmd=add",
					data: JSON.stringify(payInfo), 
					contentType: "application/json; charset=utf-8",
					dataType: "json"
				}).done(function(data){
					if (data.statusCode == 1){
						console.log("결제완료.");
						location.href = "pay?cmd=paySuccess&id="+userId+"&mId="+rsp.merchant_uid;						
					}  else {
						alert('결제 진행 중 오류가 발생 했습니다.');
					}
				});
				/* msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num; */
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
			}
			
	
</script>




		</div>
	</section>
	<!-- End Contact Us Section -->
</main>
<!-- End #main -->

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

<!-- Vendor JS Files -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="assets/vendor/venobox/venobox.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

</body>

</html>