<%@page contentType="text/html; charset=Windows-31J"%>

<HTML>
<BODY>

<H1>JSP�̃R�A�v�f</H1>

<H2>�X�N���v�g���b�g</H2>

<%
for(int i=0; i<10; i++){
    out.println("count:" + i + "<br>");
}
%>


<H2>��</H2>

<%="hello" %>

<%= 3 * 4 * 5 %>


<H2>�錾</H2>

<%!
  String message;
%>

<%!
  int add(int a, int b){
     return a + b;
  }
%>


<%
message = "foo";
out.println(message);
%>

<P>

<%= add(1, 2) %>



<H2>�R�����g</H2>

<%--JSP�R�����g--%>

<!--HTML�R�����g-->


<H2>EL</H2>

<%
   java.util.Map map = new java.util.HashMap();
   map.put("key1","hoge");
   request.setAttribute("map", map);
%>

${map.key1}



</BODY>
</HTML>
