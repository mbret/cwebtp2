<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 12/29/2014
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h1>List of message for user: <s:property value="user.email"/></h1>

<h3>Message sent</h3>
<ul>
  <s:iterator value="messagesSent">
    <li>
      Message: from: <s:property value="from"/>, to: <s:property value="to"/>, subject: <s:property value="object"/>, content: <s:property value="content"/>
    </li>
  </s:iterator>
</ul>

<h3>Message received</h3>
<ul>
  <s:iterator value="messagesReceived">
    <li>
      Message: from: <s:property value="from"/>, to: <s:property value="to"/>, subject: <s:property value="object"/>, content: <s:property value="content"/>
    </li>
  </s:iterator>
</ul>


