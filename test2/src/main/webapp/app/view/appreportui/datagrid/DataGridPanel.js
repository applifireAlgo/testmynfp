Ext.define('Test2.view.appreportui.datagrid.DataGridPanel', {
	extend : 'Ext.panel.Panel',
	requires : ['Test2.view.appreportui.datagrid.DataGridPanelController'],
	controller:'dataGridPanelController',
	xtype:'dataGridPanel',
	itemId:'datagridpanelId',
	layout:'fit',
	reportView:null,
	reportDataJson:null,
	listeners:{
		scope:'controller',
		added:'afterDataGridPanelAdded'
	}
});