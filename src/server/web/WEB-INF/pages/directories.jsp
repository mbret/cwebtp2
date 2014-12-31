<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 12/29/2014
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>Struts 2 Iterator tag example</h1>

<h3>Directories</h3>
<ul>
  <s:iterator value="directories">
    <li>Directory: <s:property value="name"/></li>
  </s:iterator>
</ul>

<h3>Directories sorted by name</h3>
<s:bean name="miage.bean.comparator.DirectoryNameComparator" var="nameComparator" />
<ul>
  <s:sort comparator="#nameComparator" source="directories">
    <s:iterator value="directories">
      <li>Directory: <s:property value="name"/></li>
    </s:iterator>
  </s:sort>
</ul>

<h3>Directories sorted by nb users</h3>
<s:bean name="miage.bean.comparator.DirectoryNbUsersComparator" var="userComparator" />
<ul>
  <s:sort comparator="#userComparator" source="directories">
    <s:iterator value="directories">
        <li>Directory:
            <ul>
                <li>Name: <s:property value="name"/></li>
                <li>Nb users: <s:property value="nbUsers"/></li>
            </ul>
        </li>
    </s:iterator>
  </s:sort>
</ul>

<h3>Directories with more than 2 users</h3>
<s:subset decider="usersDecider" source="directories">
  <ul>
      <s:iterator>
          <li>Directory:
            <ul>
              <li>Name: <s:property value="name"/></li>
              <li>Nb users: <s:property value="nbUsers"/></li>
            </ul>
          </li>
      </s:iterator>
  </ul>
</s:subset>


</body>
</html>
