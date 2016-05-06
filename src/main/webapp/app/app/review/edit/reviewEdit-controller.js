(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('reviewEditController', reviewEditController);

    reviewEditController.$inject = ['review', '$state'];

    function reviewEditController(review, $state) {
        var vm = this;
        vm.actionName = $state.is('app.reviews-create') ? 'Create' : 'Edit';
        vm.review = review;
        vm.submit = function() {
            
        }
    }

})();