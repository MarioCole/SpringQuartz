<%--
  Created by IntelliJ IDEA.
  User: 18784
  Date: 2018/8/15
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript">
        function reset() {
            var jobName = document.getElementById("jobName");
            var cronExpression = document.getElementById("time");
            var jobType = document.getElementById("jobType");
            jobName = "";
            cronExpression = "";
            jobType = "";
        }
    </script>
</head>
<body>
<form action="/addJob" method="get">
    <table border="0">
        <tr>
            <td>任务名称</td>
            <td><input type="text" id="jobName" name="jobName"/></td>
        </tr>
        <tr>
            <td>执行时间</td>
            <td><input type="text" id="cronExpression" name="cronExpression"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" id="jobType" name="jobType"/></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td colspan="3"><input type="text" name="startYear"/>年</td>
            <td><input type="text" name="startMonth"/>月</td>
            <td><input type="text" name="startDay"/>日</td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td colspan="3"><input type="text" name="endYear"/>年</td>
            <td><input type="text" name="endMonth"/>月</td>
            <td><input type="text" name="endDay"/>日</td>
        </tr>
        <tr>
            <td><input type="submit" value="提交任务" id="submit"/></td>
            <td><input type="button" value="重置" onclick="reset()"/></td>
        </tr>
    </table>
</form>
</body>
</html>
