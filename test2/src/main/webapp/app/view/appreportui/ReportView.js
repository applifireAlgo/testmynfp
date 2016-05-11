Ext.define('Test2.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Test2.view.appreportui.ReportViewController',
	            'Test2.view.appreportui.datagrid.DataGridPanel',
	            'Test2.view.appreportui.datagrid.DataGridView',
	            'Test2.view.appreportui.querycriteria.QueryCriteriaView',
	            'Test2.view.appreportui.chart.ChartView',
	            'Test2.view.appreportui.datapoint.DataPointView',
	            'Test2.view.googlemaps.map.MapPanel',
	            'Test2.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
