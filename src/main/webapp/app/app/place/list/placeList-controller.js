(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('placeListController', placeListController);

    placeListController.$inject = ['places'];

    function placeListController(places) {
        var vm = this;
        vm.places = places;
    }

})();