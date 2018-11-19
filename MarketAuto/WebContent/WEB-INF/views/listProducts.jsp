<div class="container">

	<div class="row">

		<!-- display sidebar -->
		<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
		<div class="col-lg-3">
		<%@include file="./shared/sidebar.jsp" %>
		</div>
		</c:if>

		<!-- display products -->
		<div class="col-md-9">
		<!-- added breadcrumb component -->
			<div class="column">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true }">
					
					<script>
						window.categoryId = '';
					</script>
					
					<ol class="breadcrumb">
					
						<li><a href="/MarketAuto/home">Home</a></li>
						<li class="active">All Products</li>
					
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true }">
					
					<script>
						window.categoryId = '${category.id}';
					</script>
					
					<ol class="breadcrumb">
					
						<li><a href="/MarketAuto/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					
					</ol>
					</c:if>
					
					
					<table id="productListTable" class="table table-striped table-bordered">
					
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Unit Price</th>
								<th>Quantity Available</th>
							
							</tr>
						
						</thead>
						
						<tfoot>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Unit Price</th>
								<th>Quantity Available</th>
							
							</tr>
						
						</tfoot>
					
					</table>
					
					</div>
				
				
			
			</div>
		</div>

	</div>


</div>