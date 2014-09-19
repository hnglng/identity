<!DOCTYPE html>
<html lang="zh-cn">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='../common/header.jsp'/>
<body>
<jsp:include page='../common/navbar.jsp'/>
<link rel="stylesheet" href="content/static/css/identity/organization.css" />
<link rel="stylesheet" href="content/static/css/common/perfect-scrollbar.min.css" />

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="#organization" role="tab" data-toggle="tab">Organization</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane active" id="organization">
        <div class="row">
            <div class="col-md-4">
                <jsp:include page="./organization-tree.jsp"/>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <jsp:include page='./user-list.jsp'/>
                    <jsp:include page='./user-edit.jsp'/>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page='../common/footer.jsp'/>

</body>
</html>