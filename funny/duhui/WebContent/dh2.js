var dh2 = function() {

	return {
		changeLive : function() {
			$.ajax({
				type : "post",
				url : "changeLive",
				success : function(data) {
					alert("成功");
				},
				error : function() {
					alert("出错");
				}

			})
		},
		changeNotLive : function() {
			$.ajax({
				type : "post",
				url : "changeNotLive",
				success : function(data) {
					alert("成功");
				},
				error : function() {
					alert("出错");
				}

			})
		},
		getStatus : function() {
			$.ajax({
				type : "post",
				url : "getStatus",
				success : function(data) {
					alert(data);
				},
				error : function() {
					alert("出错");
				}

			})
		}
	}
}();

$(document).ready(function() {
	$("#changeLive").on("click", dh2.changeLive);
	$("#changeNotLive").on("click", dh2.changeNotLive);
	$("#getStatus").on("click", dh2.getStatus);
});