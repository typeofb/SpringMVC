<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMS 발송</title>
<script language="JavaScript" src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
function selectAllList() {
	if ($("input:checkbox[id='chkSelectAllList']").is(":checked") == true) {
		$("input:checkbox[id='chkList']").each(function() {
			this.checked = true;
		});
	} else {
		$("input:checkbox[id='chkList']").each(function() {
			this.checked = false;
		});
	}
}

function add() {
	// 선택된 것이 없으면 return
	if ($("input:checked[id='chkList']:checked").length == 0) return;
	
	var tblSend = document.getElementById("tblSend");
	var objRow;
	var objCell;
	
	$("input:checkbox[id='chkList']:checked").each(function() {
		var index = $("input[id='chkList']").index(this);
		// 중복 추가인지 체크
		for (var i = 0; i < tblSend.rows.length; i++) {
			if ($("input[id='USR_ID_List']")[index].value == $("input[id='USR_ID_RCV']")[i].value) {
				alert($("input[id='USR_NM_List']")[index].value + "은(는) 수신자 목록에 있습니다.");
				return;
			}
		}
		
		$("#selectRcv").append("<option value='"+ $("input[id='USR_ID_List']")[index].value +"'>" + $("input[id='USR_NM_List']")[index].value + "</option>");
		
		objRow = tblSend.insertRow();
		objCell = objRow.insertCell();
		objCell.innerHTML = "<input type='hidden' id='USR_ID_RCV' name='USR_ID_RCV' value='" + $("input[id='USR_ID_List']")[index].value + "' />";
	});
}

function remove() {
	// 선택된 것이 없으면 return
	if ($("#selectRcv option:selected").length == 0) return;
	
	var tblSend = document.getElementById("tblSend");
	
	$("#selectRcv option:selected").each(function() {
		var index = $("#selectRcv option").index(this);
		$("#selectRcv option:eq(" + index + ")").remove();
		tblSend.deleteRow(index);
	});
}
</script>
</head>
<body>
<div id="topDiv">
	<table id="tblList" border="1" cellspacing="0" cellpadding="3" bordercolor="#999999" style="border-collapse:collapse;">
		<colgroup>
			<col width="10%" />
			<col width="90%" />
		</colgroup>
		<tr>
			<th><input type="checkbox" id="chkSelectAllList" value="N" onclick="javascript:selectAllList();" /></th>
			<th>수신자</th>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="chkList" value="Y" />
				<input type="hidden" id="USR_ID_List" value="admin" />
				<input type="hidden" id="USR_NM_List" value="관리자" />
			</td>
			<td>관리자</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="chkList" value="Y" />
				<input type="hidden" id="USR_ID_List" value="admin4" />
				<input type="hidden" id="USR_NM_List" value="약정수용가" />
			</td>
			<td>약정수용가</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="chkList" value="Y" />
				<input type="hidden" id="USR_ID_List" value="dev" />
				<input type="hidden" id="USR_NM_List" value="개발자" />
			</td>
			<td>개발자</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="chkList" value="Y" />
				<input type="hidden" id="USR_ID_List" value="test" />
				<input type="hidden" id="USR_NM_List" value="테스트" />
			</td>
			<td>테스트</td>
		</tr>
	</table>
</div>
<div id="centerDiv">
	<a href="javascript:add();"><span>추가</span></a>
	<a href="javascript:remove();"><span>삭제</span></a>
</div>
<div id="rightDiv">
	<select multiple id="selectRcv" style="width:150px; height:120px; overflow-y:scroll;"></select>
</div>
<div>
	<table id="tblSend"></table>
</div>
</body>
</html>