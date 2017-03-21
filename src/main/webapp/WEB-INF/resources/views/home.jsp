<%@include file="template/header.jsp"%>
    <%--<table id="home-table-top" class="table-bordered" width="50%">--%>
        <%--<tr class="table-row-cell">--%>
            <%--<th colspan="3">Stock prices</th>--%>
        <%--</tr>--%>
        <%--<tr class="table-row-cell">--%>
            <%--<th>Company</th>--%>
            <%--<th width="32%">Value</th>--%>
            <%--<th width="32%">Actions</th>--%>
        <%--</tr>--%>
        <%--<c:forEach var="company" items="${companies}">--%>
            <%--<tr class="table-row-cell">--%>
                <%--<td>${company.code}</td>--%>
                <%--<td>${company.unitPrice}</td>--%>
                <%--<td>--%>
                    <%--<form action="/buy" method="post">--%>
                        <%--<input type="submit" value="Buy">--%>
                        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
                    <%--</form>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%@include file="template/footer.jsp"%>