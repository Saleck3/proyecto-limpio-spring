<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${direcciones}" var="each">
    ${each.calle}
</c:forEach>