<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/login.css" />


<span onload='document.f.projectName.focus();'>
	<p class="ex2" /> <c:if test="${not empty error}">
		<div class="errorblock">
			Your Project does not exists<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<div id="RetrieveProject">
		<form name='f' action="<c:url value='j_spring_security_check' />"
			method='POST'>

			<table>
				<tr>
					<td><h1>PROJECT ID:</h1></td>
					<td><input type='text' name='projectId' value=''></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

		</form>
	</div>
</span>
<br />
<br />