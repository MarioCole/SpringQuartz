<%--
  Created by IntelliJ IDEA.
  User: 18784
  Date: 2018/8/14
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript">
        function reset() {
            var jobName = document.getElementById("jobName");
            jobName = "";
        }
    </script>
</head>
<body>
<form action="/testJob/runJobNow" method="get">
    <table>
        <tr>
            <td>任务名称</td>
            <td><input type="text" id="jobName" name="jobName"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交任务" id="submit"/></td>
            <td><input type="button" value="重置" onclick="reset()"/></td>
        </tr>
    </table>
</form>
</body>
</html>
