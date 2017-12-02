<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
function inputISBN() {
	$("#isbn-input").val($("#isbn-input").val().replace("-", ""));

	if($("#isbn-input").val().length == 13) {
		$.post(
				"./get_book_data",
				{isbn: $("#isbn-input").val()},
				function(json){
					//alert(json);
					if(json["isbn"] == null) {
						alert("該当書籍がありませんでした");
					} else {
						var copyForm = $("#row").clone();
						$(copyForm).find("textarea, :text").each(function(){initForm($(this),json)});
						copyForm.appendTo("#table");
					}

					$("#isbn-input").val("")
				},
				'json'
			 );
	}
}
function getBookData(){


}


function initForm(form, json){


	var newIndex = $("#table tr").length - 1;
	form.attr("name", form.attr("name").replace(/(\[)([0-9]{1,})(\])/g,"["+newIndex+"]"));

	if(form.attr("name").endsWith('isbn')) {
		form.val(json["isbn"])
	} else if(form.attr("name").endsWith('title')) {
		form.val(json["title"])
	} else if(form.attr("name").endsWith('author')) {
		form.val(json["author"])
	}


}
</script>
<body>
	<s:form cssClass="form-horizontal" action="/bulk_regist_books/regist">
	  <div class="form-group">
	    <div class="col-sm-12" >
	    	<input type="text" name="isbn" id="isbn-input" onkeyup="inputISBN()">
	    	<input type="button" value="書籍情報取得" class="btn btn-primary" onclick="getBookData()"/>
	    </div>
	    <div class="col-sm-12">

	      <div class="col-sm-12">
			<table id="table" class="table table-striped table-hover">
				<tr>
					<th>ISBN</th>
					<th>書籍名</th>
					<th>著者</th>
				</tr>

				<s:iterator value="list" status="list">

					<tr id="row">
					<s:hidden property="id" name="id"/>
					<td><s:textfield name="list[%{#list.index}].isbn" /></td>
					<td><s:textfield name="list[%{#list.index}].title" /></td>
					<td><s:textfield name="list[%{#list.index}].author" /></td>
					</tr>
				</s:iterator>
			</table>
	      </div>
	      <div class="col-sm-12">
				<input type="button" value="add" class="btn btn-primary" onclick="addForm()"/>
				<s:submit value="Save" cssClass="btn btn-primary"/>
		  </div>
	    </div>
	  </div>
	</s:form>
</body>
