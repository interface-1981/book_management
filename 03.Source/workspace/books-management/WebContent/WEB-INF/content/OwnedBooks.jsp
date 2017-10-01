<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<s:form cssClass="form-horizontal" action="/owned_books/regist">
		<div class="form-group">
			<div class="col-sm-12" >
				<div class="col-sm-12">
					<div class="col-sm-4">
						<label class="control-label">ユーザー名:</label>
					</div>
					<div class="col-sm-8">
						<s:select name="userId" listKey="id" listValue="name" list="userList" class="form-control" />
					</div>
					<div class="col-sm-4">
						<label class="control-label">書籍名:</label>
					</div>
					<div class="col-sm-8">
						<s:select name="bookId" listKey="id" listValue="title" list="bookList" class="form-control" />
					</div>
				</div>
				<div class="col-sm-12">
					<s:submit value="Save" cssClass="btn btn-primary"/>
				</div>
			</div>
		</div>
	</s:form>
</body>
