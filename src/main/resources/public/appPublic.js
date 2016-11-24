//
// function Hello($scope,$http) {
//     $http.get('incDel/product/init',{data:{name:name}})
//         .success(function (data) {
//             $scope.greeting = data
//         });
//
//     $scope.update = function () {
//         $http.get('incDel/product/init',{params:{name:$scope.name}})
//             .success(function (data) {
//                 $scope.greeting = data;
//             });
//     }
//







var module = angular.module('app', ['ngResource']);






module.factory('OrdersIncDel', function ($resource) {

    return $resource('incDel/product/:incDelNumber', {incDelNumber: '@incDelNumber'});

}).controller('incDelFormAddNewOrderControllerAng', function ($scope, OrdersIncDel) {

    $scope.factoryF = "factoryF";
    $scope.controllerR = "controllerR";
  
    var url = function () {
        // return {incDelNumber: $scope.incDelNumber || "init"};
        return {incDelNumber: "init"};
    }

    var update = function () {

        $scope.orderstIncDelList = OrdersIncDel.query(url());

        var s = $scope.orderstIncDelList;
        $scope.message = "meSSage update , size OrdersIncDel: "+ s.size();
    };


    $scope.add = function () {


        var order = new OrderIncDel();

        order.productName = $scope.productName;
        order.price = $scope.price;
        order.qty = $scope.qty;

        $scope.message = $scope.qty;

        order.$save(url(), function () {

            $scope.message = "meSSage save";

            order.productName = "";
            order.price = "";
            order.qty = "";
            update();
        });
    };
    update();

});
