<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<s:form cssClass="form-horizontal" action="/book_list/search">
		<div class="form-group">
			<div class="col-sm-12">
				<div class="col-sm-4">
					<label class="control-label">書籍名:</label>
				</div>
				<div class="col-sm-8">
					<s:textfield name="bookSearchDto.titleCriteria"  cssClass="form-control"/>
				</div>

				<div class="col-sm-4">
						<label class="control-label">著者名:</label>
				</div>
				<div class="col-sm-8">
					<s:textfield name="bookSearchDto.authorCriteria"  cssClass="form-control"/>
				</div>
				</div>
					<div class="col-sm-12">
				<s:submit value="Search" cssClass="btn btn-primary"/>
			</div>
			<div class="col-sm-12">
				<table class="table table-striped table-hover">
					<tr>
						<th>ID</th>
						<th>書籍名</th>
						<th>著者名</th>
					</tr>
					<s:iterator value="bookSearchDto.results">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="title" /></td>
							<td><s:property value="author" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</s:form>
</body>
