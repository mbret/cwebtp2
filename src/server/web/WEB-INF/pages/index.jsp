<%@ taglib prefix="s" uri="/struts-tags" %>
<%--

  Form tags: http://struts.apache.org/docs/struts-2-form-tags.html
  Tag examples:
    textarea: http://www.mkyong.com/struts2/struts-2-stextarea-textarea-example/
    select: select tag: http://www.mkyong.com/struts2/struts-2-sselect-drop-down-box-example/
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <h1>Index</h1>
  <h2>Your are seeing index page, you do not need to be authenticated here</h2>
  <h3>You are authenticated under: <s:property value="authenticatedUser" /></h3>
  <nav>
    <ul>
      <li><a href="directories/list">See directories</a></li>
      <li><a href="signup">Sign up</a></li>
      <li><a href="auth/login">Login</a></li>
      <li><a href="auth/logout">Logout (Need to be authenticated)</a></li>
      <li><a href="users/list">See users (Need to be authenticated)</a></li>
      <li><a href="messages/add/form">Send a message (Need to be authenticated)</a></li>
      <li><a href="messages/see">See messages (Need to be authenticated)</a></li>
    </ul>
  </nav>

</body>
</html>
