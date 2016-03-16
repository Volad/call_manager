(function($) {

	$.widget("ui.customerPhraseDialog", {
		options : {
			callerPhrases : null,
			callerPhrase : null,
			customerPhrase : null
		},

		_render : function(callerPhrase, isCreateDialog, customerPhrase) {
			var thisObj = this;

			thisObj.element.html();
			var modalHeader = $('.modal-header', thisObj.element);
			var modalBody = $('.modal-body', thisObj.element);
			var modalFooter = $('.modal-footer', thisObj.element);
			modalBody.html("");
			modalHeader.text((isCreateDialog ? "Добавить" : "Редактировать") + " ответ клиента")

			var srcPhraseContainer = $("<div/>");
			var targetPhraseContainer = $("<div><textarea class='form-control'></textarea><div>");

			if (isCreateDialog) {
				$("<h4><div>Ваш вопрос:</h4></div>").appendTo(srcPhraseContainer);
				$("<div><small>" + callerPhrase.title + "</small></div></h4>").appendTo(srcPhraseContainer);
			}
			srcPhraseContainer.appendTo(modalBody);

			$("<div><h4>Ответ клиента:</h4></div>").appendTo(modalBody);
			if (!isCreateDialog) {
				$("textarea", targetPhraseContainer).val(customerPhrase.title);
				
			}
			
			targetPhraseContainer.appendTo(modalBody);
			
			if(!isCreateDialog){
				var callerPhraseContainer = $("<div>");
				callerPhraseContainer.appendTo(modalBody)
				$("<div><h4>Выберите ваш ответ, или введите новый:</h4></div>").appendTo(callerPhraseContainer);
				$("<div id='rbGroup'>" +
						"" +
						"<label class='radio-inline' ><input type='radio' name='inlineRadioOptions' id='rb_group_cn'>Создать новый</label>" +
						"<label class='radio-inline'><input type='radio' name='inlineRadioOptions' id='rb_group_ce'>Выбрать из списка</label>" +
						"</div>").appendTo(callerPhraseContainer);
				var rbActionContent=$("<div id='rbActionContent'></div>").appendTo(callerPhraseContainer);
					$("#rb_group_cn",callerPhraseContainer).on("click",function () {
						rbActionContent.html("");
						$("<div><textarea class='form-control' id='dialog_new_cp'></textarea><div>").appendTo(rbActionContent);
					});
					
					$("#rb_group_ce",callerPhraseContainer).on("click",function () {
						rbActionContent.html("");
						var selectContent="";
						for(var i in thisObj.options.callerPhrases){
							var cp= thisObj.options.callerPhrases[i]
							selectContent+="<option "+(thisObj.options.nextCallerPhrase&& thisObj.options.nextCallerPhrase.id==cp.id?"selected":"")+ " value='"+cp.id+"' >"+cp.title+"</option>";
						}
						$("<div><select class='form-control' id='dialog_cp'>"+selectContent+"</select><div>").appendTo(rbActionContent);
					})
			}

			$("#saveCustomerPhrase", modalFooter).on("click", function() {
				// TODO [vk]: implement saving or updating customer answer variants
				console.log("value save")
				var value = $("textarea", modalBody).val();
				if (!isCreateDialog) {
					customerPhrase.title = value;
					var newCp=$("#dialog_new_cp",callerPhraseContainer);
					var existedCp=$("#dialog_cp",callerPhraseContainer);
					var callerPhrase={};
					if(newCp.length>0){
						callerPhrase.title=newCp.val();
					}
					
					if(existedCp.length>0){
						var searchableCpId=existedCp.val();
						for(var i in thisObj.options.callerPhrases){
							var cp= thisObj.options.callerPhrases[i]
							if(cp.id=searchableCpId){
								callerPhrase=cp;
								break;
							}
						}
					}
					
					thisObj._trigger("onCustomerPhraseChanged", null, [{
						title : customerPhrase.title,
						id : customerPhrase.id
					},callerPhrase]);
				} else {
					thisObj._trigger("onCustomerPhraseCreate", null, [ callerPhrase, {
						title : value
					} ]);
				}

			});
			//			
		},
		openDialog : function(callerPhrase, isCreate, customerPhrase,nextCallerPhrase) {
			this.options.callerPhrase = callerPhrase;
			this.options.isCreateDialog = isCreate;
			this.options.nextCallerPhrase = nextCallerPhrase;
			
			this.options.customerPhrase = customerPhrase;
			this._render(callerPhrase, isCreate, customerPhrase);
			this.element.modal('show');
		}
	})

})(jQuery);