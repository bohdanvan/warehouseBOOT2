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

var module = angular.module('app', ['ngRoute','ngResource']);


module.factory('OrdersIncDel', function ($resource) {

    return $resource('incDel/orderProduct/:incDelNumber', {incDelNumber: '@incDelNumber'});

}).controller('Ctrl', function ($scope, OrdersIncDel) {

    $scope.controllerR = "controller Ctrl start init";

    // var Order = $resource('/order/:orderId', {orderId:'@productName'});
    // var order = Order.get({orderId:5}, function() {
    //     order.price = 10;
    //     order.$save();
    // });
    
    
    var url = function () {
        // $scope.url = "url function";
        // return {incDelNumber: $scope.incDelNumber || "init"};
        return {incDelNumber: "init"}; 
    }

    var update = function () {
        $scope.message = " update function start";
        $scope.orderstIncDelList = OrdersIncDel.query(url());

        $scope.message = " update function finish / productName:"+$scope.productName; ;
    };

    $scope.update = function () {
        $scope.message = " update function start";
        $scope.orderstIncDelList = OrdersIncDel.query(url());

        $scope.message = " update function finish / productName:"+$scope.productName; ;
    };


    $scope.add = function () {

        $scope.addF = "add function start";
        $scope.addF = "add function  productName : " + $scope.productName;

        var order = new OrderIncDel();

        order.productName = $scope.productName;
        order.price = $scope.price;
        order.qty = $scope.qty;

        $scope.addF = "add function $scope.productName " + $scope.productName;
        
        order.$save(url(), function () {

            $scope.saveF = "save func";

            order.productName = "";
            order.price = "";
            order.qty = "";
            update();
        });
        $scope.addF = "add function finish";
    };
    update();
    $scope.controllerR = "controller Ctrl finish";
});
