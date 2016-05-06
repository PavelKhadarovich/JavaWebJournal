(function() {
    'use strict';

    angular.module('javaJournal').service('profileServiceMock', profileServiceMock);

    profileServiceMock.$inject = ['_'];

    function profileServiceMock() {
        var data = [
                {
                    "email": "ivan@gmail.com",
                    "firstName": "ivan",
                    "id": 1,
                    "lastName": "ivanov",
                    "password": "1234",
                    "ssoId": "ivan",
                    "userProfiles": [
                        {
                            "id": 2,
                            "type": "MANAGER"
                        }
                    ]
                }
            ];

        this.getUserProfile = function () {
            return data[0];
        }
    }
})();