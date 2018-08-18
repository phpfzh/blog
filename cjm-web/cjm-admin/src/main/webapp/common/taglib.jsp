<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
		String path = request.getContextPath();
 		String basePath;
 		int prot = request.getServerPort();
 		if(prot == 80){
	 		 basePath = request.getScheme() + "://"+ request.getServerName()+ path;
 		}else{
 			basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
 		}
 	pageContext.setAttribute("basePath", basePath);
%>