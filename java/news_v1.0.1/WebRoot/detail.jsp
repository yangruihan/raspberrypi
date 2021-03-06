<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ page import="com.yrh.model.*" import="com.yrh.service.*" %>
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
<title>新闻系统 - 新闻详情页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- header start -->
	<div class="header">
		<div class="toplinks">
			<span>【<a href="register.htm">注册</a>】【<a href="login.htm">登录</a>】</span>
		</div>

		<h1>
			<a href="index"><img src="images/logo.png" width="260"
				height="56" alt="新闻系统" /> </a>
		</h1>
	</div>
	<!-- header end -->

	<!-- menu start -->
	<div class="menu">

		<ul>
			<li><a href="index"><span>主页</span> </a>
			</li>

			<li><a href="toNewsType?typeid=1"><span>国际新闻</span> </a>
			</li>

			<li><a href="toNewsType?typeid=2"><span>国内新闻</span> </a>
			</li>

			<li><a href="toNewsType?typeid=3"><span>娱乐新闻</span> </a>
			</li>

			<li><a href="toNewsType?typeid=4"><span>体育新闻</span> </a>
			</li>

			<li><a href="toNewsType?typeid=5"><span>财经频道</span> </a>
			</li>

			<li><a href="toNewsType?typeid=6"><span>汽车频道</span> </a>
			</li>

			<li><a href="toNewsType?typeid=7"><span>电子频道</span> </a>
			</li>
		</ul>


		<!-- <form action="" method="post">
			<input type="hidden" name="newstypeId" value="0" /> <input
				name="name" type="text" class="search-keyword" id="search-keyword"
				value="在这里搜索..." /> <input type="submit" class="search-submit"
				value="搜索" />
		</form> -->
	</div>
	<!-- menu end -->

	<!-- main start -->
	<div class="main">
		<!-- left start -->
		<div class="left">
			<div class="place">
				<strong>当前位置:</strong> 主页 &gt; 文章查看
			</div>
			<%
				News news = (News)request.getAttribute("news");
			 %>

			<div class="viewbox">
				<div class="title">
					<h2><%= news.getTitle() %></h2>
				</div>
				<div class="info">
					<small>时间:</small><%= news.getCreateTime() %> <small>来源:</small><%= news.getSource() %> <small>作者:</small><%=news.getAuthor() %>
					<small>点击:</small><%= news.getClick() %>
				</div>
				<div class="content"><%= news.getContent() %></div>

			</div>
			<!-- viewbox end -->

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
						<%
								ArrayList<News> newsList = new ArrayList<News>();
								newsList = (ArrayList<News>)request.getAttribute("reNews");
								if(news != null) {
									for (News n : newsList) {
										out.print("<li><a href=\"toNewsDetail?newsid="+n.getId()+"\"  target=\"_blank\">"+ n.getTitle() +"</a></li>");
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
						<%
								newsList = (ArrayList<News>)request.getAttribute("hotNews");
								if(news != null) {
									for (News n : newsList) {
										out.print("<li><a href=\"toNewsDetail?newsid="+n.getId()+"\"  target=\"_blank\">"+ n.getTitle() +"</a></li>");
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
