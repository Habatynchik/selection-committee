<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


    <h1><a href="/recruitment?recruitmentId=${recruitment.id}"> ${recruitment.name} </a></h1>

    <p>

        <c:out value="${application.user.firstName}"/>
        <c:out value="${application.user.secondName}"/>

        Average Score:
        <c:out value="${application.averageGrade}"/>

        <c:out value="${application.state}"/>


    </p>

    <c:forEach var="subject" items="${application.subjects}">

        <c:out value="${subject.nameEn}"/>
        <c:out value="${subject.grade.grade}"/>

    </c:forEach>


</div>

</body>
</html>
