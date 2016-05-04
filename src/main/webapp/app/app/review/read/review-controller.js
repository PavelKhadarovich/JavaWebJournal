(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('reviewController', reviewController);

    reviewController.$inject = ['review'];

    function reviewController(review) {
        var vm = this;
        vm.review = review;
    }

})();