<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 8/1/14
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page='../common/header.jsp'/>
<body>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Parent Id</th>
                <th>Parent Ids</th>
                <th>Priority</th>
                <th>Available</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="organization" items="${organizations}">
                <tr>
                    <td><c:out value="${organization.id}"/></td>
                    <td><c:out value="${organization.name}"/></td>
                    <td><c:out value="${organization.parentId}"/></td>
                    <td><c:out value="${organization.parentIds}"/></td>
                    <td><c:out value="${organization.priority}"/></td>
                    <td><c:out value="${organization.enabled}"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form role="form" action="/organization/${organization.id}" method="post">
            <a href="/organization/${organization.id}">edit</a>
        </form>

        <form role="form" action="/organization/${organization.id}" method="post">
            <input name="_method" type="hidden" value="delete" />
            <button type="submit" class="btn btn-link">delete</button>
        </form>

        <%--
        <c:forEach var="hotel" items="${hotels}">
            <tr>
                <td>${hotel.name}</td>
                <td>${hotel.type}</td>
                <td>${hotel.description}</td>
                <td>${hotel.phone}</td>
                <td>${hotel.address}</td>
                <td>
                    <a href="hotel/update?id=${hotel.id}">edit</a>
                </td>
            </tr>
        </c:forEach>
        --%>
    </div>
    <div class="col-md-4"></div>
</div>
</div>
</body>
</html>
