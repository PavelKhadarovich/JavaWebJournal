(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('comment', comment);

    function comment() {
        return {
            scope: {
                comment: "=data"
            },
            templateUrl: '/app/common/templates/comment.html'
        }
    }

})();