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
    <title>Login</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
			integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
			crossorigin="anonymous">
	</script>
	<script src="./assets/js/login.js"></script>
	<style>
    	#login-div{
    		width:400px;
    	}
    </style>
</head>
<body>
    
    <div align="center">
    
        <div id="login-div">
	    
	    	<fieldset>
	    		
	    		<legend>Acesso Restrito</legend>

	    		<form id="flogin">
	    			<input type="text" id="nome" placeholder="Insira seu usuário..."  autofocus required><br/><br/>
	    			<input type="password" id="senha" placeholder="Insira sua senha..." required><br/><br/>
	    			<input type="submit" value="Entrar">	    			
	    			
	    		</form>
	    		
	    	</fieldset>
	    		
	    </div>
    
    
    </div>
    
	
    
</body>
</html>