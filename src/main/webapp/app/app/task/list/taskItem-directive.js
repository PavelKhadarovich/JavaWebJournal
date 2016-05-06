(function () {

    'use strict';

    angular.module('javaJournal')
        .directive('taskItem', taskItem);

    function taskItem() {
        return {
            scope: {
                data: "="
            },
            templateUrl: '/app/task/list/taskItem.html',
            link: function(scope) {
                scope.data.isExpanded = false;
                scope.data.isAssigned = scope.data.assignedEmployee != null;
                scope.expand = function() {
                    scope.data.isExpanded = !scope.data.isExpanded;
                }
                scope.assignToMe = function () {
                    //TODO:send assign request
                }
            }
        }
    }

})();