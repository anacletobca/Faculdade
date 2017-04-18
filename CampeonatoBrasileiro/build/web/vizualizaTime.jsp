

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Torcedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controle.ControlaTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
                  /*Torcedor torcedor = new Torcedor();
                  List lista = new ArrayList();
                  lista = torcedor.listaTimesPorTorcedor();
                  Iterator it = lista.iterator();
                  while (it.hasNext()) {
                  out.println(it.next());
                  out.println("<br>");
                  }*/
                  ControlaTime teste = new ControlaTime();
                  teste.buscaTime(request, response);
                

        %>
    </body>

</html>
