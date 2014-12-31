<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>Inscription</title>
</head>
  <body>

    <s:if test="hasErrors()">
      <div id="message_erreur"/>
        <s:fielderror />
        <s:actionerror/>
      </div>
    </s:if>

    <div id="enveloppe">
      <h3>Signup</h3>
      <s:form method="post" action="validateSignup">
        <%--<s:textfield name="id"  type="email" cssClass="input" label="id"/>--%>
        <s:password name="password" cssClass="input" label="Password"/>
        <s:textfield name="email" cssClass="input" label="email"/>
        <%--<s:textfield name="firstname" cssClass="input"/>--%>
        <s:submit value="Signup"/>
      </s:form>
    </div>

  </body>
</html>