<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pmDetail.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


	<div class="receipt-content">
		<div class="container bootstrap snippets bootdey">
			<div class="row">
				<div class="col-md-12">
					<div class="invoice-wrapper">
						<div class="intro">
							Hi <strong>${user.name}</strong>, <br>
							This is the receipt for a payment of <strong>&nbsp;₩&nbsp;<fmt:formatNumber value="${pmdlist.amount_total}" pattern="#,###,###" /></strong> (KRW) for your works
						</div>
	
						<div class="payment-info">
							<div class="row">
								<div class="col-sm-6">
									<span>Payment No.</span> <strong>${pmdlist.tid}</strong>
								</div>
								<div class="col-sm-6 text-right">
									<span>Payment Date</span> <strong>${pmdlist.approved_at}</strong>
								</div>
							</div>
						</div>
	
						<div class="payment-details">
							<div class="row">
								<div class="col-sm-6">
									<span>Client</span> <strong> ${user.name} </strong>
									<p>
										${user.bday} <br>
										${user.phone} <br>
										KOREA <br>
										<a href="#">${user.email}</a>
									</p>
								</div>
								<div class="col-sm-6 text-right">
									<span>Payment To</span> <strong> TEAM SKYLIFE </strong>
									<p>
										2021-06-27 <br>
										GANGSEO, SEOUL <br>
										KOREA <br>
										<a href="#">skylife@gmail.com</a>
									</p>
								</div>
							</div>
						</div>
	
						<div class="line-items">
							<div class="headers clearfix">
								<div class="row">
									<div class="col-xs-4">Description</div>
									<div class="col-xs-3">Quantity</div>
									<div class="col-xs-5 text-right">Amount</div>
								</div>
							</div>
							<div class="items">
								<div class="row item">
									<div class="col-xs-4 desc">Plane Ticket</div>
									<div class="col-xs-3 qty">${pmdlist.quantity}</div>
									<div class="col-xs-5 amount text-right">₩ <fmt:formatNumber value="${pmdlist.amount_total - pmdlist.amount_vat}" pattern="#,###,###" /></div>
								</div>
								<div class="row item">
									<div class="col-xs-4 desc">Value Added Tax</div>
									<div class="col-xs-3 qty">${pmdlist.quantity}</div>
									<div class="col-xs-5 amount text-right">₩ <fmt:formatNumber value="${pmdlist.amount_vat}" pattern="#,###,###" /></div>
								</div>
							</div><br><br>
							
							<div class="total text-right">
								<p class="extra-notes">
									<strong>Extra Notes</strong>
									If there is any problem, please contact SKYLIFE or airline customer service center. Thanks a lot.
								</p>
								<div class="field">
									Subtotal <span>₩ <fmt:formatNumber value="${pmdlist.amount_total - pmdlist.amount_vat}" pattern="#,###,###" /></span>
								</div>
								<div class="field">
									VAT <span>₩ <fmt:formatNumber value="${pmdlist.amount_vat}" pattern="#,###,###" /></span>
								</div>
								<div class="field">
									Discount <span>0.0%</span>
								</div>
								<div class="field grand-total">
									Total <span>₩ <fmt:formatNumber value="${pmdlist.amount_total}" pattern="#,###,###" /></strong></span>
								</div>
							</div><br>
							
							<div class="print">
								<a href="#"><i class="fa fa-print"></i>Print this receipt</a>
							</div>
						</div>
					</div>
					<div class="footer">Copyright © 2021. SKYLIFE</div><br>
				</div>
			</div>
		</div>
	</div>
	
		
		

<%@ include file="../layout/footer.jsp"%>

