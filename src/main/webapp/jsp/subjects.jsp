<%@ page import="ua.epam.elearn.selection.committee.model.entity.Subject" %>
<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <%-- code --%>


    <c:forEach var="subject" items="${subjectList}">
        <li><a style="color: darkcyan" href="/view_faculty?id=${subject.id}">
            <c:out value="${subject.nameEn}"/></a></li>
    </c:forEach>


    <a href="/add_subject" class="btn btn-primary">Add new Subject</a>


</div>

</body>
</html>
