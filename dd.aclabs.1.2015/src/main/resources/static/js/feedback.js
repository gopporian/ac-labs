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
}]);

views.controller('ListFeedbackController', function($scope, $http) {
	$scope.hasFeedback = false;
	
	$scope.loadFeedbacks = function(){
		$http.get('/feedback').success(function(data) {
			$scope.feedbacks = data;
			$scope.hasFeedback = $scope.feedbacks && $scope.feedbacks.length > 0;
		});
	}
	
	$scope.removeFeedback = function(id){
		$http.delete('/feedback/'+id).success(function(){
			$scope.loadFeedbacks();
		});
	}
	
	$scope.showFeedbackEdit = function(feedback){
		$scope.editFeedback = {};
		$scope.editFeedback.name = feedback.name;
		$scope.editFeedback.message = feedback.message;
		$scope.editFeedback.id = feedback.id;
	}
	
	$scope.saveFeedbackEdit = function(){
		$http.post('/feedback', $scope.editFeedback).success(function(){
			$scope.loadFeedbacks();
			$scope.editFeedback = {};
			$('#editFeedbackModal').modal('toggle');
		});
	}
	
	$scope.loadFeedbacks();
});

views.controller('AddFeedbackController', function($scope, $http) {
	$scope.addFeedback = function(){
		console.log('adding ...');
		$http.post('/feedback', $scope.newFeedback);
		$scope.newFeedback = {};
	};
});

feedbackApp.controller('HeaderController', function($scope, $location) {
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};
});
