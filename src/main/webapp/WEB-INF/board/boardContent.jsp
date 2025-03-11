<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLine", "\n"); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>boardContent.jsp</title>
  <jsp:include page="/include/bs5.jsp"/>
  <script>
    'use strict';
  
    function delCheck() {
    	let ans = confirm("현재 게시글을 삭제하시겠습니까?");
    	if(ans) location.href = "boardDelete.bo?idx=${vo.idx}";
    }
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2 class="text-center">게시판 상세보기234234</h2>
  <table class="table table-bordered">
    <tr>
      <th class="text-center align-middle bg-body-secondary">글쓴이</th><td>${vo.name}</td>
      <th class="text-center align-middle bg-body-secondary">글쓴날짜</th><td>${vo.wDate}</td>
    </tr>
    <tr>
      <th class="text-center align-middle bg-body-secondary">글조회수</th><td>${vo.readNum}</td>
      <th class="text-center align-middle bg-body-secondary">접속IP</th><td>${vo.hostIp}</td>
    </tr>
    <tr>
      <th class="text-center align-middle bg-body-secondary">글제목</th><td colspan="3">${vo.title}</td>
    </tr>
    <tr>
      <th class="text-center align-middle bg-body-secondary" style="height:350px">글내용</th><td colspan="3">${fn:replace(vo.content, newLine, "<br/>")}</td>
    </tr>
  </table>
  <br/>
  <div class="row">
    <div class="col"><a class="btn btn-info" href="boardList.bo">돌아가기</a></div>
    <div class="col text-end">
	    <a class="btn btn-outline-danger" href="javascript:delCheck()">삭제</a>
	    <a class="btn btn-outline-warning" href="boardUpdate.bo?idx=${vo.idx }">수정</a>
    </div>
  </div>
</div>
</body>
</html>