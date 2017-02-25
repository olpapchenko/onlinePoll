angular.module("app", []).controller("controller", function ($scope, $http) {
    var optionIdx = 0;

    $scope.polls = [{ id: 1, name: "one", text: "hello text goes here", options: [{text: "One text", id: 1, percent: 0},
        {text: "Second text", id: 2, percent: 0}]},
        { id: 1, name: "one", text: "hello text goes here", options: [{text: "One text", id: 1, percent: 0},
            {text: "Second text", id: 2, percent: 0}]}];

    $http.get("/questions").then(function (questions) {
        $scope.polls = questions;
    });

    $scope.newEntity = {options: []};

    $scope.addOption = function () {
        $scope.newEntity.options.push({id: optionIdx++});
    }

    $scope.removeOption = function (option) {
        $scope.newEntity.options = $scope.newEntity.options.filter(function (item) {
            return item.id != option.id;
        })
    }

    $scope.add = function () {
        $http.post("/questions", $scope.newEntity).then(function () {
            location.reload();
        }, function() {
            alert("something went wrong");
        });
    }

    $scope.confirm = function (id, answer) {
        $http.post("/question/answer", {id: id, answer: answer}).then(function () {
            $location.reload();
        });
    }
});