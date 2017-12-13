<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">

function detaile(button){

	$(button).parent().find("input").each(function(i){
		//alert(i + " : " + $(this).attr("name"));

		if ($(this).attr("name") != null) {
			if($(this).attr("name").endsWith('thumbnailImage')) {
				//alert($(this).attr("name"));
				$("#thumbnail").attr('src', $(this).val());
			} else if($(this).attr("name").endsWith('contents')) {

				$("#description").html($(this).val());

			} else if($(this).attr("name").endsWith('pageCount')) {

			}
		}
	});
}


</script>
<body>
	<s:form cssClass="form-horizontal" action="/book_list/search">
		<div class="form-group">
			<div class="col-sm-8">
				<div class="col-sm-2">
					<label class="control-label">登録日:</label>
				</div>
				<div class="col-sm-5">
					<div class="input-group date" data-date="%{bookSearchDto.registDateFromCriteria}"  data-date-format="yyyy/mm/dd">
						<s:textfield name="bookSearchDto.registDateFromCriteria" cssClass="form-control date-form" value="%{util.toStringDate(bookSearchDto.registDateFromCriteria)}"/>
						<span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="input-group date" data-date="%{bookSearchDto.registDateToCriteria}"  data-date-format="yyyy/mm/dd">
						<s:textfield name="bookSearchDto.registDateToCriteria" cssClass="form-control date-form" value="%{util.toStringDate(bookSearchDto.registDateToCriteria)}"/>
						<span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="col-sm-2">
					<label class="control-label">更新日:</label>
				</div>
				<div class="col-sm-5">
					<div class="input-group date" data-date="%{bookSearchDto.modifytDateFromCriteria}"  data-date-format="yyyy/mm/dd">
						<s:textfield name="bookSearchDto.modifyDateFromCriteria" cssClass="form-control date-form" value="%{util.toStringDate(bookSearchDto.modifyDateFromCriteria)}"/>
						<span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="input-group date" data-date="%{bookSearchDto.modifytDateToCriteria}"  data-date-format="yyyy/mm/dd">
						<s:textfield name="bookSearchDto.modifyDateToCriteria" cssClass="form-control date-form" value="%{util.toStringDate(bookSearchDto.modifyDateToCriteria)}"/>
						<span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="col-sm-2">
						<label class="control-label">ISBN:</label>
				</div>
				<div class="col-sm-5">
					<s:textfield name="bookSearchDto.isbnCriteria"  cssClass="form-control"/>
				</div>
				<div class="col-sm-5" ></div>
			</div>
			<div class="col-sm-8">

				<div class="col-sm-2">
					<label class="control-label">キーワード:</label>
				</div>
				<div class="col-sm-5">
					<s:textfield name="bookSearchDto.keywordCriteria"  cssClass="form-control"/>
				</div>
				<div class="col-sm-5" ></div>
			</div>

			<div class="col-sm-12">
				<br />
				<s:submit value="検索" cssClass="btn btn-primary"/>
			</div>
			<div class="col-sm-12">
				<table class="table table-striped table-hover">
					<tr>
						<th>ISBN</th>
						<th>書籍名</th>
						<th>巻</th>
						<th>著者名</th>
						<th>登録日</th>
						<th>更新日</th>
						<th></th>
					</tr>
					<s:iterator value="bookSearchDto.results">
						<tr>
							<td><s:property value="isbn" /></td>
							<td><s:property value="title" /></td>
							<td><s:property value="volume" /></td>
							<td><s:property value="author" /></td>
							<td><s:property value="%{util.toStringDateTime(registDate)}" /></td>
							<td><s:property value="%{util.toStringDateTime(modifyDate)}" /></td>
							<td>
								<input type="button" value="詳細" class="btn btn-primary" onclick="detaile(this)" data-toggle="modal" data-target="#bookDetail"/>
								<s:hidden name="thumbnailImage"  value="%{thumbnailImage}"/>
								<s:hidden name="contents" value="%{contents}" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
			<div class="col-sm-12">
				<s:if test="bookSearchDto.recordCount != 0">
					<input type="button" value="＜＜" class="btn btn-primary" onclick="$('#pagerAction').val('<s:property value="%{bookSearchDto.ACTION_PREVIEW}" />');form.submit();" />
					<s:property value="bookSearchDto.currentPage" />/
					<s:property value="bookSearchDto.maxPage" />
					<input type="button" value="＞＞" class="btn btn-primary" onclick="$('#pagerAction').val('<s:property value="%{bookSearchDto.ACTION_NEXT}" />');form.submit();" />
				</s:if>
				<s:hidden property="bookSearchDto.currentPage" name="bookSearchDto.currentPage"/>
				<s:hidden property="bookSearchDto.recordCount" name="bookSearchDto.recordCount"/>
				<s:hidden property="bookSearchDto.pageDisplayCount" name="bookSearchDto.pageDisplayCount"/>
				<s:hidden property="bookSearchDto.pagerAction" name="bookSearchDto.pagerAction" id="pagerAction" value="%{bookSearchDto.ACTION_INIT}"/>
			</div>
		</div>
		<div class="modal fade" id="bookDetail" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span>×</span></button>
						<h4 class="modal-title">書籍情報</h4>
					</div>
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
