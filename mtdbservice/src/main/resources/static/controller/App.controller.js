sap.ui.define(
		["sap/ui/core/mvc/Controller"],
		function(Controller){
	return Controller.extend("shahriyar.controller.App",{
		onInit: function(){
			debugger;
			var oDataModel = new sap.ui.model.odata.v2.ODataModel("/shahriyar.svc");
			this.getView().setModel(oDataModel);
		}
	});
});