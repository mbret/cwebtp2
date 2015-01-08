<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%--<form class="form-signin">--%>
  <%--<h2 class="form-signin-heading">Please sign in</h2>--%>
  <%--<label for="inputEmail" class="sr-only">Email address</label>--%>
  <%--<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">--%>
  <%--<label for="inputPassword" class="sr-only">Password</label>--%>
  <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">--%>
  <%--<div class="checkbox">--%>
    <%--<label>--%>
      <%--<input type="checkbox" value="remember-me"> Remember me--%>
    <%--</label>--%>
  <%--</div>--%>
  <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
<%--</form>--%>

<s:if test="hasErrors()">
  <div id="message_erreur"/>
    <s:fielderror />
    <s:actionerror/>
  </div>
</s:if>

<div id="enveloppe" >
  <s:form method="post" action="validateLogin" cssClass="form-signin">
    <h2 class="form-signin-heading">Please sign in</h2>
    <s:textfield name="email" cssClass="input form-control" label="email"/>
    <s:password name="password" cssClass="input form-control" label="Password"/>
    <s:submit value="Login" cssClass="btn btn-lg btn-primary btn-block"/>
  </s:form>
  <a href="/signup">Or sign up</a>
</div>

