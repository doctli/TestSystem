<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎使用考务管理系统</title>
</head>


<body style=" width:100%;height: 100% ;background-size: 100%;overflow: hidden" background="/image/bg.jpg">

<form action="/loginServlet" method="get">
<div style="width:600px; margin:0 auto;margin-top:150px; height:300px; background-image:url(image/bg1.png); border-radius:10px;">
    <center>
        <div style="height:75px; line-height:75px; color:#069; font-weight:bolder; font-size:24px">
            用户名：<input type="text" name="userno" value="" style="height:24px" ></div>
        <div style="height:75px; line-height:75px; color:#069; font-weight:bolder; font-size:24px">
            密&nbsp;码：<input type="password" name="password" value="" style="height:24px"></div>
        <div style="height:75px; line-height:75px; color:#069; font-weight:bolder; font-size:24px">
            &nbsp;<input type="radio" name="identity" style="width:20px; height:20px" value="teacher">教师&nbsp;
            &nbsp;<input type="radio" value="student" name="identity" checked=checked style="width:20px; height:20px">学生</div>
        <div style="height:75px; line-height:75px;">
            &nbsp;<input type="submit"  value="登录系统" style="width:200px; height:40px; color:#069; font-weight:bolder; font-size:20px;"></div>
    </center>
</div>

<div style="width:600px; margin:0 auto;margin-top:40px; height:200px;  background-image:url(/image/bg1.png); border-radius:10px;">
    <div style="height:84px; margin-left:10px;">
        <br>
        <span style=" display:block"><a href ="message1.jsp">通知</a></span>
    </div>
    <hr style="">
    <div style="height:84px; margin-left:10px">
        <span style=" display:block"><a href ="message2.jsp">通告</a></span>
    </div>
</div>
</form>
<%System.out.print("");%>
</body>
</html>
