var cartApp = angular.module("cartApp", []);
cartApp.controller("cartCtrl", function($scope,$http){
	$scope.refreshCart = function (){
		$http.get('/styleandcut/rest/cart/'+$scope.cartId).then(function(data){
			$scope.cart=data;
		});
	};

$scope.clearCart = function(){
	$http.delete('/styleandcut/rest/cart/'+$scope.cartId).then($scope)
};

$scope.initCartId= function (cartId){
	$scope.cartId = cartId;
	$scope.refreshCart(cartId);
};

$scope.addToCart = function (productId){
	$http.post('/styleandcut/rest/cart/add/'+productId).then(function(data){
	alert("Product successfully added to the cart")
	});
};

$scope.removeFromCart = function (productId){
	$http.put('/styleandcut/rest/cart/remove/'+productId).then(function(){
			$scope.refreshCart();
	});
};
$scope.calGrandTotal=function(){
	var grandTotal=0;

	for(var i=0; i<1; i++){
		
		grandTotal+=$scope.cart.cartItems[i].totalPrice;
		}
	return grandTotal;
	};
});