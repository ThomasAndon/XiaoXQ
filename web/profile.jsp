<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="css/profilepage.css">
<title>Profile - NiceKey</title>
	<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
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
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/docs.min.css" rel="stylesheet">
<!-- Custom Theme files -->
<!--theme style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<script src="js/jquery.min.js"></script>

<!--//theme style-->
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
<!--header-->	
<script src="js/responsiveslides.min.js"></script>
<script>  
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: false,
      });
    });
  </script>



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
			<h1><a href="index(welcome).jsp" style="font-size: 1.4em;">NiceKey</a></h1>
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

<!---->
<!-- <script src="js/bootstrap.js"> </script> -->
<script src="js/bootstrap-3.4.0.js"></script>
<script type="text/jsp">
  <%String account=(String)session.getAttribute("username");%>
  <%String realname=(String)session.getAttribute("realName");%>
  <%String gender=(String)session.getAttribute("gender");%>
  <%String addr=(String)session.getAttribute("address");%>

  <%String password=(String)session.getAttribute("password");%>
</script>



<%--<script type="text/jsp">
<!--  此处加入检测页面是否有Attribute需要提示内容。-->
  <%String msg = (String)session.getAttribute("message");%>
</script>--%>



<%--
<script type="text/javascript">

function alerting() {
	var alertinfo = <%=msg%>;
	if(alertinfo != null) {
		alert(alertinfo);
	}
}
alerting();
</script>

<script type="text/jsp">
	<% msg = null; %>
</script>
--%>

<%--
<script type="javascript">
  if((string)<%=msg%> != null) {
      alert(<%=msg%>);
  }
</script>

<script type="text/jsp">
<!--此处将msg信息归零-->
  <%
  msg = null;
  %>
</script>

--%>


  <script src="js/Profile.js"></script>

<div id="profileWrap">
  <div id="borderArea">
    <div id="ContentPanel">
      <h2 id="ProfileTitle">My Profile</h2>
      <br>
      <br>
      <div class="info">Your account:
        <div class="infocontent"><%=account%></div>
      </div>
      <div class="info">Your Real Name:
        <div class="infocontent"><%=realname%></div>
      </div>
      <div class="info">Your gender:
        <div class="infocontent"><%=gender%></div>
      </div>
      <div class="info">Your address:
        <div class="infocontent"><%=addr%></div>
      </div>
    </div>
    <br>
    <button type="button" class="btn btn-warning" id="changepibutton" onClick="showorclose('changeinfobox',1)">Change Profile Info</button>
    <button type="button" class="btn btn-warning" id="changepwbutton" onclick="showorclose('changepwbox', 1)">Change Password</button>
  </div>
</div>

<div id="changeinfobox" class="changebox">
  <button type="button" class="btn btn-danger" id="closechangeinfobtn" onClick="showorclose('changeinfobox',0)">Close</button>
<div class="cif-inputbox" id="pwcheck">
    <p class="prompt">We need to verify your password</p><br>
    <input type="password" width="50px" id="veripw"><br><br>
    <button onClick="showchangebar(<%=password%>)">Verify</button>
    <br><br>
    <p id="rightorwrong">Waiting for verification...</p>
  </div>
  <form method="post" action="${pageContext.request.contextPath}/changepi">
    <div class="cif-inputbox" id="showchange" >
      <p>Change your real name "<%=realname%>" to:</p><br>
      <input id="changern" name="rninput"><br><br>
      <p>Change your address "<%=addr%>" to:</p><br>
      <input id="changeaddr" name="addrinput">
      <br>
      <br>
      <input  type="submit" class="btn btn-warning submitbtn" value="Submit">
    </div>
  </form>

</div>

<div id="changepwbox" class="changebox">
  <button type="button" class="btn btn-danger" id="closechangepwbtn" onClick="showorclose('changepwbox',0)">Close</button>
  <form method="post" action="${pageContext.request.contextPath}/changepw">
    <div id='check-and-new'>
      <p class="changepwprompt">Enter your original password:</p><br><br>
      <input type="password" name="enter-ori"><br><br>
      <p class="changepwprompt">Enter your new password:</p><br><br>
      <input name="enter-new" type='password'><br><br>
    </div>
    <div id='submit-changepw-btn'>
      <input type='submit' value='Submit' class='btn btn-success' >
    </div>
    </form>
</div>


<%--<script type="text/jsp">
	<!--  此处加入检测页面是否有Attribute需要提示内容。-->
	<%String msg = (String)session.getAttribute("message");%>
</script>--%>


<%
	String mess = (String) session.getAttribute("message");
	if ("".equals(mess) || mess == null) {
	} else {
%>
<script type="text/javascript">
	alert("<%=mess%>");
</script>
<%session.setAttribute("message", "");
 }
%>





<%--
<script type="text/javascript">

	function alerting() {
		<%String msg = (String)session.getAttribute("message");%>
		var alertinfo = <%=msg%>;
		if(alertinfo != null) {
			alert(alertinfo);
		}
	}
	alerting();
</script>

<script type="text/jsp">
	<% msg = null; %>
</script>

--%>


<%--
<!--
<div class = "profile">
  <h3 class="profiletitle"><a href="css/style.css"> &nbsp; &nbsp;My Profile:</a></h3>
  <div class = "profilecontent">
	  <%String account=(String)session.getAttribute("username");%>
    <p class=paccount">Your Account: <%=account%></p>
</div>
	  <div class = "realname">
	  <%String realname=(String)session.getAttribute("realName");%>
    <p class=prealname">Your Name: <%=realname%></p>
	</div>
	<div class = "gender">
	  <%String gender=(String)session.getAttribute("gender");%>
    <p class="pgender">Your gender: <%=gender%></p>
	</div>
	<div class = "address">
	  <%String addr=(String)session.getAttribute("address");%>
    <p class=paddr">Your Address: <%=addr%></p>
	</div>
</div>

-->--%>

<!---->
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
