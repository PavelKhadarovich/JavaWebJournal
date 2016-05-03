(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('emailServiceAd', reviewItem);

    function reviewItem() {
        return {
            scope: {},
            templateUrl: '/app/common/templates/emailServiceAd.html',
            link: function (scope) {
                scope.subscribe = function () {
                    alert("You'll get emails on " + scope.email + "!");
                }
            }
        }
    }

})();