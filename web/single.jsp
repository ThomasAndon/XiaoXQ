<%@ page import="jspServlet.vo.Commodity" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<title>Commodity - NiceKey</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<!--theme style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<script src="js/jquery.min.js"></script>
<!--//theme style-->
	<style>

		body {
			padding-right: 0px !important;
		}
		*.model-open{
			overflow-y:scroll;
			padding-right: 0 !important;
		}

		.mysubmit {

			-webkit-transition-duration: 0.4s;

			transition-duration: 0.4s;

			padding: 16px 32px;

			text-align: center;

			background-color: white;

			size: 1px;

			color: black;

			border: 2px red ;

			border-radius:5px;

			box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
		}

		.mysubmit:hover {

			background-color: red;

			color: white;

		}

	</style>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Wedding Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

</head>
<body> 
<!--header-->

<%
	System.out.println("---single---");

%>

<div id="identifier" class="modal" data-toggle="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Confirm</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to log out?<br/>Current shopping cart will be <b>lost</b></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
				<form action="${pageContext.request.contextPath}/logout" method="post">
					<button type="submit" class="btn btn-primary">Sure</button>
				</form>
			</div>
		</div>
	</div>
</div>

<!--header-->
<div class="header-top">
	<div class="header-bottom">
		<div class="logo">
			<h1><a href="index(welcome).jsp" style="font-size: 1.95em;">NiceKey</a></h1>
		</div>
		<!---->
		<div class="top-nav">
			<ul class="memenu skyblue">
				<li class="grid"><a href="index(welcome).jsp">Home</a></li>
				<li class="grid"><a href="products.jsp">Products</a></li>
				<li class="grid"><a id="order" href="order.jsp">Order</a></li>
				<li class="grid"><a href="./aboutus.jsp">About Us</a></li>
			</ul>
		</div>
		<!---->


		<div class="container-fluid">
			<div class="row">
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<%--				 <div class="col-md-1">cmd1</div>--%>
				<div class="col-md-3 col-md-offset-10" id="logg">
					<a href="login.jsp">
						<span style="font-size: 35px;line-height: 2.2;" class="glyphicon glyphicon-log-in btn-lg"></span>
					</a>
				</div>
					<div class="col-md-9 col-md-offset-6" id="user">
						<div class="row justify-content-md-center">
							<a href="checkout.jsp"><img src="imagesOfUs/cart.png" width="5%"></a>
						</div>
						<div class="row justify-content-md-center">
							<div class="col-md12">
								<%String name=(String)session.getAttribute("username");%>
								<a href="profile.jsp"><h5 style="line-height: 2.5">Welcome! <%=name%></h5></a>
							</div>
						</div>
						<%-->
                        下面这段是购物车的金额

                        <div class="row justify-content-md-center">
                            <div class="col-md12">
                                <h5 style="line-height: 36px"><span class="simpleCart_total"></span></h5>
                            </div>
                        </div>
                        <--%>
						<div class="row justify-content-md-center">
							<div class="col-md12">
								<a href="profile.jsp" class="btn btn-success btn-sm" style="font-size: 1.4rem;">Information</a>
							</div>
						</div>
						<div class="row justify-content-md-center">
							<div class="col-md12">
								<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#identifier" style="font-size: 1.1rem;line-height: 0.6;">Log out</button>						 </div>
						</div>
					</div>
			</div>



		</div>



		<%--		 <div id="user" class="cart box_1">--%>
		<%--			 <a href="checkout.jsp"><img  src="imagesOfUs/user.jpg" href="#"/>--%>
		<%--				 <%String name=(String)session.getAttribute("username");%>--%>
		<%--				 <p>Welcome! <%=name%></p>--%>
		<%--				 <div class="total">--%>
		<%--					 <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span>)--%>
		<%--				 </div>--%>
		<%--				 <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>--%>
		<%--			 </a>--%>
		<%--			 <form method="post" action="./logout">--%>
		<%--				 <input class="mysubmit" type="submit" value="Log out" style="line-height: 0px;">--%>
		<%--			 </form>--%>

		<%--			 <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>--%>
		<%--			 <div class="clearfix"> </div>--%>
		<%--		 </div>--%>
		<div class="clearfix"> </div>
		<!---->
	</div>
	<div class="clearfix"> </div>
</div>

<script type="text/javascript">
	// alert("test alert");
	function carr() {
		var a='<%=session.getAttribute("try")%>';
		if(a=='ok'){
			document.getElementById("logg").style.display='none';
			document.getElementById("user").style.display='inline';
			document.getElementById("rl1").style.display='none';
			document.getElementById("rl2").style.display='inline';
			document.getElementById("order").style.display='inline';

		}else{
			document.getElementById("order").style.display='none';
			document.getElementById("user").style.display='none';
			document.getElementById("rl1").style.display='inline';
			document.getElementById("rl2").style.display='none';
			document.getElementById("logg").style.display='inline';
		}

	}
	window.onload = carr();
</script>
			 <!---->			 
			 </div>
			<div class="clearfix"> </div>
</div>
<!--header//-->
<div class="product">
	<div class="container">
		<div class="product-price1" style="float:left">
			<div class="top-sing">
				<!--

				-->
				<%
					/**
					 *
					 * @商品加载功能author Luo Deng
					 */


					//根据cmName为页面显示准备变量，保证不同Name对应不同页面信息
					ArrayList<Commodity> tempCmArray = (ArrayList<Commodity>)session.getAttribute("tempCmArray");
					String cmName = request.getParameter("cmName");
					String cmType = request.getParameter("cmType");
					String cmWarranty = request.getParameter("cmWarranty");
					Integer cmUserID = Integer.parseInt(request.getParameter("cmUserID"));
					System.out.println("cmName = " + cmName);
					String urlString = (String)session.getAttribute("urlString");

					float whitePrice = (float) 0.;
					float blackPrice = (float) 0.;
                    float lowPrice = (float) 0.;
                    float highPrice = (float) 0.;
					for(Commodity cm : tempCmArray){
					    String cmColor = cm.getTheColor();
					    //System.out.println(cmColor);
					    if(cmColor.equals("white")){
					        whitePrice = cm.getPrice();
                        }else if(cmColor.equals("black")){
					        blackPrice = cm.getPrice();
                        }else{
					        System.out.println("The color is neither black nor white!!!");
                        }
                    }

                    if(whitePrice >= blackPrice){
                        lowPrice = blackPrice;
                        highPrice = whitePrice;
                    }else{
                        lowPrice = whitePrice;
                        highPrice = blackPrice;
                    }

					String descText = "The keyboard comes with world leading digital audio technology, " +
                            "with professional quality and gives you the best experience.";
				%>




				<div class="col-md-7 single-top">
                    <!--图片显示有问题，弃用
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb=“imagesOfUs/key1.jpg”>
								<div class="thumb-image"> <img src="imagesOfUs/key1.jpg" , data-imagezoom="true" , class="img-responsive" , alt=""/> </div>
							</li>
							<li data-thumb=“imagesOfUs/key1.jpg”>
								<div class="thumb-image"> <img src="imagesOfUs/Electronic_organ_2.jpg" , data-imagezoom="true" , class="img-responsive" , alt=""/> </div>
							</li>
							<li data-thumb=“imagesOfUs/key1.jpg”>
								<div class="thumb-image"> <img src="imagesOfUs/key3.png", data-imagezoom="true", class="img-responsive", alt=""/> </div>
							</li>
						</ul>
					</div>
					<script src="js/imagezoom.js"></script>
					<script defer src="js/jquery.flexslider.js"></script>
					<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
							$('.flexslider').flexslider({
								animation: "slide",
								controlNav: "thumbnails"
							});
						});
					</script>
					-->
                    <div>
                        <div id="img" class="thumb-image"> <img src="<%=urlString%>" , data-imagezoom="true" , class="img-responsive" , alt=""/> </div>
                    </div>

				</div>

				<div class="col-md-5 single-top-in simpleCart_shelfItem">
					<div class="single-para">
						<h4><%=cmName%></h4>
						<!--用js写两个按钮？用来选择颜色，每一次onclick就会访问一次session中的对象，根据onclick所发送的值（颜色 String）来更新价格-->
						<%
							if(lowPrice == highPrice){
								String str = "<h5 id=\"priceLabel\" class=\"item_price\">" + "$" + lowPrice
										+ "</h5>";
								out.print(str);
							}else{
								String str = "<h5 id=\"priceLabel\" class=\"item_price\">" + "$" + lowPrice
										+ "~" + highPrice + "</h5>";
								out.print(str);
							}
						%>
                        </h5>
						<p class="para"><%=descText%></p>
						<div class="prdt-info-grid">
							<ul><h4>

                              <li>- Brand : Nice Key</li>
                              <li>- Dimensions : 80cm x 35cm x 20cm</li>
                              <li>- Color : Black or White&nbsp;</li>
                              <li>- Material : Steel</li>
								<li>- Type : <%=cmType%></li>
								<li>- Warranty : <%=cmWarranty%></li>
								<li>- SellerID : <%=cmUserID%></li>

							</h4></ul>

						</div>
						<!--
                                                    <div class="check">
                                                     <p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>Enter pin code for delivery &amp; availability</p>
                                                     <form class="navbar-form">
                                                          <div class="form-group">
                                                            <input type="text" class="form-control" placeholder="Enter Pin code">
                                                          </div>
                                                          <button type="submit" class="btn btn-default">Verify</button>
                                                     </form>
                                                    </div>
                        -->
						<a ></a>
						<script type="text/javascript">
							function increase()
							{
								var txt = document.getElementById('Bnumber');
								var number=+txt.value;
								number=number+1;
								txt.value=number;
							}
							function decrease() {
								var txt = document.getElementById('Bnumber');
								var number=+txt.value;
								number=number-1;
								if(number<=0){
									number=0;
								}
								txt.value=number;
							}
						</script>

						<script type="text/javascript">
							function IdCheck(){
								var a='<%=session.getAttribute("try")%>';
								if(a != 'ok' || !a){
									document.addingCart.action="./login.jsp";
								}else{
									document.addingCart.action="./shop";
								}
							}
							//Luo Deng Add
							function whitePrice(){
                                var price = '<%=whitePrice%>';
                                document.getElementById("priceLabel").innerHTML = '$'+price;
                            }

                            function blackPrice(){
                                var price = '<%=blackPrice%>';
                                document.getElementById("priceLabel").innerHTML = '$'+price;
                            }
                            //end add
						</script>
						<form name="addingCart" method="post" action="" onsubmit="IdCheck();">
							<%--System.out.println(session.getAttribute("try"));--%>

							<div style="width:50%;float:left;">
								<p><h3>Choose the amount: </h3></p>
							<input type="button" onclick="decrease()" value="-"/>
							<!--
							input id="Bnumber" type="text" size="5" name="number" value="0"
							-->
							<input id="Bnumber" type="text" size="5" name="count" value="0">
							<input type="button" onclick="increase()" value="+"/>
							</div>
								<div style="width:50%;float:right;">
									<p><h3>Choose the color: </h3></p>
									<input type="radio" name="color" method="post" value="white" onclick="whitePrice()"><b>white</b><br/>
									<input type="radio" name="color" method="post" value="black" onclick="blackPrice()"><b>black</b>
								</div>
								<br/>
							<input type="submit" value="Add to Cart" class="add-cart item_add" style="width:100%;">

						</form>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>

		 <div class="bottom-prdt">
			 <div class="btm-grid-sec">
				 <div><h1 class="center-block" style="background-color: #FFFFFF;line-height: 3;color: orangered"><b>You May Also Like</b></h1></div>
				 <div class="col-md-2 btm-grid">
					 <a href="<%=request.getContextPath()+"/view?cmName=6"%>">
						<img src="imagesOfUs/Electronic_organ_6.jpg" style="width: 150px;height: 150px" alt=""/>
						<h4>Electronic_organ_6</h4>
						<span>$1300</span></a>
				 </div>
				 <div class="col-md-2 btm-grid">
					 <a href="<%=request.getContextPath()+"/view?cmName=7"%>">
						<img src="imagesOfUs/Electronic_organ_7.jpg" style="width: 150px;height: 150px" alt=""/>
						<h4>Electronic_organ_7</h4>
						<span>$1200-1300</span></a>
				 </div>
				 <div class="col-md-2 btm-grid">
					  <a href="<%=request.getContextPath()+"/view?cmName=8"%>">
						<img src="imagesOfUs/Electronic_organ_8.jpg" style="width: 150px;height: 150px" alt=""/>
						<h4>Electronic_organ_8</h4>
						<span>$1200</span></a>
				 </div>
				 <div class="col-md-2 btm-grid">
					  <a href="<%=request.getContextPath()+"/view?cmName=4"%>">
						<img src="imagesOfUs/Electronic_organ_4.jpg" style="width: 150px;height: 150px" alt=""/>
						<h4>Electronic_organ_4</h4>
						<span>$1400</span></a>
				 </div>
				 <div class="col-md-2 btm-grid">
					  <a href="<%=request.getContextPath()+"/view?cmName=5"%>">
						<img src="imagesOfUs/Electronic_organ_5.jpg" style="width: 150px;height: 150px" alt=""/>
						<h4>Electronic_organ_5</h4>
						<span>$1300-1600</span></a>
				 </div>
				  <div class="clearfix"></div>
			 </div>			
		 </div>

	 </div>
</div>
<!---->

<!---->
<div class="footer">
	<p>
		<a href="https://www.apple.com.cn/"><img  src="imagesOfUs/partner/PA1.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.qualcomm.cn/"><img  src="imagesOfUs/partner/PA2.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.dolby.com/"><img  src="imagesOfUs/partner/PA3.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.yamaha.com.cn/"><img href="https://www.yamaha.com.cn/" src="imagesOfUs/partner/PA4.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.qualcomm.cn/"><img src="imagesOfUs/partner/PA5.jpg" style="margin-left:80px;"width="200" height="100" class="img-rounded"/></a>	</p>
</div>
<div class="copywrite">
	 <div class="container">
		 <div class="copy">
			 <p><a target="_blank" href="http://sc.chinaz.com/moban/"></a></p>
		 </div>
		 <div class="social">							
				<a href="#"><i class="facebook"></i></a>
				<a href="#"><i class="twitter"></i></a>
				<a href="#"><i class="dribble"></i></a>	
				<a href="#"><i class="google"></i></a>	
				<a href="#"><i class="youtube"></i></a>	
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
</body>
</html>