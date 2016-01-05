<%@ page import="java.sql.ResultSet" %>
<%@ page import="cn.DB" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: doctli
  Date: 2015/12/24
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试卷批改页面</title>
</head>
<body>
<a href="teacher.jsp"> <input type="button" value="返回"></a><br>
<%
    String snosql=null;
    String Pnojudege=(String)request.getSession().getAttribute("Pnojudege");
    System.out.println(Pnojudege);
    String sql="select * from testsystem.answer where Pno='"+Pnojudege+"';";
    List<String> Snonum=new ArrayList<>();
    ResultSet rs = (new DB().search(sql));
    while (rs.next()){
        Snonum.add(rs.getString("Sno"));
    }
    request.getSession().setAttribute("Snonum",Snonum);

%>
共有<%=Snonum.size()%>位学生 ，你正在批改第<%=Snonum.indexOf(request.getSession().getAttribute("Sno"))%>位学生<br>
<form action="/SnoanswerServlet?tag=pre"><input type="button" value="上一位学生"></form>
<form action="/SnoanswerServlet?tag=nex"><input type="button" value="下一位学生"></form>
<form action="/SnoanswerServlet?tag=fir"><input type="button" value="第一位学生"></form>
<form action="/SnoanswerServlet?tag=las"><input type="button" value="最末位学生"></form>
<form action="/judegesubmitServlet">
<table>
    <thead>
    <tr>
        <th>学号</th>
        <th>试卷号</th>
        <th>题目</th>
        <th>作答</th>
        <th>分数</th>
    </tr>
    </thead>
    <tbody>
    <%String sno=(String)request.getSession().getAttribute("Sno");
        snosql="select * from testsystem.answer where Pno='"+Pnojudege+"' and Sno ='"+sno+"';";
        System.out.println(snosql);
        ResultSet snors = (new DB().search(snosql));
        while(snors.next()){
    %>
    <tr>
        <td><%=snors.getString("Sno")%></td>
        <td><%=snors.getString("Pno")%></td>
        <td><%=snors.getString("Qno")%></td>
        <td><%=snors.getString("answer")%></td>
        <td><input type="text" name=<%=rs.getString("Qno")%>></td>
    </tr>
    <%}%>
    </tbody>
</table>
    <br>
    <input type="submit" value="提交批改"><form action="/SnoanswerServlet?tag=nex"><input type="button" value="下一位学生"></form>
    <br>
    <form action="/SnoanswerServlet?tag=pre"><input type="button" value="上一位学生"></form>
    <form action="/SnoanswerServlet?tag=fir"><input type="button" value="第一位学生"></form>
    <form action="/SnoanswerServlet?tag=las"><input type="button" value="最末位学生"></form>
    <br>
    <a href="teacher.jsp"><input type="button" value="返回"></a>
</form>
</body>
</html>
