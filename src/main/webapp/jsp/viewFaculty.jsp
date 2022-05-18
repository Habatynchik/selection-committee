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

</div>

</body>
</html>
