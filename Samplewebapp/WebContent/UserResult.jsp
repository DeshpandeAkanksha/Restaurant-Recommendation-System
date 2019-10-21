<%@ page
	import="java.util.List, java.io.IOException, java.util.List,mining.GenerateMaps"%>
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
	href="https://getbootstrap.com/docs/4.3/examples/offcanvas/">

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


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.js"
	type="text/javascript">
	
</script>


<!-- Custom styles for this template -->
<link href="offcanvas.css" rel="stylesheet">
</head>
<body class="bg-light">
<main role="main" class="container">
  <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-dark rounded shadow-sm">
    <div class="lh-100">
      <h6 class="mb-0 text-light lh-100">Restaurant Recommendation</h6>
    </div>
  </div>
  </main>
<%
			System.out.println(request.getParameter("uid"));
			try {
				GenerateMaps inp = new GenerateMaps();
				String uid = request.getParameter("uid");
				GenerateMaps.generateMap(
						"/Users/akankshadeshpande/eclipse-workspace/Samplewebapp/resources/mining-proj-rev.csv");
				List<List<String>> resp = GenerateMaps.recommendBusiness(uid);
				//PrintWriter out = res.getWriter();
				for (int i = 0; i < resp.size(); i++) {
					List<String> list = resp.get(i);
		%>

	<main role="main" class="container">
	<div class="my-3 p-3 bg-white rounded shadow-sm">
		<div class="media text-muted pt-3">
			<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
				xmlns="http://www.w3.org/2000/svg"
				preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
				aria-label="Placeholder: 32x32">
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#007bff" />
				<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
			<div
				class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
				<div class="d-flex justify-content-between align-items-center w-100">
					<strong class="text-gray-dark">
						<%
							out.print(list.get(0));
						%>
					</strong>

				</div>
				<span class="d-block">
					<%
						out.print(list.get(1));
					%>
				</span> <span class="d-block">
					<%
						out.print(list.get(2));
					%>
				</span>
			</div>
		</div>
		<small class="d-block text-right mt-3"> </small>
	</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="test.js"><\/script>')
	</script>
	<script src="bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script src="offcanvas.js"></script>
</body>
<%
	}

	} catch (Exception e1) {

		e1.printStackTrace();

	}
%>
</html>
