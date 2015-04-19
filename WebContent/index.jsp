<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestão Carnaval</title>
</head>
<body>

	
	<form action="UsuarioServlet" method="post">	
			
		Login:<input type="text" name="usuario"> 
		Senha:<input type="password" name="senha">
		<input type="submit" value="Entrar">
		
		<br/></br>
		${mensagem}
			
		<hr>
		
		<br/>
		
		<h2>Cadastro Torcedor</h2>	
		
		Nome:<input type="text" name="nome"> <br/>
		Sobrenome:<input type="text" name="sobrenome"> <br/>
		e-mail:<input type="text" name="email"> <br/>
		Login:<input type="text" name="login"> <br/>
		Senha:<input type="password" name="senhaTorcedor"> <br/>
		sexo :<select name="sexo">
				<option value="M">Masculino</option>
				<option value="F">Feminino</option>
		</select><br/>
		Escola Preferida:<select name="escola">
          <c:forEach var="item" items="${listaEscola}">
            <option value="${item.id}">${item.nomeEscola}</option>
          </c:forEach>
        </select>
		<br/><br/>
		
		${mensagemCadastro}
		
		<input type="submit" value="Cadastrar" name="btnCadastro">
				
	</form>

</body>
</html>