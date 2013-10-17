<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/slick.grid.css" type="text/css" media="screen" charset="utf-8" />
<link rel="stylesheet" href="css/jquery-ui-1.8.5.custom.css" type="text/css" media="screen" charset="utf-8" />
<!-- <link rel="stylesheet" href="css/examples.css" type="text/css" media="screen" charset="utf-8" /> -->
<script language="JavaScript" src="js/jquery-1.4.3.min.js"></script>
<script language="JavaScript" src="js/jquery.event.drag-2.0.min.js"></script>
<script language="JavaScript" src="js/slick.core.js"></script>
<script language="JavaScript" src="js/slick.grid.js"></script>
<script>
	var grid;

	var columns = [{
		id : "appId",
		name : "AppId",
		field : "appId"
	}, {
		id : "appPkgName",
		name : "AppPkgName",
		field : "appPkgName"
	}, {
		id : "appSize",
		name : "AppSize",
		field : "appSize"
	}];

	var options = {
		enableCellNavigation : false,
		enableColumnReorder : false
	};

	$(function() {
		var data = [];
		<c:forEach items="${appList}" var="item" varStatus="status">
			data["${status.index}"] = {
				appId : "${item.appId}",
				appPkgName : "${item.appPkgName}",
				appSize : "${item.appSize}"
			};
		</c:forEach>
		grid = new Slick.Grid($("#myGrid"), data, columns, options);
	})
</script>

<div id="myGrid" style="width:600px; height:500px;"></div>