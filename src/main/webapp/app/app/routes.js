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
                        template: '<ui-view />'
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
            })
            .state('app.reviews-create', {
                url: '/reviews/create',
                pageTitle: 'Create Review',
                templateUrl: '/app/review/edit/reviewEdit.html',
                controller: 'reviewEditController',
                controllerAs: 'vm',
                resolve: {
                    review: [
                        function () {
                        }
                    ]
                }
            })
            .state('app.reviews-read', {
                url: '/reviews/:id',
                pageTitle: 'Review',
                templateUrl: '/app/review/read/review.html',
                controller: 'reviewController',
                controllerAs: 'vm',
                resolve: {
                    review: [
                        '$stateParams', 'reviewServiceMock', function ($stateParams, reviewServiceMock) {
                            return reviewServiceMock.getReviewById($stateParams.id);
                        }
                    ]
                }
            })
            .state('app.reviews-edit', {
                url: '/reviews/:id/edit',
                pageTitle: 'Edit Review',
                templateUrl: '/app/review/edit/reviewEdit.html',
                controller: 'reviewEditController',
                controllerAs: 'vm',
                resolve: {
                    review: [
                        '$stateParams', 'taskServiceMock', function ($stateParams, taskServiceMock) {
                            return taskServiceMock.getReviewById($stateParams.id);
                        }
                    ]
                }

            }).state('app.tasks', {
                url: '/tasks',
                pageTitle: 'Tasks',
                templateUrl: '/app/task/list/taskList.html',
                controller: 'taskListController',
                controllerAs: 'vm',
                resolve: {
                    tasks: [
                        'taskServiceMock', function (taskServiceMock) {
                            return taskServiceMock.getTaskList();
                        }
                    ]
                }
            })
            .state('app.tasks-create', {
                url: '/tasks/create',
                pageTitle: 'Create Task',
                templateUrl: '/app/task/edit/taskEdit.html',
                controller: 'taskEditController',
                controllerAs: 'vm',
                resolve: {
                    task: [
                        function () {
                        }
                    ]
                }
            })
            .state('app.tasks-read', {
                url: '/tasks/:id',
                pageTitle: 'Task',
                templateUrl: '/app/task/read/task.html',
                controller: 'taskController',
                controllerAs: 'vm',
                resolve: {
                    task: ['$stateParams', 'taskServiceMock', function ($stateParams, taskServiceMock) {
                        return taskServiceMock.getTaskById($stateParams.id);
                    }]
                }
            })
            .state('app.places', {
                url: '/places',
                pageTitle: 'Places',
                templateUrl: '/app/place/list/placeList.html',
                controller: 'placeListController',
                controllerAs: 'vm',
                resolve: {
                    places: [
                        'placeServiceMock', function (placeServiceMock) {
                            return placeServiceMock.getPlaceList();
                        }
                    ]
                }
            })
            .state('app.places-create', {
                url: '/places/create',
                pageTitle: 'Create Place',
                templateUrl: '/app/place/edit/placeEdit.html',
                controller: 'placeEditController',
                controllerAs: 'vm',
                resolve: {
                    place: [
                        function () {
                        }
                    ]
                }
            })
            .state('app.places-edit', {
                url: '/places/:id/edit',
                pageTitle: 'Edit Place',
                templateUrl: '/app/place/edit/placeEdit.html',
                controller: 'placeEditController',
                controllerAs: 'vm',
                resolve: {
                    place: [
                        '$stateParams', 'placeServiceMock', function ($stateParams, placeServiceMock) {
                            return placeServiceMock.getPlaceById($stateParams.id);
                        }
                    ]
                }
            })
            .state('app.profile', {
                url: '/profile',
                pageTitle: 'Edit Place',
                templateUrl: '/app/user/profile/profile.html',
                controller: 'profileController',
                controllerAs: 'vm',
                resolve: {
                    profile: [
                        'profileServiceMock', function (profileServiceMock) {
                            return profileServiceMock.getUserProfile();
                        }
                    ],
                    tasks: [
                        'taskServiceMock', function (taskServiceMock) {
                            return taskServiceMock.getTaskList();
                        }
                    ]
                }
            });

        $urlRouterProvider.otherwise('/');
    }

})();