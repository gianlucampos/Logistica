<%-- 
    Document   : index
    Created on : 23/06/2017, 20:39:10
    Author     : gianluca
--%>
<%
// Evitar cache das páginas
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apontadora</title>
    </head>   
    <script type="text/javascript">
        function limpar() {
            document.getElementById("X_origem").value = "";
            document.getElementById("Y_origem").value = "";
            document.getElementById("X1").value = "";
            document.getElementById("X2").value = "";
            document.getElementById("X3").value = "";
            document.getElementById("X4").value = "";
            document.getElementById("Y1").value = "";
            document.getElementById("Y2").value = "";
            document.getElementById("Y3").value = "";
            document.getElementById("Y4").value = "";
        }

        function salvar() {
            document.getElementById("acaoCRUD").value = "salvar";
            document.formcad.submit();
        }
        function nao_permite_nulo() {
            if (document.getElementById("X_origem").value === "") {
                alert("Campo X de origem vazio");
                focus(document.getElementById("X_origem"));
                request.setAttribute("pode_calcular", "false");

            } else if (document.getElementById("X1").value === "") {
                alert("Campo X1 vazio");
                focus(document.getElementById("X_origem"));
                request.setAttribute("pode_calcular", "false");

            } else if (document.getElementById("X2").value === "") {
                alert("Campo X2 vazio");
                focus(document.getElementById("X3"));
                request.setAttribute("pode_calcular", "false");

            } else if (document.getElementById("X3").value === "") {
                alert("Campo X3 vazio");
                focus(document.getElementById("X3"));
                request.setAttribute("pode_calcular", "false");

            } else if (document.getElementById("X4").value === "") {
                alert("Campo X4 vazio");
                focus(document.getElementById("X4"));
                request.setAttribute("pode_calcular", "false");

                //-------------------------------------------------------------
            } else if (document.getElementById("Y_origem").value === "") {
                alert("Campo Y de origem vazio");
                focus(document.getElementById("Y_origem"));
                request.setAttribute("pode_calcular", "false");


            } else if (document.getElementById("Y1").value === "") {
                alert("Campo Y1 vazio");
                focus(document.getElementById("Y1"));
                request.setAttribute("pode_calcular", "false");

            } else if (document.getElementById("Y2").value === "") {
                alert("Campo Y2 de origem vazio");
                focus(document.getElementById("Y2"));
                request.setAttribute("pode_calcular", "false");


            } else if (document.getElementById("Y3").value === "") {
                alert("Campo Y3 vazio");
                focus(document.getElementById("Y3"));
                request.setAttribute("pode_calcular", "false");


            } else if (document.getElementById("Y4").value === "") {
                alert("Campo Y4 vazio");
                focus(document.getElementById("Y4"));
                request.setAttribute("pode_calcular", "false");
            }
        <%
            request.setAttribute("pode_calcular", "true");

        %>

        }

    </script>
    <%        if ("true".equals(request.getAttribute("sucesso"))) {

            String rotaX0 = (String) request.getAttribute("melhorX0");
            String rotaX1 = (String) request.getAttribute("melhorX1");
            String rotaX2 = (String) request.getAttribute("melhorX2");
            String rotaX3 = (String) request.getAttribute("melhorX3");
            String rotaX4 = (String) request.getAttribute("melhorX4");

            String rotaY0 = (String) request.getAttribute("melhorY0");
            String rotaY1 = (String) request.getAttribute("melhorY1");
            String rotaY2 = (String) request.getAttribute("melhorY2");
            String rotaY3 = (String) request.getAttribute("melhorY3");
            String rotaY4 = (String) request.getAttribute("melhorY4");
            
            String distancia = (String) request.getAttribute("distancia");

    %>

    <script>
        alert("A Melhor rota é ir por: " + "[" +<%=rotaX0%> + "]" + " " + "[" +<%=rotaY0%> + "]");
        alert("Depois: " + "[" +<%=rotaX1%> + "]" + " " + "[" +<%=rotaY1%> + "]");
        alert("Então vá para: " + "[" +<%=rotaX2%> + "]" + " " + "[" +<%=rotaY2%> + "]");
        alert("Ai siga até: " + "[" +<%=rotaX3%> + "]" + " " + "[" +<%=rotaY3%> + "]");
        alert("Por último: " + "[" +<%=rotaX4%> + "]" + " " + "[" +<%=rotaY4%> + "]");
        alert("Distância total: " + <%=distancia%> + "km");

    </script>

    <%            }
    %>

    <body style="background-color: #1e4f8a">
        <h1>Bem Vindo ao Apontadora</h1>
        <form id="formindex" name="formindex" action="Servlet_Principal" method="post">
            <h1 style="position: relative;"> Preencha os Campos abaixo: </h1>
            <label style="color: cornsilk"  > Origem: </label><br>
            <label> X: </label>
            <input type="number" name="X_origem" id="X_origem" size="5" value="<%%>"/>
            <label> Y: </label>
            <input type="number" name="Y_origem" id="Y_origem" size="5"value="<%%>%>"/><br>
            <label style="color: cornsilk"  > Entrega 1: </label><br>
            <label> X1: </label>
            <input type="number" name="X1" id="X1" size="5"value="<%//%>"/>
            <label> Y1: </label>
            <input type="number" name="Y1" id="Y1" size="5"value="<%//nao permitir nulos%>"/><br>
            <label style="color: cornsilk"  > Entrega 2: </label><br>
            <label> X2: </label>
            <input type="number" name="X2" id="X2" size="5"value="<%//nao permitir nulos%>"/>
            <label> Y2: </label>
            <input type="number" name="Y2" id="Y2" size="5"value="<%//nao permitir nulos%>"/><br>
            <label style="color: cornsilk"  > Entrega 3: </label><br>
            <label> X3: </label>
            <input type="number" name="X3" id="X3" size="5"value="<%//nao permitir nulos%>"/>
            <label> Y3: </label>
            <input type="number" name="Y3" id="Y3" size="5"value="<%//nao permitir nulos%>"/><br>
            <label style="color: cornsilk"  > Entrega 4: </label><br>
            <label> X4: </label>
            <input type="number" name="X4" id="X4" size="5"value="<%//nao permitir nulos%>"/>
            <label> Y4: </label>
            <input type="number" name="Y4" id="Y4" size="5"value="<%//nao permitir nulos%>"/><br>
            <br><br> 
            <button class="botao" type="submit" onclick="nao_permite_nulo()" style="width: 103px; height: 32px;" value="Calcula"></button>
            <input type="button" style="width: 103px; height: 32px;"onclick="limpar()"  value="Limpar"/>
            <input type="hidden" name="acao" id="acao" value="calcular"/>
        </form>
    </body>
</html>
