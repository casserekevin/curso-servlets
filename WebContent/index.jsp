<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		Bem vindo ao nosso gerenciador de empresas!<br/>
		
		
		<c:if test="${not empty usuarioLogado}">
			Logado como ${usuarioLogado.getEmail()}
		</c:if>
		
		<form action="executa" method="POST">
			<input type="hidden" name="tarefa" value="NovaEmpresa">
			Nome: <input type="text" name="nome"/>
			<input type="submit" name="Enviar"/>
		</form>
		
		<form action="executa" method="POST">
			<input type="hidden" name="tarefa" value="Login">
			Email: <input type="email" name="email">
			Senha: <input type="password" name="senha">
			<input type="submit" value="Enviar">
		</form>
		
		<form action="executa" method="POST">
			<input type="hidden" name="tarefa" value="Logout"> 
			<input type="submit" value="Deslogar">
		</form>
	</body>
</html>
