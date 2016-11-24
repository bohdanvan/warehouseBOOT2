

var module = angular.module('app', ['ngResource']);

module.factory('OrdersIncDel', function ($resource) {
    return $resource('incDel/product/:incDelNumber', {incDelNumber: '@incDelNumber'});
})
    .controller('incDelFormAddNewOrderControllerAng', function ($scope, OrdersIncDel) {
        var url = function () {
            return {incDelNumber: $scope.incDelNumber || "init"};
        }

        var update = function () {
            $scope.orderstIncDelList = OrdersIncDel.query(url());
        };


        $scope.add = function () {
            var order = new OrderIncDel();

            order.productName = $scope.productName;
            order.price = $scope.price;
            order.qty = $scope.qty;

            order.$save(url(), function () {
                order.productName = "";
                order.price = "";
                order.qty = "";
                update();
            });
        };
        update();

    });