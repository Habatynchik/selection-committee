<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <div>
        Sort by:
        <button class="sort-order" type="button" value="name">name</button>
        <button class="sort-order" type="button" value="general_capacity">general capacity</button>
        <button class="sort-order" type="button" value="budget_capacity">budget capacity</button>
    </div>



    <div class="row row-cols-1 row-cols-md-4 g-4">

        <c:forEach var="faculty" items="${facultyList}">

            <div class="col">
                <div class="card h-100">
                    <div class="card-header">
                        <a style="color: darkcyan" href="/view_faculty?id=${faculty.id}">
                            <c:out value="Faculty ${faculty.name}"/></a>
                    </div>

                    <div class="card-body">
                        <h5 class="card-title">Open recruitment</h5>

                        <p class="card-text"> generalCapacity: ${faculty.generalCapacity}</p>
                        <p class="card-text"> budgetCapacity: ${faculty.budgetCapacity}</p>


                    </div>
                </div>
            </div>


        </c:forEach>

        <c:if test="${role == 'ADMIN'}">

            <div class="col">
                <div class="card h-100">
                    <div class="card-header">
                        Add new Faculty
                    </div>

                    <div class="card-body">

                        <form action="/add_faculty" method="get">

                            <button type="submit" class=" btn  h-100 w-100 fs-1">
                                <i class="fa fa-plus"></i>
                            </button>

                        </form>

                    </div>
                </div>
            </div>

        </c:if>


    </div>


    <c:forEach begin="1" end="${pagesNumber}" varStatus="loop">

        <button class="myselect" id="${loop.index}" type="button" value="${loop.index}">${loop.index}</button>

    </c:forEach>


</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pagination.js"></script>
</body>
</html>
