<!DOCTYPE html>
<html lang="zh-cn">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='../common/header.jsp'/>
<body>
<jsp:include page='../common/navbar.jsp'/>
<link rel="stylesheet" href="content/static/css/identity/organization-tree.css" />
<link rel="stylesheet" href="content/static/css/common/perfect-scrollbar.min.css" />

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="#user" role="tab" data-toggle="tab">User</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane active" id="user">
        <div class="row">
            <div class="col-md-4">
                <jsp:include page="organization-tree.jsp"/>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <jsp:include page='user-list.jsp'/>
                    <jsp:include page='user-edit.jsp'/>
                </div>
                <div class="row">
                    <jsp:include page='role-list.jsp'/>
                    <jsp:include page='role-edit.jsp'/>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page='../common/footer.jsp'/>
<script src="content/static/js/lib/require-2.1.14.js" defer async="true" data-main="content/static/js/identity/main"></script>

</body>
</html>