(function() {
    'use strict';

    angular.module('javaJournal').service('taskServiceMock', taskServiceMock);

    taskServiceMock.$inject = ['_'];

    function taskServiceMock() {
        var data = [
                {
                    "dateChanged": 1461668017000,
                    "dateCreated": 1461668017000,
                    "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                    "id": 2,
                    "place": {
                        "id": 6,
                        "name": "Hilton Hotel",
                        "type": "HOTEL"
                    },
                    "assignedEmployee": {
                        "firstName": "ivan",
                        "id": 1,
                        "lastName": "ivanov"
                    },
                    "status": "NEW",
                    "title": "Review new Hilton in London"
                },
                {
                    "dateChanged": 1461668017000,
                    "dateCreated": 1461668017000,
                    "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                    "id": 3,
                    "place": {
                        "id": 7,
                        "name": "WILD DINGO",
                        "type": "CASINO"
                    },
                    "assignedEmployee": {
                        "firstName": "ivan",
                        "id": 1,
                        "lastName": "ivanov"
                    },
                    "status": "NEW",
                    "title": "RE-review Wild Dingo"
                },
               {
                   "dateChanged": 1461668017000,
                   "dateCreated": 1461668017000,
                   "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                   "id": 4,
                   "place": {
                       "id": 6,
                       "name": "Hilton Hotel",
                       "type": "HOTEL"
                   },
                   "assignedEmployee":null,
                   "status": "NEW",
                   "title": "Review new Hilton in London"
               },
                {
                    "dateChanged": 1461668017000,
                    "dateCreated": 1461668017000,
                    "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                    "id": 5,
                    "place": {
                        "id": 7,
                        "name": "WILD DINGO",
                        "type": "CASINO"
                    },
                    "status": "NEW",
                    "title": "RE-review Wild Dingo"
                }, {
                    "dateChanged": 1461668017000,
                    "dateCreated": 1461668017000,
                    "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                    "id": 6,
                    "place": {
                        "id": 6,
                        "name": "Hilton Hotel",
                        "type": "HOTEL"
                    },
                    "status": "NEW",
                    "title": "Review new Hilton in London"
                },
                {
                    "dateChanged": 1461668017000,
                    "dateCreated": 1461668017000,
                    "description": "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n",
                    "id": 7,
                    "place": {
                        "id": 7,
                        "name": "WILD DINGO",
                        "type": "CASINO"
                    },
                    "assignedEmployee": {
                        "firstName": "ivan",
                        "id": 1,
                        "lastName": "ivanov"
                    },
                    "status": "NEW",
                    "title": "RE-review Wild Dingo"
                }
            ];

        this.getTaskList = function () {
            return data;
        }

        this.getTaskById = function(id) {
            var x = _.filter(data, function(o) {
               return o.id == id;
            });
            return _.head(x);
        }
    }
})();