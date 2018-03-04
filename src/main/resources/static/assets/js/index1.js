$(function(){
	var logstyle = $(".log-form").prop("style");
	var user_message = $("#user_input").val();
	if(user_message!=""){
		$(".log-form").prop("style","display:block");
	}
	
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