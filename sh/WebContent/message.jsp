<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>极限滑雪城--留言</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, width=device-width">
		<link rel="stylesheet" href="${ctx }/cij/css/demo.css" />
		<link rel="stylesheet" href="${ctx }/cij/css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate.css" />
		<link rel="stylesheet" href="${ctx }/cij/css/fen.css" />
		<script type="text/javascript" src="${ctx }/cij/js/jquery-2.2.0.min.js"></script>
	</head>

	<body style="background: url(img/BG.jpg) center center;height: 100%;overflow: hidden;">
		<script>
			var _PageHeight = document.documentElement.clientHeight,
				_PageWidth = document.documentElement.clientWidth;
			//计算loading框距离顶部和左部的距离（loading框的宽度为215px，高度为61px）
			var _LoadingTop = _PageHeight > 61 ? (_PageHeight - 61) / 2 : 0,
				_LoadingLeft = _PageWidth > 215 ? (_PageWidth - 215) / 2 : 0;
			//在页面未加载完毕之前显示的loading Html自定义内容
			var _LoadingHtml = '<div id="loadingDiv" style="position:absolute;left:0;width:100%;height:' + _PageHeight + 'px;top:0;background:#f3f8ff;opacity:0.8;filter:alpha(opacity=80);z-index:10000;"><div style="position: absolute; cursor1: wait; left: ' + _LoadingLeft + 'px; top:' + _LoadingTop + 'px; width: auto; height: 57px; line-height: 57px; padding-left: 50px; padding-right: 5px; background: #fff url(img/load.gif) no-repeat scroll 5px 10px; border: 2px solid #95B8E7; color: #696969; font-family:\'Microsoft YaHei\';">页面加载中，请等待...</div></div>';
			//var _LoadingHtml=='<img src="${ctx }/cij/img/load.gif" id="loadingDiv" style="left: ' + _LoadingLeft + 'px; top:' + _LoadingTop + 'px;"/>';
			//呈现loading效果
			document.write(_LoadingHtml);

			//window.onload = function () {
			//    var loadingMask = document.getElementById('loadingDiv');
			//    loadingMask.parentNode.removeChild(loadingMask);
			//};
			//监听加载状态改变
			document.onreadystatechange = completeLoading;

			//加载状态为complete时移除loading效果
			function completeLoading() {
				if(document.readyState == "complete") {
					var loadingMask = document.getElementById('loadingDiv');
					loadingMask.parentNode.removeChild(loadingMask);
				}
			}
		</script>
			<div class="message_box" style="overflow: hidden;margin: 0px auto;margin-top: 100px;">
				<img src="${ctx }/cij/img/page1_p1.png" id="img1" />
				<div class="message" style="transform: translateY(-3408px);">
					<div class="page1">
						<div class="header2" style="display:block;">
							<img src="${ctx }/cij/img/phone_meau.png" class="meau" />
							<a href="index.html"><img src="${ctx }/cij/img/logo.png" class="logo" /></a>
							<a href="shop_car.html"><i class="iconfont">&#xe600;</i><span>1</span></a>
							<ul class="meau_box">
								<a href="successLogin.jsp">
									<li>首页</li>
								</a>
								<a href="product.html">
									<li>极限一下</li>
								</a>
								<a href="blog.jsp">
									<li>BLOG</li>
								</a>
								<a href="personal.jsp">
									<li>个人中心</li>
								</a>
								<a href="message.html">
									<li>留言板</li>
								</a>
								<p style="border-right:1px #fff solid;" class="login_btn">登录</p>
								<a href="register.html">
									<p>注册</p>
								</a>
							</ul>
						</div>
						<script>
							$(function() {
								$(".meau").on("click", function(e) {
									$(".meau_box").slideToggle();
									$(document).one("click", function() {
										$(".meau_box").slideUp();
									});
									e.stopPropagation();
								});
								$(".meau").on("click", function(e) {
									e.stopPropagation();
								});
							});
						</script>
						
						<div class="xiang">
							<img src="${ctx }/cij/img/text.png"/>
							<p>字传朋友圈</p>
							<p style="right:40px;">不如情唤朋友缘</p>
						</div>
						<img src="${ctx }/cij/img/page1_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page1_p3.png" class="img3" />
						<img src="${ctx }/cij/img/page1_p4.png" class="img4" />
						<a href="message2.html"><img src="img/zz.png" class="img5" /></a>
						<img src="${ctx }/cij/img/page1_p6.png" class="img6" />
						<img src="${ctx }/cij/img/page1_p7.png" class="img7" />
					</div>
					<div class="page2">
						<img src="${ctx }/cij/img/page2_p1.png" class="img1" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page7_p3.png" class="img3" />
						<p class="word">记得，捎上你的心意问候<br />或者一切想说的话儿<br />因为有一天<br />如果礼物不再只是物品<br />那样的生活是多么美妙无比
						</p>
						<span>——爱你的杰</span>
						<img src="${ctx }/cij/img/page2_p2.png" class="img4" />
						<img src="${ctx }/cij/img/page2_p3.png" class="img5" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img6" />
						<img src="img/to.png" class="to_top"/>
					</div>
					<div class="page3">
						<img src="${ctx }/cij/img/page3_p1.png" class="img1" />
						<img src="${ctx }/cij/img/page3_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img3" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img4" />
						<img src="${ctx }/cij/img/page1_p6.png" class="img5" />
						<p class="word">我们的人生因为各种各样<br /> 的礼物而丰富多彩，<br /> 因为种各样的礼物而变得有 <br />情谊有意义.</p>
						<img src="${ctx }/cij/img/to.png" class="to_top"/>
					</div>
					<div class="page4">
						<img src="${ctx }/cij/img/page4_p1.png" class="img1" />
						<img src="${ctx }/cij/img/page4_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page3_p3.png" class="img3" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img4" />
						<img src="${ctx }/cij/img/page2_p2.png" class="img5" />
					</div>
					<div class="page5">
						<p class="word">我们生活的城市没有绝对的完美 但我们会精心挑选 <br />我们眼里最美好的礼物 <br />因为TA值得最好 </p>
						<img src="${ctx }/cij/img/page5_p1.png" class="img1" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page5_p2.png" class="img3" />
						<img src="${ctx }/cij/img/page2_p3.png" class="img4" />
						<img src="${ctx }/cij/img/to.png" class="to_top"/>
					</div>
					<div class="page6">
						<img src="${ctx }/cij/img/page6_p5.png" class="img1" />
						<img src="${ctx }/cij/img/page6_p1.png" class="img2" />
						<img src="${ctx }/cij/img/page6_p3.png" class="img3" />
						<img src="${ctx }/cij/img/page7_p3.png" class="img4" />
						<img src="${ctx }/cij/img/page6_p4.png" class="img5" />
						<img src="${ctx }/cij/img/page5_p2.png" class="img6" />
						<img src="${ctx }/cij/img/page2_p3.png" class="img7" />
						<img src="${ctx }/cij/img/page3_p3.png" class="img8" />
						<img src="${ctx }/cij/img/page2_p2.png" class="img9" />
						<img src="${ctx }/cij/img/page3_p2.png" class="img10" />
						<img src="${ctx }/cij/img/page5_p2.png" class="img11" />
					</div>
					<div class="page7">
						<img src="${ctx }/cij/img/page7_p1.png" class="img1" />
						<img src="${ctx }/cij/img/page7_p2.png" class="img2" />
						<img src="${ctx }/cij/img/page7_p3.png" class="img3" />
						<img src="${ctx }/cij/img/page7_p4.png" class="img4" />
						<img src="${ctx }/cij/img/page7_p5.png" class="img5" />
						<img src="${ctx }/cij/img/page7_p6.png" class="img6" />
						<p>至小丸子</p>
					</div>
				</div>
			</div>
		<!--音樂-->
		<audio autoplay="autoplay" controls="controls" id="yin" style="opacity: 0;">
		  <source src="yin.mp3" type="audio/mpeg">
			Your browser does not support the audio element.
		</source>
		</audio>
		<script type="text/javascript">
			$(function(){
				$(".page1").find(".img4").click(function(){
					$(".page1").find(".xiang").fadeIn();
					$(".page1").find(".xiang").children("img").addClass("xiang_p");
					$(".page1").find(".xiang").children("p").addClass("xiang_p");
					$(".xiang").click(function(){
						$(this).hide();
					});
					setTimeout(function(){
						$(".xiang").hide();
					},5000);
				});
			});
		</script>
		<script type="text/javascript">
		if(window.screen.width < 800) {
			var wechatInfo = navigator.userAgent.match(/MicroMessenger\/([\d\.]+)/i);
			if(wechatInfo[1] < "6.0") {
				alert("为了看到更好的页面效果，请更新你的微信!");
			}
		}
		</script>
		<script>
			var x = document.getElementById("yin");
			var bo=true;
			$("#img1").click(function(){
				if(bo){
					x.pause();
					$(this).removeClass("pg1_img").css("opacity","1");
					$(this).attr("src","img/pause.png")
					bo=false;
				}else{
					x.play();
					$(this).addClass("pg1_img");
					$(this).attr("src","img/page1_p1.png")
					bo=true;
				}
			});
		</script>
		<!--音樂-->
		<script>
			$(function() {
				$(".word").each(function() {
					var old = $(this).text();
					var len = $(this).text().length;
					var nn = old.substring(0, 2);
					var ee = old.substring(2, len);
					$(this).html("<font style='font-size: 30px;'>" + nn + "</font>" + ee);
				});
				$("#img1").addClass("pg1_img");
				$(".page7").find(".img4").addClass("qiu");
				$(".page7").find(".img5").addClass("qiu2");
				$(".page7").find(".img6").addClass("qiu3");
				$(".page7").find(".img2").addClass("left_yue");
				$(".page7").find(".img3").addClass("right_yue");
				$(".page7").find("p").addClass("qiu4");
				$(".page7").find(".img1").addClass("qiu5");
			});
			document.body.addEventListener('touchmove', function(event) {
				event.preventDefault();
			}, false);
		</script>
		<!--滚动效果-->
		<script>
			$(function() {
				$(".page7").find(".img6").click(function() {
					$(".message").addClass("big");
					$(".page6").find(".img11").addClass("p6_an1");
					$(".page6").find(".img8").addClass("p6_an2");
					$(".page6").find(".img9").addClass("p6_an3");
					$(".page6").find(".img10").addClass("p6_an4");
					$(".page6").find(".img5").addClass("p6_an5");
					$(".page6").find(".img6").addClass("p6_an6");
					$(".page5").find("p").addClass("pg5_p");
					$(".page5").find(".img4").addClass("pg5_img4");
					$(".page5").find(".img3").addClass("pg5_img3");
					$(".page5").find(".img2").addClass("pg5_img2");
					$(".page5").find(".to_top").addClass("tt");
				});
				$(".page5").find(".to_top").click(function() {
					$(".message").addClass("big2");
					$(".page5").find(".img3").addClass("p6_an7");
					$(".page4").find(".img4").addClass("left_yue2");
					$(".page4").find(".img3").addClass("pg5_img2");
					$(".page4").find(".img5").addClass("pg5_img");
					$(".page3").find(".img5").addClass("pg5_img3");
					$(".page3").find(".img4").addClass("page3_img4");
					$(".page3").find(".img2").addClass("pg5_i3");
					$(".page3").find("p").addClass("pg3_p");
					$(".page3").find(".img1").addClass("pg5_i1");
					$(".page3").find(".img3").addClass("page3_img3");
					$(".page3").find(".to_top").addClass("tt");
				});
				$(".page3").find(".to_top").click(function() {
					$(".message").addClass("big3");
					$(".page2").find("p").addClass("pg2_p");
					$(".page2").find("span").addClass("pg2_p");
					$(".page2").find(".img6").addClass("p2_right_yue");
					$(".page2").find(".img5").addClass("pg5_img");
					$(".page2").find(".img4").addClass("pg2_img4");
					$(".page2").find(".img1").addClass("pg2_img1");
					$(".page2").find(".img2").addClass("page3_img3");
					$(".page2").find(".img3").addClass("right_yue");
					$(".page2").find(".to_top").addClass("tt2");
					$(".page3").find(".img2").addClass("p6_an8");
				});
				$(".page2").find(".to_top").click(function() {
					$(".message").addClass("big4");
					$(".page1").find(".img2").addClass("pg3_img1");
					$(".page1").find(".img4").addClass("p1_left_yue");
					$(".page1").find(".img5").addClass("p1_right_yue");
					$(".page1").find(".img1").addClass("pg1_img");
					$(".page1").find(".img3").addClass("pg3_img1");
					$(".page2").find(".img4").addClass("p6_an8");
					$(".page1").find(".img6").addClass("p6_an9");
				});
			});
		</script>
	</body>

</html>