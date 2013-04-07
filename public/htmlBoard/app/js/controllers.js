'use strict';

/* Controllers */


function HtmlBoardAppController($scope, $http) {

    $scope.test = "Hello";
    $http({
        url: "/wallboard",
        method: "GET"
    }).success(function (data, status, headers, config) {
            $scope.scrumBoards = data.scrumBoards;
        }).error(function (data, status, headers, config) {
            $scope.status = status;
        });

}


HtmlBoardAppController.$inject = ['$scope', '$http'];

