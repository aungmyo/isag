<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>send sms</title>
</head>
<body>
	<form id="messageForm" action="${pageContext.request.contextPath }/sendSms.do" method="post">
		<div>
			<label id="addressLabel">号码：</label>
			<input id="address" name="address" type="text"/>
		</div>
		<div>
			<label id="messageLable">短信：</label>
			<input id="message" name="message" type="text"/>
		</div>
		<div>
			<input id="submitButton" name="submitButton" type="submit" value="发送"/>
		</div>
	</form>
</body>
</html>