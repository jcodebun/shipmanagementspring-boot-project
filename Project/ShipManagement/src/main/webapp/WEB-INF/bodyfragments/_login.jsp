<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">Login</div>
		
		<div class="card-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
				<div class="form-group">
					<s:bind path="login">
						<label for="inputEmail4" class="form-label">Email</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Email" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="form-group mt-2">
					<s:bind path="password">
						<label for="inputEmail4" class="form-label">Password</label>
						<sf:input type="password" path="${status.expression}"
							placeholder="Enter Password" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="container col d-flex justify-content-center mt-3">
				<input type="submit" class="btn btn-dark mb-4" value="Login" name="operation"> or
            	<input type="submit" class="btn btn-outline-dark  mb-4" value="Reset" name="operation">
				</div>
				 
				
			</sf:form>
		</div>
	</div>
</div>

