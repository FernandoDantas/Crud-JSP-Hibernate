<%@page import="br.com.fernando.DB.Categoria"%>
<%@page import="br.com.fernando.DB.CategoriaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>
	<form action="http://localhost:8080/Hibernate/Cliente" method="POST">
		Nome: <br><input type="text" name="txtNome">
		<br>
		Sobrenome: <br><input type="text" name="txtSobrenome">
		<br>
		Categoria: <br>
		<select name="cbCat">
			<option value="0">-- Selecione --</option>
			<%
				CategoriaDAO dao = new CategoriaDAO();
				for(Categoria cat : dao.exibir()){
			%>
				<option value="<%=cat.getId() %>"><%=cat.getNome() %></option>
			<%
				}
			%>
		</select>
		<br><br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>