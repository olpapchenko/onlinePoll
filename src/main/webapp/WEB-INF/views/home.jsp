<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online poll</title>
        <link href="https://fonts.googleapis.com/css?family=Baloo" rel="stylesheet">
        <link rel="stylesheet" href="/resources/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link href="/resources/style.css" rel="stylesheet"/>
        <script src="/resources/vendor/angular/angular.min.js"></script>
        <script src="/resources/app.js"></script>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-2">
                <div class="row">
                    <h3 class="brand pull-right">Online poll</h3>
                </div>
            </div>
            <div class="col-lg-8"></div>
        </div>

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="jumbotron" style="background-color: transparent;">
                    <h2 style="color: white;">List of active polls</h2>
                    <div class="alert alert-info row" role="alert" ng-repeat="poll in polls" ng-click="poll.active = true">
                        <a href="#" class="alert-link pull-left">{{poll.name}}</a>
                        <button class="btn-primary btn-sm pull-right" ng-click="poll.results = true">Results</button>

                        <div ng-show="poll.active">
                            <span>{{poll.text}}</span>

                            <form action="#">
                                <div ng-repeat="options in poll.options">
                                    <label>
                                        <input type="checkbox" ng-model="poll.value">
                                        label0
                                    </label>
                                </div>
                                <div>
                                    <label>
                                        <input type="checkbox">
                                        label0
                                    </label>
                                </div>

                            </form>
                            <button class="btn-primary btn-sm" ng-click="confirm(poll.id)">Confirm</button>
                        </div>
                        <div ng-show="poll.results" class="row" style="padding: 20px;">
                            <div style="padding-top: 10px;" ng-repeat="result in poll.options">
                                <span>{{result.text}} ({{result.percent}}%)</span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="{{{result.percent}}" aria-valuemin="0" aria-valuemax="100" ng-style="{'width': result.percent + '%'}">
                                     </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <p><a class="btn btn-primary btn-lg" href="#" role="button">Add new poll</a></p>
                    <div class="alert alert-warning">
                        <input type="text" class="form-control">
                    </div>
                </div>
            </div>
        </div>

     </body>
</html>
