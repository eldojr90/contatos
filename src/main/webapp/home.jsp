<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
			integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
			crossorigin="anonymous">
	</script>
	<script src="./assets/js/home.js"></script>
	<style>
    	
    	#contatos-table, #div-form{
    		margin-top:20px;
    	}
    	
    	td{
    		text-align:center;
    	}
    	
    </style>
</head>
<body>
    
    <div align="center">
    
        <div id="home-div">
	    	
	    	<div id="div-tab">
		    
		    	<h2>Olá <span id="usuario_logado"></span></h2>
		    	<button id="logout">Sair</button>
		    	
		    	<table id="contatos-table" border="1px">
		    		<thead>
		    			<th>Nome</th>
		    			<th>Sobrenome</th>
		    			<th>Telefone</th>
		    			<th>Idade</th>
		    			<th>Endereço</th>
		    			<th>Email</th>
		    			<th><button id="novo-contato">Novo Contato</button></th>
		    		</thead>
		    		<tbody id="tabContatos">
		    			
		    		</tbody>
		    	</table>
    		
    		</div>
    		
    		<div id="div-form">
    			
    			<fieldset>
	    		
		    		<legend>Novo contato</legend>
	
		    		<form id="fnovo-contato">
						
						<label>Nome:</label>
		    			<input type="text" id="nome" autofocus required><br/><br/>
						<label>Sobrenome:</label>
						<input type="text" id="sobrenome" required><br/><br/>
						<label>Telefone:</label>
						<input type="text" id="tel" required><br/><br/>
						<label>Data de Nascimento:</label>
						<input type="date" id="nascimento" required><br/><br/>
						<label>Endereço:</label>
						<input type="text" id="endereco" required><br/><br/>
						<label>Email:</label>
						<input type="email" id="email" required><br/><br/>
		    			<input type="submit" value="Salvar"><br/><br/>
		    		</form>
		    		<button id="cancel">Cancelar</button>
	    		
	    		</fieldset>
    		</div>
	    		
	    </div>
    
    
    </div>
    
	
    
</body>
</html>