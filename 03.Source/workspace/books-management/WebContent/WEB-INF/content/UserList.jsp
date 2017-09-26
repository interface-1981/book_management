<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			sample
		</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

		<script>

		</script>
	</head>
	<body>
		<s:form cssClass="form-horizontal" action="/userlist/search">
			<div class="form-group">
				<div class="col-sm-12" >
					<div class="col-sm-12">
						<div class="col-sm-4">
							<label class="control-label">ユーザー名:</label>
						</div>
						<div class="col-sm-8">
							<s:textfield name="userList.userCriteria"  cssClass="form-control"/>
						</div>
					</div>
					<div class="col-sm-12">
						<s:submit value="Search" cssClass="btn btn-primary"/>
					</div>
					<div class="col-sm-12">
						<table class="table table-striped table-hover">
							<tr>
								<th>ID</th>
								<th>Name</th>
							</tr>

							<s:iterator value="userList.results">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="name" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
		</s:form>
	</body>
</html>
