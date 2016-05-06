(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('taskListController', taskListController);

    taskListController.$inject = ['taskServiceMock'];

    function taskListController(taskServiceMock) {
        var vm = this;
        vm.tasks = taskServiceMock.getTaskList();
    }

})();