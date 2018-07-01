$(document).ready(function(){
	login();
});

function login(){
	
	$("#flogin").submit(function(e){
		
		$.ajax({
			url:"./login",
			type:"POST",
			data:{
				nome:$("#nome").val(),
				senha:$("#senha").val(),
			},
			success:function(result){
				var num = new Number(result);
				if(num == 1){
					window.location = "./login";
				}else if(num == 0){
					alert("Dados inválidos!");
				}
					
			},
			error:function(e1,e2,e3){
				console.log(e1);
				console.log(e2);
				console.log(e3);
			}
		})
		
		e.preventDefault();
		
	});
	
}
