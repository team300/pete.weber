<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="java.util.*, el.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<HTML>
<BODY>

<H2>���K���</H2>

<%
   List list = new ArrayList();
   list.add(new User("���Y",true));
   list.add(new User("���Y",true));
   list.add(new User("�Ԏq",false));
   request.setAttribute("userList",list);
%>


<TABLE BORDER="1">
<TR>
	<TH>�ԍ�
	<TH>���O
	<TH>����

<c:forEach var="user" items="${userList}" varStatus="status">
	
<TR>
	<TD>${status.count} 
	<TD>${user.name}
    <TD>
    	<c:choose>
    		<c:when test="${user.male}">
    			�j
    		</c:when>
    		<c:otherwise>
    			�j�ȊO
    		</c:otherwise>
    	</c:choose>

</c:forEach>

</TABLE>

</BODY>
</HTML>
