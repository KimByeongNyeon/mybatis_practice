<%@page import="java.util.List"%>
<%@page import="day0527.ExamMapper4DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="frm" action="index.jsp">
	<input type="hidden" name="link" value="day0527/scmr"/>
	<h2>부서번호에 해당하는 사원명 조회</h2>
	<label>사원번호</label>
	<input type="text" name="deptno"/>
	<input tpye="text" style="display: none">
	<input type="submit" value="검색" class="btn btn-success btn-sm"/>
</form>
<div>
<c:if test ="${ not empty param.deptno }">
입력하신 부서번호 [<storng><c:out value="${ param.deptno }"/></storng>번] 사원번호 검색 결과<br>
<c:catch var="e">
<% 
int deptno=Integer.parseInt(request.getParameter("deptno")); 
ExamMapper4DAO em4DAO=ExamMapper4DAO.getInstance();
List<Integer> list = em4DAO.scmr(deptno);
pageContext.setAttribute("list", list);
%>
<select>
<c:if test="${ empty list }">
<option value="none">--사원이 존재하지 않는 부서--</option>
</c:if>
<c:forEach var="empno" items="${list}" varStatus="i">
<option value="${ empno }"><c:out value="${i.count}. ${ empno }"/></option>
</c:forEach>
</select>

</c:catch>
<c:if test="${ not empty deptno }">
부서번호는 숫자로만 조회됩니다.
</c:if>
</c:if>
</div>