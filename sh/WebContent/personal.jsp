<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>极限滑雪城--个人中心</title>
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
					<a href="${ctx }/successLogin.jsp"><li>首页</li></a>
					<a href="${ctx }/blog.jsp"><li>BLOG</li></a>
					<a href="${ctx }/personal.jsp"><li>个人中心</li></a>
					<a href="${ctx }/message.jsp"><li>留言板</li></a>
				</ul>
			</div>
			<div class="hea_right">
				<p>
					<a>你好，十二月</a>|<a href="/sh/loginuser/destory">退出</a>
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
		<div class="personal">
			<p class="title">我的账户<span>您好，liuxw.特洛夫斯基</span></p>
			<ul class="per_nav">
				<li class="active">我的商品</li>
				<li>客户管理</li>
				<li>订单管理</li>
				<li>我的留言</li>
				<li>新增商品</li>
			</ul>
			<ul class="per_nav2">
				<li class="active">订单</li>
				<li>信息</li>
				<li>优惠卷</li>
				<li>留言</li>
			</ul>
			<div class="per_box">
				<ul class="per_navul">
					<li style="width: 130px;margin-right: 10px;">
						<input type="checkbox" style="margin-right: 20px;"/>
						全选
					</li>
					<li style="width: 450px;text-align: left;">商品名称</li>
					<li>单价</li>
					<li>修改</li>
					<li>删除</li>
				</ul>
				<c:forEach items="${page.list}" var="p">
					<ul class="per_listul">
						<li style="width: 130px;margin-right: 10px;">
							<input type="checkbox" style="margin-right: 10px;margin-left: 18px;"/>
							<img src="${ctx }/${p.listimg }" width="30" height="40" style="vertical-align: middle;"/>
						</li>
						<li style="width: 450px;text-align: left;">${p.name }</li>
						<li>￥ ${p.price }</li>
						<li><a href="editProduct?id=${p.id }">修改</a></li>
						<li><a href="deleteProduct?id=${p.id }">删除</a></li>
					</ul>
				</c:forEach>
				<table align="right">
					<tr><td colspan="5">共有${page.totalCount }条数据，一共${page.totalPageNum }页
					<a href="productpage?pageNum=1&ac=1">首页</a>
					<a href="productpage?pageNum=${page.prePageNum }&ac=1">上一页</a>
					<a href="productpage?pageNum=${page.nextPageNum }&ac=1">下一页</a>
					<a href="productpage?pageNum=${page.totalPageNum }&ac=1">末页</a>
					</td></tr>
				</table>
			</div>
			<div class="per_box per_info" style="display: none;">
				<ul class="per_navul">
					<li style="width: 130px;margin-right: 10px;">
						<input type="checkbox" style="margin-right: 20px;"/>
						全选
					</li>
					<li style="width: 450px;text-align: left;">客户</li>
					<li  style="width: 120px;text-align: left;">客户邮箱</li>
					<li>是否登录</li>
					<li>是否激活</li>
					<li>删除</li>
				</ul>
				<c:forEach items="${users}" var="u">
					<ul class="per_listul">
						<li style="width: 130px;margin-right: 10px;">
							<input type="checkbox" style="margin-right: 10px;margin-left: 18px;"/>
							<img src="${ctx }/images/e1.jpg" width="30" height="40" style="vertical-align: middle;"/>
						</li>
						<li style="width: 450px;text-align: left;">${u.lastname }${u.firstname }</li>
						<li style="width: 120px;text-align: left;">${u.email }</li>
						<c:if test="${u.admainac==1 }"><li>已登录</li></c:if>
						<c:if test="${u.admainac==0 }"><li>未登录</li></c:if>
						<c:if test="${u.active==1 }"><li>已激活</li></c:if>
						<c:if test="${u.active==0 }"><li>未激活</li></c:if>
						<li><a href="userController/deleteUser?id=${u.id }">删除</a></li>
					</ul>
				</c:forEach>
			</div>
			<div class="per_box per_coupon" style="display: none;">
				<c:if test="${list==null }">
					<h4 class="title">订单是空的</h4>
					<p class="cart">您的客户还没有购买商品<br>点击<a href="productlist2"> 这里</a>添加订单</p>
				</c:if>
				<c:if test="${list!=null }">
				<ul class="per_navul">
					<li style="width: 130px;margin-right: 10px;">
						<input type="checkbox" style="margin-right: 20px;"/>
						全选
					</li>
					<li style="width: 100px;text-align: left;">客户</li>
					<li  style="width: 120px;text-align: left;">订单编号</li>
					<li>商品</li>
					<li>商品名字</li>
					<li>商品数量</li>
					<li>商品价格</li>
					<li>取消订单</li>
				</ul>
				
				<c:forEach items="${list }" var="l">
					<ul class="per_listul">
						<li style="width: 130px;margin-right: 10px;">
							<input type="checkbox" style="margin-right: 10px;margin-left: 18px;"/>
							<img src="${ctx }/images/e1.jpg" width="30" height="40" style="vertical-align: middle;"/>
						</li>
						<li style="width: 100px;text-align: left;">${u.lastname }${u.firstname }</li>
						<li style="width: 120px;text-align: left;">${orderid }</li>
						<li style="width: 120px;text-align: middle;"><img width="40" height="45" src="${ctx }/${l.getProduct().getListimg() }"/></li>
						<li>${l.getProduct().getName() }</li>
						<li>${l.getCount()}</li>
						<li>${l.getProduct().getPrice()}</li>
						<li><a href="/sh/Order/deleteOrder?orderId=${l.getProduct().getId()}&deo=1">取消订单</a></li>
					</ul>
				</c:forEach>
				</c:if>
			</div>
			<div class="per_box" style="display: none;">
				我的留言
			</div>
			<div class="per_box per_info" style="display: none;">
				<form action="/sh/product/addProduct1" method="post" enctype="multipart/form-data">
					产品类型：<select name="producttypeid">
							<c:forEach items="${pts }" var="pt">
								<option value="${pt.id }">${pt.name }</option>
							</c:forEach>
							</select><br>
							产品名字：<input type="text" name="name" /><br>
							产品颜色：<input type="text" name="color" /><br>
							产品价格：<input type="text" name="price" /><br>
							产品描述：<input type="text" name="description" /><br>
							产品照片：<input type="file" name="img" /><br>
							<input type="submit" value="新增">
				</form>
			</div>
		</div>
		<script>
			$(function(){
				$(".per_couponul li").click(function(){
					$(".per_couponul li").removeClass("active");
					$(this).addClass("active");
					$(".per_coupon_box").hide();
					$(".per_coupon_box").eq($(".per_couponul li").index(this)).fadeIn();
				});
				$(".per_nav li").click(function(){
					$(".per_nav li").removeClass("active");
					$(this).addClass("active");
					$(".per_box").hide();
					$(".per_box").eq($(".per_nav li").index(this)).fadeIn();
				});
				$(".per_nav2 li").click(function(){
					$(".per_nav2 li").removeClass("active");
					$(this).addClass("active");
					$(".per_box").hide();
					$(".per_box").eq($(".per_nav2 li").index(this)).fadeIn();
				});
			});
				</script>
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
		<script type="text/javascript">
			$(function(){
				$(".res_nav").children("li").click(function(){
					$(".res_nav").children("li").stop().removeClass("active");
					$(this).stop().addClass("active");
					$(".res_form").stop().slideUp();
					$(".res_form").eq($(".res_nav").children("li").index(this)).stop().slideDown();
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