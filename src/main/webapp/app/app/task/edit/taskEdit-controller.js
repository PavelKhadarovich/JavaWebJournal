(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('taskEditController', reviewEditController);

    reviewEditController.$inject = ['task', '$state'];

    function reviewEditController(task, $state) {
        var vm = this;
        vm.actionName = $state.is('app.tasks-create') ? 'Create' : 'Edit';
        vm.task = task;
        vm.submit = function() {
            
        }
    }

})();