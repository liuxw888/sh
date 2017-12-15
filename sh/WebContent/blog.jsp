<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>极限滑雪城--BLOG</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, width=device-width">
		<link rel="stylesheet" href="${ctx }/cij/css/demo.css" />
		<link rel="stylesheet" href="${ctx }/cij/css/style.css" />
		<link rel="stylesheet" href="${ctx }/cij/css/fen.css" />
		<script type="text/javascript" src="${ctx }/cij/js/jquery-2.2.0.min.js"></script>
	</head>

	<body>
		<div class="header">
			<div class="hea_nav">
				<ul>
					<a href="index.html"><li>首页</li></a>
					<a href="blog.html"><li>BLOG</li></a>
					<a href="personal.html"><li>个人中心</li></a>
					<a href="message.html"><li>留言板</li></a>
				</ul>
			</div>
			<div class="hea_right">
				<p>
					<a href="register.html">注册</a>|<a class="login_btn">登录</a>
				</p>
			<a href="shop_car.html"><p>
						<i class="iconfont">&#xe600;</i>
						<span>0件</span>
					</p>
					</a>
			</div>
		</div>
		<div class="header2">
				<img src="${ctx }/cij/img/phone_meau.png" class="meau"/>
				<a href="index.html"><img src="${ctx }/cij/img/logo.png" class="logo"/></a>
				<a href="shop_car.html"><i class="iconfont">&#xe600;</i><span>1</span></a>
				<ul class="meau_box">
					<a href="index.html"><li>首页</li></a>
					<a href="product.html"><li>叮咚一下</li></a>
					<a href="blog.html"><li>BLOG</li></a>
					<a href="personal.html"><li>个人中心</li></a>
					<a href="message.html"><li>留言板</li></a>
					<p style="border-right:1px #fff solid;" class="login_btn">登录</p>
					<a href="register.html"><p>注册</p></a>
				</ul>
			</div>
			<script>
				$(function(){
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
		<div class="blog">
			<div class="blog_list">
				<p class="title">2016年1月15日 花束主题 | 感谢之意</p>
				<p class="date">2016/01/25</p>
				<p class="info">待客人们各自找到自己最舒适的位置，慢慢的喝着咖啡，我们再点上几只蜡烛，播上音乐。我们的感谢之意就这样开始了。想要坐到他们身边，
					看着他们的眼睛，问他们近况如何，听他们讲自己的生活，自己的爱人，自己的孩子，自己的小狗，自己的一切一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下
				</p>
				<a href="blog_list.html"><div class="b_l_bg">
					<img src="${ctx }/cij/img/blog_p1.png" />
				</div></a>
			</div>
			<div class="blog_list">
				<p class="title">2016年1月15日 花束主题 | 感谢之意</p>
				<p class="date">2016/01/25</p>
				<p class="info">待客人们各自找到自己最舒适的位置，慢慢的喝着咖啡，我们再点上几只蜡烛，播上音乐。我们的感谢之意就这样开始了。想要坐到他们身边，
					看着他们的眼睛，问他们近况如何，听他们讲自己的生活，自己的爱人，自己的孩子，自己的小狗，自己的一切一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下
				</p>
				<a href="blog_list.html"><div class="b_l_bg">
					<img src="${ctx }/cij/img/blog_p1.png" />
				</div></a>
			</div>
			<div class="blog_list">
				<p class="title">2016年1月15日 花束主题 | 感谢之意</p>
				<p class="date">2016/01/25</p>
				<p class="info">待客人们各自找到自己最舒适的位置，慢慢的喝着咖啡，我们再点上几只蜡烛，播上音乐。我们的感谢之意就这样开始了。想要坐到他们身边，
					看着他们的眼睛，问他们近况如何，听他们讲自己的生活，自己的爱人，自己的孩子，自己的小狗，自己的一切一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下
				</p>
				<a href="blog_list.html"><div class="b_l_bg">
					<img src="${ctx }/cij/img/blog_p1.png" />
				</div></a>
			</div>
			<div class="blog_list">
				<p class="title">2016年1月15日 花束主题 | 感谢之意</p>
				<p class="date">2016/01/25</p>
				<p class="info">待客人们各自找到自己最舒适的位置，慢慢的喝着咖啡，我们再点上几只蜡烛，播上音乐。我们的感谢之意就这样开始了。想要坐到他们身边，
					看着他们的眼睛，问他们近况如何，听他们讲自己的生活，自己的爱人，自己的孩子，自己的小狗，自己的一切一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下一切，我们就静静的听着就好。
					就这样慢慢的聊下去，也不觉得时间将尽，我们一起看日落，一起看晚霞，直到夜幕降临。在漫天繁星下
				</p>
				<a href="blog_list.html"><div class="b_l_bg">
					<img src="${ctx }/cij/img/blog_p1.png" />
				</div></a>
			</div>
		</div>
		<div class="login_bg">
			<div class="login">
				<img src="${ctx }/cij/img/close.png" class="close"/>
				<img src="${ctx }/cij/img/login.png" style="margin: 25px 0px;"/>
				<form action="" method="post">
					<p class="list">
						<img src="${ctx }/cij/img/login_pic2.png"/>
						<input type="text" placeholder="请输入注册时的邮箱/手机号"/>
					</p>
					<p class="list">
						<img src="${ctx }/cij/img/login_pic3.png"/>
						<input type="password" placeholder="请输入注册时的邮箱/手机号"/>
					</p>
					<a href="find.html">忘记密码?</a>
					<p>
						<a href="register.html">注册</a>
						<a>登录</a>
					</p>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$(".close").click(function(){
					$(".login_bg").fadeOut();
				});
				$(".login_btn").click(function(){
					$(".login_bg").slideDown();
					$(".meau_box").slideUp();
				});
			});
		</script>
		<div class="footer">
			<div class="footer_con">
				<p>享有 | enjoy</p>
				<img src="${ctx }/cij/img/footer.png" />
			</div>
			<div class="footer_con2">
				<p>© 2015 dingdongyouli.com All rights reserved.</p>
				<img src="${ctx }/cij/img/footer_p2.jpg" />
			</div>

		</div>
	</body>

</html>