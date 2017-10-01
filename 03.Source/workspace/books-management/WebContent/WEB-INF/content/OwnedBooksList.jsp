<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<s:form cssClass="form-horizontal" action="/owned_books_list/search">
		<div class="form-group">
			<div class="col-sm-12" >
				<div class="col-sm-12">
					<div class="col-sm-4">
						<label class="control-label">ユーザー名:</label>
					</div>
					<div class="col-sm-8">
						<s:textfield name="ownedBooksSearchDto.userCriteria"  cssClass="form-control"/>
					</div>
				</div>
				<div class="col-sm-12">
					<s:submit value="Search" cssClass="btn btn-primary"/>
				</div>
				<div class="col-sm-12">
					<table class="table table-striped table-hover">
						<tr>
							<th>ID</th>
							<th>所有者</th>
							<th>書籍名</th>
							<th>著者</th>

						</tr>

						<s:iterator value="ownedBooksSearchDto.results">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="user.name" /></td>
								<td><s:property value="book.title" /></td>
								<td><s:property value="book.author" /></td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</s:form>
</body>
