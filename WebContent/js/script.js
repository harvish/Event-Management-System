angular.module('eventApp.Services',[]).service('SessionService', function(){
    var userIsAuthenticated = false;

    this.setUserAuthenticated = function(value){
        userIsAuthenticated = value;
    };

    this.getUserAuthenticated = function(){
        return userIsAuthenticated;
    };
});

	
var eventApp = angular.module('eventApp', ['ngRoute','ngAnimate','eventApp.Services']);
	eventApp.run(function($rootScope, $templateCache,$location) {
		   $rootScope.$on('$viewContentLoaded', function() {
		      $templateCache.removeAll();
		   });
		   $rootScope.$on("$locationChangeStart", function(event, next, current) {
			   
		   });
		   var oldLocation='';
		   $rootScope.$on('$routeChangeStart', function(angularEvent, next) {
			   $rootScope.isActive = function(route) {
			        return route === $location.path();
			    };
			   var isDownwards = true;
		       if (next && next.$$route) {
		         var newLocation = next.$$route.originalPath;
		         if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
		           isDownwards = false;
		         } 
		         oldLocation = newLocation;
		       }
		       $rootScope.isDownwards = isDownwards;
		   });
		});
	var resolve = {
	  delay: function($q, $timeout) {
	    var delay = $q.defer();
	    $timeout(delay.resolve, 0, false);
	    return delay.promise;
	  }
	};
	
	// configure our routes
	eventApp.config(function($routeProvider) {
		$routeProvider

			// route for the home page
			.when('/', {
				templateUrl : 'pages/welcome.html',
				controller  : 'mainController'
			})

			.when('/register', {
				templateUrl : 'pages/customer_registration.jsp',
				controller  : 'registerController',
				resolve: resolve  
			})

			.when('/event', {
				templateUrl : 'pages/event.jsp?q='+new Date().getTime(),
				controller  : 'eventController',
				resolve: resolve  
			})

			.when('/facility', {
				templateUrl : 'pages/facility.jsp',
				controller  : 'facilityController',
				resolve: resolve  
			})

			.when('/vendor', {
				templateUrl : 'pages/vendor.jsp',
				controller  : 'vendorController',
				resolve: resolve  
			})

			.when('/success/:msg', {
				templateUrl : 'pages/success.jsp',
				controller  : 'successController',
				resolve: resolve  
			})

			.when('/error/:msg', {
				templateUrl : 'pages/error.jsp',
				controller  : 'errorController',
				resolve: resolve  
			})

			.when('/report', {
				templateUrl : 'pages/reports.jsp',
				controller  : 'reportController',
				resolve: resolve  
			});
/*			.otherwise({
				redirectTo: function(search){
					return '/error/404 Not Found';
					}
			});
*/	});

	
	eventApp.controller('mainController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        oldLocation = newLocation;
	      }
	      $scope.isDownwards = isDownwards;
	    });*/
	});

	eventApp.controller('registerController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});
	
	eventApp.controller('eventController', function($scope,$http,$location,$templateCache) {
		$scope.message = 'Event Registration';
		/*$scope.$on('$viewContentLoaded', init);
		*/
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });
		*/$scope.form={};
		$scope.form.addOrEdit="false";
		$scope.checkcustomer='';
		$scope.checkevent='';
		$scope.fetchDetails= function() {
			
			loadgif();
			$http.get('EventUpdateController?customer_id='+$scope.form.customer_id+'&event_id='+$scope.form.event_id)
			.success(function(resp){
				$scope.form={};
				unloadgif();
				$scope.checkevent='';
				$scope.form=resp;
				$scope.form.addOrEdit="true";
				$scope.form.budget=$scope.form.budget_amount;
				$scope.form.event_type=$scope.form.event_code;
			})
			.error(function() {
				$scope.custid=$scope.form.customer_id;
				$scope.eventid=$scope.form.event_id;
				$scope.form={};
				$scope.form.customer_id=$scope.custid;
				$scope.form.event_id=$scope.eventid;
				$scope.form.addOrEdit="true";
				unloadgif();
				$scope.checkevent='Invalid Event ID';
			});
		};
		$scope.checkCustomerId = function() {
			loadgif();
			$http.get('CustomerCheck?customer_id='+$scope.form.customer_id)
			.success(function(){
				unloadgif();
				$scope.checkcustomer='';
			})
			.error(function() {
				unloadgif();
				$scope.checkcustomer='Invalid Customer ID';
			});
		};
		$scope.processform = function() {
			loadgif();
			if($scope.form.addOrEdit=='false')
			{
				$http({
					method: 'POST',
					url: 'EventRegistration', 
					data: $.param($scope.form),
					headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				})
				.success(function(data) {
					unloadgif();
					$location.path("success/Event Added");
				})
				.error(function() {
					unloadgif();
					$location.path("error/Event was not Addded");
				});
			}
			else
			{
				$http({
					method: 'POST',
					url: 'EventUpdateController', 
					data: $.param($scope.form),
					headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				})
				.success(function(data) {
					unloadgif();
					$location.path("success/Event Updated Successfully");
				})
				.error(function() {
					unloadgif();
					$location.path("error/Event was not updated");
				});
			}
		};
		
	});
	
	eventApp.controller('facilityController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});
	
	eventApp.controller('reportController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
		var oldLocation = '';
	    /*$scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});

	eventApp.controller('vendorController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});
	
	eventApp.controller('successController', function($scope,$routeParams) {
		$scope.message = $routeParams.msg;
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});

	eventApp.controller('errorController', function($scope,$routeParams) {
		$scope.message= $routeParams.msg;
		/*var oldLocation = '';
	    $scope.$on('$routeChangeStart', function(angularEvent, next) {
	      console.log("routeChangeStart");
	      var isDownwards = true;
	      if (next && next.$$route) {
	        var newLocation = next.$$route.originalPath;
	        if (oldLocation !== newLocation && oldLocation.indexOf(newLocation) !== -1) {
	          isDownwards = false;
	        }
	        
	        oldLocation = newLocation;
	      }
	      
	      $scope.isDownwards = isDownwards;
	    });*/
	});
	
	/*   
	 * directive to make jquery ui datepicker work 
	 */
	eventApp.directive('datepicker', function() {
	    return {
	        restrict: 'A',
	        require : 'ngModel',
	        link : function (scope, element, attrs, ngModelCtrl) {
	            $(function(){
	                element.datepicker({
	                    dateFormat:'dd/mm/yy',
	                    onSelect:function (date) {
	                        scope.$apply(function () {
	                            ngModelCtrl.$setViewValue(date);
	                        });
	                    }
	                });
	            });
	        }
	    }
	});
	