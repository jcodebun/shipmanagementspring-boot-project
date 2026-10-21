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
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login/addshipment" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="senderName">
						<label for="inputEmail4" class="form-label">Sender Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				<div class="col">
				<div class="form-group ">
					<s:bind path="receiverName">
						<label for="inputEmail4" class="form-label">Receiver Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Receiver Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="senderEmail">
						<label for="inputEmail4" class="form-label">Sender Email</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Email" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				<div class="col">
				<div class="form-group ">
					<s:bind path="receiverEmail">
						<label for="inputEmail4" class="form-label">Receiver Email</label>
						<sf:input  path="${status.expression}"
							placeholder="Enter Receiver Email" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="senderMobile">
						<label for="inputEmail4" class="form-label">Sender Mobile</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Mobile No." class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				<div class="col">
				<div class="form-group ">
					<s:bind path="receiverMobile">
						<label for="inputEmail4" class="form-label">Receiver Mobile</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Receiver Mobile No." class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>	
			<div class="row">
				<div class="col">
				<div class="form-group">
					<s:bind path="senderAddress">
						<label for="inputEmail4" class="form-label">Sender Address</label>
						<sf:textarea path="${status.expression}"
							placeholder="Enter Sender Address" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
				<div class="col">
				<div class="form-group ">
					<s:bind path="receiverAddress">
						<label for="inputEmail4" class="form-label">Receiver Address</label>
						<sf:textarea path="${status.expression}"
							placeholder="Enter Receiver Address" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</div>
			</div>	
			<div class="row">
				<div class="form-group ">
					<s:bind path="shipmentDetails">
						<label for="inputEmail4" class="form-label">Enter Shipment Information</label>
						<sf:textarea path="${status.expression}"
							placeholder="Enter Shipment Information" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
			</div>
			<div class="row">
				<div class="form-group ">
					<s:bind path="shipmentWeight">
						<label for="inputEmail4" class="form-label">Shipment Weight</label>
						<sf:input type="number" path="${status.expression}"
							placeholder="Enter Weight" class="form-control" />	
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
			</div>
				
				<div class="container col d-flex justify-content-center mt-3">
				<input type="submit" class="btn btn-dark mb-4" value="Proceed" name="operation"> or
            	<input type="submit" class="btn btn-outline-dark  mb-4" value="Reset" name="operation">
				</div>
				 
				
			</sf:form>
		</div>
	</div>
</div>

