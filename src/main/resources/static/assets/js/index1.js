$(function(){
	var logstyle = $(".log-form").prop("style");
	$("#loginlink").click(function(){
		if(logstyle.display=="none"){
			$(".log-form").prop("style","display:block");
		}else{
			$(".log-form").prop("style","display:none");
		}
	});
	
	$("#cancelbtn").click(function(){
		$(".log-form").prop("style","display:none");
	});
});