angular.module("app", []).controller("controller", function ($scope) {
    $scope.polls = [{ id: 1, name: "one", text: "hello text goes here", options: [{text: "One text", id: 1, percent: 0},
        {text: "Second text", id: 2, percent: 0}]},
        { id: 1, name: "one", text: "hello text goes here", options: [{text: "One text", id: 1, percent: 0},
            {text: "Second text", id: 2, percent: 0}]}];
});