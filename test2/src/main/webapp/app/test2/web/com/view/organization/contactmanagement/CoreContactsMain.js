Ext.define('Test2.test2.web.com.view.organization.contactmanagement.CoreContactsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CoreContactsMainController",
     "restURL": "/CoreContacts",
     "defaults": {
          "split": true
     },
     "requires": ["Test2.test2.shared.com.model.organization.contactmanagement.CoreContactsModel", "Test2.test2.web.com.controller.organization.contactmanagement.CoreContactsMainController", "Test2.test2.shared.com.model.organization.contactmanagement.TitleModel", "Test2.test2.shared.com.model.organization.locationmanagement.LanguageModel", "Test2.test2.shared.com.model.organization.contactmanagement.GenderModel", "Test2.test2.shared.com.model.organization.locationmanagement.TimezoneModel", "Test2.view.fw.component.Grids", "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationGroupModel", "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationTypeModel", "Test2.view.fw.component.Grids", "Test2.test2.shared.com.model.organization.locationmanagement.AddressTypeModel", "Test2.test2.shared.com.model.organization.locationmanagement.CountryModel", "Test2.test2.shared.com.model.organization.locationmanagement.StateModel", "Test2.test2.shared.com.model.organization.locationmanagement.CityModel", "Test2.test2.shared.com.viewmodel.organization.contactmanagement.CoreContactsViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Core Contacts",
               "name": "CoreContactsTreeContainer",
               "itemId": "CoreContactsTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CoreContactsTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Core Contacts",
                    "name": "CoreContacts",
                    "itemId": "CoreContactsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Contact Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "2214A317-412F-4631-9C09-F0E61426BA48",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "contactId"
                              }, {
                                   "name": "titleId",
                                   "itemId": "titleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.contactmanagement.TitleModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Title<font color='red'> *<\/font>",
                                   "fieldId": "93C985E3-BFDF-4A6E-AB9D-636461AE0BC9",
                                   "errorMessage": "Please enter title",
                                   "restURL": "Title",
                                   "bindable": "titleId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "firstName",
                                   "itemId": "firstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "First Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "78D2BAEB-4442-4972-900A-C6B831101379",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter First Name",
                                   "bindable": "firstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "middleName",
                                   "itemId": "middleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Middle Name",
                                   "fieldId": "9749D674-41F4-41DC-B5D4-DF896B95309B",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "middleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "lastName",
                                   "itemId": "lastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Last Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Last Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2FB08B25-B8C7-4A09-BD50-C531FD9464CB",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Last Name",
                                   "bindable": "lastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLanguageCode",
                                   "itemId": "nativeLanguageCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Language Code",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.LanguageModel"
                                   },
                                   "fieldLabel": "Native Language Code",
                                   "fieldId": "E56A2993-E95F-4B04-906E-A6DCFFFD748E",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Language",
                                   "bindable": "nativeLanguageCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeTitle",
                                   "itemId": "nativeTitle",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "fieldLabel": "Native Title",
                                   "fieldId": "7B82AA2C-F552-4501-9D93-0356D761B417",
                                   "bindable": "nativeTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeFirstName",
                                   "itemId": "nativeFirstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native First Name",
                                   "fieldId": "F28D1741-30CA-4D9C-B3E8-75A8B6A42A24",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeFirstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeMiddleName",
                                   "itemId": "nativeMiddleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Middle Name",
                                   "fieldId": "9B47FC30-68C9-4B46-AE53-A2505FC1F5FE",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeMiddleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLastName",
                                   "itemId": "nativeLastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native LastName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native LastName",
                                   "fieldId": "DC30F5E1-76A8-4CD6-9BDA-E56184DCB2DA",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeLastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "genderId",
                                   "itemId": "genderId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Gender",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.contactmanagement.GenderModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Gender<font color='red'> *<\/font>",
                                   "fieldId": "AD3E8AB1-D6F7-49FE-982E-2E8BD02F0D32",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Gender",
                                   "bindable": "genderId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateofbirth",
                                   "itemId": "dateofbirth",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "DOB",
                                   "fieldId": "D3871425-6AF5-4EAC-8B78-3D71457553E9",
                                   "errorMessage": "Please enter Date of birth",
                                   "bindable": "dateofbirth",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "age",
                                   "itemId": "age",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Age",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Age",
                                   "fieldId": "52FF362A-797B-4E23-8B85-F7DF230BD1EC",
                                   "minValue": "0",
                                   "maxValue": "125",
                                   "bindable": "age",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "approximateDOB",
                                   "itemId": "approximateDOB",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Approx DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Approx DOB",
                                   "fieldId": "B73F7699-0E1A-4742-9F6E-527E45895937",
                                   "bindable": "approximateDOB",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "emailId",
                                   "itemId": "emailId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Email ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Email ID<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "7D9DCB29-71DC-4E84-8C4B-B004E97EA13A",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Email ID",
                                   "bindable": "emailId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "phoneNumber",
                                   "itemId": "phoneNumber",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Phone Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C4B67187-9610-4A27-93EE-2B0D358C9B36",
                                   "minLength": "0",
                                   "maxLength": "20",
                                   "errorMessage": "Please enter Phone Number",
                                   "bindable": "phoneNumber",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "DD1E501C-547B-4283-9687-61EB95B20A61",
                                   "bindable": "versionId",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "Timezone",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "timezone.timeZoneId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Timezone<font color='red'> *<\/font>",
                                   "title": "Timezone",
                                   "itemId": "timezone",
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.TimezoneModel"
                                   }
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Communication Data",
                         "title": "Communication Data",
                         "name": "CommunicationData",
                         "itemId": "CommunicationDataForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "commDataId",
                                        "itemId": "commDataId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "commType",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "commType<font color='red'> *<\/font>",
                                        "fieldId": "EDF05826-7BFA-445C-A714-4C6804C538C3",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "communicationData.commDataId"
                                   }, {
                                        "name": "commGroupId",
                                        "itemId": "commGroupId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Group",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationGroupModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                        "fieldId": "516087DC-D03D-44C8-8B18-14F2F67EDFD2",
                                        "restURL": "CommunicationGroup",
                                        "bindable": "communicationData.commGroupId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCommGroupIdChange"
                                        }
                                   }, {
                                        "name": "commType",
                                        "itemId": "commType",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                        "fieldId": "1126E7DF-1839-484F-A718-E6620F0B41D5",
                                        "restURL": "CommunicationType",
                                        "bindable": "communicationData.commType",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "commData",
                                        "itemId": "commData",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Communication Data",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "4240BDBF-109C-4897-809A-78BACFD2E5E0",
                                        "minLength": "10",
                                        "errorMessage": "please enter communication details",
                                        "bindable": "communicationData.commData",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "versionId",
                                        "itemId": "versionId",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "versionId",
                                        "margin": "5 5 5 5",
                                        "value": "-1",
                                        "fieldLabel": "versionId",
                                        "fieldId": "E141619E-5F26-4736-A25C-918033E7CB84",
                                        "bindable": "communicationData.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add CommunicationData",
                              "handler": "addCommunicationData"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "CommunicationData",
                              "columnWidth": 1,
                              "itemId": "CommunicationDataGrid",
                              "fieldLabel": "List",
                              "bindLevel": "communicationData",
                              "bindable": "communicationData",
                              "listeners": {
                                   "select": "onCommunicationDataGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "commType",
                                   "text": "commType",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commDataId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Communication Group",
                                   "text": "Communication Group",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commGroupId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Type",
                                   "text": "Communication Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commType",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Data",
                                   "text": "Communication Data",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commData",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "txnAccessCode",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "xtype": "actioncolumn",
                                   "customWidgetType": "vdActionColumn",
                                   "width": 30,
                                   "sortable": false,
                                   "menuDisable": true,
                                   "items": [{
                                        "icon": "images/delete.gif",
                                        "tooltip": "Delete Record",
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Address",
                         "title": "Address",
                         "name": "Address",
                         "itemId": "AddressForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "addressId",
                                        "itemId": "addressId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Id",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                        "fieldId": "F35C93A3-8F24-4E54-A936-CA03716A35DB",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "address.addressId"
                                   }, {
                                        "name": "addressTypeId",
                                        "itemId": "addressTypeId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Address Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.locationmanagement.AddressTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                        "fieldId": "AFB82BD3-2917-4102-B2E4-AAFA9498E016",
                                        "errorMessage": "Please enter valid Address type",
                                        "restURL": "AddressType",
                                        "bindable": "address.addressTypeId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "addressLabel",
                                        "itemId": "addressLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Label",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Label",
                                        "fieldId": "FAC37F95-BDBD-45C9-A030-F3AB064E0AF1",
                                        "minLength": "0",
                                        "maxLength": "11",
                                        "bindable": "address.addressLabel",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address1",
                                        "itemId": "address1",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address1",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address1",
                                        "fieldId": "AD9D7044-2D30-450A-A3A3-7DC73397DE98",
                                        "bindable": "address.address1",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address2",
                                        "itemId": "address2",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address2",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address2",
                                        "fieldId": "B80BCBE5-948C-48DA-8FB7-96DA4F1A387D",
                                        "bindable": "address.address2",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address3",
                                        "itemId": "address3",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address3",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address3",
                                        "fieldId": "1F838C3F-ED76-4B5E-9F76-79F3BD3867EC",
                                        "bindable": "address.address3",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "countryId",
                                        "itemId": "countryId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.locationmanagement.CountryModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Country<font color='red'> *<\/font>",
                                        "fieldId": "F8339C2E-FE63-43BD-9129-677556AE34E9",
                                        "errorMessage": "Please enter Country",
                                        "restURL": "Country",
                                        "bindable": "address.countryId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCountryIdChange"
                                        }
                                   }, {
                                        "name": "stateId",
                                        "itemId": "stateId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "State",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.locationmanagement.StateModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "State<font color='red'> *<\/font>",
                                        "fieldId": "8051E7FC-BD11-41AA-AA9D-B9EED88CBEA6",
                                        "errorMessage": "Please enter State",
                                        "restURL": "State",
                                        "bindable": "address.stateId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onStateIdChange"
                                        }
                                   }, {
                                        "name": "cityId",
                                        "itemId": "cityId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Test2.test2.shared.com.model.organization.locationmanagement.CityModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "City<font color='red'> *<\/font>",
                                        "fieldId": "1C64A49E-4D49-458B-8E13-EA79214EA6E3",
                                        "errorMessage": "Please enter City",
                                        "restURL": "City",
                                        "bindable": "address.cityId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "zipcode",
                                        "itemId": "zipcode",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Postal Code",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "FEBD8FD1-36A7-4823-BD24-A46747187768",
                                        "minLength": "0",
                                        "maxLength": "6",
                                        "errorMessage": "Please enter postal code",
                                        "bindable": "address.zipcode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "latitude",
                                        "itemId": "latitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Latitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Latitude",
                                        "fieldId": "17CFC38E-CE48-4F42-B078-D1B30EEC9231",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.latitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "longitude",
                                        "itemId": "longitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Longitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Longitude",
                                        "fieldId": "18CDD8B8-3094-42A7-AE04-ACFEB6D4637F",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.longitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "versionId",
                                        "itemId": "versionId",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "versionId",
                                        "margin": "5 5 5 5",
                                        "value": "-1",
                                        "fieldLabel": "versionId",
                                        "fieldId": "4BDDBF98-0E16-41CA-BA82-68CE41A1A64D",
                                        "bindable": "address.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 132,
                              "text": "Add Address",
                              "handler": "addAddress"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "Address",
                              "columnWidth": 1,
                              "itemId": "AddressGrid",
                              "fieldLabel": "List",
                              "bindLevel": "address",
                              "bindable": "address",
                              "listeners": {
                                   "select": "onAddressGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Address Id",
                                   "text": "Address Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Address Type",
                                   "text": "Address Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressTypeId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Address Label",
                                   "text": "Address Label",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressLabel",
                                   "flex": 1
                              }, {
                                   "header": "Address1",
                                   "text": "Address1",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address1",
                                   "flex": 1
                              }, {
                                   "header": "Address2",
                                   "text": "Address2",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address2",
                                   "flex": 1
                              }, {
                                   "header": "Address3",
                                   "text": "Address3",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address3",
                                   "flex": 1
                              }, {
                                   "header": "Country",
                                   "text": "Country",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "countryId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "State",
                                   "text": "State",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "stateId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "City",
                                   "text": "City",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "cityId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Postal Code",
                                   "text": "Postal Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "zipcode",
                                   "flex": 1
                              }, {
                                   "header": "Latitude",
                                   "text": "Latitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "latitude",
                                   "flex": 1
                              }, {
                                   "header": "Longitude",
                                   "text": "Longitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "longitude",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "txnAccessCode",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "xtype": "actioncolumn",
                                   "customWidgetType": "vdActionColumn",
                                   "width": 30,
                                   "sortable": false,
                                   "menuDisable": true,
                                   "items": [{
                                        "icon": "images/delete.gif",
                                        "tooltip": "Delete Record",
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Core Contacts",
                    "title": "Details Grid",
                    "name": "CoreContactsGrid",
                    "itemId": "CoreContactsGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Contact Id",
                         "dataIndex": "contactId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Title",
                         "dataIndex": "titleId",
                         "flex": 1
                    }, {
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "Middle Name",
                         "dataIndex": "middleName",
                         "flex": 1
                    }, {
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Native Language Code",
                         "dataIndex": "nativeLanguageCode",
                         "flex": 1
                    }, {
                         "header": "Native Title",
                         "dataIndex": "nativeTitle",
                         "flex": 1
                    }, {
                         "header": "Native First Name",
                         "dataIndex": "nativeFirstName",
                         "flex": 1
                    }, {
                         "header": "Native Middle Name",
                         "dataIndex": "nativeMiddleName",
                         "flex": 1
                    }, {
                         "header": "Native LastName",
                         "dataIndex": "nativeLastName",
                         "flex": 1
                    }, {
                         "header": "Gender",
                         "dataIndex": "genderId",
                         "flex": 1
                    }, {
                         "header": "DOB",
                         "dataIndex": "dateofbirth",
                         "flex": 1
                    }, {
                         "header": "Age",
                         "dataIndex": "age",
                         "flex": 1
                    }, {
                         "header": "Approx DOB",
                         "dataIndex": "approximateDOB",
                         "flex": 1
                    }, {
                         "header": "Email ID",
                         "dataIndex": "emailId",
                         "flex": 1
                    }, {
                         "header": "Phone Number",
                         "dataIndex": "phoneNumber",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Core Contacts",
               "name": "CoreContacts",
               "itemId": "CoreContactsForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "contactId",
                              "itemId": "contactId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Contact Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                              "fieldId": "2214A317-412F-4631-9C09-F0E61426BA48",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "contactId"
                         }, {
                              "name": "titleId",
                              "itemId": "titleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Test2.test2.shared.com.model.organization.contactmanagement.TitleModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Title<font color='red'> *<\/font>",
                              "fieldId": "93C985E3-BFDF-4A6E-AB9D-636461AE0BC9",
                              "errorMessage": "Please enter title",
                              "restURL": "Title",
                              "bindable": "titleId",
                              "columnWidth": 0.5
                         }, {
                              "name": "firstName",
                              "itemId": "firstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "First Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "78D2BAEB-4442-4972-900A-C6B831101379",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter First Name",
                              "bindable": "firstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "middleName",
                              "itemId": "middleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Middle Name",
                              "fieldId": "9749D674-41F4-41DC-B5D4-DF896B95309B",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "middleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "lastName",
                              "itemId": "lastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Last Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Last Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "2FB08B25-B8C7-4A09-BD50-C531FD9464CB",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Last Name",
                              "bindable": "lastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLanguageCode",
                              "itemId": "nativeLanguageCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Language Code",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Test2.test2.shared.com.model.organization.locationmanagement.LanguageModel"
                              },
                              "fieldLabel": "Native Language Code",
                              "fieldId": "E56A2993-E95F-4B04-906E-A6DCFFFD748E",
                              "errorMessage": "Please enter gender",
                              "restURL": "Language",
                              "bindable": "nativeLanguageCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeTitle",
                              "itemId": "nativeTitle",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "fieldLabel": "Native Title",
                              "fieldId": "7B82AA2C-F552-4501-9D93-0356D761B417",
                              "bindable": "nativeTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeFirstName",
                              "itemId": "nativeFirstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native First Name",
                              "fieldId": "F28D1741-30CA-4D9C-B3E8-75A8B6A42A24",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeFirstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeMiddleName",
                              "itemId": "nativeMiddleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Middle Name",
                              "fieldId": "9B47FC30-68C9-4B46-AE53-A2505FC1F5FE",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeMiddleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLastName",
                              "itemId": "nativeLastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native LastName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native LastName",
                              "fieldId": "DC30F5E1-76A8-4CD6-9BDA-E56184DCB2DA",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeLastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "genderId",
                              "itemId": "genderId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Gender",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Test2.test2.shared.com.model.organization.contactmanagement.GenderModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Gender<font color='red'> *<\/font>",
                              "fieldId": "AD3E8AB1-D6F7-49FE-982E-2E8BD02F0D32",
                              "errorMessage": "Please enter gender",
                              "restURL": "Gender",
                              "bindable": "genderId",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateofbirth",
                              "itemId": "dateofbirth",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "DOB",
                              "fieldId": "D3871425-6AF5-4EAC-8B78-3D71457553E9",
                              "errorMessage": "Please enter Date of birth",
                              "bindable": "dateofbirth",
                              "columnWidth": 0.5
                         }, {
                              "name": "age",
                              "itemId": "age",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Age",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Age",
                              "fieldId": "52FF362A-797B-4E23-8B85-F7DF230BD1EC",
                              "minValue": "0",
                              "maxValue": "125",
                              "bindable": "age",
                              "columnWidth": 0.5
                         }, {
                              "name": "approximateDOB",
                              "itemId": "approximateDOB",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Approx DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Approx DOB",
                              "fieldId": "B73F7699-0E1A-4742-9F6E-527E45895937",
                              "bindable": "approximateDOB",
                              "columnWidth": 0.5
                         }, {
                              "name": "emailId",
                              "itemId": "emailId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Email ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Email ID<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "7D9DCB29-71DC-4E84-8C4B-B004E97EA13A",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Email ID",
                              "bindable": "emailId",
                              "columnWidth": 0.5
                         }, {
                              "name": "phoneNumber",
                              "itemId": "phoneNumber",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Phone Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C4B67187-9610-4A27-93EE-2B0D358C9B36",
                              "minLength": "0",
                              "maxLength": "20",
                              "errorMessage": "Please enter Phone Number",
                              "bindable": "phoneNumber",
                              "columnWidth": 0.5
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "DD1E501C-547B-4283-9687-61EB95B20A61",
                              "bindable": "versionId",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "Timezone",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "timezone.timeZoneId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Timezone<font color='red'> *<\/font>",
                              "title": "Timezone",
                              "itemId": "timezone",
                              "store": {
                                   "data": [],
                                   "model": "Test2.test2.shared.com.model.organization.locationmanagement.TimezoneModel"
                              }
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Communication Data",
                    "title": "Communication Data",
                    "name": "CommunicationData",
                    "itemId": "CommunicationDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "commDataId",
                                   "itemId": "commDataId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "commType",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "commType<font color='red'> *<\/font>",
                                   "fieldId": "EDF05826-7BFA-445C-A714-4C6804C538C3",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "communicationData.commDataId"
                              }, {
                                   "name": "commGroupId",
                                   "itemId": "commGroupId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Group",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationGroupModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                   "fieldId": "516087DC-D03D-44C8-8B18-14F2F67EDFD2",
                                   "restURL": "CommunicationGroup",
                                   "bindable": "communicationData.commGroupId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCommGroupIdChange"
                                   }
                              }, {
                                   "name": "commType",
                                   "itemId": "commType",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.contactmanagement.CommunicationTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                   "fieldId": "1126E7DF-1839-484F-A718-E6620F0B41D5",
                                   "restURL": "CommunicationType",
                                   "bindable": "communicationData.commType",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "commData",
                                   "itemId": "commData",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Communication Data",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "4240BDBF-109C-4897-809A-78BACFD2E5E0",
                                   "minLength": "10",
                                   "errorMessage": "please enter communication details",
                                   "bindable": "communicationData.commData",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "E141619E-5F26-4736-A25C-918033E7CB84",
                                   "bindable": "communicationData.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add CommunicationData",
                         "handler": "addCommunicationData"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "CommunicationData",
                         "columnWidth": 1,
                         "itemId": "CommunicationDataGrid",
                         "fieldLabel": "List",
                         "bindLevel": "communicationData",
                         "bindable": "communicationData",
                         "listeners": {
                              "select": "onCommunicationDataGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "commType",
                              "text": "commType",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commDataId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commGroupId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commType",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commData",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "txnAccessCode",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "xtype": "actioncolumn",
                              "customWidgetType": "vdActionColumn",
                              "width": 30,
                              "sortable": false,
                              "menuDisable": true,
                              "items": [{
                                   "icon": "images/delete.gif",
                                   "tooltip": "Delete Record",
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Address",
                    "title": "Address",
                    "name": "Address",
                    "itemId": "AddressForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "addressId",
                                   "itemId": "addressId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                   "fieldId": "F35C93A3-8F24-4E54-A936-CA03716A35DB",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "address.addressId"
                              }, {
                                   "name": "addressTypeId",
                                   "itemId": "addressTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Address Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.AddressTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                   "fieldId": "AFB82BD3-2917-4102-B2E4-AAFA9498E016",
                                   "errorMessage": "Please enter valid Address type",
                                   "restURL": "AddressType",
                                   "bindable": "address.addressTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "addressLabel",
                                   "itemId": "addressLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Label",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Label",
                                   "fieldId": "FAC37F95-BDBD-45C9-A030-F3AB064E0AF1",
                                   "minLength": "0",
                                   "maxLength": "11",
                                   "bindable": "address.addressLabel",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address1",
                                   "itemId": "address1",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address1",
                                   "fieldId": "AD9D7044-2D30-450A-A3A3-7DC73397DE98",
                                   "bindable": "address.address1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address2",
                                   "itemId": "address2",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address2",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address2",
                                   "fieldId": "B80BCBE5-948C-48DA-8FB7-96DA4F1A387D",
                                   "bindable": "address.address2",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address3",
                                   "itemId": "address3",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address3",
                                   "fieldId": "1F838C3F-ED76-4B5E-9F76-79F3BD3867EC",
                                   "bindable": "address.address3",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "countryId",
                                   "itemId": "countryId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.CountryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Country<font color='red'> *<\/font>",
                                   "fieldId": "F8339C2E-FE63-43BD-9129-677556AE34E9",
                                   "errorMessage": "Please enter Country",
                                   "restURL": "Country",
                                   "bindable": "address.countryId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCountryIdChange"
                                   }
                              }, {
                                   "name": "stateId",
                                   "itemId": "stateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "State",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.StateModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "State<font color='red'> *<\/font>",
                                   "fieldId": "8051E7FC-BD11-41AA-AA9D-B9EED88CBEA6",
                                   "errorMessage": "Please enter State",
                                   "restURL": "State",
                                   "bindable": "address.stateId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "name": "cityId",
                                   "itemId": "cityId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Test2.test2.shared.com.model.organization.locationmanagement.CityModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "City<font color='red'> *<\/font>",
                                   "fieldId": "1C64A49E-4D49-458B-8E13-EA79214EA6E3",
                                   "errorMessage": "Please enter City",
                                   "restURL": "City",
                                   "bindable": "address.cityId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "zipcode",
                                   "itemId": "zipcode",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Postal Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "FEBD8FD1-36A7-4823-BD24-A46747187768",
                                   "minLength": "0",
                                   "maxLength": "6",
                                   "errorMessage": "Please enter postal code",
                                   "bindable": "address.zipcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "latitude",
                                   "itemId": "latitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Latitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Latitude",
                                   "fieldId": "17CFC38E-CE48-4F42-B078-D1B30EEC9231",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.latitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "longitude",
                                   "itemId": "longitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Longitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Longitude",
                                   "fieldId": "18CDD8B8-3094-42A7-AE04-ACFEB6D4637F",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.longitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "4BDDBF98-0E16-41CA-BA82-68CE41A1A64D",
                                   "bindable": "address.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 132,
                         "text": "Add Address",
                         "handler": "addAddress"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "Address",
                         "columnWidth": 1,
                         "itemId": "AddressGrid",
                         "fieldLabel": "List",
                         "bindLevel": "address",
                         "bindable": "address",
                         "listeners": {
                              "select": "onAddressGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Address Id",
                              "text": "Address Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Address Type",
                              "text": "Address Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressTypeId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Address Label",
                              "text": "Address Label",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressLabel",
                              "flex": 1
                         }, {
                              "header": "Address1",
                              "text": "Address1",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address1",
                              "flex": 1
                         }, {
                              "header": "Address2",
                              "text": "Address2",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address2",
                              "flex": 1
                         }, {
                              "header": "Address3",
                              "text": "Address3",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address3",
                              "flex": 1
                         }, {
                              "header": "Country",
                              "text": "Country",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "countryId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "State",
                              "text": "State",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "stateId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "City",
                              "text": "City",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "cityId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "zipcode",
                              "flex": 1
                         }, {
                              "header": "Latitude",
                              "text": "Latitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "latitude",
                              "flex": 1
                         }, {
                              "header": "Longitude",
                              "text": "Longitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "longitude",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "txnAccessCode",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "xtype": "actioncolumn",
                              "customWidgetType": "vdActionColumn",
                              "width": 30,
                              "sortable": false,
                              "menuDisable": true,
                              "items": [{
                                   "icon": "images/delete.gif",
                                   "tooltip": "Delete Record",
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});