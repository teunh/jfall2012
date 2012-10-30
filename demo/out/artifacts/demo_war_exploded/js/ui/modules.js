'use strict';

var timeControl = angular.module('timeControl', ['ui', 'ngResource'], function ($routeProvider) {
    console.log("Configure route provider");
    $routeProvider
        .when("/weekstaatoverzicht", {
            templateUrl: "partials/weekstaatoverzicht.html",
            controller: AppController
        })
        .when("/weekstaat/:weeknummer", {
            templateUrl: "partials/weekstaat.html",
            controller: WeekstaatController
        })
        .when("/", {
            redirectTo: "/weekstaatoverzicht"
        })
        .otherwise({
            redirectTo: "/weekstaatoverzicht"
        });
})
    .factory("WeekstaatResource", WeekstaatResourceImpl)
    .service("TimeManagementService", TimeManagementServiceImpl);

Date.prototype.getWeek = function () {
    var determinedate = new Date();
    determinedate.setFullYear(this.getFullYear(), this.getMonth(), this.getDate());
    var D = determinedate.getDay();
    if (D == 0) D = 7;
    determinedate.setDate(determinedate.getDate() + (4 - D));
    var YN = determinedate.getFullYear();
    var ZBDoCY = Math.floor((determinedate.getTime() - new Date(YN, 0, 1, -6)) / 86400000);
    var WN = 1 + Math.floor(ZBDoCY / 7);
    return WN;
};