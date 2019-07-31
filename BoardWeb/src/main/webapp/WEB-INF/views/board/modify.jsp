<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script><style>
body{
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
  padding:60px;
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
					<h5 class="card-title text-center" >게시물 수정</h5>
					<form class="form-signin" id="modform" role="modform" action="/board/modify" method="post">
						<label>번호</label>
						<div class="form-label-group">
							<input name="bno" value="${board.bno}" readonly="readonly"
								class="form-control">
						</div>
						<label>제목</label>
						<div class="form-label-group">
							<input name="title" value="${board.title}" class="form-control">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="content" class="form-control" rows="5" >${board.content}</textarea>
						</div>
						<label>작성자</label>
						<div class="form-label-group">
							<input name="writer" value="${board.writer}" class="form-control">
						</div>

						<div class="btn-group" align="center"  style="margin-top:50px; width:100%;">
				     <button type="button" class="btn btn-primary">게시물 저장</button>
				    <button type="button" class="btn btn-primary" onClick="location.href='/board/list'">목록으로</button>
				  </div>
		
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>