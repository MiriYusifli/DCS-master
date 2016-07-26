<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:if test="${not empty ErrorArg}">
<spring:message code="${ErrorKey}" arguments="${ErrorArg}"/>
</c:if>
<c:if test="${empty ErrorArg}">
<spring:message code="${ErrorKey}"/>
</c:if>
