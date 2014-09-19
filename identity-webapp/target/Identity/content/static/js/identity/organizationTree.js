
define('organizationTree', ['jquery', 'identity', 'ajaxHandler'], function($, Identity, AjaxHandler) {

    "use strict";

    var OrganizationTree = {};



    //////////////////////// Private Method ///////////////////////////////
    function initScrollbar(){
        $('#treepanel').perfectScrollbar();
    }

    function initTreeView(){
        $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');

        $('.tree li.parent_li > span').on('click', function (e) {

            var children = $(this).parent('li.parent_li').find(' > ul > li');

            if (children.is(":visible")) {
                children.hide('fast');
                $(this).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon glyphicon-plus')
                    .removeClass('glyphicon glyphicon-minus');
            } else {
                children.show('fast');
                $(this).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon glyphicon-minus')
                    .removeClass('glyphicon glyphicon-plus');
            }

            e.stopPropagation();
        });
    }

    function addTreeNode( response ) {

        for (var index in response) {
            var treeNodePrefix = '<li data-click-handler="organizationTreeClickHandler" index="' + response[index].id + '"><span>',
                treeNodeProperties = '<i class="glyphicon glyphicon-minus"></i>',
                treeNodeSuffix = '</span></li>',
                treeNode;            treeNode = treeNodePrefix + treeNodeProperties + response[index].name + treeNodeSuffix;
            $('#rootChildren').append(treeNode);
        }
    }

    ///////////////////////// Public Method /////////////////////////



    //////////////////////// Objects /////////////////////////////////

    OrganizationTree.Model = {};
    OrganizationTree.View = {};

    OrganizationTree.Controller = {
        selectTreeNode : function(target, event){
            var organizationId = target.attributes.getNamedItem("index").value;

            AjaxHandler.request({
                type: 'GET',
                url: "/organization/" + organizationId,
                data: {},
                dataType: 'json',
                success: function (rps) {


                },
                fail: function (xhr, status, error) {
                    view.loader.hide();
                    view.error.show();
                    alert('AJAX request error in Ajax(' + error + ')');
                },
                always: function () {

                }
            });

        }
    };



    $(function () {

        initTreeView();

        AjaxHandler.request({
            type: 'GET',
            url: "/organization/1/children",
            data: {},
            dataType: 'json',
            success: function (rps) {

                addTreeNode(rps);

            },
            fail: function (xhr, status, error) {
                view.loader.hide();
                view.error.show();
                alert('AJAX request error in Ajax(' + error + ')');
            },
            always: function () {

            }
        });

    });


    Identity.OrganizationTree = OrganizationTree;
    return OrganizationTree;
});



