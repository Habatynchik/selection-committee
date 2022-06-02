<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">
    <h1>
        <c:out value="${recruitment.name}"/>
    </h1>


    <c:forEach var="application" items="${applicationList}">

        <p>

            <a href="/application?id=${application.id}"> Check application </a>

            <c:out value="${application.user.firstName}"/>
            <c:out value="${application.user.secondName}"/>

            Average Score:
            <c:out value="${application.averageGrade}"/>

            <c:out value="${application.state}"/>


        </p>
    </c:forEach>


</div>

</body>
</html>
