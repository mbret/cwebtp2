<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 12/29/2014
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h1>Users</h1>

<h3>List</h3>
<ul>
  <s:iterator value="users">
    <li>
      User: <s:property value="email"/>
      <ul>
        <li>

        </li>
      </ul>
    </li>
  </s:iterator>
</ul>

