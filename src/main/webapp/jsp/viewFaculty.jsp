<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


    <%-- code --%>
    <h1>Faculty ${faculty.name}</h1>

    <p> id : ${faculty.id}</p>
    <p> name : ${faculty.name}</p>
    <p> generalCapacity : ${faculty.generalCapacity}</p>
    <p> budgetCapacity : ${faculty.budgetCapacity}</p>

    <p> requiredSubjectList:

        <c:forEach var="subject" items="${requiredSubjectList}">
            ${subject.nameEn}
        </c:forEach>
    </p>

    <p>recruitments:</p>
    <p>
        <c:forEach var="recruitment" items="${recruitmentsList}">

            <c:out value="${recruitment.name}"/>
            <c:out value="${recruitment.startDate}"/>
            <c:out value="${recruitment.endDate}"/>
            <c:out value="${recruitment.closed}"/>

        </c:forEach>
    </p>
    <a href="/view_faculty?id=${faculty.id}&command=delete"> Delete </a>
    <br>
    <a href="/view_faculty?id=${faculty.id}&command=change"> Change </a>
    <br>
    <a href="/add_recruitment?id=${faculty.id}"> Open recruitment </a>
    <br>



</div>

</body>
</html>
