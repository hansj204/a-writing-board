<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
body {
	background: #f5cab8;
}

.card-signin {
	border: 0;
	background: #ffffff;
	border-radius: 1rem;
	box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.5);
	margin-top: 100px;
}

.card-signin .card-title {
	margin-bottom: 2rem;
	font-weight: 100;
	font-size: 50px;
}

.card-signin .card-body {
	padding: 60px;
}

.form-signin {
	width: 100%;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="card card-signin">
				<div class="card-body">
					<h5 class="card-title text-center">게시물 조회</h5>
					<form class="form-signin">
						<label>번호</label>
						<div class="form-label-group">
							<input name="bno" value="${board.bno}" readonly="readonly"
								class="form-control">
						</div>
						<label>제목</label>
						<div class="form-label-group">
							<input name="title" value="${board.title}" readonly="readonly"
								class="form-control">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="5" id="content"
								readonly="readonly">${board.content}</textarea>
						</div>
						<label>작성자</label>
						<div class="form-label-group">
							<input name="writer" value="${board.writer}" readonly="readonly"
								class="form-control">
						</div>

						<div class="btn-group" align="center"
							style="margin-top: 50px; width: 100%;">
							<a href="/board/modify?bno=${board.bno}">
								<button type="button" class="btn btn-primary">게시물 수정</button>
							</a> <a href="/board/remove?bno=${board.bno}"><button
									type="button" class="btn btn-primary">게시물 삭제</button></a> <a
								href="/board/list"><button type="button"
									class="btn btn-primary">목록으로</button></a>
						</div>
					</form>
				</div>


				<div class="panel panel-default">
					<div class="panel-heading">댓글</div>
				</div>
				<form id="newForm" action="/replies/new" method="post">
						<input name="replyer" value='${board.writer}' type="hidden">
						<table style="width: 90%;" align="center">
							<tr>
								<td width="85%" align="center"><textarea rows="2"
										class="form-control" name="reply"></textarea></td>
								<td width="15%" align="center"><button id="btn4"
										class="btn btn-primary">작성</button> <input name="bno" id="bno"
									value='${board.bno}' type="hidden"></td>
							</tr>
						</table>
				</form>
				<br>
				<div class="container" style="margin-bottom: 8%;">
					<c:forEach items="${replylist}" var="replyVO">
						<table class="table">
							<tr>
								<td width="20%" align="center">${replyVO.replyer}</td>
								<td width="40%" align="center">${replyVO.reply}</td>
								<td width="15%" align="center"><fmt:formatDate
										value='${replyVO.replyDate}' pattern="yyyy/MM/dd hh:mm:ss" /></td>
								<td width="20%" align="center">
									<form action="/replies/delete" method="post">
										<c:choose>
											<c:when test="${board.writer == replyVO.replyer}">
												<button class="btn btn-waring">X</button>
												<input name="bno" id="bno" value='${board.bno}'
													type="hidden">
												<input name="rno" id="rno" value='${replyVO.rno}'
													type="hidden">
											</c:when>

										</c:choose>
									</form>
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
