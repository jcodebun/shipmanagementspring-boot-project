<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">Update Cost</div>
		
		<div class="card-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login/addcost" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="cost1">
						<label for="inputEmail4" class="form-label">Enter Cost for Weight Less than Equal to 100</label>
						<sf:input type="number" path="${status.expression}"
							placeholder="Enter Cost for Weight Less than Equal to 100" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				
			</div>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="cost2">
						<label for="inputEmail4" class="form-label">Enter Cost for Weight greater than 100</label>
						<sf:input type="number" path="${status.expression}"
							placeholder="Enter Cost for Weight greater than 100" class="form-control" />
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

