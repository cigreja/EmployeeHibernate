var app1 = angular.module('app1',[]);

app1.controller("ctrl1", function($scope){
    $scope.navSelection = "addEmployee";
    $scope.addNavSelection = "selected";
    $scope.getNavSelection = "";
    
    $scope.updateNavSelection = function(){
        $scope.navSelection = "getEmployee";
    }
    
    $scope.addEmployeeNavSelection = function(){
        $scope.addNavSelection = "selected";
        $scope.getNavSelection = "";
    }
    
    $scope.getEmployeeNavSelection = function(){
        $scope.addNavSelection = "";
        $scope.getNavSelection = "selected";
    }
});

