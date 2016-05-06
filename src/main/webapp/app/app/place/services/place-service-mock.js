(function() {
    'use strict';

    angular.module('javaJournal').service('placeServiceMock', placeServiceMock);

    placeServiceMock.$inject = ['_'];

    function placeServiceMock() {
        var data = [
                {
                    "city": "Minsk",
                    "description": "cool restaurant",
                    "email": "some@gmail.com",
                    "house": 5,
                    "id": 1,
                    "name": "Falcone",
                    "street": "Nemanskaja",
                    "type": "Restaurant"
                },
                {
                    "city": "London",
                    "description": "cool restaurant",
                    "email": "some@gmail.com",
                    "house": 5,
                    "id": 2,
                    "name": "Tempo",
                    "street": "Nemanskaja",
                    "type": "Restaurant"
                },
                {
                    "city": "Chicago",
                    "description": "cool restaurant",
                    "email": "some@gmail.com",
                    "house": 5,
                    "id": 2,
                    "name": "NAchos king",
                    "street": "Nemanskaja",
                    "type": "Restaurant"
                },

        ];

        this.getPlaceList = function () {
            return data;
        }

        this.getPlaceById = function(id) {
            var x = _.filter(data, function(o) {
               return o.id == id;
            });
            return _.head(x);
        }
    }
})();