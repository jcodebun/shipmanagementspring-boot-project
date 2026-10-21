<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="container">
	<div class="card shadow bg-bg" style="margin: 5rem;">
		<div class="card-header card-font text-center">View Cost By Weight</div>
		
		<div class="card-body">
			<div class="row">
				<div class="col">
				<div class="form-group">
				<c:if test="${bean.getCost1()==null || bean.getCost2()==null }">
				<table class="table table-bordered">
						<tr class="bg-info">
							<th class="col text-center">Weight</th>
							<th class="col text-center">Cost</th>
						</tr>
						<tr>
							<td class="col text-center"> <= 100 Kg</td>
							<td class="col text-center">10 &#x20b9  /kg</td>
						</tr>
						<tr>
							<td class="col text-center"> > 100 Kg</td>
							<td class="col text-center">10 &#x20b9  /kg</td>
						</tr>
					</table>				
				</c:if>
				<c:if test="${bean.getCost1()>0 || bean.getCost2()>0 }">
					<table class="table table-bordered">
						<tr class="bg-info">
							<th class="col text-center">Weight</th>
							<th class="col text-center">Cost</th>
						</tr>
						<tr>
							<td class="col text-center"> <= 100 Kg</td>
							<td class="col text-center">${bean.getCost1() } &#x20b9  /kg</td>
						</tr>
						<tr>
							<td class="col text-center"> > 100 Kg</td>
							<td class="col text-center">${bean.getCost2() } &#x20b9  /kg</td>
						</tr>
					</table>
				</c:if>
					
				</div>
				</div>
				
			</div>
			
	</div>
</div>

