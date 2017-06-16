<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script>
            function deleteUser(pid){
                if(confirm('Do you realy want to delete this user?')){
                    var url= 'delete/'+pid;
                    window.location.href=url;
                }
            }
        </script>
    </head>

    <body>
        <a href="home.jsp">Home</a>
        <c:url var="action" value="/user/add"></c:url>
        <form:form method="post" action="${action}" commandName="user">
            <table>
                <c:if test="${!empty user.name}">
                <tr>
                    <td>
                        <label>Id</label>
                    </td>
                    <td>
                        <form:input type="text" path="id"/>
                    </td>
                </tr>
                </c:if>
                <tr>
                    <td>
                        <label>Email</label>
                    </td>
                    <td>
                        <form:input type="email" path="email"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Name</label>
                    </td>
                    <td>
                        <form:input type="text" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Password</label>
                    </td>
                    <td>
                        <form:input type="password" path="pass"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Registration Date</label>
                    </td>
                    <td>
                        <form:input type="text" path="regdate"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${! empty user.name}">
                            <input type="submit" value="Update"/>
                        </c:if>
                        <c:if test="${ empty user.name}">
                            <input type="submit" value="Add user"/>
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>
        <h3> List of User</h3>
        <c:if test="${! empty userList}">
            <table>
                <tr>
                    <td>User Email</td>
                    <td>User Name</td>
                    <td>Password</td>
                    <td>Registration Date</td>
                    <td>Action</td>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.name}</td>
                        <td>${user.pass}</td>
                        <td>${user.regdate}</td>
                        <td><a href="/SpringHiberMVC/edit/${user.id}">Edit</a>
                            <a href="#" onclick="javascript:deleteUser(${user.id})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:if>
    </body>
</html>
