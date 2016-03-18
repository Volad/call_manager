module = angular.module('conversationApp', [])

module.service('ConversationService', function($http) {
	this.getCustomerPhraseByCallerPhraseId = function(callerPhraseId, customerPhrases, customerAnswerVariants) {
		var ids = $.grep(customerAnswerVariants, function(n) {
			return n.callerPhraseId == callerPhraseId;
		});

		var phrases = []
		for (i in ids) {
			phrases.push(getById(ids[i].customerPhraseId, customerPhrases));
		}
		return phrases;
	}
	this.getInitialCallerPhrase = function(callerPhrases) {
		for ( var i in callerPhrases) {
			var callerPhrase = callerPhrases[i];
			if (callerPhrase.initial) {
				return callerPhrase;
			}
		}
	}

	this.getCallerPhraseByCustomerPhraseId = function(customerPhraseId, callerAnswerVariants, callerPhrases) {
		var ids = $.grep(callerAnswerVariants, function(n) {
			return n.customerPhraseId == customerPhraseId;
		});

		for (i in ids) {
			return getById(ids[i].callerPhraseId, callerPhrases);
		}
	}

	this.loadTree = function(id, onSuccess) {
		$http.get("/rest/1.0/conversation/tree/" + id).success(function(data) {
			onSuccess(data)
		});
	}

	this.deleteCustomerAnswer = function(customerPhraseId, callerPhraseId, callBack) {
		$http.delete("/rest/1.0/conversation/customer/phrase/delete/" + customerPhraseId + "/" + callerPhraseId).success(callBack());
	}

	this.updateCustomerPhrase = function(customerPhrase) {
		 $http.put("/rest/1.0/conversation/customer/phrase/update", customerPhrase);
	}
	
	this.saveCall = function(callData) {
		$http.put("/rest/1.0/conversation/call", callData);
	}

	this.addCustomerPhrase = function(callerPhrase, customerPhrase) {

		$http.post("/rest/1.0/conversation/customer/phrase/create/" + callerPhrase.id, customerPhrase).success(function(data) {
			callerPhrase.customerPhrases.push(data)
		})
	},
	this.createCallerPhrase = function(callerPhrase) {

		return $http.post("/rest/1.0/conversation/caller/phrase/create/", callerPhrase).success(function(data) {
			return data;
		});
	},
	
	this.updateCallerAnswerVariants = function(customerPhraseId,callerPhraseId) {

		return $http.post("/rest/1.0/conversation/customer/answer/update/"+customerPhraseId+"/"+callerPhraseId);
	},
	

	
	

	getById = function(id, collection) {
		for ( var i in collection) {
			var item = collection[i];
			if (item.id == id) {
				return item;
			}
		}
	}

});

module.controller('conversationController', [
		'$scope',
		'$http',
		'ConversationService',
		function($scope, $http, conversationService) {
			$scope.conversationData = [];
			$scope.callData={callerId:2};
			$scope.startCall=function(){
				$scope.callData.startTime=new Date();
				conversationService.loadTree(2, function(data) {
					$scope.conversationData = data;
					$scope.visibleCallerPhrases = []

					var initialPhrase = conversationService.getInitialCallerPhrase(data.callerPhrases)

					pushNewCallerPhrase(initialPhrase)

					$scope.showNextCallerPhrase = function(callerPhrase, customerPhrase) {
						if (callerPhrase.historyIndex < $scope.visibleCallerPhrases.length) {
							$scope.visibleCallerPhrases = $scope.visibleCallerPhrases.slice(0, callerPhrase.historyIndex);
						}
						for ( var i in callerPhrase.customerPhrases) {
							callerPhrase.customerPhrases[i].selected = false;
						}
						customerPhrase.selected = true;
						var callerPhrase = conversationService.getCallerPhraseByCustomerPhraseId(customerPhrase.id, $scope.conversationData.callerAnswerVariants,
								$scope.conversationData.callerPhrases);
						pushNewCallerPhrase(callerPhrase)

					};

					function pushNewCallerPhrase(callerPhrase) {
						callerPhrase == $.extend({}, callerPhrase)
						callerPhrase.selected = true;
						callerPhrase.customerPhrases = conversationService.getCustomerPhraseByCallerPhraseId(callerPhrase.id,
								$scope.conversationData.customerPhrases, $scope.conversationData.customerAnswerVariants);
						$scope.visibleCallerPhrases.push(callerPhrase);
						callerPhrase.historyIndex = $scope.visibleCallerPhrases.length;
					}

					$scope.openEditCustomerPhraseDialog = function($event, callerPhrase, customerPhrase) {
						openDialog($event, callerPhrase, customerPhrase, false)
					};
					$scope.openCreateCustomerPhraseDialog = function($event, callerPhrase, customerPhrase) {
						openDialog($event, callerPhrase, null, true)
					};
					$scope.deleteCustomerAnswerVariant = function($event, callerPhrase, customerPhraseId) {
						$event.stopPropagation();
						conversationService.deleteCustomerAnswer(customerPhraseId, callerPhrase.id,function(){
							var targetCp=[]
							for (var i in callerPhrase.customerPhrases){
								var cp=callerPhrase.customerPhrases[i]
								if(cp.id==customerPhraseId){
									continue;
								}
								targetCp.push(cp)
							}
							callerPhrase.customerPhrases=targetCp
						});
			
					};

					openDialog = function($event, callerPhrase, customerPhrase, isCreate) {
						$event.stopPropagation();
						var dialogDiv = $('#customerPhraseDialog');
						var dialog;
						if(!$scope.dialog){
							 dialog = $(dialogDiv).customerPhraseDialog({
								isCreateDialog : isCreate,
								callerPhrases:$scope.conversationData.callerPhrases,
								onCustomerPhraseChanged : function(evt, changedCustomerPhrase,newCallerPhrase) {
									if(newCallerPhrase&&!newCallerPhrase.id){
										newCallerPhrase.callerId=$scope.callData.callerId;
										conversationService.createCallerPhrase(newCallerPhrase).then(function(response){
											$scope.conversationData.callerPhrases.push(response.data)
											updatePhrases(changedCustomerPhrase,response.data,true);
										})
										
									}else{
										updatePhrases(changedCustomerPhrase,newCallerPhrase);
									}
									
									
									function updatePhrases(changedCustomerPhrase,newCallerPhrase,isNew){
										 conversationService.updateCustomerPhrase(changedCustomerPhrase);
											 conversationService.updateCallerAnswerVariants(changedCustomerPhrase.id,newCallerPhrase.id).then(function(){
												 for(i in $scope.conversationData.callerAnswerVariants){
														var answerVariant=$scope.conversationData.callerAnswerVariants[i];
														if(answerVariant.customerPhraseId==changedCustomerPhrase.id){
															answerVariant.callerPhraseId=newCallerPhrase.id;
															return;
														}
													}
												 $scope.conversationData.callerAnswerVariants.push({"callerPhraseId":newCallerPhrase.id,"customerPhraseId":changedCustomerPhrase.id});
											 });
									}
								},
	
								onCustomerPhraseCreate : function(evt, callerPhrase, customerPhrase) {
									conversationService.addCustomerPhrase(callerPhrase, customerPhrase);
									$scope.$apply($scope.visibleCallerPhrases);
								}
							});
							var nextCallerPhrase;
							if(!isCreate){
								var nextCallerPhrase= conversationService.getCallerPhraseByCustomerPhraseId(customerPhrase.id, $scope.conversationData.callerAnswerVariants,
										$scope.conversationData.callerPhrases);
							}
							$scope.dialog=dialog;
						}
						$(dialogDiv).customerPhraseDialog('openDialog', callerPhrase, isCreate, customerPhrase,nextCallerPhrase);
					}
				});
			};
			$scope.endCall=function(){
				if(!$scope.callData.startTime){
					alert("Перед тем как что-то закончить надо что-то начать")
					return;
				}
				$scope.callData.endTime=new Date();
				$scope.callData.history=$scope.visibleCallerPhrases;
				conversationService.saveCall($scope.callData);
				location.reload();
			}
		} ]);
