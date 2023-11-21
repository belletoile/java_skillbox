<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<body>

<h2>Employee info</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>

    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <form:errors path="salary"/>

    <br>
    <input type="submit" value="OK"/>

</form:form>

</body>
</html>