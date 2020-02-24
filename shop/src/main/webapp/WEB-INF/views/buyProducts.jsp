<link href="${css}/buyProducts.css" rel="stylesheet"/>
<h1>
<p class="disc" >Buy second hand products at cheap prices.</p>
 </h1>
<div class="container">

	<c:forEach items="${categories}" var="category">
		<a href="#" class="list">${category.name}</a>
	</c:forEach>
</div>
