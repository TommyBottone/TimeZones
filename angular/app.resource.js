var app = angular.module("timezoneApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/Brazil", {
        templateUrl : "www.google.com"
    })
    .when("/Russia", {
        templateUrl : "www.yahoo.com"
    })
    .when("/US", {
        templateUrl : "www.msn.com"
    });
});