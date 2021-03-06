<%--
  Created by IntelliJ IDEA.
  User: 18784
  Date: 2018/8/15
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    任务列表：
    <table border="1">
        <tr>
            <td>任务名称</td>
            <td>执行时间</td>
            <td>状态</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${scheduleJobAll}" var="list">
            <tr>
                <td>${list.jobName}</td>
                <td>${list.cronExpression}</td>
                <td>${list.jobState}</td>
                <td>${list.startDate}</td>
                <td>${list.endDate}</td>
                <td><a href="/deleteJob?jobName=${list.jobName}" target="main">删除</a>
                    <a href="/deleteBeforeUpdate?jobName=${list.jobName}" target="main">修改</a>
                    <a href="/runJobNow?jobName=${list.jobName}" target="main">立即执行</a>
                    <a href="/pauseJob?jobName=${list.jobName}" target="main">暂停</a>
                    <a href="/resumeJob?jobName=${list.jobName}" target="main">恢复</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
