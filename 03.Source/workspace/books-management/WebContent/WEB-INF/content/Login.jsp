<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<s:form cssClass="form-horizontal" action="/login">
		<div class="form-group">
			<div class="col-sm-12" >
				<div class="col-sm-12">
					<div class="col-sm-12">
						<s:actionmessage class="text-success" />
						<s:actionerror class="text-danger" />
						<s:fielderror class="text-danger" />
					</div>
					<div class="col-sm-4">
						<label class="control-label">ユーザー名:</label>
					</div>
					<div class="col-sm-8">
						<s:textfield name="user.name"  cssClass="form-control"/>
					</div>
					<div class="col-sm-4">
						<label class="control-label">パスワード:</label>
					</div>
					<div class="col-sm-8">
						<s:password name="user.password"  cssClass="form-control"/>
					</div>
				</div>
				<div class="col-sm-12">
					<s:submit value="Login" cssClass="btn btn-primary"/>
				</div>
			</div>
		</div>
	</s:form>
</body>
