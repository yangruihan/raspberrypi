<%@ page language="java" import="java.util.*" import="com.yrh.model.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻系统 - 首页</title>
<meta name="description" content="软酷新闻发布系统" />
<meta name="keywords" content="软酷网 新闻发布" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- header start -->
	<div class="header">
		<div class="toplinks">
			<%
				User user = (User) session.getAttribute("user");
				if (user != null) {
					if (user.getRole() == 1) {
						out.print("您好："
								+ user.getName()
								+ "，欢迎使用新闻系统！<span>【<a href=\"toAdmin\" target=\"_top\">进入管理界面</a>】【<a href=\"logout\" target=\"_top\">注销登录</a>】</span>");
					} else if (user.getRole() == 0) {
						out.print("您好："
								+ user.getName()
								+ "，欢迎使用新闻系统！<span>【<a href=\"toEditor\" target=\"_top\">进入管理界面</a>】【<a href=\"logout\" target=\"_top\">注销登录</a>】</span>");
					} else {
						System.out.println("用户权限错误");
						response.sendRedirect("toError");
					}
				} else {
					out.print("<span>【<a href=\"toRegister\">注册</a>】【<a href=\"toLogin\">登录</a>】</span>");
				}
			%>
		</div>

		<h1>
			<a href="index.htm"><img src="images/logo.png" width="260"
				height="56" alt="新闻系统" /> </a>
		</h1>
	</div>
	<!-- header end -->

	<!-- menu start -->
	<div class="menu">
		<ul>
			<li><a href="index.htm"><span>主页</span> </a></li>

			<li><a href="newsType.htm"><span>国际新闻</span> </a></li>

			<li><a href="newsType.htm"><span>国内新闻</span> </a></li>

			<li><a href="newsType.htm"><span>娱乐新闻</span> </a></li>

			<li><a href="newsType.htm"><span>体育新闻</span> </a></li>

			<li><a href="newsType.htm"><span>财经频道</span> </a></li>

			<li><a href="newsType.htm"><span>汽车频道</span> </a></li>

			<li><a href="newsType.htm"><span>电子频道</span> </a></li>
		</ul>

		<form action="" method="post">
			<input type="hidden" name="newstypeId" value="0" /> <input
				name="name" type="text" class="search-keyword" id="search-keyword"
				value="在这里搜索..." /> <input type="submit" class="search-submit"
				value="搜索" />
		</form>
	</div>
	<!-- menu end -->

	<!-- main start -->
	<div class="main">
		<!-- left start -->
		<div class="left">
			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">国际新闻</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">

						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>

						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>

						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>

						<li><a href="detail.htm">十堰他日必大兴</a></li>

						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>

						<li><a href="detail.htm">红 楼 梦 遗</a></li>

						<li><a href="detail.htm">教师节，那些代课老师们</a></li>

						<li><a href="detail.htm">你所不知道的白岩松</a></li> -->
						
						<%
								ArrayList<News> news = (ArrayList<News>)request.getAttribute("type1");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>

					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">国内新闻</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">

						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>

						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>

						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>

						<li><a href="detail.htm">十堰他日必大兴</a></li>

						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>

						<li><a href="detail.htm">红 楼 梦 遗</a></li>

						<li><a href="detail.htm">教师节，那些代课老师们</a></li>

						<li><a href="detail.htm">你所不知道的白岩松</a></li> -->
						<%
								news = (ArrayList<News>)request.getAttribute("type2");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>

					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">娱乐新闻</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">

						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>

						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>

						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>

						<li><a href="detail.htm">十堰他日必大兴</a></li>

						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>

						<li><a href="detail.htm">红 楼 梦 遗</a></li>

						<li><a href="detail.htm">教师节，那些代课老师们</a></li>

						<li><a href="detail.htm">你所不知道的白岩松</a></li>-->
						<%
								news = (ArrayList<News>)request.getAttribute("type3");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>

					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">体育新闻</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">

						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>

						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>

						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>

						<li><a href="detail.htm">十堰他日必大兴</a></li>

						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>

						<li><a href="detail.htm">红 楼 梦 遗</a></li>

						<li><a href="detail.htm">教师节，那些代课老师们</a></li>

						<li><a href="detail.htm">你所不知道的白岩松</a></li>-->
						
						<%
								news = (ArrayList<News>)request.getAttribute("type4");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>

					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">财经频道</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">
						
						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>
						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>
						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>
						<li><a href="detail.htm">十堰他日必大兴</a></li>
						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>

						<li><a href="detail.htm">红 楼 梦 遗</a></li>
						<li><a href="detail.htm">教师节，那些代课老师们</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>-->
						<%
								news = (ArrayList<News>)request.getAttribute("type5");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>
					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="newsType.htm">汽车频道</a> </strong><span class="more"><a
						href="newsType.htm">更多...</a> </span>
				</dt>
				<dd>
					<ul class="ico3">
						<!-- <li><a href="detail.htm">人无完人，但要注意怎么做人</a></li>
						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>
						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>
						<li><a href="detail.htm">十堰他日必大兴</a></li>
						<li><a href="detail.htm">用批处理实现删除3389终端服务</a></li>
						<li><a href="detail.htm">红 楼 梦 遗</a></li>
						<li><a href="detail.htm">教师节，那些代课老师们</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>-->
						<%
								news = (ArrayList<News>)request.getAttribute("type6");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>
					</ul>
				</dd>
			</dl>
		</div>
		<!-- left end -->

		<!-- right start -->
		<div class="right">
			<dl class="tbox">
				<dt>
					<strong>最新更新</strong>
				</dt>
				<dd>
					<ul class="ico1">
						<!-- <li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li> -->
						<%
								news = (ArrayList<News>)request.getAttribute("reNews");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>
					</ul>
				</dd>
			</dl>

			<dl class="tbox">
				<dt>
					<strong>热点内容</strong>
				</dt>
				<dd>
					<ul class="ico2">
						<!-- <li><a href="detail.htm">教师节，那些代课老师们</a></li>
						<li><a href="detail.htm">十堰他日必大兴</a></li>
						<li><a href="detail.htm">城市千金，我要远离农村婆婆</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a></li>
						<li><a href="detail.htm">十堰他日必大兴</a></li>
						<li><a href="detail.htm">十堰他日必大兴</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li>
						<li><a href="detail.htm">你所不知道的白岩松</a></li> -->
						<%
								news = (ArrayList<News>)request.getAttribute("hotNews");
								if(news != null) {
									for (News n : news) {
										out.print("<li><a href=\"detail.htm\">"+ n.getTitle() +"</a></li>");
									}
								}
						%>
					</ul>
				</dd>
			</dl>
		</div>
		<!-- right end -->
	</div>
	<!-- main end -->

	<!-- footer start -->
	<div class="footer">
		<p>
			Copyright&nbsp;&copy;&nbsp;软酷卓越实验室&nbsp;<a
				href="http://www.ruanko.com" title="软酷网" target="_blank"><strong>软酷网</strong>
			</a>&nbsp;版权所有
		</p>
	</div>
	<!-- footer end -->
</body>
</html>
