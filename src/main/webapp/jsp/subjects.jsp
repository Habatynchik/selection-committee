<%@ page import="ua.epam.elearn.selection.committee.model.entity.Subject" %>
<%@include file="/jsp/jspf/head.jspf" %>


<body>

<%@include file="/jsp/jspf/header.jspf" %>

<div class="container">

    <%-- code --%>

    <div class="container">
        <div class="row mb-3">
            <div class="col-sm-8"><h2>Subjects <b>Details</b></h2></div>
            <div class="col-sm-4 text-end">
                <a href="/add_subject" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New Subject</a>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <table class="table table-bordered">
                    <thead class="bg-info ">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">NameEn</th>
                        <th scope="col">NameRu</th>
                        <th scope="col">NameUk</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <c:forEach var="subject" items="${subjectList}">
                    <tbody class="bg-light">
                    <tr>
                        <th scope="row">${subject.id}</th>
                        <td>${subject.nameEn}</td>
                        <td>${subject.nameRu}</td>
                        <td>${subject.nameUk}</td>

                        <td>
                            <a href="/view_faculty?id=${subject.id}" class=" btn btn-primary">
                                <i class="fa fa-eye"></i>
                            </a>
                            <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                            <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                        </td>
                    </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>

</body>
</html>
