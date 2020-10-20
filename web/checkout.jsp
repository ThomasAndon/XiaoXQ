<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="jspServlet.vo.Commodity" %>
<html>
<head>
	<title>Shopping Cart</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<!-- Custom Theme files -->
	<!--theme style-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery.min.js"></script>


	<!--//theme-style-->
	<style>

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
</head>

<body>
<!-- header -->
<%
	//初始化接口元素
	System.out.println("---checkout---");
	ArrayList<Commodity> cmArray = (ArrayList<Commodity>) session.getAttribute("cmArray");
	HashMap<Integer, Integer> shopList = (HashMap<Integer, Integer>) session.getAttribute("shopList");
	Float totalPrice = (Float) session.getAttribute("totalPrice");
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
				<p>Are you sure you want to log out?<br/>Current shopcart will be <b>lost</b>></p>
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
				<div id="logg" class="col-md-3 col-md-offset-10"  >
					<a href="login.jsp">
						<span style="font-size: 35px;line-height: 2.2;" class="glyphicon glyphicon-log-in btn-lg"></span>
					</a>
				</div>
				<div class="col-md-3 col-md-offset-9" id="user">
					<div class="row justify-content-md-center">

						<div class="col-md12">
							<%String name=(String)session.getAttribute("username");%>
							<a href="profile.jsp"><h4 style="line-height: 2.8">Welcome! <%=name%></h4></a>
						</div>
					</div>
					<%--金额显示已注释掉--%>
<%--					<div class="row justify-content-md-center">--%>
<%--						<div class="col-md12">--%>
<%--							<h5 style="line-height: 36px"><span class="simpleCart_total"></span></h5>--%>
<%--						</div>--%>
<%--					</div>--%>
					<div class="row justify-content-md-center">
						<div class="col-md12">
							<a href="profile.jsp" class="btn btn-success btn-sm" style="font-size: 1.4rem;">Information</a>
						</div>
					</div>
					<div class="row justify-content-md-center">
						<div class="col-md12">
							<button  class="btn btn-danger btn-sm" data-toggle="modal" data-target="#identifier" style="font-size: 1.1rem;">Log out</button>						 </div>
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

<!--
check out
购物车
-->
<div class="container">
	<div class="check-sec">
		<div class="col-md-3 cart-total" style="float:left;">
			<a class="continue" href="products.jsp"><h4>Continue to basket</h4></a>
			<div class="price-details">
				<h3>Price Details</h3>
				<span>Total</span>
				<span class="total1">

				</span>
				<!--
				<span>Discount</span>
				<span class="total1">0%(Festival Offer)</span>

				<span>Delivery Charges</span>
				<span class="total1">total1></span>
				-->

				<div class="clearfix"></div>
			</div>
			<ul class="total_price">
				<li class="last_price"> <h4>TOTAL</h4></li>
				<li class="last_price"><span><%=totalPrice%></span></li>
			</ul>
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<script>

			</script>
			<a class="order" href="index(welcome).jsp" onclick="orderPlace()">Place Order
				<script>
					function orderPlace() {
						alert("Order placed successfully!");
					}
				</script>
				<form method="post" action="index(welcome).jsp">
					<input type=hidden>
				<%
					session.removeAttribute("totalPrice");
					session.removeAttribute("cmAmount");
					session.removeAttribute("shopCart");
				%>
				</form>
			</a>
			<div class="total-item">
				<h3>OPTIONS</h3>
				<h4>COUPONS</h4>
				<a class="cpns" href="#">Apply Coupons</a>
			</div>
		</div>

		<%--
		下面看购物车的要放到右边
		--%>
		<%--div class="col-md-9 cart-items"--%>
		<div style="float:right;width:73%;">
			<h1>My Shopping Cart</h1>
			<!--
			用for循环遍历cmArray，到处每一个cm并生成对应的购物车卡品啊
			-->
			<%

				Iterator cmIt = cmArray.iterator();
				Commodity cm = new Commodity();
				String picString = new String();
				while (cmIt.hasNext()) {
					cm = (Commodity) cmIt.next();
					System.out.println("cmId = " + cm.getCommodityId());
					%>
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<%
					switch (cm.getCommodityId()){
						case 1: picString = "<div class=\"cart-item cyc\">\n" +
								"\t\t\t\t\t\t<img src=\"imagesOfUs/key1.jpg\" class=\"img-responsive\" alt=\"\"/>\n" +
								"\t\t\t\t\t</div>";break;
						case 2: picString = "<div class=\"cart-item cyc\">\n" +
								"\t\t\t\t\t\t<img src=\"imagesOfUs/key2.jpg\" class=\"img-responsive\" alt=\"\"/>\n" +
								"\t\t\t\t\t</div>";break;
						//随便选了一张图片
						default: picString = "<div class=\"cart-item cyc\">\n" +
								"\t\t\t\t\t\t<img src=\"imagesOfUs/key10.jpg\" class=\"img-responsive\" alt=\"\"/>\n" +
								"\t\t\t\t\t</div>";break;
					}
					out.println(picString);
					%>
					<div class="cart-item-info">
						<b><h1><%=cm.getName()%></h1></b>
						<ul class="qty">
							<%
								Integer count = shopList.get(cm.getCommodityId());
							%>
							<p><li><h3>Count : <%=count%></h3></li></p>
						</ul>
						<div class="delivery">
							<p><h3>Charges : <%=count * cm.getPrice()%></h3></p>
							<span>Delivered in 2-3 bussiness days</span>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
					<%
					}
					%>
			<%--
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">

					<div class="cart-item cyc">
						<img src="images/p4.jpg" class="img-responsive" alt=""/>
					</div>
					<div class="cart-item-info">
						<h3>Electronic organ1</h3>
						<ul class="qty">
							<%
								/**
								Integer count1 = (Integer)shopList.get(1);
								if((Integer)shopCart.get(1) == null){
									count1 = 0;
								}
								*/
							%>
							<li><p>Count : <%//=count1%></p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : Rs.0</p>
							<span>Delivered in 2-3 bussiness days</span>
							<div class="clearfix"></div>
						</div>
					</div>

					<div class="clearfix"></div>

				</div>
			</div>
			<script>$(document).ready(function(c) {
				$('.close2').on('click', function(c){
					$('.cart-header2').fadeOut('slow', function(c){
						$('.cart-header2').remove();
					});
				});
			});
			</script>
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						<img src="images/p3.jpg" class="img-responsive" alt=""/>
					</div>
					<div class="cart-item-info">
						<h3>Electronic organ2</h3>
						<ul class="qty">
							<%
								//Integer count2 = (Integer)shopCart.get(2);
								//if((Integer)shopCart.get(2) == null){
								//	count2 = 0;
								//}
							%>
							<li><p>Count : <%//=count2%></p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : Rs.0</p>
							<span>Delivered in 2-3 bussiness days</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>

				</div>
			</div>
		</div>
		--%>

		<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //check out -->


<!---->
<div class="subscribe">
	<div class="container">
		<h3>NiceKey</h3>
		<form action="${pageContext.request.contextPath}/search"  method="get">
			<input type="text" name="SC" class="text" value="Search"
				   onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
			<input type="submit" value="Go"><br/>
			Query method:
			<div id="searchway">
				<input type="radio" name="Search" value="SN" checked>Search by name
				<input type="radio" name="Search" value="SLC">Search by large class
				<input type="radio" name="Search" value="SSC">Search by small class
			</div><br/>
			Order method:
			<div id="orderway">
				<input type="radio" name="Order" value="asc" checked>Increase
				<input type="radio" name="Order" value="desc">Decrease
			</div><br/>
		</form>
	</div>
</div>
<!---->
<div class="footer">
	<h3 class="text-center"><strong>OUR PARTNERS</strong></h3>
	<p>
		<a href="https://www.apple.com.cn/"><img  src="imagesOfUs/partner/PA1.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.qualcomm.cn/"><img  src="imagesOfUs/partner/PA2.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.dolby.com/"><img  src="imagesOfUs/partner/PA3.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.yamaha.com.cn/"><img href="https://www.yamaha.com.cn/" src="imagesOfUs/partner/PA4.jpg" style="margin-left:80px;" width="200" height="100" class="img-rounded"/></a>
		<a href="https://www.qualcomm.cn/"><img src="imagesOfUs/partner/PA5.jpg" style="margin-left:80px;"width="200" height="100" class="img-rounded"/></a>	</p>
</div>
<!---->
<div class="copywrite">
	<div class="container">
		<div class="copy">
			<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
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

</body>
</html>