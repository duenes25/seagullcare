<!-- Check for any errors -->
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>


<!-- Check for any messages -->
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>
