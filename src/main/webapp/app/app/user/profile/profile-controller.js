(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('profileController', profileController);

    profileController.$inject = ['profile', 'tasks'];

    function profileController(profile, tasks) {
        var vm = this;
        vm.profile = profile;
        vm.tasks = tasks;
    }

})();