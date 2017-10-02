<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
  <div class="col-sm-12">
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <!--
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
          </div>
          -->
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li style="border-left : solid 1px #bbbbbb;" class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >図書マスタ管理<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="<s:url value="/book"/>" >図書マスタ登録</a></li>
                  <li><a href="<s:url value="/book_list"/>" >図書マスタ一覧</a></li>
                </ul>
              </li>
                <li style="border-left : solid 1px #bbbbbb;" class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >ユーザー管理<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="user" >ユーザー登録</a></li>
                  <li><a href="user_list" >ユーザー一覧</a></li>
                </ul>
              </li>
              <li style="border-left : solid 1px #bbbbbb;" class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >図書管理<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="<s:url value="/owned_books"/>" >個人所蔵図書登録</a></li>
                  <li><a href="<s:url value="/owned_books_list"/>" >個人所蔵図書一覧</a></li>
                </ul>
              </li>
              <li style="border-left : solid 1px #bbbbbb;" class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >貸出管理<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="<s:url value="/lending_books"/>" >図書貸出登録</a></li>
                  <li><a href="<s:url value="/lending_books_list"/>" >図書貸出一覧</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
  </div>