'use strict';

app.factory('digitalReceiptsFactory', [
    "$http",
    "$q",
    function ($http, $q) {
        var getDigitalReceipts = function (fromDate, toDate) {
            var deferred = $q.defer();
            var queryString = fromDate ? '?from=' + fromDate + '&to=' + toDate : '';
            $http.get('http://localhost:8086/api/receipts/all' + queryString).then(function (response) {
                deferred.resolve(response);
            }, function (response) {
                deferred.reject(response);
            });

            return deferred.promise;
        };
        return {
            getDigitalReceipts: getDigitalReceipts
        };
    }
]);