<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="guess.*"%>

<html>
<body>

<h1>�������ăQ�[��</h1>

<p>�S���̐�������͂��Ă�������

<form action="<%=request.getContextPath()%>/servlet/guess.GuessNumberServlet">

	<p>����
	<input type="text" name="number">

	<p>
	<input type="submit">
	
</form>

<%
	GuessNumber guess = GuessNumber.getInstanceFromSession(request);

	//out.println(guess + "<br>");	

	if(guess.isInputError()){
		
		out.println(guess.getInputErrorMessage());
		
	}else if(guess.getCount() != 0){

		out.println(
			guess.getCount()
			+ "��ڂ̐����u"
			+ guess.getInput()
			+ "�v"
			+ guess.getHit() + "�q�b�g"
			+ guess.getError() + "�G���["
		);
	}
%>

</body>
</html>
