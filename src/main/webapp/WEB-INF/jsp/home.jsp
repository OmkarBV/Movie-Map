<%@page import="movies.entity.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Map</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
<c :url value="/img/head2.jpg" var="head2" />


<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
}

.main-header {
	background: url("img/head2.jpg");
	padding: 20px;
	color: white;
	filter: grayscale(10%);
}

.main-nav {
	background-color: #ff9999;
	padding: 10px 30px;
	position: sticky;
	top: 0;
	text-align: center;
}

.main-nav button {
	color: rgb(251, 137, 137);
	background-color: white;
	border-radius: 40px;
	text-decoration: none;
	padding: 10px 25px;
	margin-left: 20px;
	margin-right: 20px;
	display: inline-block;
	font-size: 18px;
	display: inline-block;
	display: inline-block;
}

.main-nav button:hover {
	background: linear-gradient(45deg, black, orangered);
	border-radius: 50px;
	box-shadow: 0 0 5px white;
	transition: 0.4s;
	scale: 1.2 1;
}

.main-nav button.active {
	background: linear-gradient(45deg, rgb(255, 64, 64), darkred);
	border-radius: 50px;
	box-shadow: 0 0 5px white;
}

.my-table {
	display: table;
	border-collapse: collapse;
	border: 1px solid black;
	background-color: #ff9999; /* use #ff9999 as the main color */
	width: 100%;
}

.my-table th, .my-table td {
	padding: 10px;
	border: 1px solid black;
}

.my-table th {
	font-weight: bold;
	background-color: #333;
	color: #FFF;
}

.my-table tr {
	background-color: #ffe6e6; /* use a lighter shade for even rows */
}

.my-table tr:hover {
	background-color: #ffc2b3; /* use a darker shade for hovered rows */
}

h1 {
	font-family: 'Poppins', sans-serif;
	font-size: 60px;
	font-weight: 700;
	color: #ffffff;
	text-align: center;
	background-color: transparent;
	padding: 60px 0;
	margin-top: 0;
	text-shadow: 2px 2px 4px #000000;
	transition: all 0.3s ease;
	cursor: pointer;
}

#searchmovie {
	background-color: #ffcccc;
	padding: 20px;
	border-radius: 10px;
}

.searchtable {
	margin: auto;
}

.searchtable td {
	padding: 10px;
}

input[type=text], input[type=range] {
	border-radius: 5px;
	padding: 5px;
	border: none;
	background-color: #fff;
	box-shadow: 1px 1px 1px #ccc;
}

input[type=submit] {
	background-color: #fff;
	border-radius: 5px;
	padding: 5px 10px;
	border: none;
	cursor: pointer;
	box-shadow: 1px 1px 1px #ccc;
}

#sortmovie {
	background-color: #ffcccc;
	padding: 20px;
	border-radius: 10px;
}

.sortmovie {
	margin: auto;
}

.sortmovie td {
	padding: 10px;
}

#ratemovie {
	background-color: #ffcccc;
	padding: 20px;
	border-radius: 10px;
}

.ratemovie {
	margin: auto;
}

.ratemovie td {
	padding: 10px;
}

#admin {
	background-color: #ffcccc;
	padding: 20px;
	border-radius: 10px;
}

.admin {
	margin: auto;
}

.admin td {
	padding: 10px;
}
</style>

<script>
	function deleteSms() {
		if (document.getElementById("delete").value.length != 0) {
			alert("Data Deleted");
		}
	}

	function insertSms() {
		if (document.getElementById("insert").value.length != 0) {
			alert("Data Inserted");
		}
	}
	function updateSms() {
		if (document.getElementById("update").value.length != 0) {
			alert("Data Updated");
		}
	}

	function isAdmin() {
<%if (request.getAttribute("isadmin") != null) {%>
	
<%boolean check = (boolean) request.getAttribute("isadmin");%>
	
<%if (check) {%>
	adminController();
<%}
}%>
	}

	function adminController() {
		var x = document.getElementById("admin");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
	function searchMovie() {
		var x = document.getElementById("searchmovie");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
	function sortMovie() {
		var x = document.getElementById("sortmovie");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}

	function rateMovie() {
		var x = document.getElementById("ratemovie");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
</head>

<body>

	<header class="main-header">
		<h1>Movie Map</h1>
	</header>

	<nav class="main-nav" style="display: flex;">

		<form action="alldata">
			<button type="submit" style="align: left;">All Movies</button>
		</form>
		<button onclick="searchMovie()">Search Movie</button>
		<button onclick="sortMovie()">Sort Movies</button>
		<button onclick="rateMovie()">Rate Movie</button>
		<button onclick="isAdmin()">AdminController</button>
	</nav>


	<div id="searchmovie" style="display: none">

		<table class="searchtable">
			<tr>
				<form action="searchmovie">
					<td>Search Movie</td>
					<td><input type="text" name="name" required></td>
					<td><input type="submit" value="Search Movie"></td>
				</form>
			</tr>
			<tr>
				<form action="releseyear">
					<td>Search By Year</td>
					<td><input type="text" name="relese" required></td>
					<td><input type="submit" value="Search Movie"></td>
				</form>
			</tr>
			<tr>
				<form action="relesebetweenyear">
					<td>Enter Starting Year</td>
					<td><input type="text" name="firsty" required></td>
					<td>Enter End Year</td>
					<td><input type="text" name="lasty" required></td>
					<td><input type="submit" value="Search Movie"></td>
				</form>
			</tr>
			<tr>
				<form action="searchcountry">
					<td>Search Country</td>
					<td><input type="text" name="country" required></td>
					<td><input type="submit" value="Search Movie"></td>
				</form>

			</tr>
			<tr>
				<form action="searchdirector">
					<td>Search Director Name</td>
					<td><input type="text" name="director" required></td>
					<td><input type="submit" value="Search Movie"></td>
				</form>
			</tr>
			<tr>
				<form action="ratinggross">
					<td>Rating</td>
					<td><input type="range" name="rating" required min="1"
						max="10" value="5" id="ratingrange"
						oninput="result.value=ratingrange.value"> <output
							name="result" for="ratingrange">5</output></td>
					<td>Gross</td>
					<td><input type="text" name="gross" required> <input
						type="submit" value="Search Movie"></td>
			</tr>
			</form>
		</table>
	</div>
	<div id="sortmovie" style="display: none">

		<table class="sorttable">
			<tr>
				<td>
					<form action="sortbugetlh">
						<input type="submit" value="Sort By Budget Low To High">
					</form>
				</td>
				<td>
					<form action="sortbugethl">
						<input type="submit" value="Sort Budget High To Low">
					</form>
				</td>
				<td>
					<form action="sortgrosshl">
						<input type="submit" value="Sort Gross High To Low">
					</form>
				</td>
				<td>
					<form action="sortgrosslh">
						<input type="submit" value="Sort Gross Low To High">
					</form>
				</td>
				<td>
					<form action="hitmovie">
						<input type="submit" value="Hit Movies">
					</form>
				</td>
				<td>
					<form action="flopmovie">
						<input type="submit" value="Flop Movies">
					</form>
				</td>
			</tr>
		</table>
	</div>
	<div id="ratemovie" style="display: none">
		<form action="addrating" oninput="result.value=ratingrange.value">
			<table class="ratetable">
				<tr>
					<td>Movie Name</td>
					<td><input type="text" name="movie_name" required></td>


					<td>User Number</td>
					<td><input type="text" name="user_number" required></td>


					<td>Rating</td>
					<td><input type="range" name="ratingValue" required min="1"
						max="10" value="5" id="ratingrange"> <output name="result"
							for="ratingrange">5</output></td>
					<td><input type="submit" value="Gave"></td>

				</tr>
			</table>
		</form>
	</div>
	<div id="admin" style="display: none">
		<form action="insert">
			<table class="admin-insert-table">

				<tr>
					<td>Movie Name</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>Genres</td>
					<td><input type="text" name="genres" required></td>
				</tr>
				<tr>
					<td>Budget</td>
					<td><input type="text" name="buget" required></td>
				</tr>
				<tr>
					<td>Gross</td>
					<td><input type="text" name="gross" required></td>
				</tr>
				<tr>
					<td>Director</td>
					<td><input type="text" name="director" required></td>
				</tr>
				<tr>
					<td>Release</td>
					<td><input type="text" name="relese" required></td>
				</tr>
				<tr>
					<td>Rating</td>
					<td><input type="range" name="rating" required min="1"
						max="10" value="5" id="ratingrange"
						oninput="result.value=ratingrange.value"> <output
							name="result" for="ratingrange">5</output></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><input type="text" name="country" required></td>
				</tr>
				<tr>
					<td>Runtime</td>
					<td><input type="text" name="runtime" required id="insert">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Insert Movie"
						onclick="insertSms()"></td>
				</tr>


			</table>
		</form>
		<br> <br>
		<form action="delete">
			<table>

				<tr>
					<td>Delete Movie</td>
				</tr>
				<tr>
					<td><input type="text" required name="name" value=""
						id="delete"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Delete" onclick="deleteSms()">
						<%
						if (request.getAttribute("sms") == "false") {
							out.print("Movie Not Available");
						}
						%></td>
				</tr>

			</table>
		</form>
		<br> <br>
		<form action="update">
			<table>

				<tr>
					<td>Movie Name</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>Genres</td>
					<td><input type="text" name="genres" required></td>
				</tr>
				<tr>
					<td>Budget</td>
					<td><input type="text" name="buget" required></td>
				</tr>
				<tr>
					<td>Gross</td>
					<td><input type="text" name="gross" required></td>
				</tr>
				<tr>
					<td>Director</td>
					<td><input type="text" name="director" required></td>
				</tr>
				<tr>
					<td>Release</td>
					<td><input type="text" name="relese" required></td>
				</tr>
				<tr>
					<td>Rating</td>
					<td><input type="range" name="rating" required min="1"
						max="10" value="5" id="ratingrange"
						oninput="result.value=ratingrange.value"> <output
							name="result" for="ratingrange">5</output></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><input type="text" name="country" required></td>
				</tr>
				<tr>
					<td>Runtime</td>
					<td><input type="text" name="runtime" required id="insert">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Movie"
						onclick="updateSms()"></td>
				</tr>

			</table>
		</form>
	</div>

	<table class="my-table" id="getdata" style="display: table;">

		<tr>
			<th>NO</th>
			<th>Movie Name</th>
			<th>Genres</th>
			<th>Budget</th>
			<th>Gross</th>
			<th>Director</th>
			<th>Release</th>
			<th>Rating</th>
			<th>Country</th>
			<th>Runtime</th>
		</tr>

		<%
		if (request.getAttribute("data") != null) {
			ArrayList<Movie> al = (ArrayList<Movie>) request.getAttribute("data");
		%>
		<%
		int cnt = 1;
		for (Movie m : al) {
		%>
		<tr>
			<td>
				<%
				out.print(cnt++);
				%>
			</td>
			<td>
				<%
				out.print(m.getName());
				%>
			</td>
			<td>
				<%
				out.print(m.getGenres());
				%>
			</td>
			<td>
				<%
				out.print(m.getBuget());
				%>
			</td>
			<td>
				<%
				out.print(m.getGross());
				%>
			</td>
			<td>
				<%
				out.print(m.getDirector());
				%>
			</td>
			<td>
				<%
				out.print(m.getRelese());
				%>
			</td>
			<td>
				<%
				out.print(m.getRating());
				%>
			</td>
			<td>
				<%
				out.print(m.getCountry());
				%>
			</td>
			<td>
				<%
				out.print(m.getRuntime());
				%>
			</td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>

</html>