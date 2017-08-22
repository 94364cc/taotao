<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>文件上传下载</title>
</head>
<form action="/file/upload" method="POST" ENCTYPE="multipart/form-data">
	<input type="file" name="file" width="120px"/><br>
	<button type="submit" value="上传">上传</button>
</form>