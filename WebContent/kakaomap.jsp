<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<style>
.map_wrap {
	position: relative;
	width: 100%;
	height: 350px;
}

.title {
	font-weight: bold;
	display: block;
}

.hAddr {
	position: absolute;
	left: 10px;
	top: 10px;
	border-radius: 2px;
	background: #fff;
	background: rgba(255, 255, 255, 0.8);
	z-index: 1;
	padding: 5px;
}

#centerAddr {
	display: block;
	margin-top: 2px;
	font-weight: normal;
}

.bAddr {
	padding: 5px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}
</style>
</head>
<body>
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
		<div class="hAddr">
			<span class="title"></span> <span id="centerAddr"></span>
		</div>
	</div>

	<a id="clicker" class="btn btn-danger">버튼</a>
	<a id="clicker2" class="btn btn-warning">버튼</a>
	<p id="result"></p>

	<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8b385aad74b61dffd6dd040ee8aa38cd&libraries=services,clusterer,drawing"></script>


	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		document
				.getElementById('clicker')
				.addEventListener(
						'click',
						function() {
							var a = 35.26795684446407;
							var b = 129.0925752077242;
							var mapOption = {
								center : new kakao.maps.LatLng(a, b), // 지도의 중심좌표
								level : 3
							// 지도의 확대 레벨
							};

							var map = new kakao.maps.Map(mapContainer,
									mapOption); // 지도를 생성합니다

							// 마커가 표시될 위치입니다 
							var markerPosition = new kakao.maps.LatLng(a, b);

							// 마커를 생성합니다
							var marker = new kakao.maps.Marker();

							// 인포윈도우가 표시될 위치입니다
							iwPosition = new kakao.maps.LatLng(a, b);

							// 인포윈도우를 생성합니다
							var infowindow = new kakao.maps.InfoWindow({
								position : iwPosition
							});

							var geocoder = new kakao.maps.services.Geocoder();

							function searchDetailAddrFromCoords(coords,
									callback) {
								// 좌표로 법정동 상세 주소 정보를 요청합니다
								geocoder.coord2Address(coords.getLng(), coords
										.getLat(), callback);
							}

							searchDetailAddrFromCoords(
									markerPosition,
									function(result, status) {

										if (status === kakao.maps.services.Status.OK) {

											var detailAddr = !!result[0].road_address ? '<div>도로명주소 : '
													+ result[0].road_address.address_name
													+ '</div>'
													: '';
											detailAddr += '<div>지번 주소 : '
													+ result[0].address.address_name
													+ '</div>';

											var content = '<div class="bAddr">'
													+ '<span class="title">부부스시 주소정보</span>'
													+ detailAddr + '</div>';

											// 마커를 클릭한 위치에 표시합니다 
											marker.setPosition(markerPosition);
											// 마커가 지도 위에 표시되도록 설정합니다
											marker.setMap(map);

											// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
											infowindow.setContent(content);
											// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
											infowindow.open(map, marker);
										}
									});
						});

		document
				.getElementById('clicker2')
				.addEventListener(
						'click',
						function() {
							//35.14991102569784, 129.03620284190603
							var a = 35.14991102569784;
							var b = 129.03620284190603;
							var mapOption = {
								center : new kakao.maps.LatLng(a, b), // 지도의 중심좌표
								level : 3
							// 지도의 확대 레벨
							};

							var map = new kakao.maps.Map(mapContainer,
									mapOption); // 지도를 생성합니다

							// 마커가 표시될 위치입니다 
							var markerPosition = new kakao.maps.LatLng(a, b);

							// 마커를 생성합니다
							var marker = new kakao.maps.Marker();

							// 인포윈도우가 표시될 위치입니다
							iwPosition = new kakao.maps.LatLng(a, b);

							// 인포윈도우를 생성합니다
							var infowindow = new kakao.maps.InfoWindow({
								position : iwPosition
							});

							var geocoder = new kakao.maps.services.Geocoder();

							function searchDetailAddrFromCoords(coords,
									callback) {
								// 좌표로 법정동 상세 주소 정보를 요청합니다
								geocoder.coord2Address(coords.getLng(), coords
										.getLat(), callback);
							}

							searchDetailAddrFromCoords(
									markerPosition,
									function(result, status) {

										if (status === kakao.maps.services.Status.OK) {

											var detailAddr = !!result[0].road_address ? '<div>도로명주소 : '
													+ result[0].road_address.address_name
													+ '</div>'
													: '';
											detailAddr += '<div>지번 주소 : '
													+ result[0].address.address_name
													+ '</div>';

											var content = '<div class="bAddr">'
													+ '<span class="title">해들녘 주소정보</span>'
													+ detailAddr + '</div>';

											// 마커를 클릭한 위치에 표시합니다 
											marker.setPosition(markerPosition);
											// 마커가 지도 위에 표시되도록 설정합니다
											marker.setMap(map);

											// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
											infowindow.setContent(content);
											// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
											infowindow.open(map, marker);
										}
									});
						});
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	</script>
</body>
</html>