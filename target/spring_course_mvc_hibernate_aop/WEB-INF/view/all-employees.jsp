<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Employees</h2>
<br>
<%--создаем шапку таблицы:--%>
<table>
    <tr> <%--данный тег означает table row - строка таблицы--%>
        <%-- тег <th> означает table header - шапка таблицы: --%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>

        <th>Operations</th>

    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo"> <%--горит красным но работает--%>
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee"> <%--горит красным но работает--%>
            <c:param name="empId" value="${emp.id}"/>
        </c:url>



        <tr>
            <%--тег <td> (table data) означает ячейку в таблице--%>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
                onClick = "window.location.href = '${updateButton}' "/>

                <input type="button" value="Delete"
                onClick = "window.location.href = '${deleteButton}' "/>

            </td>

<%--            <td>--%>
<%--                <input type="button" value="Delete"--%>
<%--                onClick = "window.location.href = '${deleteButton}' "/>--%>
<%--            </td>--%>


        </tr>
    </c:forEach>

</table>

<br><br>
<input type="button" value="add"
    onclick="window.location.href = 'addNewEmployee' "/>


</body>
</html>