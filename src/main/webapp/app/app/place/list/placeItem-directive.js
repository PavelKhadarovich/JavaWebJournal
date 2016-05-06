(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('placeItem', reviewItem);

    function reviewItem() {
        return {
            scope: {
                data: "="
            },
            templateUrl: '/app/place/list/placeItem.html',
            link: function(scope) {
                scope.data.isExpanded = false;
                scope.expand = function () {
                    scope.data.isExpanded = !scope.data.isExpanded;
                }
            }
        }
    }

})();