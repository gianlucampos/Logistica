<%-- 
    Document   : rota_calculada
    Created on : 26/06/2017, 15:14:01
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        if ("true".equals(request.getAttribute("sucesso"))) {

            String rota = (String) request.getAttribute("xorigem");

    %>

    <script>
        alert("Rota x é:" + <%=rota%>);// Quero passar o numero conta aqui
    </script>

    <%            }
    %>

    <body>
        
    </body>
</html>
