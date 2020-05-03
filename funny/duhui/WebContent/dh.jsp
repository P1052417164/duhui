<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="video-js.min.css" rel="stylesheet" type="text/css">
<script src="jquery.js"></script>

<title>灰灰的喜悦</title>
</head>
<body>
<div align="center">
	<video id='myvideo' width=1280 height=720 class="video-js vjs-default-skin" controls  autoplay="true" preload="auto" data-setup="{}">
	    <source id="src1" src="rtmp://47.96.169.248:8081/duhui/dh" type='rtmp/flv'>
	    <source id="src2" src="http://47.96.169.248/hls/dh.m3u8">
	    <source id="src3" src="http://47.96.169.24/22.mp4" type="video/mp4">  
	</video>
</div>
</body>
<script src="dh.js"></script>
<script src="video.min.js"></script>
<script src="videojs-flash.min.js"></script>
<script> 
	var player = videojs('myvideo', {}, function(){console.log('videojsdd')})
	player.play();
</script>
</html>