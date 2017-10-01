<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
		function upload() {
		    alert("test");
			document.getElementById('book-form').action = "/books-management/book/upload";
			document.getElementById('book-form').submit();
		}
</script>
</head>
<body>
	<s:form id="book-form" cssClass="form-horizontal" action="/book/regist"  enctype="multipart/form-data">
		<div class="form-group">
			<div class="col-sm-12" >
				<div class="col-sm-12">
					<div class="col-sm-12">
						<s:actionmessage class="text-success" />
						<s:actionerror class="text-danger" />
						<s:fielderror class="text-danger" />
					</div>
					<div class="col-sm-4">
						<label class="control-label">書籍名:</label>
					</div>
					<div class="col-sm-8">
						<s:textfield name="bookDto.title"  cssClass="form-control"/>
					</div>
					<div class="col-sm-4">
						<label class="control-label">著者:</label>
					</div>
					<div class="col-sm-8">
						<s:textfield name="bookDto.author"  cssClass="form-control"/>
					</div>
					<div class="col-sm-12">
						<img src="<s:property value="bookDto.fileImgUrl"/>" />
					</div>
				</div>
				<div class="col-sm-12">
					<s:submit value="Save" cssClass="btn btn-primary"/>
					<label>
					    <span class="btn btn-primary">
					        Choose File
					        <s:file name="imgFile"  label="File" style="display:none" onchange="upload();"/>
					    </span>
					</label>

				</div>
			</div>
		</div>
	</s:form>
</body>
