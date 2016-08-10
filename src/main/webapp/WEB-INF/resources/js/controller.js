/**
 * Created by wcc on 2016/8/3.
 */

var applyApp = angular.module("applyApp", []);

applyApp.controller("applyCtrl", function($scope, $http) {

    $scope.refreshApply = function() {
        $http.get('/rest/apply/'+$scope.applyId).success(function (data) {
           $scope.apply = data;
        });
    };

    $scope.clearApply = function() {
        $http.delete('/rest/apply/'+$scope.applyId).success($scope.refreshApply());
    };

    $scope.initApplyId = function(applyId) {
        $scope.applyId = applyId;
        $scope.refreshApply();
    };

    $scope.removeFromApply = function (bookId) {
        $http.put('/rest/apply/remove/'+bookId).success(function () {
            $scope.refreshApply();
        });
    };

    $scope.applyGrandTotal = function() {
        var grandTotal = 0;

        for(var i = 0; i < $scope.apply.applyItems.length; i++) {
            grandTotal += $scope.apply.applyItems[i].totalPrice;
        }

        return grandTotal;
    };

    $scope.createOrder = function() {
        $http.put('/rest/apply/order/'+$scope.applyId).success(function() {
            $scope.refreshApply();
            alert('You have successfully send your purchase request!');
        });
    };
});