
(function($) {
 	
	$.widget("ui.customerPhraseDialog", {
	  options: {
	  	callerPhrase: null,
	  	customerPhrase:null
	  },
	

	  _render: function(callerPhrase,isCreateDialog,customerPhrase) {
			var thisObj = this;

			thisObj.element.html();
			var modalHeader = $('.modal-header',thisObj.element);
			var modalBody = $('.modal-body',thisObj.element);
			var modalFooter = $('.modal-footer',thisObj.element);
			modalBody.html("");
			modalHeader.text((isCreateDialog?"Добавить":"Редактировать")+" ответ клиента")
			
			var srcPhraseContainer=$("<div/>");
			var targetPhraseContainer=$("<div><textarea class='form-control'></textarea><div>");
			
			if(isCreateDialog){
				$("<h4><div>Ваш вопрос:</h4></div>").appendTo(srcPhraseContainer);
				$("<div><small>"+callerPhrase.title+"</small></div></h4>").appendTo(srcPhraseContainer);
			}
			srcPhraseContainer.appendTo(modalBody);
			
			$("<div><h4>Ответ клиента:</h4></div>").appendTo(modalBody);
			if(!isCreateDialog){
				$("textarea",targetPhraseContainer).val(customerPhrase.title);
			}
			targetPhraseContainer.appendTo(modalBody);
			
			$("#saveCustomerPhrase",modalFooter).on("click",function(){
				//TODO [vk]: implement saving or updating customer answer variants
				console.log("value save")
				thisObj._trigger("onPhraseChanged", null);
			});
//			
	  },
	  openDialog: function(callerPhrase,isCreate,customerPhrase){
		  	this.options.callerPhrase = callerPhrase;
		  	this.options.isCreateDialog = isCreate;
		  	this.options.customerPhrase=customerPhrase;
		  	this._render(callerPhrase,isCreate,customerPhrase);
		  	this.element.modal('show');
		  }
	})

})(jQuery);