<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">Pay</div>
		
		<div class="card-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/home/login/addshipment/pay" modelAttribute="form"><br/>
				<b><%@ include file="businessMessage.jsp"%></b>
			
			<table class="table table-bordered bg-white rounded shadow-sm table-hover">
				<tr>
					<td>Sender Name</td>
					<td><s:bind path="senderName">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control"/>
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Receiver Name</td>
					<td><s:bind path="receiverName">
						<sf:input path="${status.expression}"
							placeholder="Enter Receiver Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Sender Email</td>
					<td><s:bind path="senderEmail">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" disabled="disabled" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Receiver Email</td>
					<td><s:bind path="receiverEmail">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Sender Mobile</td>
					<td><s:bind path="senderMobile">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Receiver Mobile</td>
					<td><s:bind path="receiverMobile">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Sender Address</td>
					<td><s:bind path="senderAddress">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Receiver Address</td>
					<td><s:bind path="receiverAddress">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Sender Details</td>
					<td><s:bind path="shipmentDetails">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr>
					<td>Sender Weight</td>
					<td><s:bind path="shipmentWeight">
						<sf:input path="${status.expression}"
							placeholder="Enter Sender Name" class="form-control" />
					
					</s:bind></td>
				</tr>
				<tr class="bg-info"><td>Total Charges <td><strong>${price}</strong> &#x20b9</td></tr>
			</table>	
			
			<div class="container">
				<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Payment Page
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      	<div class="form-outline mb-3">
                <input
                  type="text"
                  id="formControlLgXM8"
                  class="form-control"
                  placeholder="1234 5678 1234 5678"
                />
                <label class="form-label" for="formControlLgXM8">Card Number</label>
        </div>
        <div class="row mb-3">
                <div class="col-6">
                  <div class="form-outline">
                    <input
                      type="password"
                      id="formControlLgExpk8"
                      class="form-control"
                      placeholder="MM/YYYY"
                    />
                    <label class="form-label" for="formControlLgExpk8">Expire</label>
                  </div>
                </div>
                <div class="col-6">
                  <div class="form-outline">
                    <input
                      type="password"
                      id="formControlLgcvv8"
                      class="form-control"
                      placeholder="Cvv"
                    />
                    <label class="form-label" for="formControlLgcvv8">CVV</label>
                  </div>
                </div>
              </div>
        
      </div>
    </div>
  </div>
  </div>
			</div>
				
				<div class="container col d-flex justify-content-center mt-3">
				<input type="submit" class="btn btn-dark mb-4" value="Save" name="operation">
            	
				</div>
				 
				
			</sf:form>
		</div>
	</div>
</div>

