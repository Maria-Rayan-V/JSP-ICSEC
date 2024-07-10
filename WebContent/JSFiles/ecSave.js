function btnEcSaveOnClick()
{
	var objForm = document.forms[0];
	var objHdnClickEvent = null;
	if ( objForm != null)
	{
		objHdnClickEvent = document.getElementById('hdnClickEvent');
		objHdnClickEvent.value = "EcEntry:ECFormSave";
	}
	objForm.submit();
	return true;
}