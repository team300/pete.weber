<H1>${wikiPage.name} �̕ҏW</H1>

<FORM ACTION="update">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="update">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${wikiPage.name}">


	<TEXTAREA ROWS="15" COLS="60" NAME="content">${wikiPage.content}</TEXTAREA>
	
	<BR>
	<INPUT TYPE="SUBMIT" VALUE="�@�X�V�@">
	<INPUT TYPE="SUBMIT" VALUE="�@�폜�@" ONCLICK="cmd.value='delete'">
	<INPUT TYPE="BUTTON" VALUE="�L�����Z��"  ONCLICK="location.href='refer'">

</FORM>
