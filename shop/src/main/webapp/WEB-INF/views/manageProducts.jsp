<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>







<div class="container">

	<div class="row">

		<div class="offset-md-2 col-md-8">

			<div class="card card-success card-bd-success">

				<div class="card-header">

					<h3>Product Management</h3>

				</div>

				<div class="card-body">

					<sf:form class="form-horizontal" modelAttribute="product">

						<div class="form-group row">

							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />

							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="Description">Enter
								Product Description:</label>

							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description for the product" class="form-control"></sf:textarea>
							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="Price">Enter
								Product Price:</label>

							<div class="col-md-8">

								<sf:input type="number" path="price" id="price" placeholder="Product Price" class="form-control" />
							</div>

						</div>

						<div class="form-group row">

							<label class="control-label col-md-4" for="Quantity">Enter
								Product Quantity:</label>

							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
							</div>

						</div>
 
						<div class="form-group row">


							<div class="offset-md-4 col-md-8">

								<input type="submit" name="submit" id="submit"
									placeholder="Submit" class="btn btn-primary" />
							</div>
							
							<!-- Hidden Fields -->
							<sf:hidden path="id"/>
							<sf:hidden path="active"/>

						</div>


					</sf:form>


				</div>

			</div>

		</div>

	</div>


</div>