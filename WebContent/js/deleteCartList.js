
function deleteById(itemId, userId) {
	$.ajax({
		type: "post",
		url: "/breadReservation/cart?cmd=delete&itemId=" + itemId + "&userId=" + userId,
		dataType: "json"
	})
		.done(function(result) {
			if (result.statusCode == 1) {
				console.log(result);
				alert("제품을 삭제 했습니다.");
				location.href = "cart?cmd=list&id=" + userId;
			} else {
				console.log(result);
				alert("제품을 삭제하는데 실패 했습니다.");
			}
		});
}
