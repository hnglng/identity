
requirejs.config({
    baseUrl : 'content/static/js',
    paths: {
        "jquery" : "lib/jquery-1.10.2",
        "bootstrap" : "bootstrap/3.2.0/bootstrap.min",
        "perfect-scrollbar" : "common/perfect-scrollbar.min",
        "organizationTree" : "identity/organizationTree",
        "identity" : "identity/identity",
        "clickHandler" : "identity/clickHandler",
        "ajaxHandler" : "identity/ajaxHandler"
    },

    shim: {
        'bootstrap' : {
            deps : ['jquery'],
            exports : "bootstrap"
        },
        'perfect-scrollbar':{
            deps : ['jquery'],
            exports : "perfect-scrollbar"
        }
    }

});


requirejs(["jquery", "bootstrap", "organizationTree", "clickHandler", "ajaxHandler"],
    function($, Bootstrap, OrganizationTree, ClickHandler, AjaxHandler){

});







