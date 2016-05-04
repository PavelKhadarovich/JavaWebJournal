(function() {
    'use strict';

    angular.module('javaJournal').service('reviewServiceMock', reviewServiceMock);

    reviewServiceMock.$inject = ['_'];

    function reviewServiceMock() {
        var data = [
                {
                    "id": 1,
                    "title": "First item",
                    "shortDescription": "Laborum excepteur culpa ad reprehenderit labore consectetur sit do est et do. Pariatur quis velit exercitation id esse non velit dolor deserunt eiusmod est esse ullamco. Voluptate laborum amet tempor nisi veniam magna ea ut anim. Commodo minim est ipsum cillum voluptate deserunt dolor irure ex veniam anim aute deserunt exercitation. Elit amet dolor ullamco qui laboris tempor enim sint magna et ex eiusmod.\r\n",
                    "text": "Nisi do anim non voluptate pariatur do aliquip. Minim occaecat magna non occaecat sint do sit anim esse velit nulla enim. Do ea amet deserunt proident anim laborum adipisicing deserunt aliqua enim dolor. Fugiat qui sunt incididunt ipsum aute enim duis commodo nisi eu cillum. Sit minim sit veniam magna labore ullamco quis pariatur incididunt aute.\r\nFugiat tempor amet consequat reprehenderit aliquip irure velit quis in deserunt enim consectetur. Pariatur ad esse in consectetur officia. Elit ut mollit aliqua voluptate quis Lorem. Culpa aliqua sint Lorem commodo nulla commodo ut mollit.\r\nMollit magna incididunt veniam est qui pariatur qui commodo nulla do ipsum dolore proident. Laborum incididunt irure Lorem nisi fugiat et dolor quis. Non eu excepteur incididunt deserunt culpa. Amet ea Lorem excepteur minim occaecat ipsum id nulla adipisicing eu consectetur anim adipisicing. Anim aliqua duis anim Lorem. Ullamco mollit pariatur ipsum proident enim ullamco consectetur ea amet consectetur quis sit cillum. Ipsum dolore eiusmod cillum aliquip voluptate qui minim.\r\nNulla occaecat ex ex excepteur incididunt amet culpa nulla irure voluptate voluptate tempor. Dolor dolore eu ullamco aute consequat nostrud. Quis ipsum labore nulla ex non. Sit ex culpa laborum cillum aliquip aliquip fugiat ex enim sit exercitation aute consequat enim. Aliqua eiusmod culpa in quis incididunt magna nostrud veniam cillum aliquip anim labore ut.\r\nVelit ex sit Lorem ea in Lorem et nostrud esse laborum reprehenderit id labore anim. Ad consequat incididunt tempor dolore pariatur mollit. Cillum velit magna eiusmod ullamco anim duis velit proident ex ipsum mollit non. Consectetur aute exercitation ex ad. Commodo fugiat irure ullamco ad in. Nostrud esse esse dolor voluptate ut nostrud Lorem consequat pariatur aliquip commodo.\r\n",
                    "mark": 0,
                    "pictureSource": "http://2.bp.blogspot.com/-fsSpGME0mDw/UDJF3_icjXI/AAAAAAAAAKA/TA6bTxbC7mM/s1600/Fiordland-National-Park.jpg",
                    "date": 1461678841000,
                    "status": "NEW",
                    "reviewComments": [
                        {
                            nickname: "Aaron Paul",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        },
                        {
                            nickname: "Jason Momoa",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        }
                    ]
                },
                {
                    "id": 3,
                    "title": "Second item",
                    "shortDescription": "Laborum excepteur culpa ad reprehenderit labore consectetur sit do est et do. Pariatur quis velit exercitation id esse non velit dolor deserunt eiusmod est esse ullamco. Voluptate laborum amet tempor nisi veniam magna ea ut anim. Commodo minim est ipsum cillum voluptate deserunt dolor irure ex veniam anim aute deserunt exercitation. Elit amet dolor ullamco qui laboris tempor enim sint magna et ex eiusmod.\r\n",
                    "text": "Nisi do anim non voluptate pariatur do aliquip. Minim occaecat magna non occaecat sint do sit anim esse velit nulla enim. Do ea amet deserunt proident anim laborum adipisicing deserunt aliqua enim dolor. Fugiat qui sunt incididunt ipsum aute enim duis commodo nisi eu cillum. Sit minim sit veniam magna labore ullamco quis pariatur incididunt aute.\r\nFugiat tempor amet consequat reprehenderit aliquip irure velit quis in deserunt enim consectetur. Pariatur ad esse in consectetur officia. Elit ut mollit aliqua voluptate quis Lorem. Culpa aliqua sint Lorem commodo nulla commodo ut mollit.\r\nMollit magna incididunt veniam est qui pariatur qui commodo nulla do ipsum dolore proident. Laborum incididunt irure Lorem nisi fugiat et dolor quis. Non eu excepteur incididunt deserunt culpa. Amet ea Lorem excepteur minim occaecat ipsum id nulla adipisicing eu consectetur anim adipisicing. Anim aliqua duis anim Lorem. Ullamco mollit pariatur ipsum proident enim ullamco consectetur ea amet consectetur quis sit cillum. Ipsum dolore eiusmod cillum aliquip voluptate qui minim.\r\nNulla occaecat ex ex excepteur incididunt amet culpa nulla irure voluptate voluptate tempor. Dolor dolore eu ullamco aute consequat nostrud. Quis ipsum labore nulla ex non. Sit ex culpa laborum cillum aliquip aliquip fugiat ex enim sit exercitation aute consequat enim. Aliqua eiusmod culpa in quis incididunt magna nostrud veniam cillum aliquip anim labore ut.\r\nVelit ex sit Lorem ea in Lorem et nostrud esse laborum reprehenderit id labore anim. Ad consequat incididunt tempor dolore pariatur mollit. Cillum velit magna eiusmod ullamco anim duis velit proident ex ipsum mollit non. Consectetur aute exercitation ex ad. Commodo fugiat irure ullamco ad in. Nostrud esse esse dolor voluptate ut nostrud Lorem consequat pariatur aliquip commodo.\r\n",
                    "mark": 0,
                    "pictureSource": "http://www.southbeachmagazine.com/wp-content/uploads/2014/05/bltsteak585.jpg",
                    "date": 1461680168000,
                    "status": "NEW",
                    "reviewComments": [
                        {
                            nickname: "David Tennant",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        }
                    ]
                }, {
                    "id": 4,
                    "title": "Third item",
                    "shortDescription": " Laborum excepteur culpa ad reprehenderit labore consectetur sit do est et do. Pariatur quis velit exercitation id esse non velit dolor deserunt eiusmod est esse ullamco. Voluptate laborum amet tempor nisi veniam magna ea ut anim. Commodo minim est ipsum cillum voluptate deserunt dolor irure ex veniam anim aute deserunt exercitation. Elit amet dolor ullamco qui laboris tempor enim sint magna et ex eiusmod.\r\n",
                    "text": "Nisi do anim non voluptate pariatur do aliquip. Minim occaecat magna non occaecat sint do sit anim esse velit nulla enim. Do ea amet deserunt proident anim laborum adipisicing deserunt aliqua enim dolor. Fugiat qui sunt incididunt ipsum aute enim duis commodo nisi eu cillum. Sit minim sit veniam magna labore ullamco quis pariatur incididunt aute.\r\nFugiat tempor amet consequat reprehenderit aliquip irure velit quis in deserunt enim consectetur. Pariatur ad esse in consectetur officia. Elit ut mollit aliqua voluptate quis Lorem. Culpa aliqua sint Lorem commodo nulla commodo ut mollit.\r\nMollit magna incididunt veniam est qui pariatur qui commodo nulla do ipsum dolore proident. Laborum incididunt irure Lorem nisi fugiat et dolor quis. Non eu excepteur incididunt deserunt culpa. Amet ea Lorem excepteur minim occaecat ipsum id nulla adipisicing eu consectetur anim adipisicing. Anim aliqua duis anim Lorem. Ullamco mollit pariatur ipsum proident enim ullamco consectetur ea amet consectetur quis sit cillum. Ipsum dolore eiusmod cillum aliquip voluptate qui minim.\r\nNulla occaecat ex ex excepteur incididunt amet culpa nulla irure voluptate voluptate tempor. Dolor dolore eu ullamco aute consequat nostrud. Quis ipsum labore nulla ex non. Sit ex culpa laborum cillum aliquip aliquip fugiat ex enim sit exercitation aute consequat enim. Aliqua eiusmod culpa in quis incididunt magna nostrud veniam cillum aliquip anim labore ut.\r\nVelit ex sit Lorem ea in Lorem et nostrud esse laborum reprehenderit id labore anim. Ad consequat incididunt tempor dolore pariatur mollit. Cillum velit magna eiusmod ullamco anim duis velit proident ex ipsum mollit non. Consectetur aute exercitation ex ad. Commodo fugiat irure ullamco ad in. Nostrud esse esse dolor voluptate ut nostrud Lorem consequat pariatur aliquip commodo.\r\n",
                    "mark": 0,
                    "pictureSource": "http://www.modern-traveler.com/wp-content/uploads/2015/07/Design-party.jpg",
                    "date": 1461682810000,
                    "status": "NEW",
                    "reviewComments": [
                        {
                            nickname: "Daniel Radcliff",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        },
                        {
                            nickname: "Emma Watson",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        },
                        {
                            nickname: "Graham Norton",
                            text: "Ut et nulla aliqua aute dolore ad laborum mollit voluptate labore ut. Qui deserunt mollit ea aliquip magna mollit tempor voluptate laborum commodo sit. Et Lorem aliquip non ullamco eiusmod ea elit aute sint id. Cupidatat velit esse laboris cupidatat aliqua mollit adipisicing exercitation enim reprehenderit do dolor. Sunt laboris aliquip occaecat elit et sunt.\r\n"
                        }
                    ]
                }
        ];

        this.getReviewList = function () {
            return data;
        }

        this.getReviewById = function(id) {
            var x = _.filter(data, function(o) {
               return o.id == id;
            });
            return _.head(x);
        }
    }
})();