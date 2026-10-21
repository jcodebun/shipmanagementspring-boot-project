<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

		<div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
			<i class="fas fa-truck me-2"></i> Ship Management
		</div>
		<div class="list-group list-group-flush my-3">
			<a href="#" class="list-group-item list-group-item-action bg-transparent second-text active">
				<i class="fas fa-tachometer-alt me-2"></i> 
			</a>
			<a href="<c:url value="/home"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-home me-2"></i> Home
			</a>
			<c:if test="${sessionScope.user != null}">
			<c:if test="${sessionScope.user.roleId == 1}">
			<a href="<c:url value="/home/login/customers/search"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-user me-2"></i> Customers  List
			</a>
			<a href="<c:url value="/home/login/shipments/search"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-truck me-2"></i> Shipments List
			</a>
			<a href="<c:url value="/home/login/addtracking"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-eye me-2"></i> Update Tracking Info
			</a>
			<a href="<c:url value="/home/login/trackshipment/search"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-paper-plane me-2"></i> Tracking List
			</a>
			<a href="<c:url value="/home/login/addcost"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-money me-2"></i> Update Cost
			</a>
			<a href="<c:url value="/home/login/viewcost"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-dollar me-2"></i> View Added Cost
			</a>
			
			
			
			</c:if>
			<c:if test="${sessionScope.user.roleId == 2}">
			<a href="<c:url value="/home/login/viewcost"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-dollar me-2"></i> View Cost
			</a>
			<a href="<c:url value="/home/login/addshipment"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-truck me-2"></i> Add Shipments
			</a>
			<a href="<c:url value="/home/login/shipments/search"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-project-diagram me-2"></i> Shipments List
			</a>
			<a href="<c:url value="/home/login/trackshipment/search"/>" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
				<i class="fas fa-truck me-2"></i> Track Shipments
			</a>
			</c:if>
			</c:if>
			
			<c:if test="${sessionScope.user == null}">
					<a class="list-group-item list-group-item-action bg-transparent second-text fw-bold"
						 href="<c:url value="/home/login"/>"><i class="fas fa-user me-2"></i>  SignIn</a>
					<a class="list-group-item list-group-item-action bg-transparent second-text fw-bold "
						 href="<c:url value="/home/create"/>"><i class="fas fa-user-plus me-2"></i> Register</a>
					<a class="list-group-item list-group-item-action bg-transparent second-text fw-bold "
						 href="<c:url value="/aboutus"/>"><i class="fas fa-user-circle me-2"></i> About Us</a>	 
						 
			</c:if>
			
			
		</div>
	
