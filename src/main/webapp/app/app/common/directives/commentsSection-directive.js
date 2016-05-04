(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('commentsSection', reviewItem);

    function reviewItem() {
        return {
            scope: {
                comments: "="
            },
            templateUrl: '/app/common/templates/commentsSection.html'
        }
    }

})();