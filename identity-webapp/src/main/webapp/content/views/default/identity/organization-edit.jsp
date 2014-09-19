<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 8/1/14
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page='../common/header.jsp'/>
<body>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form role="form" action="/organization/${organizationModel.id}" method="post">
                <input name="organization_id" type="hidden" value="${organizationModel.id}" />
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Name" value="${organizationModel.name}"/>
                </div>
                <div class="form-group">
                    <label for="parent_id">Parent Id</label>
                    <input type="text" name="parent_id" class="form-control" id="parent_id" placeholder="Parent Id" value="${organizationModel.parentId}"/>
                </div>
                <div class="form-group">
                    <label for="parent_ids">Parent Id</label>
                    <input type="text" name="parent_ids" class="form-control" id="parent_ids" placeholder="Parent Ids" value="${organizationModel.parentIds}"/>
                </div>
                <div class="form-group">
                    <label>Priority</label>
                    <select class="form-control" name="priority" onselect="${organizationModel.priority}">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>

                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="enabled" checked="${organizationModel.enabled}"/>Enabled
                    </label>
                </div>
                <input name="_method" type="hidden" value="put" />
                <button type="submit" class="btn btn-default">Submit</button>

            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</body>
</html>
