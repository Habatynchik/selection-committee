<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


    <p> ${user.firstName}</p>
    <p> ${user.secondName}</p>

    HISTORY:
    <c:forEach var="application" items="${applications}">

        <p><a href="/application?id=${application.id}">
                ${application.recruitment.startDate} -
                ${application.recruitment.endDate},
                ${application.recruitment.name},
                ${application.state}
        </a></p>
    </c:forEach>

</div>

</body>
</html>
