<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <%-- code --%>


    <div class="row">
        <div class="col-sm-6 mx-auto">
            <div class="card border-0 shadow">

                <div class="card-header">
                    <h5> New subject</h5>
                </div>
                <div class="card-body">
                    <h5 class="card-title">Special title treatment</h5>
                    <form action="/add_faculty" method="post">
                        <div class="modal-body">

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput"
                                       placeholder="name@example.com"
                                       name="facultyName">
                                <label for="floatingInput">Faculty name</label>
                            </div>

                            <c:if test="${requestScope.facultyNameIsReserved}">
                                <div class="alert alert-warning" role="alert">
                                    <fmt:message key="loginPage.exception.facultyNameIsReserved"/>
                                </div>
                            </c:if>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" id="floatingPassword" placeholder="Password"
                                       name="generalCapacity">
                                <label for="floatingPassword">General capacity</label>
                            </div>
                            <c:if test="${requestScope.generalCapacityIncorrectException}">
                                <div class="alert alert-warning" role="alert">
                                    <fmt:message key="loginPage.exception.generalCapacityIncorrectException"/>
                                </div>
                            </c:if>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" id="floatingPassword12" placeholder="Password"
                                       name="budgetCapacity">
                                <label for="floatingPassword12">Budget capacity</label>
                            </div>

                            <c:if test="${requestScope.capacityIncorrectException}">
                                <div class="alert alert-warning" role="alert">
                                    <fmt:message key="loginPage.exception.capacityIncorrectException"/>
                                </div>
                            </c:if>

                            <div class="form-floating mb-3">
                                <div class="row  row-cols-lg-3 g-2 g-lg-3 ">
                                    <c:forEach var="subject" items="${subjectList}">

                                        <input type="checkbox" class="btn-check" value="${subject.id}"
                                               id="${subject.id}"
                                               autocomplete="off" name="subjectId">
                                        <label class="btn  p-3 border btn-outline-secondary"
                                               for="${subject.id}"> ${subject.nameEn} </label><br>

                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary"> Send message</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
