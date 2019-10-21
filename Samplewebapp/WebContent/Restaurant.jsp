<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin" action="RestaurantResult.jsp">

		<label for="businessId" class="sr-only">Enter the Business id:
		</label> <input list="bids" id=bid name="bid" class="form-control"
			placeholder="Business Id" required autofocus>
		<datalist id="bids">
			<option value="GhC1V0MRGoma3MP0Gn28Fw">
			<option value="Cdnp0HbJ4wVlzffuueG45w">
			<option value="9yKzy9PApeiPPOUJEtnvkg">
			<option value="ZRJwVLyzEJq1VAihDhYiow">
			<option value="6oRAC4uyJCsJl1X0WZpVSA">
			<option value="zp713qNhx8d9KCJJnrw1xA">
			<option value="wNUea3IXZWD63bbOQaOH-g">
			<option value="nMHhuYan8e3cONo3PornJA">
			<option value="e9nN4XxjdHj4qtKCOPq_vg">
			<option value="h53YuCiIDfEFSJCQpk8v1g">

		</datalist>
	    <label for="city" class="sr-only">Select the City: </label>
		<input list="cities" name="cities" class="form-control"
			placeholder="City" required autofocus>

		<datalist id="cities">
			<option value="Phoenix">
			<option value="Glendale">
			<option value="Scottsdale">
			<option value="Chandler">
			<option value="Gilbert">
			<option value="Tempe">
			
		</datalist>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

	</form>
</body>
</html>
