<%@page import="br.com.fernando.DB.Categoria"%>
<%@page import="br.com.fernando.DB.CategoriaDAO"%>
<%@page import="br.com.fernando.DB.Cliente"%>
<%@page import="br.com.fernando.DB.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
		<tr bgcolor="#c0c0c0">
			<td>ID</td>
			<td>Nome</td>
			<td>Ordem</td>
		</tr>
		<%
			CategoriaDAO dao = new CategoriaDAO();
			Categoria cat = new Categoria();
			cat.setNome("Comum");
			cat.setOrdem(1);
			//dao.salvar(cat);
			
			for(Categoria c : dao.exibir()){
		%>
		<tr>
			<td><%=c.getId() %></td>
			<td><%=c.getNome() %></td>
			<td><%=c.getOrdem() %></td>
		</tr>
		<%
			}
		%>
</table>
</body>
</html>