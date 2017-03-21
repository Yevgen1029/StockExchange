<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/resources/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>User Registration.</h2>
            <p class="lead">Please input your information bellow:</p>

            <spring:url value="/register" var="registerForm"/>
            <form:form action="${registerForm}" method="post" modelAttribute="user">

                <div class="form-group">
                    <label for="username">Name:</label>
                    <form:errors path="username" cssStyle="color: red"/>
                    <form:input path="username" id="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="firstname">First Name: </label>
                    <form:input path="firstName" id="firstname" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="lastname">Last Name: </label>
                    <form:input path="lastName" id="lastname" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="phonenumber">Phone Number: </label>
                    <form:input path="phoneNumber" id="phonenumber" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">
                        <Email></Email>
                        Email:
                        <c:if test="${not empty emailError}">
                            <p style="color: red"> ${emailError}</p>
                        </c:if>
                    </label>
                    <form:input type="email" path="email" id="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">
                        <Password></Password>
                        Password:</label>
                    <form:errors path="password" cssStyle="color: red"/>
                    <form:password path="password" id="password" class="form-control"/>
                </div>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" class="btn btn-default">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/resources/views/template/footer.jsp" %>