<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">


  <div class="row">
    <div class="col-sm-6 mx-auto">
      <div class="card border-0 shadow">

        <div class="card-header">
          <h5> New Recruitment</h5>
        </div>
        <div class="card-body">

          <h5 class="card-title">Special title treatment</h5>
          <form class="mb-3" action="${pageContext.request.contextPath}/add_recruitment" method="post">
            <div class="modal-body">

              <input type="hidden" name="facultyId" value="${facultyId}">

              <div class="mb-3">
                <label for="name" class="col-form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name">
              </div>

              <div class="mb-3">
                <label for="startDate" class="col-form-label">Start Date:</label>
                <input type="date" class="form-control" id="startDate" name="startDate">
              </div>

              <div class="mb-3">
                <label for="endDate" class="col-form-label">End Date:</label>
                <input type="date" class="form-control" id="endDate" name="endDate">
              </div>
            </div>

            <c:if test="${requestScope.emptyFieldException}">
              <div class="alert alert-warning" role="alert">
                <fmt:message key="exception.emptyFieldException"/>
              </div>
            </c:if>

            <c:if test="${requestScope.dateNotMatchTemplateException}">
              <div class="alert alert-warning" role="alert">
                <fmt:message key="exception.dateNotMatchTemplateException"/>
              </div>
            </c:if>

            <c:if test="${requestScope.dateOutOfDateException}">
              <div class="alert alert-warning" role="alert">
                <fmt:message key="exception.dateOutOfDateException"/>
              </div>
            </c:if>

            <c:if test="${requestScope.endDateBeforeStartDateException}">
              <div class="alert alert-warning" role="alert">
                <fmt:message key="exception.endDateBeforeStartDateException"/>
              </div>
            </c:if>

            <div class="modal-footer">
              <button id="click" type="submit" class="btn btn-primary">Ok</button>
            </div>
          </form>
        </div>



      </div>
    </div>
  </div>

</div>

</body>
</html>
