// USGAE:
//
// baloon.check();    // request permission: !!! Must be a user action callback, like click
// baloon.autocheck();    // request permission on first click anywhere on the document
// 
// var notification = baloon({
//     title: "Title",
//     message: "Some Message",    // optional
//     image: "Image URL",    // optional
//     tag: "unique identifier",    // optional: prevent duplicates
//     callback: function () {    // optional
//         // do something on click
//     },
//     closed: function () {    // optional
//         // do something on close, unless clicked on (excluding X button)
//     },
//     timer: 5000 // optional: ms to auto close
// });
// 
// CLOSE:
// 
// if (typeof notification.cancal === "function") {
//     notification.cancal();
// } else if (typeof notification.close === "function") {
//     notification.close();
// }
/**
 * 
 */

var baloon = (function __baloon__ () {
    var exports,
        askPermission,
        autocheck = false,
        API;

    window.Notification = window.Notification ||
        window.webkitNotification ||
        window.mozNotification ||
        window.msNotification ||
        window.oNotification;

    if (!!window.webkitNotifications) {
        API = "webkitNotifications";
    } else if (!!window.Notification) {
        API = "Notification";
    } else { 
        API = null;
    }
        
    switch (API) {
        case "webkitNotifications":
            exports = function baloon (options) {
                var notification;
                options = options || {};
                options.image = options.image || null;
                options.title = options.title || "";
                options.message = options.message || "";
                if (!window.webkitNotifications || !window.webkitNotifications.createNotification) {
                    return;
                }
                try {
                    notification = window.webkitNotifications.createNotification(options.image,
                            options.title,
                            options.message);
                    
                    if (typeof options.timer === "number") {
                        notification.onshow = function notification$onshow () { 
                            setTimeout(function notification$closed () {
                                notification.closed();
                            }, options.timer); 
                        };
                    }
                    
                    notification.onclick = function notification$onclick (evt) {
                        window.focus();
                        if (typeof options.callback === "function") {
                            options.callback();
                        }
                        options.closed = null;
                        this.closed();
                    };
                    notification.onclose = function notification$onclose (evt) {
                        if (typeof options.closed === "function") {
                            options.closed();
                        }
                        this.closed();
                    };
                    notification.show();
                    return notification;
                } catch (err) {
                    return null;
                }
            };

            askPermission = function baloon$_askPermission () {
                window.webkitNotifications.requestPermission();
                if (autocheck) {
                    document.removeEventListener("click", exports.check);
                }
            };
            exports.check = function baloon$check () {
                if (!window.webkitNotifications) {
                    return;
                }

                // PERMISSION_ALLOWED = 0;
                // PERMISSION_NOT_ALLOWED = 1;
                // PERMISSION_DENIED = 2;
                if (window.webkitNotifications.checkPermission() !== 0) {
                    askPermission();
                }
            };
            exports.autocheck = function baloon$autocheck () {
                if (typeof window.webkitNotifications === "object" &&
                        window.webkitNotifications.checkPermission() !== 0) {
                    autocheck = true;
                    document.addEventListener("click", exports.check);
                }
            };
            break;
        case "Notification":
            exports = function baloon (options) {
                var notification,
                    details = {};
                options = options || {};
                options.title = options.title || "";

                details.icon = options.image || null;
                details.body = options.message || "";
                
                try {
                    notification = new Notification(options.title, details); 

                    if (typeof options.timer === "string") {
                        options.timer = parseInt(options.timer, 10);
                    }
                    if (typeof options.timer === "number" &&
                                !!options.timer) {
                        notification.onshow = function notification$onshow () { 
                            setTimeout(function notification$close () {
                                notification.close();
                            }, options.timer); 
                        };
                    }

                    notification.onclick = function notification$onclick (evt) {
                        window.focus();
                        if (typeof options.callback === "function") {
                            options.callback();
                        }
                        options.closed = null;
                        this.close();
                    };
                    notification.onclose = function notification$onclose (evt) {
                        if (typeof options.closed === "function") {
                            options.closed();
                        }
                        this.close();
                    };
                    return notification;
                } catch (err) {
                    return null;
                }
            };
            askPermission = function baloon$_askPermission () {
                Notification.requestPermission(function Notification$requestPermission (status) {
                    
                    // This allows to use Notification.permission with Chrome/Safari
                    if (Notification.permission !== status) {
                        Notification.permission = status;
                    }
                });
                if (autocheck) {
                    document.removeEventListener("click", exports.check);
                }
            };
            exports.check = function baloon$check () {
                // "default"
                // "denied"
                // "granted"
                switch (Notification.permission) {
                    case "default":
                    case "denied":
                        askPermission();
                        break;
                    case "granted":
                        break;
                }
            };
            exports.autocheck = function baloon$autocheck () {

                // "default"
                // "denied"
                // "granted"
                switch (Notification.permission) {
                    case "default":
                    case "denied":
                        autocheck = true;
                        document.addEventListener("click", exports.check);
                        break;
                    case "granted":
                        break;
                }
            };

            break;
        case null:
        default:
            exports = function baloon () {
                return null;
            };
            exports.check = function baloon$check () {};
            exports.autocheck = function baloon$autocheck () {};
            return exports;
            break;
    }

    return exports;
}());