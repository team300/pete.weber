<%@page contentType="text/html; charset=Windows-31J"%>

<HTML>
<BODY>

<H2>�哖����I</H2>

<%
String message = (String)request.getAttribute("message");
if(message != null){
	out.println(message);
}
%>

</BODY>
</HTML>