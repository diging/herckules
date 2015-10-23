var iolausApp = angular.module('iolausApp', []);

iolausApp.controller('projectController', function ($scope, $http) {
  $http.get('projects').success(function(data) {
    $scope.projects = data;
  });
});