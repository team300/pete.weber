<%@page contentType="text/html; charset=Windows-31J"%>

<HTML>
<BODY>

<H2>�������ăQ�[��</H2>
<P>(�Z�b�V�����o�[�W����)

<P>0�`9�̐���������Ă�������
<FORM ACTION="../servlet/session.GuessServlet">
	<INPUT TYPE="TEXT" NAME="number">
	<INPUT TYPE="SUBMIT" VALUE="���M">
</FORM>

<%
String message = (String)request.getAttribute("message");
if(message != null){
	out.println(message);
}
%>

</BODY>
</HTML>
