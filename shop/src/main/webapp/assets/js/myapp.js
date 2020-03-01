$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Buy Products':
		$('#buyProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;

	}

	// dataTable code

	var $table = $('#productListTable');

	if ($table.length) {

		// console.log('Inside the table.');

		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/json/data/buy/products';

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Items', '5 Items', '10 Items', 'All' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg">';
								}
							},

							{
								data : 'name'
							},
							{
								data : 'price',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;

								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									return str;

								}
							}

					],
				});

	}

	// dismissing the alert
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}


	// Admin DataTable

	var $adminProductsTable = $('#adminProductsTable');

	if ($adminProductsTable.length) {

		// console.log('Inside the table.');

		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable.DataTable({

					lengthMenu : [ [ 5, 10, 20, -1 ],
							[ '5 Items', '10 Items', '20 Items', 'All' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
								{
									data: 'id'
								},
							
								{
									data : 'code',
									bSortable: false, 
									mRender : function(data, type, row) {
	
										return '<img src="' + window.contextRoot
												+ '/resources/images/' + data
												+ '.jpg" class="adminDataTableImg">';	
									}
								},
	
								{
									data : 'name'
								},
								{
									data : 'quantity',
									mRender : function(data, type, row) {
	
										if (data < 1) {
											return '<span style="color:red">Out of Stock!</span>';
										}
										return data;
	
									}
								},
								{
									data : 'price',
									mRender : function(data, type, row) {
										return '&#8377; ' + data
									}
								},
								{
									data : 'active',
									bSortable: false,
									mRender: function(data, type, row){
										
										var str ='';
											str += '<label class="switch">'
											if(data){
													str +=	'<input type="checkbox" checked = "checked" value="'+row.id+'" />'
											}	
											else{
												str +=	'<input type="checkbox" value="'+row.id+'" />'
											}
											str	+=	'<div class="slider round"></div></label>';
											return str;
									}
																
								},
								{
									data: 'id',
									bSortable: false,
									mRender: function(data, type ,row){
										var str = '';
										
											str +=	'<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
											str +=	'<span class="glyphicon glyphicon-pencil"></span> </a>';
											
											return str;
									}
								}

							],
				
		// Activation and Deactivation using bootbox
					
		initComplete: function(){
			
			var api = this.api();
				
			api.$('.switch input[type="checkbox"]').on('change',function() {
							
				var checkbox = $(this);
				var checked = checkbox.prop('checked');
				var dMsg = (checked) ? 'You want to activate the Product?'
									: 'You want to deactivate the product?';

				var value = checkbox.prop('value');
					bootbox.confirm({
							
						size : 'medium',
						title : 'Product Activation & Deactivation',
						message : dMsg,
						callback : function(confirmed) {
						
							if (confirmed) {
								console.log(value);
								
								var activationUrl = window.contextRoot +'/manage/product/' +value+ '/activation';
								$.post(activationUrl, function (data){
									
									bootbox.alert({
										
										size : 'medium',
										title : 'Information',
										message : data
									});
									
								});
 								
								
							} else {
								checkbox.prop('checked', !checked);
							}

						}
					});

				});

								
			}
							
		});
	}
	
	

});
