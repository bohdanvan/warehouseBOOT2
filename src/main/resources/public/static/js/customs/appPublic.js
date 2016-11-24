
var module = angular.module('app', ['ngResource']);


module.factory('OrdersIncDel', function ($resource) {

    return $resource('incDel/orderProduct/:incDelId', {incDelId: '@incDelId'});

});


// module.controller('Ctrl', [ '$scope','$http','$location','OrdersIncDel',  function ($scope, $http, $location, OrdersIncDel) {
module.controller('Ctrl',  function ($scope, $http, $location, OrdersIncDel) {


    $scope.checkIsUserRegistr = function () {
        var id = $scope.productName;

        $http({
            method: 'GET',
            url: 'checkIsUserRegistr/'+id
        }).then(function successCallback(response) {
            $scope.checkIsUserRegistr = response;
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            $scope.checkIsUserRegistr = '404 from server /response :' + response;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };

    $scope.sendGet = function () {
       var id = $scope.id;

        $http({
            method: 'GET',
            url: 'incDel/orderProduct/'+id
        }).then(function successCallback(response) {
            $scope.resp = response.data;
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            $scope.resp = '404 from server';
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };



    $scope.controllerR = "controller Ctrl start init";

    var url = function () {
        return {incDelId: $scope.id};
        // return {orderId: $scope.productName || "init"};
    }

    //

    var update = function () {
        $scope.message = " update function start :"+$scope.productName;
        $scope.orderstIncDelList = OrdersIncDel.query(url());
        $scope.message = " update function finish  :"+$scope.productName;
    };

    $scope.update = function () {
        $scope.updateF = " update function start  :  "+$scope.productName;
        $scope.orderstIncDelList = OrdersIncDel.query(url());

        $scope.updateF = " update function finish  :"+$scope.productName;
    };


    $scope.add = function () {

        $scope.addF = "add function start";


        var order = new OrderIncDel();

        order.productName = $scope.productName;
        order.price = $scope.price;
        order.qty = $scope.qty;
        $scope.addF = "add function start / order  initialize";

        order.$save(url(), function () {

            $scope.saveF = "save func ready";

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




//
//
//
// var module = angular.module('app', ['ngResource']);
//
//
// module.factory('OrdersIncDel', function ($resource) {
//
//     return $resource('incDel/orderProduct/:incDelId/:product/:qty/:price', {incDelId: '@incDelId'},
//         {product:'@product'},{qty:'@qty'},{price:'@price'});
//
// });
//
//
// // module.controller('Ctrl', [ '$scope','$http','$location','OrdersIncDel',  function ($scope, $http, $location, OrdersIncDel) {
// module.controller('Ctrl',  function ($scope, $http, $location, OrdersIncDel) {
//
//
//     var url = function () {
//         return {
//             incDelId: $scope.id ,
//             product:$scope.productName,
//             qty:$scope.qty,
//             price:$scope.price};
//         // return {orderId: $scope.productName || "init"};
//     }
//
//
//
//     // $scope.sendGet = function () {
//     //    var id = $scope.id;
//     //    var product = $scope.productName;
//     //    var qty = $scope.qty;
//     //    var price = $scope.price;
//     //
//     //     $http({
//     //         method: 'GET',
//     //         url: 'incDel/orderProduct/'+id+'/'+product+'/'+qty+'/'+price
//     //     }).then(function successCallback(response) {
//     //         $scope.resp = response.data;
//     //         update();
//     //         // this callback will be called asynchronously
//     //         // when the response is available
//     //     }, function errorCallback(response) {
//     //         $scope.resp = '404 from server';
//     //         // called asynchronously if an error occurs
//     //         // or server returns response with an error status.
//     //     });
//     // };
//
//
//
//     var update = function () {
//         // $scope.message = " update function start :"+$scope.productName;
//         $scope.orderstIncDelList = OrdersIncDel.query(url());
//         // $scope.message = " update function finish  :"+$scope.productName;
//     };
//
//     $scope.update = function () {
//         // $scope.updateF = " update function start  :  "+$scope.productName;
//         $scope.orderstIncDelList = OrdersIncDel.query(url());
//
//         // $scope.updateF = " update function finish  :"+$scope.productName; ;
//     };
//
//
//
//
//
//     $scope.add = function () {
//
//         $scope.addF = "add function start";
//
//
//         var order = new OrderIncDel();
//
//         order.productName = $scope.productName;
//         order.price = $scope.price;
//         order.qty = $scope.qty;
//         $scope.addF = "add function start / order  initialize";
//
//         order.$save(url(), function () {
//
//             $scope.saveF = "save func ready";
//
//             order.productName = "";
//             order.price = "";
//             order.qty = "";
//             update();
//
//         });
//
//         $scope.addF = "add function finish";
//     };
//     update();
//     $scope.controllerR = "controller Ctrl finish";
//
// });
//
//
//
// //
// // $scope.checkIsUserRegistr = function () {
// //     var id = $scope.productName;
// //
// //     $http({
// //         method: 'GET',
// //         url: 'checkIsUserRegistr/'+id
// //     }).then(function successCallback(response) {
// //         $scope.checkIsUserRegistr = response;
// //         // this callback will be called asynchronously
// //         // when the response is available
// //     }, function errorCallback(response) {
// //         $scope.checkIsUserRegistr = '404 from server /response :' + response;
// //         // called asynchronously if an error occurs
// //         // or server returns response with an error status.
// //     });
// // };
// //
//
// $scope.sendPOST = function () {
//     var id = $scope.productName;
//
//     $http({
//         method: 'POST',
//         url: 'order/'+id,
//         data: $.param({ incDelId: productName })
//     }).then(function successCallback(response) {
//         $scope.respPost = response.data;
//         // this callback will be called asynchronously
//         // when the response is available
//     }, function errorCallback(response) {
//         $scope.respPost = '404 from server';
//         // called asynchronously if an error occurs
//         // or server returns response with an error status.
//     });
// };



// // $scope.sendPOST = function () {
// //     var id = $scope.productName;
// //
// //     $http({
// //         method: 'POST',
// //         url: 'order/'+id,
// //         data: $.param({ incDelId: productName })
// //     }).then(function successCallback(response) {
// //         $scope.respPost = response.data;
// //
// //         // this callback will be called asynchronously
// //         // when the response is available
// //     }, function errorCallback(response) {
// //         $scope.respPost = '404 from server';
// //         // called asynchronously if an error occurs
// //         // or server returns response with an error status.
// //     });
// // };
//
// // $scope.controllerR = "controller Ctrl start init";
//
// // var Order = $resource('/order/:orderId', {orderId:'@productName'});
// // var order = Order.get({orderId:5}, function() {
// //     order.price = 10;
// //     order.$save();
// // });
//
// // OrdersIncDel.query({incDelNumber : 'init'} , function (data) {
// //     $scope.orderstIncDelList = data;
// // });
//
//
//
// //