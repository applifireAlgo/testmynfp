Ext.define('Test2.view.usermanagement.admin.AddUserDetailsViewModel',
{
	extend : 'Ext.app.ViewModel',
	
	alias : 'viewmodel.addUserModel',

	model: "AddUserDataModel",
	 
	requires:['Test2.model.AddUserDataModel'],

});