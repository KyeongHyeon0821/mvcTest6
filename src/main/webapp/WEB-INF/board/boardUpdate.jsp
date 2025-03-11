<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardUpdate.jsp</title>
	<%@ include file="/include/bs5.jsp"%>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2 class="text-center">게시판 글 수정</h2>	
	<br/>
	<form method="post" action="boardUpdateOk.bo">
		<table class="table table-bordered">
			<tr>
				<th class="text-center align-middle bg-body-secondary">글쓴이</th>
				<td><input class="form-control" type="text" name="name" value="${vo.name }" autofocus placeholder="글쓴이를 입력하세요" required></td>
			</tr>
			<tr>
				<th class="text-center align-middle bg-body-secondary">제목</th>
				<td><input class="form-control" type="text" name="title" value="${vo.title }" size="58" placeholder="글제목을 입력하세요" required></td>
			</tr>
			<tr>
				<th class="text-center align-middle bg-body-secondary">내용</th>
				<td><textarea class="form-control" rows="8" name="content" required>${vo.content }</textarea></td>
			</tr>
		</table>
		<div class="text-center row">
			<div class="col text-start"><input type="submit" value="수정하기" class="btn btn-success" /> &nbsp;</div>
			<div class="col text-end"><input type="button" value="돌아가기" onclick="location.href='boardList.bo'" class="btn btn-primary" /></div>
		</div>
		<input type="hidden" name="idx" value="${vo.idx }" />
	</form>
</div>
</body>
</html>