/**
 * Created by Bright Huang on 8/27/14.
 */

define('clickHandler', ['identity', 'jquery', "organizationTree"], function(Identity, $, OrganizationTree){
    var ClickHandler = {};

    "use strict";

    ClickHandler.touchmove = false;
    ClickHandler.handlers = {};
    ClickHandler.defaultElementQuery = '.click-handler-range';
    ClickHandler.elementQuery = ClickHandler.defaultElementQuery;

    ClickHandler.disableAllInput = function () {
        $("*").off();
    };

    ClickHandler.setElementQuery = function (queryString) {
        ClickHandler.elementQuery = queryString;
    };

    ClickHandler.registerHandler = function () {
        $(document).on('touchmove', ClickHandler.elementQuery, function (event) {
            ClickHandler.touchmove = true;
        });

        $(document).on('click touchend', ClickHandler.elementQuery, function (event) {
            ClickHandler.dispatchHandler(event);

            if( event.type === 'touchend' ) {
                ClickHandler.touchmove = false;
            }
        });
    };

    ClickHandler.addHandler = function (name, handler) {
        ClickHandler.handlers[name] = handler;
    };

    ClickHandler.dispatchHandler = function (event) {
        var recordInTealeaf = false,
            target = event.srcElement ? event.srcElement : event.target,
            clickHandlerId = target.attributes['data-click-handler'],
            isStopEventPropagation = target.attributes['data-stop-propagate'] !== undefined && target.attributes['data-stop-propagate'].value === 'true',
            isPreventDefault = target.attributes['data-prevent-default'] !== undefined && target.attributes['data-prevent-default'].value === 'true';

        if(isPreventDefault) {
            event.preventDefault();
        }

        if (isStopEventPropagation) {
            event.stopPropagation();
        }

        if (clickHandlerId === undefined) {
            var parent = target.parentNode;
            while (parent !== undefined && parent != document) {
                clickHandlerId = parent.attributes['data-click-handler'];
                if (clickHandlerId !== undefined) {
                    target = parent;
                    break;
                }
                parent = parent.parentNode;
            }
        }

        if (clickHandlerId !== undefined) {
            var handlerList = clickHandlerId.nodeValue;

            // multiple event handlers, separated by commas,
            // are processed left to right
            var handlerIds = handlerList.split(',');
            for (var i = 0; i < handlerIds.length; i++) {
                var handlerName = handlerIds[i];
                var clickHandler = ClickHandler.handlers[handlerName];
                if (clickHandler === undefined) {
                    return;
                }
                clickHandler(target, event);
            }

        }
    };

    ClickHandler.init = function () {
        ClickHandler.registerHandler();
        ClickHandler.addHandler('organizationTreeClickHandler', ClickHandler.callbacks.organizationTreeClickHandler);
    };

    // Callback functions
    ClickHandler.callbacks = {

        organizationTreeClickHandler: function (target, event) {
            OrganizationTree.Controller.selectTreeNode(target, event);
        }
    };

    $(function () {
        ClickHandler.init();
    });


    Identity.ClickHandler = ClickHandler;
    return ClickHandler;
});

