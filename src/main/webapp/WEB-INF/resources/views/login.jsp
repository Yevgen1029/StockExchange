<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/resources/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Email and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="error" style="color: #ff0000;">${error}</div>
            </c:if>

            <spring:url value="/j_spring_security_check" var="loginForm"/>
            <form:form action="${loginForm}"  method="post" modelAttribute="user">
                <%--<div class="form-group">--%>
                    <%--<label for="email">Email: </label>--%>
                    <%--<input type="text" id="email" name="email" class="form-control"/>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="password">Password:</label>--%>
                    <%--<input type="password" id="password" name="password" class="form-control"/>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label for="email"><Email></Email>Email:</label>
                    <form:input path="email" id="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password"><Password></Password>Password:</label>
                    <form:password path="password" id="password" class="form-control"/>
                </div>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" class="btn btn-default">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form:form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/resources/views/template/footer.jsp" %>