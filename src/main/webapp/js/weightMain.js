$(document).ready(function() {

	$('#mySelect').val($("#currentServer").val());

	$("#mySelect").change(function() {
		var serverName = $("#mySelect").val();
		window.location.href = "GetTradeByServer?serverName=" + serverName;
	});

});