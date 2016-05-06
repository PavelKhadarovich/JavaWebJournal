(function (angular) {
    'use strict';

    angular.module('javaJournal', [
        'ui.router',
        'ui.bootstrap'
    ])
    .run(['$rootScope', function ($rootScope) {
        $rootScope.$on('$stateChangeSuccess', function () {
            document.body.scrollTop = document.documentElement.scrollTop = 0;
        });
    }]);
})(angular);