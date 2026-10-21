<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page import="in.co.sm.util.*" %>
<%@page import="java.time.*" %>
<%@page import="java.sql.Timestamp.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/home/login/addshipment" />

<c:url var="addSearch" value="/home/login/shipments/search" />

<c:url var="editUrl" value="/home/login/addtracking?id=" />

<div class="container-fluid px-4">
<sf:form method="post"
	action="${pageContext.request.contextPath}/home/login/trackshipment/search"
	modelAttribute="form">
	<div class="row g-3 my-2">
	<h3 class="fs-4 mb-3 text-white text-center" >Tracking List</h3>
		
		
	</div>
	
	<b><%@ include file="businessMessage.jsp"%></b>


		<sf:input type="hidden" path="pageNo" />
		<sf:input type="hidden" path="pageSize" />

		<sf:input type="hidden" path="listsize" />
		<sf:input type="hidden" path="total" />
		<sf:input type="hidden" path="pagenosize" />
	<div class="row my-5">
		
		<div class="col">
			<table class="table bg-white rounded shadow-sm table-hover">
				<thead>
					<tr>
					<c:if test="${sessionScope.user.roleId == 1}">
							<th scope="col">Select
								</th>
						</c:if>
						<th scope="col" width="50">#</th>
						<th scope="col">Tracking Id</th>
						<th scope="col">Date & Time</th>
						<th scope="col">Description</th>
						<c:if test="${sessionScope.user.roleId == 1}">
						<th scope="col">Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="track_list" varStatus="s">
					<tr>
						<c:if test="${sessionScope.user.id==track_list.shipment.userid || sessionScope.user.roleId==1}">
						<c:if test="${sessionScope.user.roleId == 1}">
								<td><input type="checkbox" class="case" name="ids"
									value="${track_list.id}"></td>
							</c:if>
						<th scope="row">${s.index+1}</th>
						<td>${track_list.shipment.trackingId}</td>
						<td>${track_list.createdDatetime}</td>
						<td>${track_list.description}</td>
						</c:if>
						<c:if test="${sessionScope.user.roleId == 1}">
								<td class="col" width="50">
								<div class="btn-group">
								<a href="${editUrl}${track_list.id}"
									class="btn btn-warning">Edit</a>
									
									
									</div></td>
									</c:if>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
		<div class="clearfix">
		<c:if test="${sessionScope.user.roleId == 1}">
		<input type="submit" name="operation"
					class="btn btn-sm btn-danger float-start"
					<c:if test="${listsize == 0}">disabled="disabled"</c:if>
					value="Delete"></c:if>
		<nav aria-label="Page navigation example float-end">
				<ul class="pagination justify-content-end" style="font-size: 13px">
					<li class="page-item"><input type="submit" name="operation"
						class="page-link"
						<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
						value="Previous"></li>
					<c:forEach var="i" begin="1" end="${(listsize/10)+1}">
						<c:if test="${i== pageNo}">
							<li class="page-item active"><a class="page-link activate"
								href="${addSearch}?pageNo=${i}">${i}</a></li>
						</c:if>
						<c:if test="${i != pageNo}">
							<li class="page-item"><a class="page-link"
								href="${addSearch}?pageNo=${i}">${i}</a></li>
						</c:if>
					</c:forEach>
					<li class="page-item"><input type="submit" name="operation"
						class="page-link"
						<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
						value="Next"></li>
				</ul>
			</nav>
			</div>
	</div>
	</sf:form>
</div>
