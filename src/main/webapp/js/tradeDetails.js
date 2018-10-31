var firstResult = 0;
var currentPage = 1;

$(document).ready(function() {
	
	loadTradeList(firstResult,currentPage);

	$("#toPage").click(function() {
		var jumpPage = $("#jumpPage").val();
		var maxResults = $("#maxResults").val();
		var pagesNum = $("#pagesNum").html();
		
		if(Number(jumpPage) > 0 && Number(jumpPage)<=Number(pagesNum) ){
		
		var firstResult = (Number(jumpPage) - 1) * maxResults;
		loadTradeList(firstResult,jumpPage);
	}		
	});
	
	//tradeServer change
	$("#tradeServer").change(function() {	
		currentPage = 1;
		loadTradeList(firstResult,currentPage);		
	});
	
	//tradeMonth change
	$("#tradeMonth").change(function() {	
		currentPage = 1;
		loadTradeList(firstResult,currentPage);		
	});
	
	//maxResults change
	$("#maxResults").change(function() {
		currentPage = 1;
		loadTradeList(firstResult,currentPage);		
	});
	
	//moneyNum change
	$("#moneyNum").change(function() {	
		currentPage = 1;
		loadTradeList(firstResult,currentPage);		
	});
	
	//first page
	$("#firstPage").click(function() {	
		currentPage = 1;
		loadTradeList(firstResult,currentPage);
		
	});
	
	//previous page
	$("#previousPage").click(function() {		
		 currentPage = $("#currentPage").html();
		
		var maxResults = $("#maxResults").val();
		if((Number(currentPage)-1)>0){
			var  firstResult =(Number(currentPage)-2)*Number(maxResults);	
			previousPage = Number(currentPage)-1;
			loadTradeList(firstResult,previousPage);	
		}			
	});
	
	//next page
	$("#nextPage").click(function() {		
		 currentPage = $("#currentPage").html();
		var maxResults = $("#maxResults").val();
		var pagesNum = $("#pagesNum").html();
		if(Number(currentPage) < Number(pagesNum)){
			var  firstResult = Number(currentPage) * Number(maxResults);		
			nextPage = Number(currentPage) + 1;
			loadTradeList(firstResult,nextPage);		
		}
		
	});
	
	//last page
	$("#lastPage").click(function() {	
		currentPage = $("#pagesNum").html();
		var maxResults = $("#maxResults").val();
		var  firstResult = (Number(currentPage)-1)*maxResults;
		loadTradeList(firstResult,currentPage);
		
	});
	
	
	function loadTradeList(firstResult,currentPage){
		var tradeServer = $("#tradeServer").val();
		var tradeTime = $("#tradeMonth").val();
		var tradeMoney = $("#moneyNum").val();
		var maxResults = $("#maxResults").val();		
		
		$.ajax({
			url:path+"/trade/queryTradeList",
			dataType:"json",
			async:true,
			data:{"tradeServer":tradeServer,"tradeTime":tradeTime,"tradeMoney":tradeMoney,"firstResult":firstResult,"maxResults":maxResults},
			cache:false,
			type:"post",
			success:function(results){				
				$("#tradeList tbody").remove();
				var tbody = $("<tbody>");
				tbody.appendTo($("#tradeList"));
				if(results.trades != null && results.trades.length > 0)	{			
				for (var i = 0; i < results.trades.length; i++) {
					var tr = $("<tr></tr>");
					tr.appendTo(tbody);
					
					var td0 = $("<td>"
							+ (++firstResult)
							+ "</td>");
					var td1 = $("<td>"
							+ results.trades[i].tradeServer
							+ "</td>");
					var td2 = $("<td>"
							+ results.trades[i].tradeCurrency
							+ "</td>");
					var td3 = $("<td>"
							+ results.trades[i].tradeMoney
							+ "</td>");					
					var td4 = $("<td>"
							+ results.trades[i].tradeTime
							+ "</td>");
					var td5 = $("<td>"
							+ results.trades[i].tradeComment
							+ "</td>");
					td0.appendTo(tr);
					td1.appendTo(tr);
					td2.appendTo(tr);
					td3.appendTo(tr);
					td4.appendTo(tr);
					td5.appendTo(tr);
			
				}
			 }
				$("#currentPage").html(currentPage);
				$("#pagesNum").html(results.pagesNum);			
				
				if(currentPage == 1){
					$("#previousPage").attr("class", "disabled");
				}else{
					 $("#previousPage").removeClass("disabled");
				}
				
				if(currentPage == results.pagesNum){
					$("#nextPage").attr("class", "disabled");
				}else{
					 $("#nextPage").removeClass("disabled");
				}
			}
		});
		
		
		}
	

});