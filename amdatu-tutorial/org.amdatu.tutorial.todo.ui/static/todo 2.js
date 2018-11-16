angular.module('todoApp', [])
  .controller('TodoController', ['$scope', '$http', function($scope, $http) {

    $http.get('/todo/amdatu').success(function(response) {
      $scope.todos = response;
    });    
 
    $scope.addTodo = function() {
      var todo = {
        "description": $scope.todoText,
        "completed": false,
        "user": "amdatu"
      };

      $http.post('/todo', todo).success(function() {
        $scope.todoText = '';
        $scope.todos.push(todo);
      });
      
    };
 
    $scope.remaining = function() {
      var count = 0;
      angular.forEach($scope.todos, function(todo) {
        count += todo.done ? 0 : 1;
      });
      return count;
    };
 
    $scope.updateTodo = function(todo) {
      $http.post('/todo', todo).success(function() {
        $scope.todoText = '';
        $scope.todos.push(todo);
      });
    }
  }]);