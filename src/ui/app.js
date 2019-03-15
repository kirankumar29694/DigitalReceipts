'use strict';

var app = angular.module('digitalReceipts', []);
app.controller('digitalReceiptsController', ['$scope', 'digitalReceiptsFactory', function ($scope, digitalReceiptsFactory) {
$scope.currentDate = new Date();
    $scope.getReceipts = function (fromDate, toDate) {
        digitalReceiptsFactory.getDigitalReceipts(formatdate(fromDate), formatdate(toDate)).then(successHandler, errorHandler);
    };

    $scope.getNetSaleAmountPerWeek = function (data) {
        return parseFloat(data.reduce(returnTotalAmount, 0)).toFixed(2);
    };

    function formatdate(dateVal) {
        if(!dateVal) {
            return;
        }
        var d = new Date(dateVal);
        var date = [
            d.getFullYear(),
            ('0' + (d.getMonth() + 1)).slice(-2),
            ('0' + d.getDate()).slice(-2)
        ].join('-');
        return date;
    }

    function returnTotalAmount(total, eachObject) {
        return total + eachObject.netSaleAmount;
    }

    function successHandler(response) {
        var data = response.data;
        $scope.receiptsData = prepareReceiptsData(data);
    }

    function errorHandler(error) {
        console.log(error);
    }

    function prepareReceiptsData(data) {
        var receiptsData = {};
        var monthNames = ["January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        ];
        $.each(data, function (index, eachObject) {
            var businessDate = new Date(eachObject.businessDate);
            var year = businessDate.getFullYear();
            var weekNumber = businessDate.getWeek();
            var month = monthNames[businessDate.getMonth()];
            var weekInMonth = weekNumber % (businessDate.getMonth() + 1) + 1;
            if (!receiptsData[year]) {
                receiptsData[year] = {};
            }

            if (!receiptsData[year][month]) {
                receiptsData[year][month] = {};
            }

            if (receiptsData[year][month][weekInMonth] && receiptsData[year][month][weekInMonth].length > 0) {
                receiptsData[year][month][weekInMonth].push(eachObject);
            } else {
                receiptsData[year][month][weekInMonth] = [eachObject];
            }
        });

        var receiptsArray = [];
        var yearValues = Object.keys(receiptsData);
        yearValues.forEach(function (eachYear) {
            var receiptObject = {};
            receiptObject.year = eachYear;
            receiptObject.dataByMonth = [];
            var monthValues = Object.keys(receiptsData[eachYear]);
            monthValues.forEach(function (eachMonth) {
                var receiptMonthObject = {};
                receiptMonthObject.month = eachMonth;
                receiptMonthObject.dataByWeek = [];
                var weekValues = Object.keys(receiptsData[eachYear][eachMonth]);
                weekValues.forEach(function (eachWeek) {
                    var receiptWeekObject = {};
                    receiptWeekObject.weekNumber = eachWeek;
                    receiptWeekObject.data = receiptsData[eachYear][eachMonth][eachWeek];
                    receiptMonthObject.dataByWeek.push(receiptWeekObject);
                });
                receiptObject.dataByMonth.push(receiptMonthObject);
            });
            receiptsArray.push(receiptObject);
        });
        return receiptsArray;
    }

    Date.prototype.getWeek = function () {
        var dt = new Date(this.getFullYear(), 0, 1);
        return Math.ceil((((this - dt) / 86400000) + dt.getDay() + 1) / 7);
    };
}]);