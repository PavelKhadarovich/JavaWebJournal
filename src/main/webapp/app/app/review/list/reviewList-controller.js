(function () {

    'use strict';

    angular.module('javaJournal')
        .controller('reviewListController', reviewListController);

    reviewListController.$inject = ['reviewServiceMock'];

    function reviewListController(reviewServiceMock) {
        var vm = this;
        vm.reviews = reviewServiceMock.getReviewList();
    }

})();