<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestão Carnaval</title>
</head>
<body>
<h3>Cadastro de Escola de Samba</h3>

<form action="<%=request.getContextPath()%>/EscolaServlet" method="post">

Cnpj: <input type="text" name="cnpj"/><br/>
Nome: <input type="text" name="nome"/><br/>
Login: <input type="text" name="login"/><br/>
senha: <input type="text" name="senha"/><br/>
<br/>

${mensagem}

<br/><br/>

<input type="submit" value="cadastrar"/>
<input type="submit" value="voltar" name="btnVoltar"/>

</form>
</body>
</html>