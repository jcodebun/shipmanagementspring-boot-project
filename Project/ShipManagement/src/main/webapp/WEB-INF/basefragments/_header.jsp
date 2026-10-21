<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<nav
	class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
	<div class="d-flex align-items-center">
		<i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggler"></i>
		<!-- <h2 class="fs-2 m-0">Dashboard</h2> -->
	</div>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#navbarSupfportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		<c:if test="${sessionScope.user != null}">
		<li><a   class="dropdown-item">Welcome,${sessionScope.user.firstName} (${sessionScope.user.roleName })</a></li>
			
		<li><a href="<c:url value="/home/login/myprofile"/>" class="dropdown-item">My Profile</a></li>
			<li><a href="<c:url value="/home/login/changepassword"/>" class="dropdown-item">Change Password</a></li>
			<li><a href="<c:url value="/home/login"/>" class="dropdown-item">Logout</a></li>
		</ul>
		
		
		
			
		</c:if>
		
	</div>
</nav>


<script type="text/javascript">
var a = document.getElementById("wrapper")
var toggledButton = document.getElementById("menu-toggler")
toggledButton.onclick = function(){
	a.classList.toggle("toggled")
}

</script>