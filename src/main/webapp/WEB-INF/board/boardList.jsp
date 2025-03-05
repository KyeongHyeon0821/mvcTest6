<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>boardList.jsp</title>
  <jsp:include page="/include/bs5.jsp"/>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2 class="text-center">게시판 리스트 연습입니다</h2>
  <br/>
  <div class="row">
	  <div class="col mb-2"><a href="boardInput.bo" class="btn btn-success ">글쓰기</a></div>
  </div>
  <table class="table table-hover">
    <tr class="table-secondary text-center">
      <th>번호</th>
      <th>글제목</th>
      <th>글쓴이</th>
      <th>글쓴날짜</th>
      <th>조회수</th>
    </tr>
		<c:forEach items="${vos }" var="vo" varStatus="st">
	    <tr class="text-center">
	  <%-- <td>${fn:length(vos) - st.index}</td> --%>
	      <td>${boardLength - st.index}</td>
	      <td class="text-start"><a class="text-dark link-primary link-underline-opacity-0 link-underline-opacity-100-hover" href="boardContent.bo?idx=${vo.idx }">${vo.title }</a></td>
	      <td>${vo.name }</td>
	      <td>${vo.wDate }</td>
	      <td>${vo.readNum }</td>
	    </tr>
		</c:forEach>
  </table>
</div>
</body>
</html>