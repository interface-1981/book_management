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
		<s:form cssClass="form-horizontal" action="/book/regist">
			<div class="form-group">
				<div class="col-sm-12" >
					<div class="col-sm-12">
						<div class="col-sm-4">
							<label class="control-label">書籍名:</label>
						</div>
						<div class="col-sm-8">
							<s:textfield name="book.title"  cssClass="form-control"/>
						</div>
						<div class="col-sm-4">
							<label class="control-label">著者:</label>
						</div>
						<div class="col-sm-8">
							<s:textfield name="book.author"  cssClass="form-control"/>
						</div>
					</div>
					<div class="col-sm-12">
						<s:submit value="Save" cssClass="btn btn-primary"/>
					</div>
				</div>
			</div>
		</s:form>
	</body>
</html>
