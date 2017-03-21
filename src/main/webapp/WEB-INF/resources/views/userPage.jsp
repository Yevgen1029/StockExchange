<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp" %>
<table id="table-top" class="table-view">
    <tr>
        <th width="45%" class="table-vertical-align-top">
            <table class="table-bordered" width="96%">
                <tr class="table-row-cell">
                    <th colspan="3">Stock prices</th>
                </tr>
                <tr class="table-row-cell">
                    <th>Company</th>
                    <th width="25%">Value</th>
                    <th width="25%">Actions</th>
                </tr>
                <c:forEach var="StockExchande" items="${stockCompanies}">
                    <form:form action="/buy" method="post" modelAttribute="">
                        <tr class="table-row-cell">
                            <td>${StockExchande.code}</td>
                            <td>${StockExchande.price}</td>
                            <td>
                                <input type="text">
                                <input type="submit" value="Buy"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </td>
                        </tr>
                    </form:form>
                </c:forEach>
            </table>
        </th>
        <th width="45%" class="table-vertical-align-top">
            <table class="table-bordered" width="100%">
                <tr class="table-row-cell">
                    <th colspan="5">My wallet</th>
                </tr>
                <tr class="table-row-cell">
                    <th width="25%">Company</th>
                    <th width="25%">Unit price</th>
                    <th width="20%">Amount</th>
                    <th width="15%">Value</th>
                    <th width="15%">Actions</th>
                </tr>
                <c:forEach var="userCompany" items="${companies}">
                    <tr class="table-row-cell">
                        <td>${userCompany.code}</td>
                        <td>${userCompany.price}</td>
                        <td>${userCompany.amount}</td>
                        <td>${userCompany.amount*userCompany.price}</td>
                        <td>
                            <form action="/sell" method="post">
                                <input type="submit" value="Sell">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5" id="wallet">Available money: <b>${user.wallet} PLN</b></td>
                </tr>
            </table>
        </th>
    </tr>
</table>
<%@include file="template/footer.jsp" %>
