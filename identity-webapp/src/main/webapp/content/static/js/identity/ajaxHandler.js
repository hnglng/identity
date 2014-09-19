/**
 * Created by Bright Huang on 8/27/14.
 */
define('ajaxHandler', ['identity', 'jquery', ], function(Identity, $){
    var AjaxHandler = {};

    "use strict";

    function shouldParseJSON(data, type)
    {
        return 'string' === typeof data && (type === 'json' || type === 'jsonp');
    }

    AjaxHandler.request = function (options) {
        $.ajax({
            cache: false,
            data: options.data,
            dataType: options.dataType,
            type: options.type,
            url: options.url
        }).done(function (data, status, xhr) {
            var responseData;

            if ('function' === typeof options.success) {
                try {
                    responseData = shouldParseJSON(data, options.dataType) ? $.parseJSON(data) : data;
                } catch (error) {

                    if ('function' === typeof options.fail) {
                        setTimeout(function () {
                            options.fail();
                        }, 25);
                    }
                }
                setTimeout(function () {
                    options.success(responseData);
                }, 25);
            }

        }).fail(function (xhr, status, error) {
            if ('function' === typeof options.fail) {
                setTimeout(function () {
                    options.fail();
                }, 25);
            }
        }).always(function (xhr, status, error) {
            if ('function' === typeof options.always) {
                setTimeout(function () {
                    options.always();
                }, 25);
            }
        });
    };

    Identity.AjaxHandler = AjaxHandler;
    return AjaxHandler;
});