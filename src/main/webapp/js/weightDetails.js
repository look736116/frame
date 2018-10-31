

$(document).ready(function() {
	
	loadWeightList();		
	
	//recordName change
	$("#recordName").change(function() {			
		loadWeightList();		
	});
	
	function loadWeightList(){
		var recordName = $("#recordName").val();		
		$.ajax({
			url:path+"/weight/queryWeightList",
			dataType:"json",
			async:true,
			data:{"recordName":recordName},
			cache:false,
			type:"post",
			success:function(weights){				
				$("#weightList tbody").remove();
				var tbody = $("<tbody>");
				tbody.appendTo($("#weightList"));
				if(weights != null && weights.length > 0)	{			
				for (var i = 0; i < weights.length; i++) {
					var tr = $("<tr></tr>");
					tr.appendTo(tbody);					
					var td0 = $("<td>"
							+ (i+1)
							+ "</td>");
					var td1 = $("<td>"
							+ weights[i].recordName
							+ "</td>");
					var td2 = $("<td>"
							+ weights[i].recordWeigth
							+ "</td>");
					var td3 = $("<td>"
							+ weights[i].recordTime
							+ "</td>");					
					var td4 = $("<td>"
							+ weights[i].recordComment
							+ "</td>");				
					td0.appendTo(tr);
					td1.appendTo(tr);
					td2.appendTo(tr);
					td3.appendTo(tr);
					td4.appendTo(tr);			
				}
			 }
				
			}
		});
		
		
		}
	

});