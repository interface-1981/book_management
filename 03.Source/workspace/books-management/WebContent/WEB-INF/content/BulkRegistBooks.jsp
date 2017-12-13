<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">

var isProcessing = false;


function inputISBN() {

	if ($("#isbn-input").val().length > 13) {
		//alert($("#isbn-input").val());
		$("#isbn-input").val("");
	}else if($("#isbn-input").val().length == 13) {

		var requestISBN = $("#isbn-input").val().replace(/[Ａ-Ｚａ-ｚ０-９]/g,function(s){
	          return String.fromCharCode(s.charCodeAt(0)-0xFEE0);
        });
		$("#isbn-input").val("");

		if (isProcessing) {

			return;
		}

		//alert(requestISBN);
		var existsFlag = false;

		$("input:hidden").each(function(){

			if($(this).attr("name") != null
					&& $(this).attr("name").endsWith('isbn')
					&& $(this).attr("style") != "display: none;"
					&& $(this).val() == requestISBN) {

				existsFlag = true;
			}
		});

		if (existsFlag) {
			$("#message").html('<ul class="text-danger"><li><span>既に読み込み済みです</span></li></ul>');
			return;

		}
		isProcessing = true;
		//alert($("#isbn-input").val());
		$.post(
				"./get_book_data",
				{isbn: requestISBN},
				function(json){
					//alert(json.status + " : " + json.statusCode);
					//alert(json.bookData["contents"]);
					isProcessing = false;
					if(json.statusCode > 200) {
						$("#message").html('<ul class="text-danger"><li><span>該当書籍がありませんでした</span></li></ul>');
						return;
					} else if(json.statusCode == 101) {
						$("#message").html('<ul class="text-danger"><li><span>既に図書マスタに登録済みです</span></li></ul>');
						return;
					} else {
						var copyForm = $("#row").clone();
						copyForm.attr("style", "");
						$(copyForm).find("input").each(function(){
							initForm($(this),json.bookData);
						});
						copyForm.appendTo("#table");
					}
					$("#message").html("");
				},
				'json'
			 );
	}
}
function detaile(button){

	$("#thumbnail").attr('src', "");
	$("#description").attr('src', "");

	$(button).parent().find("input").each(function(i){
		//alert(i + " : " + $(this).attr("name"));

		if ($(this).attr("name") != null) {
			if($(this).attr("name").endsWith('fileImgUrl')) {
				if ($(this).val() != null && $(this).val() != "") {
					$("#thumbnail").attr('src', $(this).val());
				}
			}if($(this).attr("name").endsWith('thumbnailImage')) {
				if ($(this).val() != null && $(this).val() != "") {
					$("#thumbnail").attr('src', $(this).val());
				}
			} else if($(this).attr("name").endsWith('contents')) {

				$("#description").html($(this).val());

			} else if($(this).attr("name").endsWith('pageCount')) {

			}
		}
	});
}

function deleteForm(button){

	$(button).parent().parent().attr("style", "display: none;");
	$(button).parent().parent().find("input").each(function(){
		$(this).val("");
	});
}

function initForm(form, json){

	if (form.attr("name") != null) {
		var newIndex = $("#table tr").length - 1;
		form.attr("name", form.attr("name").replace(/(\[)([0-9]{1,})(\])/g,"["+newIndex+"]"));

		if(form.attr("name").endsWith('isbn')) {
			form.parent().append(json["isbn"]);
			form.val(json["isbn"])
		} else if(form.attr("name").endsWith('title')) {
			form.parent().append(json["title"]);
			form.val(json["title"])
		} else if(form.attr("name").endsWith('volume')) {
			form.parent().append(json["volume"]);
			form.val(json["volume"])
		} else if(form.attr("name").endsWith('author')) {
			form.parent().append(json["author"]);
			form.val(json["author"])
		} else if(form.attr("name").endsWith('publisher')) {
			form.parent().append(json["publisher"]);
			form.val(json["publisher"])
		} else if(form.attr("name").endsWith('publicationDate')) {
			form.parent().append(json["publicationDateStr"]);
			form.val(json["publicationDate"])
		} else if(form.attr("name").endsWith('fileImgUrl')) {
			form.val(json["fileImgUrl"])
		} else if(form.attr("name").endsWith('thumbnailImage')) {
			form.val(json["thumbnailImage"])
		}  else if(form.attr("name").endsWith('contents')) {
			form.val(json["contents"])
		} else if(form.attr("name").endsWith('pageCount')) {
			form.val(json["pageCount"])
		}
	}
}
$( document ).ready(function() {

	$("#isbn-input").focus();
});
</script>
<body>
	<s:form cssClass="form-horizontal" action="/bulk_regist_books/regist"  >
	  <div class="form-group">
	  	<div class="col-sm-12" id="message">
			<s:actionmessage class="text-success" />
			<s:actionerror class="text-danger" />
			<s:fielderror class="text-danger" />
		</div>

	    <div class="col-sm-12">
			<div class="col-sm-12">
			<div class="col-sm-12" >
				<input type="text" name="isbn" id="isbn-input" onkeyup="inputISBN()" autocomplete="off" onblur="$('#isbn-input').focus();">
				<s:submit value="一括登録" class="btn btn-primary"/>
			</div>
			<table id="table" class="table table-striped table-hover">
				<tr>
					<th>ISBN</th>
					<th>書籍名</th>
					<th>巻</th>
					<th>著者</th>
					<th>出版社</th>
					<th>出版日</th>
					<th></th>
				</tr>

				<s:iterator value="list" status="list">

					<tr id="row" style="<s:property value="style" />">
					<td>
						<s:property value="isbn" />
						<s:hidden name="list[%{#list.index}].isbn" value="%{isbn}"/>
					</td>
					<td>
						<s:property value="title" />
						<s:hidden name="list[%{#list.index}].title" value="%{title}"/>
					</td>
					<td>
						<s:property value="volume" />
						<s:hidden name="list[%{#list.index}].volume" value="%{volume}"/>
					</td>
					<td>
						<s:property value="author" />
						<s:hidden name="list[%{#list.index}].author" value="%{author}"/>
					</td>
					<td>
						<s:property value="publisher" />
						<s:hidden name="list[%{#list.index}].publisher" value="%{publisher}"/>
					</td>
					<td>
						<s:property value="publicationDateStr" />
						<s:hidden name="list[%{#list.index}].publicationDate" value="%{publicationDate}"/>
					</td>
					<td>
						<input type="button" value="詳細" class="btn btn-primary" onclick="detaile(this)" data-toggle="modal" data-target="#bookDetail"/>
						<input type="button" value="削除" class="btn btn-primary" onclick="deleteForm(this)"/>
						<s:hidden name="list[%{#list.index}].fileImgUrl" value="%{fileImgUrl}"/>
						<s:hidden name="list[%{#list.index}].thumbnailImage" value="%{thumbnailImage}"/>
						<s:hidden name="list[%{#list.index}].contents" value="%{contents}"/>
						<s:hidden name="list[%{#list.index}].pageCount" value="%{pageCount}"/>
					</td>
					</tr>
				</s:iterator>
			</table>
	      </div>
	    </div>
	  </div>
	  <div class="modal fade" id="bookDetail" >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" ><span>×</span></button>
            <h4 class="modal-title">書籍情報</h4>
          </div>
          <br/>
          <div class="modal-body">

            <div>
            	<img id="thumbnail" src="">
            </div>
            <br/>
            <div id="description">
            </div>
          </div>
        </div>
      </div>
    </div>
	</s:form>
</body>
