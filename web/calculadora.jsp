<%-- 
    Document   : calculadora
    Created on : 04-mar-2016, 17:05:06
    Author     : 2DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculadora</h1>
        <%=request.getAttribute("resultado")!=null ? request.getParameter("op1")+request.getParameter("oper")+request.getParameter("op2")+"="+request.getAttribute("resultado"):""%>
        <br>
        <p>Introduzca números con los que operar</p>
        <br>
        <form action="calculadora" method="POST">
            <label>Número 1</label>
            <input type="text" name="op1" size="10" 
                   value="<%=request.getParameter("op1")!=null ? request.getParameter("op1"):""%>">
            <br>
            <label>Operación</label>
            <select name="oper">
                <option value="+" <%=request.getParameter("oper")=="+" ? "selected":""%>>Sumar
                <option value="-" <%=request.getParameter("oper")=="-" ? "selected":""%>>Restar
                <option value="*" <%=request.getParameter("oper")=="*" ? "selected":""%>>Multiplicar
                <option value="/" <%=request.getParameter("oper")=="/" ? "selected":""%>>Dividir
            </select>
            <br>
             <label>Número 2</label>
            <input type="text" name="op2" size="10"
                    value="<%=request.getParameter("op2")!=null ? request.getParameter("op2"):""%>">
            <br>
            <input type="submit" value="[Realizar Operación]">
        </form>
            
    </body>
</html>
