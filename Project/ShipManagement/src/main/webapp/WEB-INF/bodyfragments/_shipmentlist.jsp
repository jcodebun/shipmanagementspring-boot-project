<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/home/login/addshipment" />

<c:url var="addSearch" value="/home/login/shipments/search" />

<c:url var="editUrl" value="/home/login/shipments?id=" />

<div class="container-fluid px-4">
<sf:form method="post"
	action="${pageContext.request.contextPath}/home/login/shipments/search"
	modelAttribute="form">
	<div class="row g-3 my-2">
	<h3 class="fs-4 mb-3 text-white text-center" >Shipment List</h3>
		<div class="col">
			<div class="p-3   ">
				<div>
					<s:bind path="senderName">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm"
							placeholder="Search By Sender Name" />
					</div>
				</s:bind>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="p-3 ">
				<div>
					<s:bind path="receiverName">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm"
							placeholder="Search By Receiver Name" />
					</div>
				</s:bind>
				</div>
			</div>
		</div>
		
	</div>
	<div class="row text-center">
			<div class="p-3  ">
				<div>					
					<input type="submit" class="btn btn btn-dark"
						name="operation" value="Search"></input> or <input type="submit"
						class="btn btn btn-outline-dark" name="operation"
						value="Reset">
				
				</div>
			</div>
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
						<th scope="col" width="50">#</th>
						<th scope="col">Sender Name</th>
						<th scope="col">Receiver Name</th>
						<th scope="col">Sender Email</th>
						<th scope="col">Receiver Email</th>
						<th scope="col">Tracking Id</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="shipment_list" varStatus="s">
					<tr>
						<c:if test="${sessionScope.user.id==shipment_list.userid || sessionScope.user.roleId==1}">
						<th scope="row">${s.index+1}</th>
						<td>${shipment_list.senderName}</td>
						<td>${shipment_list.receiverName}</td>
						<td>${shipment_list.senderEmail}</td>
						<td>${shipment_list.receiverEmail}</td>
						<td>${shipment_list.trackingId}</td>
						</c:if>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
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
	</sf:form>
</div>
