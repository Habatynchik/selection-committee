<%@include file="../jsp/jspf/head.jspf" %>

<body>


<%@include file="jspf/header.jspf" %>

<div id="registration">
    <div class="container">
        <div id="registration-row" class="row justify-content-center align-items-center mt-4">
            <div id="registration-column" class="col-md-6">
                <div id="registration-box" class="col-md-12">
                    <form id="registration-form" autocomplete="off" class="form"
                          action="${pageContext.request.contextPath}/registration" method="post">


                        <div class="form-group">
                            <label for="login"><fmt:message key="registrationPage.login"/>:</label><br>
                            <input type="text" name="login" value="${requestScope.login}" id="login" maxlength="64"
                                   class="form-control">
                        </div>
                        <c:if test="${requestScope.loginSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.loginSizeOutOfBoundsException"/></p>
                        </c:if>
                        <c:if test="${requestScope.loginIsReserved}">
                            <p class="error-message"><fmt:message key="registrationPage.exception.loginIsReserved"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="email"><fmt:message key="registrationPage.email"/>:</label><br>
                            <input type="text" name="email" value="${requestScope.email}" id="email" maxlength="128"
                                   class="form-control">
                        </div>
                        <c:if test="${requestScope.emailSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.emailSizeOutOfBoundsException"/></p>
                        </c:if>
                        <c:if test="${requestScope.emailIsReserved}">
                            <p class="error-message"><fmt:message key="registrationPage.exception.emailIsReserved"/></p>
                        </c:if>
                        <c:if test="${requestScope.emailNotMatchTemplateException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.emailNotMatchTemplateException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="password"><fmt:message key="registrationPage.password"/>:</label><br>
                            <input type="password" name="password" id="password" maxlength="64" class="form-control">
                        </div>
                        <c:if test="${requestScope.passwordSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.passwordSizeOutOfBoundsException"/></p>
                        </c:if>
                        <c:if test="${requestScope.passwordNotMatchTemplateException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.passwordNotMatchTemplateException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="passwordCopy"><fmt:message key="registrationPage.confirmPassword"/>:</label><br>
                            <input type="password" name="passwordCopy" id="passwordCopy" class="form-control">
                        </div>
                        <c:if test="${requestScope.passwordsNotSameException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.passwordsNotSame"/></p>
                        </c:if>
                        <div class="form-group">
                            <label for="firstName"><fmt:message key="registrationPage.firstName"/>:</label><br>
                            <input type="text" name="firstName" value="${requestScope.firstName}" id="firstName"
                                   maxlength="32" class="form-control">
                        </div>
                        <c:if test="${requestScope.firstNameSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.firstNameSizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="secondName"><fmt:message key="registrationPage.secondName"/>:</label><br>
                            <input type="text" name="secondName" value="${requestScope.secondName}" id="secondName"
                                   maxlength="32" class="form-control">
                        </div>
                        <c:if test="${requestScope.secondNameSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.secondNameSizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="patronymic"><fmt:message key="registrationPage.patronymic"/>:</label><br>
                            <input type="text" name="patronymic" value="${requestScope.patronymic}" id="patronymic"
                                   maxlength="32" class="form-control">
                        </div>
                        <c:if test="${requestScope.patronymicSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.patronymicSizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="region"><fmt:message key="registrationPage.region"/>:</label><br>
                            <input type="text" name="region" value="${requestScope.region}" id="region" maxlength="128"
                                   class="form-control">
                        </div>
                        <c:if test="${requestScope.regionSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.regionSizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="city"><fmt:message key="registrationPage.city"/>:</label><br>
                            <input type="text" name="city" value="${requestScope.city}" id="city" maxlength="128"
                                   class="form-control">
                        </div>
                        <c:if test="${requestScope.citySizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.citySizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="form-group">
                            <label for="institution"><fmt:message key="registrationPage.institution"/>:</label><br>
                            <input type="text" name="institution" value="${requestScope.institution}" id="institution"
                                   maxlength="128" class="form-control">
                        </div>
                        <c:if test="${requestScope.institutionSizeOutOfBoundsException}">
                            <p class="error-message"><fmt:message
                                    key="registrationPage.exception.institutionSizeOutOfBoundsException"/></p>
                        </c:if>

                        <div class="text-center mt-3">
                            <button type="submit" class="btn btn-primary"><fmt:message
                                    key="registrationPage.signUpButton"/></button>
                        </div>
                    </form>

                    <a href="/login">login</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>