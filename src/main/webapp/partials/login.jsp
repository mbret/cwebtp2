<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>Login</title>
</head>
  <body>

    <s:if test="hasErrors()">
      <div id="message_erreur"/>
        <s:fielderror />
        <s:actionerror/>
      </div>
    </s:if>

    <div id="enveloppe">
      <h3>Login</h3>
      <s:form method="post" action="validateLogin">
        <s:textfield name="email" cssClass="input" label="email"/>
        <s:password name="password" cssClass="input" label="Password"/>
        <s:submit value="Login"/>
      </s:form>
    </div>

  </body>
</html>