<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">Add Shipment</div>
		
		<div class="card-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login/changepassword" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="oldPassword">
						<label for="inputEmail4" class="form-label">Old Password</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Old passsword" class="form-control" type="password" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="newPassword">
						<label for="inputEmail4" class="form-label">New Password</label>
						<sf:input type="password" path="${status.expression}"
							placeholder="Enter New Password" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="confirmPassword">
						<label for="inputEmail4" class="form-label">Confirm Password</label>
						<sf:input type="password" path="${status.expression}"
							placeholder="Enter Confirm Password" class="form-control" />
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

