Ext.define('Test2.view.fw.DataPointPanel',{
	extend : 'Ext.panel.Panel',
	xtype: 'dataPointPanel',
	cls: 'kpi-main',
	dpData : [],
	//border:2,
	requires: ['Test2.view.fw.DataPointPanelController'],
	
	controller:'dataPointPanelController',
	header:{
		hidden:true
	},
	items: [{
        xtype: 'component',
        itemId:'dataPointPanelId', 
      //  cls: 'kpi-tiles',

        tpl: [
            '<div class="kpi-meta" align="center">',
                '<tpl for=".">',
                    '<span style="width:{width};background: {color};" >',
                        '<div >{statistic}</div> {description}',
                    '</span>',
                '</tpl>',
            '</div>'
        ],

        
	}]
});