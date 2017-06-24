<%-- 
    Document   : index
    Created on : 23/06/2017, 20:39:10
    Author     : gianluca
--%>

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

    </script>
    <body style="background-color: #1e4f8a">
        <h1>Bem Vindo ao Apontadora</h1>
        <form id="formindex" name="formindex" action="Servlet_Principal" method="post">
            <h1 style="position: relative;"> Preencha os Campos abaixo: </h1>
            <label style="color: cornsilk"  > Origem: </label><br>
            <label> X: </label>
            <input type="number" name="X_origem" id="X_origem" size="5"value="<%//colocar funcao aqui=%>"/>
            <label> Y: </label>
            <input type="number" name="Y_origem" id="Y_origem" size="5"value="<%//colocar funcao aqui=%>"/><br>
            <label style="color: cornsilk"  > Entrega 1: </label><br>
            <label> X1: </label>
            <input type="number" name="X1" id="X1" size="5"value="<%//colocar funcao aqui=%>"/>
            <label> Y1: </label>
            <input type="number" name="Y1" id="Y1" size="5"value="<%//colocar funcao aqui=%>"/><br>
            <label style="color: cornsilk"  > Entrega 2: </label><br>
            <label> X2: </label>
            <input type="number" name="X2" id="X2" size="5"value="<%//colocar funcao aqui=%>"/>
            <label> Y2: </label>
            <input type="number" name="Y2" id="Y2" size="5"value="<%//colocar funcao aqui=%>"/><br>
            <label style="color: cornsilk"  > Entrega 3: </label><br>
            <label> X3: </label>
            <input type="number" name="X3" id="X3" size="5"value="<%//colocar funcao aqui=%>"/>
            <label> Y3: </label>
            <input type="number" name="Y3" id="Y3" size="5"value="<%//colocar funcao aqui=%>"/><br>
            <label style="color: cornsilk"  > Entrega 4: </label><br>
            <label> X4: </label>
            <input type="number" name="X4" id="X4" size="5"value="<%//colocar funcao aqui=%>"/>
            <label> Y4: </label>
            <input type="number" name="Y4" id="Y4" size="5"value="<%//colocar funcao aqui=%>"/><br>

            <input type="hidden" name="acaoCRUD" id="acaoCRUD"> <br>

            <input class="buttons" type="button" onclick="salvar()"  name="acaoCRUD"value="Salvar"/>
            <input class="buttons" type="button" onclick="limpar()"  value="Limpar"/>

            <input type="hidden" name="acao" value="cadastro"/>    <%-- joga pro servlet acao == cadastro --%>      
        </form>
    </body>
</html>
