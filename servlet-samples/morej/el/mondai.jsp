<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="java.util.*, el.User"%>

<html>
<body>

<h2>���K���</h2>

<%
   List list = new ArrayList();
   list.add(new User("���Y",true));
   list.add(new User("���Y",true));
   list.add(new User("�Ԏq",false));
   request.setAttribute("list",list);
%>

${list[2].name}
��
${list[2].male ? "�j" : "�j�ȊO"}

</body>
</html>
