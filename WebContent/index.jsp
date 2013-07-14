
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Product for QR Code</title>
</head>
<body>

<p>
This page will allow the user to enter a drug ID, and generate a QR code on the fly.
</p>
<!-- This will send our input to drug_input_action.asp, which we will get via servlets -->
<form name="input" action="drug_input_action.asp" method="get">
Drug ID (for now, can only enter 1): <input type="text" name="drugId" >
<input type="submit" value="Submit"">
</form>
</body>

</html>