<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="row" tyle="margin: 100px;"><br>
		<div class="panel-head" style="margin-right: 100px;">
	<a href="/user/login"><button id="#regBtn" type="button" class="btn btn-primary pull-right" >로그인</button></a> 
		<a href="/user/sign"><button id="#regBtn" type="button" class="btn btn-primary pull-right" >회원가입</button></a><br>		
	</div>
  <jsp:include page="top.jsp" /> 

		  	<div class="panel-body" style="margin: 100px;">
		  <a href="/board/register"><button id="#regBtn" type="button" class="btn btn-primary pull-right" >게시물 등록</button></a>
		  
			<form action="/board/list" method="post">
				<table width="50%">
					<tr>
						<td width="10%"><select name="type">
								<option value="---">---</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="writer">작성자</option>
						</select></td>
						<td width="90%"><div class="input-group" width="50%">
								<input type="text" class="form-control" placeholder="Search"
									name="keword">
								<div class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div></td>
					</tr>
				</table>


				<!--   <input type="text" name="keword" >
		  <button class="btn btn-primary">검색</button> -->
			</form>
		</div>
			<div class="panel-body" style="margin: 100px;">
				<table class="table table-striped table-bordered table-hover">
					<thead>
					<!-- 	<th>번호</th> -->
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					<!-- 	<th>수정일</th> -->
					</thead>
					<c:forEach items="${list}" var="board">
						<tr>
						<%-- 	<td><c:out value="${board.bno}"></c:out></td> --%>
							<td><a href="/board/get?bno=<c:out value='${board.bno}'/>">
							<c:out value="${board.title}"></c:out>
							<c:if test="${board.replyCnt != 0}">
							<strong>[<c:out value="${board.replyCnt }"/>]</strong>
							</c:if>
							</a></td>
							<td><c:out value="${board.writer}"></c:out></td>
							<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
						<%-- 	<td><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd" /></td> --%>
						</tr>
					</c:forEach>
				</table>

				
			</div>
	</div>
</body>
</html>