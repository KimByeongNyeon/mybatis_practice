<%@page import="day0527.ExamMapper4DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="frm" action="index.jsp">
	<input type="hidden" name="link" value="day0527/scsr"/>
	<h2>사원번호에 해당하는 사원명 조회</h2>
	<label>사원번호</label>
	<input type="text" name="empno"/>
	<input tpye="text" style="display: none">
	<input type="submit" value="검색" class="btn btn-success btn-sm"/>
</form>
<div>
<c:if test ="${ not empty param.empno }">
입력하신 <storng><c:out value="${ param.empno }"/></storng>번 사원검색 결과<br>
<c:catch var="e">
<% 
int empno=Integer.parseInt(request.getParameter("empno")); 
ExamMapper4DAO em4DAO=ExamMapper4DAO.getInstance();
String ename=em4DAO.scsr(empno);
pageContext.setAttribute("ename", ename);
%>
<c:choose>
<c:when test="${ not empty ename }">
사원명 : <strong><c:out value="${ ename }"/></strong>
</c:when>
<c:otherwise>
존재하지 않는 사원입니다.
</c:otherwise>
</c:choose>
</c:catch>
<c:if test="${ not empty ename }">
사원번호는 숫자로만 조회됩니다.
</c:if>
</c:if>
</div>