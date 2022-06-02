<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <%-- code --%>


    <div class="row">
        <div class="col-sm-6 mx-auto">
            <div class="card border-0 shadow">

                <div class="card-header">
                    <h5> New Application </h5>
                </div>

                <div class="card-body">
                    <h5 class="card-title">Input marks, please</h5>

                    <form action="/create-application" method="post">

                        <input type="hidden" name="recruitmentId" value="${recruitmentId}">
                        <input type="hidden" name="userId" value="${user.id}">

                        <div class="modal-body">


                            <div class="form-floating mb-3">
                                <div class="row  row-cols-lg-3 g-2 g-lg-3 ">
                                    <c:forEach var="subject" items="${requiredSubjectList}">

                                        <div class="form-floating mb-3">

                                            <input type="number" class="form-control"
                                                   id="${subject.id}" name="grades">
                                            <label for=${subject.id}> ${subject.nameEn} </label>

                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>

                        <c:if test="${requestScope.UserAlreadyAppliedException}">
                            <div class="alert alert-warning" role="alert">
                                <fmt:message key="exception.UserAlreadyAppliedException"/>
                            </div>
                        </c:if>

                        <c:if test="${requestScope.InvalidNumberException}">
                            <div class="alert alert-warning" role="alert">
                                <fmt:message key="exception.InvalidNumberException"/>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.InvalidGradeException}">
                            <div class="alert alert-warning" role="alert">
                                <fmt:message key="exception.InvalidGradeException"/>
                            </div>
                        </c:if>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary"> Submit</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
