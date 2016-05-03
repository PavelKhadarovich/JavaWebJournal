(function() {
    'use strict';

    angular.module('javaJournal').service('reviewServiceMock', reviewServiceMock);

    function reviewServiceMock() {
        this.getReviewList = function () {
            return [
                {
                    "id": 1,
                    "title": "First item",
                    "shortDescription": "cool description",
                    "text": "text",
                    "mark": 0,
                    "pictureSource": "http://2.bp.blogspot.com/-fsSpGME0mDw/UDJF3_icjXI/AAAAAAAAAKA/TA6bTxbC7mM/s1600/Fiordland-National-Park.jpg",
                    "date": 1461678841000,
                    "status": "NEW",
                    "reviewComments": []
                },
                {
                    "id": 3,
                    "title": "Second item",
                    "shortDescription": "szxdcf gvhbjnkm",
                    "text": "text",
                    "mark": 0,
                    "pictureSource": "http://www.southbeachmagazine.com/wp-content/uploads/2014/05/bltsteak585.jpg",
                    "date": 1461680168000,
                    "status": "NEW",
                    "reviewComments": []
                }, {
                    "id": 4,
                    "title": "Third item",
                    "shortDescription": " vbnmk",
                    "text": "v bhjnkm",
                    "mark": 0,
                    "pictureSource": "http://www.modern-traveler.com/wp-content/uploads/2015/07/Design-party.jpg",
                    "date": 1461682810000,
                    "status": "NEW",
                    "reviewComments": []
                }
            ];
        }
    }
})();