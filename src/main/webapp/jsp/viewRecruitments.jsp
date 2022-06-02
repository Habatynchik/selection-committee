<%@include file="/jsp/jspf/head.jspf" %>


<body>

<style>
    .card .btn {
        z-index: 2;
        position: relative;
    }
</style>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <div>
        Sort by:
        <button class="sort-order" type="button" value="faculty.name">faculty name</button>
        <button class="sort-order" type="button" value="recruitment.name">name</button>
        <button class="sort-order" type="button" value="start_date">start date</button>
        <button class="sort-order" type="button" value="end_date">end date</button>
    </div>

    <div>
        ${requestScope.containsKey(previous)}
        Filter:
        <div class="form-check form-check-inline">

            <c:if test="${previous}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox3" name="filter-check"
                       value="previous" checked>

            </c:if>
            <c:if test="${!previous}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox3" name="filter-check"
                       value="previous">
            </c:if>

            <label class="form-check-label" for="inlineCheckbox3">previous</label>
        </div>
        <div class="form-check form-check-inline">
            <c:if test="${current}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox2" name="filter-check"
                       value="current" checked>
            </c:if>
            <c:if test="${!current}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox2" name="filter-check"
                       value="current">
            </c:if>

            <label class="form-check-label" for="inlineCheckbox2">current</label>
        </div>
        <div class="form-check form-check-inline">
            <c:if test="${future}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox1" name="filter-check"
                       value="future" checked>
            </c:if>
            <c:if test="${!future}">
                <input class="form-check-input filter-check" type="checkbox" id="inlineCheckbox1" name="filter-check"
                       value="future">
            </c:if>

            <label class="form-check-label" for="inlineCheckbox1">future</label>
        </div>
    </div>

    <div class="row row-cols-1 row-cols-md-4 g-4">

        <c:forEach var="recruitment" items="${recruitmentMap}">


            <div class="col">

                <div class="card h-100">
                    <div class="card-header">
                        Faculty ${recruitment.value.name}

                    </div>
                    <div class="card-body">
                        <a href="/recruitment?recruitmentId=${recruitment.key.id}" class="stretched-link"></a>

                        <h5 class="card-title">Open recruitment</h5>
                        <p class="card-text">${recruitment.key.name}</p>
                        <p class="card-text">${recruitment.key.startDate} - ${recruitment.key.endDate}</p>


                        <form action="/create-application" method="get">
                            <input type="hidden" name="recruitmentId" value="${recruitment.key.id}">
                            <input type="hidden" name="userId" value="${user.id}">

                            <c:choose>
                                <c:when test="${role == 'ADMIN'}">
                                    <button type="submit" class="btn btn-primary disabled">Register</button>
                                </c:when>
                                <c:when test="${recruitment.key.closed == true}">
                                    <button type="submit" class="btn btn-primary disabled">Register</button>
                                </c:when>
                                <c:otherwise>
                                    <button type="submit" class="btn btn-primary ">Register</button>
                                </c:otherwise>
                            </c:choose>
                        </form>

                        <c:if test="${role == 'ADMIN'}">

                            <form action="/close-recruitment" method="post">
                                <input type="hidden" name="recruitmentId" value="${recruitment.key.id}">

                                <button type="submit" class="btn btn-primary ">Close</button>
                            </form>

                        </c:if>


                    </div>

                </div>

            </div>

        </c:forEach>


    </div>

    <div>
        <c:forEach begin="1" end="${pagesNumber}" varStatus="loop">

            <button class="myselect" id="${loop.index}" type="button" value="${loop.index}">${loop.index}</button>

        </c:forEach>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pagination.js"></script>

</body>
</html>
