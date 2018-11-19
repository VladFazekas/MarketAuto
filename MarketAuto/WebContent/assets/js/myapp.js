$(function(){
	
	// code for jquery dataTable
	
	
	
	var $table = $('#productListTable');
	
	var products = [
		
		['1','YAMAHA','2000','15'],
		['2','SUZUKI','1500','10'],
		['3','HONDA','100','12']
		
	];
	
	if($table.length){
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = 'MarketAuto/json-data/all-products'; 
		}else{
			jsonUrl = 'MarketAuto/json-data/category-'+ window.categoryId +'-all-products'; 
		}
		
		console.log('Inside the table');
		$table.DataTable({			
				 "data":products
//			"ajax":{
//				url: jsonUrl,
//				dataSrc: ''
//			},
//		"columns": [
//			{
//				data:'id',
//			},
//			{
//				data:'pname'
//			},
//			{
//				data:'unitPrice'
//			},
//			{
//				data:'quantity'
//			},
//				 {
//					data:'quantity'
//				 mRender: function(data,type,row){
//						var str = '';
//						str +='<a href="MarketAuto/add-'+data+'-product">AddProduct</a>';
//						return str;	
//					}
//				 }
//		]
		});
	}
	
});
