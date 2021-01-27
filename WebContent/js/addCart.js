function add(itemId, userId) {
					console.log("add()실행됨.");
					
					var id = {
						 itemId: itemId,
						 userId: userId,
					}
					
					$.ajax({
						type: "POST",
						url: "/breadReservation/cart?cmd=add",
						data: JSON.stringify(id), 
						contentType: "application/json; charset=utf-8",
						dataType: "json"
					}).done(function(data){
						if (data.statusCode == 1){
							alert('장바구니에 추가 되었습니다.');
						} else if (data.statusCode == 0) {
							alert('이미 장바구에 담겨 있는 제품 입니다.');
						} else {
							alert('장바구니 추가에 실패 했습니다.');
						}
					});
				}