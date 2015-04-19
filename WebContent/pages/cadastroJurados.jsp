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

<h3>Cadastro de Jurados</h3>

<form action="<%=request.getContextPath()%>/JuradosServlet" method="post">

Nome Jurado: <input type="text" name="nome"/><br/>
Quesitos: 
 		<select name="quesito">
          <c:forEach var="item" items="${listaQuesitos}">
            <option value="${item.id}">${item.nome}</option>
          </c:forEach>
        </select>

<br/>

${mensagem}

<br/><br/>

<input type="submit" value="cadastrar"/>
<input type="submit" value="voltar" name="btnVoltar"/>

</form>

</body>
</html>