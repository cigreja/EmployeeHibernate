var app1 = angular.module('app1',[]);

app1.controller("ctrl1", function($scope,$http){
    $scope.navSelection = "addEmployee";
    $scope.addNavSelection = "selected";
    $scope.getNavSelection = "";

    // ajax to get addresses
    var url = "Get"; // the GetController
    $http.get(url).success( function(response) {
        $scope.addresses = response;
    });

    /**
     * initially start on add employee page
     */
    // show the add employee divs
    $("#addEmployeeDiv").show();
    $("#employeesDiv").show();

    // hide the get employee divs
    $("#getEmployeeDiv").hide();
    $("#addressesDiv").hide();


    /**
     * FUNCTIONS
     */
    
    $scope.updateNavSelection = function(){
        $scope.navSelection = "getEmployee";
    }
    
    $scope.addEmployeeNavSelection = function(){
        $scope.addNavSelection = "selected";
        $scope.getNavSelection = "";

        // show the add employee divs
        $("#addEmployeeDiv").show();
        $("#employeesDiv").show();

        // hide the get employee divs
        $("#getEmployeeDiv").hide();
        $("#addressesDiv").hide();

    }
    
    $scope.getEmployeeNavSelection = function(){
        $scope.addNavSelection = "";
        $scope.getNavSelection = "selected";

        // show the get employee divs
        $("#getEmployeeDiv").show();
        $("#addressesDiv").show();

        // hide the add employee divs
        $("#addEmployeeDiv").hide();
        $("#employeesDiv").hide();

    }
});

