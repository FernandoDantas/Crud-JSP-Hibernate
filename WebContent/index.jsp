<%@page import="java.util.List"%>
<%@page import="br.com.fernando.DB.Cliente"%>
<%@page import="br.com.fernando.DB.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function apagar(id){
		if (window.confirm("Deseja realmente apagar este cliente?")){
			window.location = 'http://localhost:8080/Hibernate/Cliente?delete=' + id;
		}
	}
</script>
</head>
<body>
<table width="100%">
		<tr bgcolor="#c0c0c0">
			<td>ID</td>
			<td>Nome</td>
			<td>Categoria</td>
			<td>Apagar</td>
			<td>Editar</td>
		</tr>
		<%
		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> lista = null;
		
		if(request.getParameter("txtNome") != null){
			lista = dao.exibir_by_name(request.getParameter("txtNome"));
		} else {
			lista = dao.exibir();
		}
		
		for(Cliente c : lista){		
		%>
		<tr>
			<td><%=c.getId() %></td>
			<td><%=c.getNome() %></td>
			<td><%=c.getCat().getNome() %></td>
			<td><a href="#" onclick="apagar('<%=c.getId() %>');">[APAGAR]</a></td>
			<td><a href="editar.jsp?id=<%=c.getId() %>">[EDITAR]</a></td>
		</tr>
		<%
			}
		%>
</table>
<a href="novo.jsp">Novo Cliente</a>
<br><br>
<form method="GET">
	Nome: <input type="text" name="txtNome" value="<% if (request.getParameter("txtNome") != null)out.println(request.getParameter("txtNome"));%>">
	<input type="submit" value="Filtrar">
</form>
</body>
</html>