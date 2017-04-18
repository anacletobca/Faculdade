
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Torcedor</title>
    </head>
    <body>
        <h1>Cadastro de Torcedor</h1>
        <form name="fCadastro" action="ControlaTorcedor" method="POST">
            Email:<input type="text" name="email" value="${emailR}" /><br>
            Nome:<input type="text" name="nome" value="" /><br>
            Sexo:<input type="text" name="sexo" value="" /><br>
            Nasc:<input type="text" name="data" value="" /><br>
            Time: <input type="text" name="time" value="" /><br>
            <input type="submit" value="Entrar"/>
        </form>
    </body>
</html>
