/**
 * Created by wcc on 2016/8/3.
 */

var applyApp = angular.module("applyApp", []);

applyApp.controller("applyCtrl", function($scope, $http) {

    $scope.refreshApply = function(applyId) {
        $http.get('/rest/apply/'+$scope.applyId).success(function (data) {
           $scope.apply = data;
        });
    };

    $scope.clearApply = function() {
        $http.delete('/rest/apply/'+$scope.applyId).success($scope.refreshApply($scope.applyId));
    };

    $scope.initApplyId = function(applyId) {
        $scope.applyId = applyId;
        $scope.refreshApply(applyId);
    };

    $scope.removeFromApply = function (bookId) {
        $http.put('/rest/apply/remove/'+bookId).success(function (data) {
            $scope.refreshApply($http.get('/rest/apply/applyId'));
        });
    };
});