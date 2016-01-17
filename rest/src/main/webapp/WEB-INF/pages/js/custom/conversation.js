
module=angular.module('conversationApp', [])

module.service('ConversationService', function() {
            this.getCustomerPhraseByCallerPhraseId=function(callerPhraseId, customerPhrases, customerAnswerVariants){
                  var ids= $.grep(customerAnswerVariants,function(n){
                	 return n.callerPhraseId==callerPhraseId;
                  });

                  var phrases=[]
                  for(i in ids){
                	   phrases.push(getById(ids[i].customerPhraseId,customerPhrases));
                  }
                  return phrases;
            }
            this.getInitialCallerPhrase=function(callerPhrases){
            	for(var i in callerPhrases){
            		var callerPhrase=callerPhrases[i];
            		if(callerPhrase.initial){
            			return callerPhrase;
            		}
            	}
            }

            this.getCallerPhraseByCustomerPhraseId=function(customerPhraseId,callerAnswerVariants,callerPhrases){
            	     var ids= $.grep(callerAnswerVariants,function(n){
                   return n.customerPhraseId==customerPhraseId;
                  });

                  for(i in ids){
                     return  getById(ids[i].callerPhraseId,callerPhrases);
                  }
            };
            
            this.deleteCustomerAnswerVariant=function(customerPhraseId,callerPhraseId){
            	//TODO [vk]: implement removal
            };

            getById=function(id,collection){
              for(var i in collection){
                var item=collection[i];
                if(item.id==id){
                  return item;
                }
              }
            }
           
});

module.controller('conversationController', ['$scope', '$http','ConversationService', function($scope, $http, conversationService){
	$scope.conversationData = [];
	//TODO [vk]: user actual user id here
	$http.get("/rest/1.0/conversation/tree/2").
		success(function(data) {
      $scope.conversationData = data;
      $scope.visibleCallerPhrases=[]

			var initialPhrase=conversationService.getInitialCallerPhrase(data.callerPhrases)
			
       		pushNewCallerPhrase(initialPhrase)
			
			$scope.showNextCallerPhrase=function(callerPhrase,customerPhrase){
    	  		if(callerPhrase.historyIndex<$scope.visibleCallerPhrases.length){
    	  			$scope.visibleCallerPhrases=$scope.visibleCallerPhrases.slice(0,callerPhrase.historyIndex);
    	  		}
    	  		for(var i in callerPhrase.customerPhrases){
    	  			callerPhrase.customerPhrases[i].selected=false;
    	  		}
    	  		customerPhrase.selected=true;
				var callerPhrase=conversationService.getCallerPhraseByCustomerPhraseId(customerPhrase.id,$scope.conversationData.callerAnswerVariants,$scope.conversationData.callerPhrases);
				pushNewCallerPhrase(callerPhrase)
      
			}

      function pushNewCallerPhrase(callerPhrase){
    	callerPhrase==$.extend({},callerPhrase)
        callerPhrase.selected=true;
        callerPhrase.customerPhrases=conversationService.getCustomerPhraseByCallerPhraseId(callerPhrase.id,$scope.conversationData.customerPhrases,$scope.conversationData.customerAnswerVariants);
        $scope.visibleCallerPhrases.push(callerPhrase);
        callerPhrase.historyIndex=$scope.visibleCallerPhrases.length;
      }

      $scope.openEditCustomerPhraseDialog=function($event,callerPhrase,customerPhrase){
    	  $event.stopPropagation();
    	  openDialog(callerPhrase,customerPhrase,false)
      }
      $scope.openCreateCustomerPhraseDialog=function(callerPhrase,customerPhrase){
    	  openDialog(callerPhrase,true)
      }
      $scope.deleteCustomerAnswerVariant=function(callerPhrase,customerPhrase){
    	  conversationService.deleteCustomerAnswerVariant(customerPhrase.id,callerPhrase.id);
      }
      
      openDialog=function(callerPhrase,customerPhrase,isCreate){
    	  
    	  var dialogDiv = $('#customerPhraseDialog');
    	  var dialog = $(dialogDiv).customerPhraseDialog({
				//overide widget field 
    		  callerPhrase: callerPhrase,
    		  customerPhrase:customerPhrase,
    		  isCreateDialog:isCreate,
	        	// add new method to dialog widget which will be triggered on file changed (from jquery widget)
		        onPhraseChanged: function(evt) {
					 $scope.$apply($scope.visibleCallerPhrases)
		        }
    		});
    		$(dialogDiv).customerPhraseDialog('openDialog', callerPhrase,isCreate,customerPhrase);
      }
	});
}]);

