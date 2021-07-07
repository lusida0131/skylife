<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(${pageContext.request.contextPath}/resources/images/imagesair.jpg);">  <!-- 사진 왜 안뜨냐 해결좀요 -->
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
														<section>
															<label for="from">출발지</label>
															<select class="cs-select cs-skin-border" id="from_place" name="from_place">
																<option value="" disabled selected>출발지 선택</option>
						                                        <option value="NAARKJJ">광주</option>
						                                        <option value="NAARKJK">군산</option>
																<option value="NAARKSS">김포</option>
						                                        <option value="NAARKPK">김해/부산</option>
						                                        <option value="NAARKTN">대구</option>
						                                        <option value="NAARKJB">무안</option>
						                                        <option value="NAARKPS">사천</option>
						                                        <option value="NAARKNY">양양</option>
						                                        <option value="NAARKJY">여수</option>
						                                        <option value="NAARKPU">울산</option>
						                                        <option value="NAARKNW">원주</option>
						                                        <option value="NAARKSI">인천</option>
						                                        <option value="NAARKPC">제주</option>
						                                        <option value="NAARKTU">청주</option>
						                                        <option value="NAARKTH">포항</option>
															</select>
														</section>
													</div>
													<div class="col-xxs-12 col-xs-6 mt">
														<section>
															<label for="from">도착지</label>
															<select class="cs-select cs-skin-border" id="to_place" name="to_place">
																<option value="" disabled selected>도착지 선택</option>
																<option value="NAARKJJ">광주</option>
						                                        <option value="NAARKJK">군산</option>
																<option value="NAARKSS">김포</option>
						                                        <option value="NAARKPK">김해/부산</option>
						                                        <option value="NAARKTN">대구</option>
						                                        <option value="NAARKJB">무안</option>
						                                        <option value="NAARKPS">사천</option>
						                                        <option value="NAARKNY">양양</option>
						                                        <option value="NAARKJY">여수</option>
						                                        <option value="NAARKPU">울산</option>
						                                        <option value="NAARKNW">원주</option>
						                                        <option value="NAARKSI">인천</option>
						                                        <option value="NAARKPC">제주</option>
						                                        <option value="NAARKTU">청주</option>
						                                        <option value="NAARKTH">포항</option>
															</select>
														</section>
													</div>
													<div class="col-xxs-12 col-xs-6 mt alternate">
														<div class="input-field">
															<label for="date-start">출발일</label>
															<input type="text" class="form-control" id="date-start" name="date_start" placeholder="yyyymmdd"/>
														</div>
													</div>
													<div class="col-xxs-12 col-xs-6 mt alternate">
														<div class="input-field">
															<label for="date-end">도착일</label>
															<input type="text" class="form-control" id="date-end" name="date_end" placeholder="yyyymmdd"/>
														</div>
													</div>
													<div class="col-sm-12 mt">
														<section>
															<label for="class">항공사</label>
															<select class="cs-select cs-skin-border">
																<option value="" disabled selected>항공사</option>
																<option value="AAR">아시아나항공</option>
																<option value="ABL">에어부산</option>
																<option value="ASV">에어서울</option>
																<option value="ESR">이스타항공</option>
																<option value="FGW">플라이강원</option>
																<option value="HGG">하이에어</option>
																<option value="JJA">제주항공</option>
																<option value="JNA">진에어</option>
																<option value="KAL">대한항공</option>
																<option value="TWB">티웨이항공</option>
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
						<h3>행복한 여행을 응원합니다.</h3>
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-2.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-3.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-4.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-5.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
						<div href="#">
							<img src="${pageContext.request.contextPath}/resources/images/place-6.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
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
		
		<div id="fh5co-features">
			<div class="container">
				<div class="row">
					<div class="col-md-4 animate-box">

						<div class="feature-left">
							<span class="icon">
								<i class="icon-hotairballoon"></i>
							</span>
							<div class="feature-copy">
								<h3>Family Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>

					</div>

					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-search"></i>
							</span>
							<div class="feature-copy">
								<h3>Travel Plans</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-wallet"></i>
							</span>
							<div class="feature-copy">
								<h3>Honeymoon</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 animate-box">

						<div class="feature-left">
							<span class="icon">
								<i class="icon-wine"></i>
							</span>
							<div class="feature-copy">
								<h3>Business Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>

					</div>

					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-genius"></i>
							</span>
							<div class="feature-copy">
								<h3>Solo Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>

					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-chat"></i>
							</span>
							<div class="feature-copy">
								<h3>Explorer</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		
		<div id="fh5co-destination">
			<div class="tour-fluid">
				<div class="row">
					<div class="col-md-12">
						<ul id="fh5co-destination-list" class="animate-box">
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/GMP.jpg); border: 1px solid;">
								<a href="/Park/GMPList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/PUS.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJU.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/TAE.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>

							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJJ.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-half text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/ICN.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
									<br><br><br><br><br>
										<span>해당 공항의 주차정보를 알고싶으면 클릭해주세요</span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KWJ.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/RCU.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/USN.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KUV.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/WJU.jpg); border: 1px solid;">
								<a href="#">
									<div class="case-studies-summary">
										<br><br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
						</ul>		
					</div>
				</div>
			</div>
		</div>

		<div id="fh5co-blog-section" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Recent From Blog</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit est facilis maiores, perspiciatis accusamus asperiores sint consequuntur debitis.</p>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row row-bottom-padded-md">
					<div class="col-lg-4 col-md-4 col-sm-6">
						<div class="fh5co-blog animate-box">
							<a href="#"><img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/place-1.jpg" alt=""></a>
							<div class="blog-text">
								<div class="prod-title">
									<h3><a href="#">30% Discount to Travel All Around the World</a></h3>
									<span class="posted_by">Sep. 15th</span>
									<span class="comment"><a href="">21<i class="icon-bubble2"></i></a></span>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
									<p><a href="#">Learn More...</a></p>
								</div>
							</div> 
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<div class="fh5co-blog animate-box">
							<a href="#"><img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/place-2.jpg" alt=""></a>
							<div class="blog-text">
								<div class="prod-title">
									<h3><a href="#">Planning for Vacation</a></h3>
									<span class="posted_by">Sep. 15th</span>
									<span class="comment"><a href="">21<i class="icon-bubble2"></i></a></span>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
									<p><a href="#">Learn More...</a></p>
								</div>
							</div> 
						</div>
					</div>
					<div class="clearfix visible-sm-block"></div>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<div class="fh5co-blog animate-box">
							<a href="#"><img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/place-3.jpg" alt=""></a>
							<div class="blog-text">
								<div class="prod-title">
									<h3><a href="#">Visit Tokyo Japan</a></h3>
									<span class="posted_by">Sep. 15th</span>
									<span class="comment"><a href="">21<i class="icon-bubble2"></i></a></span>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
									<p><a href="#">Learn More...</a></p>
								</div>
							</div> 
						</div>
					</div>
					<div class="clearfix visible-md-block"></div>
				</div>

				<div class="col-md-12 text-center animate-box">
					<p><a class="btn btn-primary btn-outline btn-lg" href="#">See All Post <i class="icon-arrow-right22"></i></a></p>
				</div>

			</div>
		</div>
		
		<div id="fh5co-testimonial" style="background-image:url(${pageContext.request.contextPath}/resources/images/img_bg_1.jpg);">
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
					/* else if($.trim($('#date_start').val()) === "") {
					    $('#date_start').focus();
						alert("출발일을 입력해주세요.");
					} */
					/* else if($.trim($('#date_end').val()) === "") {
					    $('#date_end').focus();
						alert("도착일을 입력해주세요.");
					} */
					else {
						$('#flightFrm').submit();
					}
				});
			});
			
		</script>
		
		<!-- <script>
			$('#date-end').datepicker({ dateFormat: 'yymmdd', autoclose : true });
		</script> -->

<%@ include file="../layout/footer.jsp"%>

