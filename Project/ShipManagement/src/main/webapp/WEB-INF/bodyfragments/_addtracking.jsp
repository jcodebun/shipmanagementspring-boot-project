<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">Update Tracking Details</div>
		
		<div class="card-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login/addtracking" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
				<sf:hidden path="id"/>
				<div class="row">
					<div class="col">
				<div class="form-group ">
					<s:bind path="shipmentId">
						<label for="inputEmail4" class="form-label">Tracking Id</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="trackingId" itemValue="id"  items="${trackingList}" /> 
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				</div>
			
				<div class="row">
					<div class="col">
				<div class="form-group ">
					<s:bind path="description">
						<label for="inputEmail4" class="form-label">Add Description</label>
								<sf:textarea  path="${status.expression}"
							placeholder="Enter Description" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				</div>	
				<div class="container col d-flex justify-content-center mt-3">
				<input type="submit" class="btn btn-dark mb-4" value="Save" name="operation"> or
            	<input type="submit" class="btn btn-outline-dark  mb-4" value="Reset" name="operation">
				</div>
			</sf:form>
		</div>
	</div>
</div>	
				