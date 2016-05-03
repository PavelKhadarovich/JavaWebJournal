(function () {
    'use strict';

    angular
        .module('javaJournal')
        .config(routeConfig);

    routeConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('app', {
                abstract: true,
                views: {
                   main: {
                        template: '<ui-view/>'
                   }
                }
            })
            .state('app.dashboard', {
                url: '/',
                pageTitle: 'Dashboard',
                templateUrl: '/app/dashboard/dashboard.html'
            })
            .state('app.login', {
                url: '/login',
                pageTitle: 'Login',
                templateUrl: '/app/authorization/login/login.html',
                controller: 'loginController'
            })
            .state('app.register', {
                url: '/register',
                pageTitle: 'Registration',
                templateUrl: '/app/authorization/registration/register.html',
                controller: 'registerController'
            })
            .state('app.reviews', {
                url: '/reviews',
                pageTitle: 'Reviews',
                templateUrl: '/app/review/list/reviewList.html',
                controller: 'reviewListController',
                controllerAs: 'vm'
            });
        $urlRouterProvider.otherwise('/');
    }

})();