<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


    <c:forEach var="user" items="${users}">

        <p><a href="/profile?userId=${user.id}">
                ${user.firstName},
                ${user.secondName}
        </a></p>

        <form action="/users" method="post">

            <input type="hidden" name="userId" value="${user.id}">
            <input type="hidden" name="userBlocked" value="${user.blocked}">

            <c:if test="${user.blocked == 'true'}">
                <button type="submit"> UNBLOCK</button>
            </c:if>

            <c:if test="${user.blocked == 'false'}">
                <button type="submit"> BLOCK </button>
            </c:if>
        </form>
    </c:forEach>

</div>

</body>
</html>
