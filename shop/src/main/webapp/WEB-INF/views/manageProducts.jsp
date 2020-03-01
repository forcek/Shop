<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">

	<div class="row ">

		<c:if test="${not empty message}">

			<div class="alert alert-success alert-dismissible offset-md-4">

				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}

			</div>


		</c:if>
		
		<c:if test="${not empty message1}">

			<div class="alert alert-danger alert-dismissible offset-md-4">

				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message1}

			</div>


		</c:if>



		<div class="offset-md-2 col-md-8">

			<div class="card card-success">

				<div class="card-header">

					<h3>Product Management</h3>

				</div>

				<div class="card-body">

					<!-- FORM -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">



						<div class="form-group row">

							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" style="color:red" element="em" />
							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="description">Enter
								Product Description</label>

							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description for the product"
									class="form-control"></sf:textarea>
								<sf:errors path="description" style="color:red" element="em" />
							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="price">Enter
								Product Price</label>

							<div class="col-md-8">

								<sf:input type="number" path="price" id="price"
									placeholder="Product Price" class="form-control" />
								<sf:errors path="price" style="color:red" element="em" />
							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="quantity">Enter
								Product Quantity</label>

							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
								<sf:errors path="quantity" style="color:red" element="em" />
							</div>

						</div>

						<!-- For Image -->

						<div class="form-group row">

							<label class="control-label col-md-4" for="file">Select
								an Image</label>

							<div class="col-md-8">

								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" style="color:red" element="em" />
							</div>

						</div>


						<div class="form-group row">


							<div class="offset-md-4 col-md-8">

								<input type="submit" name="submit" id="submit"
									placeholder="Submit" class="btn btn-primary" />
							</div>

							<!-- Hidden Fields -->
							<sf:hidden path="id" />
							<sf:hidden path="active" />
							<sf:hidden path="code" />


						</div>


					</sf:form>


				</div>

			</div>

		</div>

	</div>



	<hr />
	<h1>Available Products</h1>
	<hr />

	<div class="row">


		<div class='col-xs-12 col-md-12'>
			<div style="overflow:auto">

				<table id="adminProductsTable"
					class="table table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Active</th>
							<th>Edit</th>

						</tr>
					</thead>


					<tfoot>

						<tr>

							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Active</th>
							<th>Edit</th>

						</tr>
					</tfoot>


				</table>
			</div>

		</div>


	</div>

</div>