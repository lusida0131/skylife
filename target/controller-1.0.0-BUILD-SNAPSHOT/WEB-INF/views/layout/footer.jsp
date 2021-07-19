<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<footer>
			<div id="footer">
				<div class="container">
					<div class="row row-bottom-padded-md">
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3></h3><ul></ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Jeonghyeon Ko</h3>
							<ul>
								<li><a href="https://github.com/lsc3421">GIT</a></li>
								<li><a href="#">BLOG</a></li>
								<li><a href="#">SNS</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Daseul Kim</h3>
							<ul>
								<li><a href="https://github.com/seulda">GIT</a></li>
								<li><a href="#">BLOG</a></li>
								<li><a href="#">SNS</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Hyeonsoung Park</h3>
							<ul>
								<li><a href="https://github.com/lusida0131">GIT</a></li>
								<li><a href="#">BLOG</a></li>
								<li><a href="#">SNS</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Seungjun You</h3>
							<ul>
								<li><a href="https://github.com/wns1908">GIT</a></li>
								<li><a href="#">BLOG</a></li>
								<li><a href="#">SNS</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3></h3><ul></ul>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<!-- <p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p> -->
							<!-- Design Shared by <a href="https://bootstrapthemes.co">BootstrapThemes</a> -->
							<br>Copyright © 2021. SKYLIFE
							<c:if test="${user.id == 'admin'}" >
								<br>
								<a href="/auth/anonymous" style="color: rgb(57,62,70);">관리자 페이지</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</footer>

	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->
	

	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/sticky.js"></script>

	<!-- Stellar -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="${pageContext.request.contextPath}/resources/js/hoverIntent.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="${pageContext.request.contextPath}/resources/js/classie.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/selectFx.js"></script>
	
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/reply.js"></script>	
</body>
</html>