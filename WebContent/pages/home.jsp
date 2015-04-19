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

<h5>Perfil do Usuário: ${perfil}</h5><br/>

Funcionalidades:

<c:choose>
    <c:when test="${perfil.equals('ADMINISTRADOR')}">
       <ul>
			<li><a href="<%=request.getContextPath()%>/pages/cadastroEscola.jsp">Cadastramento das Escolas de Samba</a></li>
			<li><a href="<%=request.getContextPath()%>/pages/cadastroQuesitos.jsp">Cadastramento dos Quesitos</a></li>
			<li><a href="<%=request.getContextPath()%>/JuradosServlet">Cadastramento dos Jurados</a></li>
		</ul>
    </c:when>
    <c:when test="${perfil.equals('ESCOLA_SAMBA')}">
       <ul>
			<li><a href="<%=request.getContextPath()%>/pages/cadastroIntegrantes.jsp">Cadastramento dos Integrantes</a></li>
			<li><a href="<%=request.getContextPath()%>/pages/cadastroEnsaios.jsp">Cadastramento dos Ensaios </a></li>
		</ul>
    </c:when>
    
</c:choose>





</body>
</html>