<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
function addForm(){

	var copyForm = $("#row").clone();
	$(copyForm).find("textarea, :text").each(function(){$(this).attr("name", getNumberingName($(this).attr("name")))});
	$(copyForm).find("textarea, :text").val("");
	$(copyForm).find("#id").attr("name", "");
	$(copyForm).find("#id").val("");
	copyForm.appendTo("#table");
}

function getNumberingName(name){


	var newIndex = $("#table tr").length - 1;
	name = name.replace(/(\[)([0-9]{1,})(\])/g,"["+newIndex+"]");
	//alert(name);
	return name
}
</script>
<body>
	<s:form cssClass="form-horizontal" action="/bulk_regist_sample/regist">
	  <div class="form-group">
	    <div class="col-sm-12" >
	      <div class="col-sm-12">
			<table id="table" class="table table-striped table-hover">
				<tr>
					<th>sampleString</th>
					<th>sampleInteger</th>
					<th>sampleDate</th>
				</tr>

				<s:iterator value="list" status="list">

					<tr id="row">
					<s:hidden property="id" name="id"/>
					<td><s:textfield name="list[%{#list.index}].sampleString" /></td>
					<td><s:textfield name="list[%{#list.index}].sampleInteger" /></td>
					<td><s:textfield name="list[%{#list.index}].sampleDate" /></td>
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
