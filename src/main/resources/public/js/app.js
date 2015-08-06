(function(){
    var app = angular.module('cookbookApp', []);

    app.controller('recipeController', function($scope, $http) {
        $scope.recipe = {};
        $http.get("/recipe/1").success(function(data) {
            $scope.recipe = data;
        });

    });
})();