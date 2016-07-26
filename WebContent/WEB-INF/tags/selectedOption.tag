<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="filtr"  required="true" %>
<%@ attribute name="dataMap"  required="true" type="java.util.Map" %>

    <c:forEach  var="item" items="${dataMap}">
       <option value="${item.key}"
       <c:if test="${Filtr==item.key}"> selected="selected" </c:if>
       >
        
        ${item.value}
       </option>
    </c:forEach>