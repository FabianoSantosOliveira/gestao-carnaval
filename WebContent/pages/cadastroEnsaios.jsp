<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestão Carnaval</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/EnsaioServlet" method="post">

<h2>Cadastro de Ensaios</h2>

Endereço:<input type="text" name="endereco"><br/>
Data : <input type="text" name="data"><br/>
Horário : <input type="text" name="horario"><br/>

${mensagem}

<br/><br/>

<input type="submit" value="Cadastrar">
<input type="submit" value="voltar" name="btnVoltar">

</form>

</body>
</html>