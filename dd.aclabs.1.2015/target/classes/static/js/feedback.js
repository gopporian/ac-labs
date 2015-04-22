'use strict';

var views = angular.module('views', []);

var feedbackApp = angular.module('feedbackApp', [ 'ngRoute', 'views' ]);

feedbackApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'ListFeedbackController',
		templateUrl : 'partials/listFeedback.html'
	}).when('/addFeedback', {
		controller : 'AddFeedbackController',
		templateUrl : 'partials/addFeedback.html'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

views.controller('ListFeedbackController', function($scope, $http) {
	$http.get('/feedback').success(function(data) {
		$scope.feedbacks = data;
	});
});

views.controller('AddFeedbackController', function($scope, $http) {
	$scope.addFeedback = function(){
		$http.post('/feedback', $scope.newFeedback);
		$scope.newFeedback = {};
	};
});

feedbackApp.controller('HeaderController', function($scope, $location) {
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};
});
