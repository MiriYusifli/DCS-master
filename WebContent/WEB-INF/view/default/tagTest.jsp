<%@taglib prefix="ex" uri="http://www.myapp.net/jsp/app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<html>
<head>
<title>A sample custom tag</title>
</head>
<body>
	<hr />
	test1 with tag library with java
	<ex:Hello />

	<hr />
	test2 with tag file with jstl
	<select>
		<tags:selectedOption dataMap="${Map}" filtr="${Filtr}" />
	</select> 
	<hr />
	exception  test<br/>

		<tags:printException/>
	<hr />

</body>
</html>