<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

  <body>
    <tiles:insertAttribute name="menu" /><br/>
    <hr/>
    <tiles:insertAttribute name="body" /><br/>
    <hr/>
    <tiles:insertAttribute name="footer" /><br/>
  </body>

</html>
