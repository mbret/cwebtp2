<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasErrors()">
  <div id="message_erreur"/>
    <s:fielderror />
    <s:actionerror/>
  </div>
</s:if>

<div id="enveloppe">
  <s:form method="post" action="validateSignup" cssClass="form-signin">
    <h2 class="form-signin-heading">Sign up</h2>
    <%--<s:textfield name="id"  type="email" cssClass="input" label="id"/>--%>
    <s:password name="password" cssClass="input form-control" label="Password"/>
    <s:textfield name="email" cssClass="input form-control" label="email"/>
    <%--<s:textfield name="firstname" cssClass="input"/>--%>
    <s:submit value="Signup" cssClass="btn btn-lg btn-primary btn-block"/>
  </s:form>
  <a href="/auth/login">Or sign in</a>
</div>

