(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('placeEditController', placeEditController);

    placeEditController.$inject = ['place', '$state'];

    function placeEditController(place, $state) {
        var vm = this;
        vm.actionName = $state.is('app.places-create') ? 'Create' : 'Edit';
        vm.place = place;
        vm.submit = function() {
            
        }
    }

})();