/**
 * Created by wcc on 2016/8/11.
 */

var studentManagementApp = angular.module("studentManagementApp", []);

studentManagementApp.controller("studentManagementCtrl", function ($scope, $http) {

    $scope.refreshStudentManagement = function () {
        $http.get('/rest/studentManagement/' + $scope.studentId).success(function (data) {
            $scope.student = data;
        });
    };

    $scope.initStudentId = function (studentId) {
        $scope.studentId = studentId;
        $scope.refreshStudentManagement();
    };

    $scope.editStudentInfo = function () {

    };


});