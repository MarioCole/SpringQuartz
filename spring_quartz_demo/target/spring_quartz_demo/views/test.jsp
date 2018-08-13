<%--
  Created by IntelliJ IDEA.
  User: 18784
  Date: 2018/8/8
  Time: 21:52
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
            jobName = "";
            jobName = "";
            cronExpression = "";
        }
    </script>
</head>
<body>
    <h2 style="color: #ff261a;">this is my test page!</h2>
    <form action="/testJob/addJob" method="get">
        <table>
            <tr>
                <td>任务名称</td>
                <td><input type="text" id="jobName" name="jobName"/></td>
            </tr>
            <tr>
                <td>执行时间</td>
                <td><input type="text" id="cronExpression" name="cronExpression"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交任务" id="submit"/></td>
                <td><input type="button" value="重置" onclick="reset()"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
