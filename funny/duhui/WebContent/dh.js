var dh = function() {

	return {
		init : function() {

		}
	}
}();
$.ajax({
	type : "post",
	url : "getStatus",
	async: false,
	success : function(data) {
		if (data == 0) {
			$("#src3").remove();
		}
		if (data == 1) {
			$("#src1").remove();
			$("#src2").remove();
		}
	}

})

$(document).ready(function() {
	dh.init();
});