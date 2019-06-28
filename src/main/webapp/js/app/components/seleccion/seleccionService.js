
app.factory("seleccionService", function($http){
		

	return {
		
		
	    sumar:function(a,b) {
	      return a+b;
	    },
	    
	    restar:function(a,b) {
	      return a-b;
	    },
	    
	    getAllDog:function(){
	    	
	    	
	    	// Simple GET request example:
	    	$http({
	    	  method: 'GET',
	    	  url: "http://localhost:8091/dog/list/all"
	    	}).then(function successCallback(response) {
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    		return response;
	    		
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    		  return response;
	    		  
	    	  });
	    	
	    }
	    
	    
	    
	  }

	

});