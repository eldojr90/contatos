$(document).ready(function(){
	
	$("#div-form").hide();
	
	logout();
	
	getInitialData();
	
	showFormNewContact();
	
	cancel();
	
	novoContato();
	
});

function showFormNewContact(){
	$("#novo-contato").click(function(){
		$("#div-form").fadeIn(2000);
		var p = $("#div-form").position().top;
		$('html, body').animate({scrollTop:p}, 1000);
		$("#nome").focus();
	});
}

function cancel(){
	$("#cancel").click(function(e){
		$("#div-form").fadeOut(1000);
		e.preventDefault();
	});
}

function logout(){
	
	$("#logout").click(function(){
		
		$.ajax({
			url:"./logout",
			type:"POST",
			success:function(result){
				var result = new Number(result);
				if(result == 1){
					window.location = "./login";
				}
			},
			error:function(e1,e2,e3){
				console.log(e1);
				console.log(e2);
				console.log(e3);
			}
		})
		
	});
	
}

function excluirContato(){
	$(".excluir-contato").click(function(){
		var vals = this.id.split(":");
		var opt = confirm("Deseja excluir o contato de "+vals[1]+"?");

	});
}

function getInitialData(){
	
	$.ajax({
		url:"./home",
		type:"POST",
		success:function(data){
			
			if(data != ""){
				
				var json_data = JSON.parse(data);
				
				var usuario_logado = json_data.nome;
				var contatos = JSON.stringify(json_data.contatos);
				
				$("#usuario_logado").html(usuario_logado);
				$("#tabContatos").html(data);
				
				excluirContato();
			}
			
		},
		error:function(e1,e2,e3){
			console.log(e1);
			console.log(e2);
			console.log(e3);
		}
	});
	
}

function novoContato(){
	
	$("#fnovo-contato").submit(function(e){
		
		dados = {
				nome: $("#nome").val(),
				sobrenome: $("#sobrenome").val(),
				tel: $("#tel").val(),
				nascimento: $("#nascimento").val(),
				endereco: $("#endereco").val(),
				email: $("#email").val()
		}
		
		$.ajax({
			url:"./novo-contato",
			type:"POST",
			data: dados,
			success:function(result){
				
				result_number = new Number(result);
				
				if(result_number == 1){
					getInitialData();
				}else{
					alert(result);
				}
				
				
			},
			error:function(e1,e2,e3){
				console.log(e1);
				console.log(e2);
				console.log(e3);
			}
		});
		
		
		e.preventDefault();
		
	});
	
}