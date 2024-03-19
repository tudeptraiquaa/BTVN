<%-- 
    Document   : viewPage
    Created on : Mar 16, 2024, 9:40:23 AM
    Author     : tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" uri="/WEB-INF/tlds/custom_tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        Total View: ${total}
        <myTag:ConvertToVnDate value="11-12-2003"></myTag:ConvertToVnDate>
    </body>
</html>
