<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="guess.*"%>

<html>
<body>

<h1>�������ăQ�[��</h1>

<%
	GuessNumber guess = GuessNumber.getInstanceFromSession(request);
%>

<%=guess.getCount()%>��ڂł�����I


<%
	guess.reset();
%>

<p>
<a href="<%=request.getContextPath()%>/guess.jsp">�������</a>

</body>
</html>