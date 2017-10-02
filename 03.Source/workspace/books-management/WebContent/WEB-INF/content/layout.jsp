<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>
      <tiles:insertAttribute name="title" ignore="true" />
    </title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="/books-management/js/bootstrap-datepicker.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="/books-management/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css">

    <style>
        .datepicker {
            line-height: 20px;
        }
        .datepicker .table-condensed th,
        .datepicker .table-condensed td {
            padding: 4px 5px;
        }

body , html {
    height: 100%;
}

#container {
    width: 100%;
    position: relative;
    height: auto !important;
    height: 100%;
    min-height: 100%;
}

#contents {
    padding-bottom: 20px;
}

#footer {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 20px;
}

 .navbar-default {
  background-color: #f2f2f2;
  border-color: #bbbbbb;

}

.navbar-default .navbar-text {
  color: #222222;
}

    </style>
    <script type="text/javascript">

    $( document ).ready(function() {
        $('.date').datepicker({
            autoclose : true
          });

        $('.date-form').blur( function () {
        	$(this).parent().datepicker("setDate", this.value);

        } );
        $('.date-form').focus( function () {
        	$('.date').datepicker('hide')
        } );

        $(".date-form").each(function() {
        	$(this).parent().datepicker("setDate", $(this).val());
        });

    });

    </script>

  </head>
  <body style="background-color : #fcfcfc">
    <div class="container-fluid" id="container">
      <div class="row">
        <div class="col-xs-12"><tiles:insertAttribute name="header" /></div>
        <div class="col-md-12 col-xs-12"><tiles:insertAttribute name="menu" /></div>
        <div class="col-md-12 col-xs-12" id="contents" ><tiles:insertAttribute name="body" /></div>
        <div class="col-xs-12"id="footer" style="background-color:#333333; color:#ffffff;"><tiles:insertAttribute name="footer" /></div>
      </div>
    </div>
  </body>
</html>