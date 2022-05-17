<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


    <%-- code --%>
    <h1>Faculties</h1>


    <ol>
        <c:forEach var="faculty" items="${facultyList}">
            <li><a style="color: darkcyan" href="/view_faculty?id=${faculty.id}">
                <c:out value="${faculty.name}"/></a></li>
        </c:forEach>
    </ol>

    <c:if test="${role == 'ADMIN'}">

        <form action="/add_faculty" method="get">

            <button type="submit" class="btn btn-primary">Add new Faculty
            </button>

        </form>

    </c:if>



</div>

</body>
</html>
