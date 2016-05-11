Ext.define('Test2.view.databrowsercalendar.DBCalendar', {
	extend : 'Test2.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Test2.view.databrowsercalendar.DBCalendarController',
	             'Test2.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
