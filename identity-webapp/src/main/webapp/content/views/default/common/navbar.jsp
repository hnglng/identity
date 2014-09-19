<div class="container">
    <!-- Static navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container"> <!-- class="container-fluid" -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Project Name</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/home">Home</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/user">User</a></li>
                            <li><a href="/organization">Organization</a></li>
                            <li><a href="/resource">Resource</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Link</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                            <li><a href="/about">About</a></li>
                        </ul>
                    </li>
                </ul>
                <ul>
                    <form class="navbar-form navbar-right" role="form" >
                        <a class="btn btn-primary" href="/signup" role="button">Sign up</a>
                        <a class="btn btn-link" href=/logout role="button">logout</a>
                    </form>

                    <form class="navbar-form navbar-right" role="form" action="signin/j_spring_security_check" method="post">
                        <div class="form-group">
                            <input type="text" name='j_username' placeholder="User Name" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" name='j_password' placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </form>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>
</div> <!-- /container -->
