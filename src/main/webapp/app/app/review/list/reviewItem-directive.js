(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('reviewItem', reviewItem);

    function reviewItem() {
        return {
            scope: {
                data: "="
            },
            templateUrl: '/app/review/list/reviewItem.html'
        }
    }

})();