<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="el.*"%>

<html>
<body>

<h2>EL�̃e�X�g</h2>

<%
   //����
   User user = new User();
   user.setName("���Y");
   user.setMale(true);
   request.setAttribute("user", user);
%>

<pre>
���O�� ${user.name}

�j�ł����H ${user.male}

���Ȃ݂� ${user}
</pre>

</body>
</html>
