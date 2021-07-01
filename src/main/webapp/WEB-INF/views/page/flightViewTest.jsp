<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		<p>나오나?</p><br>
		<c:forEach var="list" items="${clist}">
			<br>
			항공편명 : ${list.vihicleId} <br>
			항공사 : ${list.airlineNm} <br>
			출발지(출발공항) : ${list.depAirportNm} <br>
			출발시간 : ${list.depPlandTime} <br>
			도착지(도착공항) : ${list.arrAirportNm} <br>
			도착시간 : ${list.arrPlandTime} <br>
			가격1 : ${list.economyCharge} <br>
			가격2 : ${list.prestigeCharge} <br>
			---------- @@@@@ ---------- <br>
		</c:forEach>

		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(/images/imagesair.jpg);">  <!-- 사진 왜 안뜨냐 해결좀요 -->
				<div class="desc">
					<div class="container">
						<div class="row">
							<div class="col-sm-5 col-md-5">
								<!-- <a href="index.html" id="main-logo">Travel</a> -->
								<div class="tabulation animate-box">

									<!-- Nav tabs -->
								    <ul class="nav nav-tabs" role="tablist">
								    	<li role="presentation" class="active">
								      		<a href="#flights" aria-controls="flights" role="tab" data-toggle="tab">Flights</a>
								    	</li>
								    	<!-- <li role="presentation">
								    		<a href="#hotels" aria-controls="hotels" role="tab" data-toggle="tab">Hotels</a>
								    	</li>
								    	<li role="presentation">
								    		<a href="#packages" aria-controls="packages" role="tab" data-toggle="tab">Packages</a>
								    	</li> -->
								    </ul>

								    <!-- Tab panes -->
									<div class="tab-content">
									
										<!-- ################################## FORM TAG HERE ################################## -->
										<form id="flightFrm" name="flightFrm" action="/page/searchFlight" method="post">
											 <div role="tabpanel" class="tab-pane active" id="flights">
												<div class="row">
													<div class="col-xxs-12 col-xs-6 mt">
														<div class="input-field">
															<label for="from">출발지:</label>
															<input type="text" class="form-control" id="from_place" name="from_place" placeholder="Los Angeles, USA"/>
														</div>
													</div>
													<div class="col-xxs-12 col-xs-6 mt">
														<div class="input-field">
															<label for="from">도착지:</label>
															<input type="text" class="form-control" id="to_place" name="to_place" placeholder="Tokyo, Japan"/>
														</div>
													</div>
													<div class="col-xxs-12 col-xs-6 mt alternate">
														<div class="input-field">
															<label for="date-start">출발일:</label>
															<input type="text" class="form-control" id="date_start" name="date_start" placeholder="mm/dd/yyyy"/>
														</div>
													</div>
													<div class="col-xxs-12 col-xs-6 mt alternate">
														<div class="input-field">
															<label for="date-end">도착일:</label>
															<input type="text" class="form-control" id="date_end" name="date_end" placeholder="mm/dd/yyyy"/>
														</div>
													</div>
													<div class="col-sm-12 mt">
														<section>
															<label for="class">Class:</label>
															<select class="cs-select cs-skin-border">
																<option value="" disabled selected>Economy</option>
																<option value="economy">Economy</option>
																<option value="first">First</option>
																<option value="business">Business</option>
															</select>
														</section>
													</div>
													<div class="col-xxs-12 col-xs-6 mt">
														<section>
															<label for="class">Adult:</label>
															<select class="cs-select cs-skin-border">
																<option value="" disabled selected>1</option>
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
																<option value="4">4</option>
															</select>
														</section>
													</div>
													<div class="col-xxs-12 col-xs-6 mt">
														<section>
															<label for="class">Children:</label>
															<select class="cs-select cs-skin-border">
																<option value="" disabled selected>1</option>
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
																<option value="4">4</option>
															</select>
														</section>
													</div>
													<div class="col-xs-12">
														<input type="button" id="flightBtn" class="btn btn-primary btn-block" value="Search Flight">
													</div>
												</div>
											 </div>
										 </form> <!-- ################################## FORM TAG HERE ################################## -->
										 
									</div>
									
								</div>
							</div>
							
							<div class="desc2 animate-box">
								<div class="col-sm-7 col-sm-push-1 col-md-7 col-md-push-1">
									<p>HandCrafted by <a href="https://github.com/lusida0131/skylife" target="_blank" class="fh5co-site-name">SkyLife.git</a></p>
									<h2>이제 여행을 시작하세요</h2>
									<h3>현재 최저가 항공권으로 갈 수 있는 여행지를 확인해보세요. 이 밖에도 평균보다 낮은 가격으로 여행할 수 있는 여행지가 많습니다.</h3>
									<span class="price">$599</span>
									<!-- <p><a class="btn btn-primary btn-lg" href="#">Get Started</a></p> -->
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		

		<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Book A Flight</h3>
						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					</div>
				</div>
				<div class="row row-bottom-padded-md">
					<div class="col-md-12 animate-box">
						<h2 class="heading-title">Todays Flight Deal</h2>
					</div>
					<div class="col-md-6 animate-box">
						<div class="row">
							<div class="col-md-12">
								<h4>Better Deals, More Abilities</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
							</div>
							<div class="col-md-12">
								<h4>Keep up with the news of your airline</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
							</div>
							<div class="col-md-12">
								<h4>In-Flight Experience</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 animate-box">
						<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/cover_bg_3.jpg" alt="travel">
						<a href="#" class="flight-book">
							<div class="plane-name">
								<span class="p-flight">United States Airways</span>
							</div>
							<div class="desc">
								<div class="left">
									<h4>HK-MNL</h4>
									<span>Dec 20 - Dec29</span>
								</div>
								<div class="right">
									<span class="price">
										<i class="icon-arrow-down22"></i>
										$1000
									</span>
								</div>
							</div>
						</a>
						<a href="#" class="flight-book">
							<div class="plane-name">
								<span class="p-flight">Qatar Airways</span>
							</div>
							<div class="desc">
								<div class="left">
									<h4>HK-MNL</h4>
									<span>Dec 20 - Dec29</span>
								</div>
								<div class="right">
									<span class="price">
										<i class="icon-arrow-down22"></i>
										$790
									</span>
								</div>
							</div>
						</a>
						<a href="#" class="flight-book">
							<div class="plane-name">
								<span class="p-flight">Philippine Airline</span>
							</div>
							<div class="desc">
								<div class="left">
									<h4>MNL-HK</h4>
									<span>Dec 20 - Dec29</span>
								</div>
								<div class="right">
									<span class="price">
										<i class="icon-arrow-down22"></i>
										$500
									</span>
								</div>
							</div>
						</a>
						<a href="#" class="flight-book">
							<div class="plane-name">
								<span class="p-flight">China Airways</span>
							</div>
							<div class="desc">
								<div class="left">
									<h4>HK-LAS</h4>
									<span>Dec 20 - Dec29</span>
								</div>
								<div class="right">
									<span class="price">
										<i class="icon-arrow-down22"></i>
										$900
									</span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="row row-bottom-padded-md">
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>New York</h3>
								<span>3 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-2.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Philippines</h3>
								<span>4 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-3.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Hongkong</h3>
								<span>2 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-4.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>New York</h3>
								<span>3 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-5.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Philippines</h3>
								<span>4 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="images/place-6.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Hongkong</h3>
								<span>2 nights</span>
								<span class="price">$1,000</span>
								<a class="btn btn-primary btn-outline" href="#">Book Now <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="fh5co-testimonial" style="background-image:url(images/img_bg_1.jpg);">
			<div class="container">
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
						<h2>Happy Clients</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="box-testimony animate-box">
							<blockquote>
								<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
								<p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
							</blockquote>
							<p class="author">John Doe, CEO <a href="http://freehtml5.co/" target="_blank">FREEHTML5.co</a> <span class="subtext">Creative Director</span></p>
						</div>
						
					</div>
					<div class="col-md-4">
						<div class="box-testimony animate-box">
							<blockquote>
								<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
								<p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.&rdquo;</p>
							</blockquote>
							<p class="author">John Doe, CEO <a href="http://freehtml5.co/" target="_blank">FREEHTML5.co</a> <span class="subtext">Creative Director</span></p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="box-testimony animate-box">
							<blockquote>
								<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
								<p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
							</blockquote>
							<p class="author">John Doe, Founder <a href="#">FREEHTML5.co</a> <span class="subtext">Creative Director</span></p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		
		<script type="text/javascript">
		
			$(document).ready(function(e){
				$('#flightBtn').click(function(){
					if($.trim($('#from_place').val()) === "") {
					    $('#from_place').focus();
						alert("출발지를 입력해주세요.");
					}
					else if($.trim($('#to_place').val()) === "") {
					    $('#to_place').focus();
						alert("도착지를 입력해주세요.");
					}
					else if($.trim($('#date_start').val()) === "") {
					    $('#date_start').focus();
						alert("출발일을 입력해주세요.");
					}
					else if($.trim($('#date_end').val()) === "") {
					    $('#date_end').focus();
						alert("도착일을 입력해주세요.");
					}
					else {
						$('#flightFrm').submit();
					}
				});
			});
			
		</script>

<%@ include file="../layout/footer.jsp"%>

