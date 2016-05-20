<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Bja BanK</title>
</head>
<body>
		Test
	<DIV>
		<f:form modelAttribute="banqueForm" method="post" action="chargerCompte"> 
		<TABLE>
			<tr>
				<TD>Code: </TD>
				<TD><f:input path="code" /> </TD>		
				<td><f:errors path="code"> </f:errors></td>	
			</tr>
			<tr>
				<TD><input type="submit" value="OK"> </TD>					
			</tr>
			
			<%-- <tr>
				<TD>erreurs: </TD>						
				<td><f:errors path="*"> </f:errors></td>	
			</tr> --%>
		</TABLE>
		
		
		</f:form>
	
	
	</DIV>
	<%-- <c:if test="${empty banqueForm.exception}"> --%>
	<c:if test="${not empty banqueForm.compte}">
	<DIV>
		<TABLE>
			<TR >
				<TD >solde </TD>
				<TD >${banqueForm.compte.solde} </TD>
			</TR>
			<TR >
				<TD >date Creation </TD>
				<TD >${banqueForm.compte.dateCreation} </TD>
			</TR>
			<TR >
				<TD >Type de Compte: </TD>
				<TD >${banqueForm.typeCompte} </TD>
			</TR>
			<c:if test="${banqueForm.typeCompte =='CompteCourant'}">  <!-- CompteEpargne -->
			<TR >
				<TD >Decouvert </TD>
				<TD >${banqueForm.compte.decouvert} </TD>
			</TR>
			</c:if>
						<c:if test="${banqueForm.typeCompte =='CompteEpargne'}">  <!--  -->
			<TR >
				<TD >taux </TD>
				<TD >${banqueForm.compte.taux} </TD>
			</TR>
			</c:if>
			
		</TABLE>	
	</DIV>
    </c:if>
    
    <c:if test="${not empty banqueForm.exception}">
    <DIV>
    	${banqueForm.exception}
    </DIV>
    </c:if>
</body>
</html>