<%-- 
    http://struts.apache.org/docs/jsp.html

--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h1 class="page-header">Send a message</h1>

<s:if test="hasErrors()">
  <div id="message_erreur"/>
    <s:fielderror />
    <s:actionerror/>
  </div>
</s:if>

<div id="enveloppe">
  <h3>Send a message</h3>
  <s:form method="post" action="send" enctype="multipart/form-data">
    <s:select name="destinator" label="To" headerKey="" headerValue="Select destinator" list="destinatorList" />
    <s:textfield name="object" label="Subject" cssClass="input form-control"/>
    <s:textarea name="content" label="Content" cols="40" rows="10"/>
    <s:file name="fileUpload" label="Add a piece" size="40" />
    <s:submit value="Send"/>
  </s:form>
</div>
