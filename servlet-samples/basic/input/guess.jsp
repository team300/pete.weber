<%@page contentType="text/html; charset=Windows-31J"%>

<HTML>
<BODY>

<H2>数字当てゲーム</H2>

0〜9の数字をいれてください
<FORM ACTION="../servlet/input.GuessServlet">
	<INPUT TYPE="TEXT" NAME="number">
	<INPUT TYPE="SUBMIT" VALUE="送信">
</FORM>

</BODY>
</HTML>
