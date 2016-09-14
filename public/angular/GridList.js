appGridList=angular.module("GridList",[]);
appGridList.controller('showGridList', function($scope, $http) {
	$http.get("/get-data").then(function(response){
		$scope.GridList=response.data;
	});
}).directive("afGridList", function(){
	return {
		restrict: 'C',
		templateUrl: '/views/grid-list.html'
	};
});