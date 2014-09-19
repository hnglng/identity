
<div class="modal fade roleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span></button>
                <h4 class="modal-title">Add User</h4>
            </div>
            <div class="modal-body">
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
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
