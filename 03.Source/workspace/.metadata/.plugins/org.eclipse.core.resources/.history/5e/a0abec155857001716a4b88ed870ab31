<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form cssClass="form-horizontal" action="/trade/summery/search">
  <div class="form-group">
    <div class="col-sm-12">
      <div class="col-sm-6" >
        <div  class="col-sm-12">
          <div class="col-sm-12">
            <label class="control-label"><h5 style="color: Red;">StartDate:</h5></label>
          </div>
          <div class="col-sm-1">
            <label class="control-label">From:</label>
          </div>
          <div class="col-sm-5">
            <div class="input-group date" data-date="%{filter.startDateFrom}"  data-date-format="yyyy/mm/dd">
              <s:textfield name="filter.startDateFrom" cssClass="form-control date-form" value="%{toString(filter.startDateFrom)}"/>
              <span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
            </div>
          </div>
          <div class="col-sm-1">
            <label class="control-label">To:</label>
          </div>
          <div class="col-sm-5">
            <div class="input-group date" data-date="%{filter.startDateTo}"  data-date-format="yyyy/mm/dd">
              <s:textfield name="filter.startDateTo" cssClass="form-control date-form" value="%{toString(filter.startDateTo)}"/>
              <span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6" >
        <div class="col-sm-12">
          <div class="col-sm-12">
            <label class="control-label"><h5 style="color: Red;">ExpiryDate:</h5></label>
          </div>
          <div class="col-sm-1">
            <label class="control-label">From:</label>
          </div>
          <div class="col-sm-5">
            <div class="input-group date" data-date="%{filter.expiryDateFrom}"  data-date-format="yyyy/mm/dd">
              <s:textfield name="filter.expiryDateFrom" cssClass="form-control date-form" value="%{toString(filter.expiryDateFrom)}"/>
              <span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
            </div>
          </div>
          <div class="col-sm-1">
            <label class="control-label">To:</label>
          </div>
          <div class="col-sm-5">
            <div class="input-group date" data-date="%{filter.expiryDateTo}"  data-date-format="yyyy/mm/dd">
              <s:textfield name="filter.expiryDateTo" cssClass="form-control date-form" value="%{toString(filter.expiryDateTo)}"/>
              <span class="input-group-addon"><span class="add-on glyphicon glyphicon-th"></span></span>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-12" style="margin-top: 5px;">
        <div class="col-sm-6">
          <div class="col-sm-6">
            <label class="control-label"><h5 style="color: Red;">Product:</h5></label>
          </div>
          <div class="col-sm-6">
            <label class="control-label"><h5 style="color: Red;">Status:</h5></label>
          </div>
          <div class="col-sm-6">
            <s:textfield name="product" cssClass="form-control" />
          </div>
          <div class="col-sm-6">
            <s:textfield name="status" cssClass="form-control" />
          </div>
        </div>
        <div class="col-sm-6" style="margin-top: 5px;">
          <div class="col-sm-12"><h5>&nbsp;</h5></div>

          <div class="col-sm-12">
            <s:submit value="Search" cssClass="btn btn-primary"/>
          </div>
        </div>
      </div>
    </div>
    <div class="col-sm-12" >
      <div class="col-sm-12">
        <div class="col-sm-12" style="padding-top: 15px; margin-top: 15px;">

        </div>
      </div>
    </div>
    <div class="col-sm-12" >
      <div class="col-sm-12">
			<table class="table table-striped table-hover">
				<tr>
					<th>TradeID</th>
					<th>Product</th>
					<th>CounterpartyID</th>
					<th>StartDate</th>
					<th>ExpiryDate</th>
					<th>PayOrRec</th>
					<th>Currency</th>
					<th>FixOrFloat</th>
					<th>PrincipalAmount</th>
					<th>AuditTimeStamp</th>
				</tr>

				<s:iterator value="list">
					<tr onClick="location.href = '<s:property value="%{getUrl(product, tradeID)}" />'" >
					<td><s:property value="tradeID" /></td>
					<td><s:property value="%{product}" /></td>
					<td><s:property value="counterpartyID" /></td>
					<td><s:date name="startDate" format="yyyy/MM/dd" /></td>
					<td><s:date name="expiryDate" format="yyyy/MM/dd" /></td>
					<td>
						<div>
							<s:property value="leg1PayOrRec" />
						</div>
						<div>
							<s:property value="leg2PayOrRec" />
						</div>
					</td>
					<td>
						<div>
							<s:property value="leg1Currency" />
						</div>
						<div>
							<s:property value="leg2Currency" />
						</div>
					</td>
					<td>
						<div>
							<s:property value="leg1FixOrFloat" />
						</div>
						<div>
							<s:property value="leg2FixOrFloat" />
						</div>
					</td>
					<td>
						<div>
							<s:property value="leg1PrincipalAmount" />
						</div>
						<div>
							<s:property value="leg2PrincipalAmount" />
						</div>
					</td>
					<td><s:date name="auditTimeStamp" format="yyyy/MM/dd hh:mm:ss" />
					</td>
					</tr>
				</s:iterator>
			</table>
      </div>
    </div>
  </div>
</s:form>

