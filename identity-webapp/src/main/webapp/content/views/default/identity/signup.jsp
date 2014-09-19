<!DOCTYPE html>
<html lang="zh-cn">
<jsp:include page='../common/header.jsp'/>
<body>
<jsp:include page='../common/navbar.jsp'/>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <form class="form-horizontal" role="form" action="/signup" method="POST">
            <div class="form-group">
                <label for="inputUserName" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserName" placeholder="User Name">
                </div>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-2 control-label">Organization</label>
                <div class="col-sm-10">
                    <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Manager</label>
                <div class="col-sm-10">
                    <select class="form-control">
                        <option>Manager</option>
                        <option>Admin</option>
                        <option>President</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Role</label>
                <div class="col-sm-10">
                    <select class="form-control">
                        <option>ROLE_USER</option>
                        <option>ROLE_ADMIN</option>
                        <option>ROLE_MANAGER</option>
                        <option>ROLE_PRESIDENT</option>
                        <option>ROLE_ANONYMOUS</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">State</label>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Enabled
                    </label>
                </div>
            </div>

            <br/>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>

</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td rowspan="2">1</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <td>Mark</td>
                <td>Otto</td>
                <td>@TwBootstrap</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <td>3</td>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-2"></div>
</div>

<jsp:include page='../common/footer.jsp'/>
</body>
</html>
