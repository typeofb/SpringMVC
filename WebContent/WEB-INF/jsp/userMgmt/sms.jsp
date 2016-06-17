<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
	#leftDiv	{float:left;}
	#centerDiv	{float:left; padding-top:50px;}
	#rightDiv	{float:left;}
</style>
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
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
	
	$("input:checkbox[id='chkList']:checked").each(function() {
		var index = $("input[id='chkList']").index(this);
		
		// 중복 추가인지 체크
		for (var i = 0; i < tblSend.rows.length; i++) {
			if ($("input[id='USR_ID_List']")[index].value == $("input[id='USR_ID_RCV']")[i].value) {
				alert($("input[id='USR_NM_List']")[index].value + "은(는) 수신자 목록에 있습니다.");
				return;
			}
		}
		
		// select tag 추가
		$("#selectRcv").append("<option value='" + $("input[id='USR_ID_List']")[index].value +"'>" + $("input[id='USR_NM_List']")[index].value + "</option>");
		
		// hidden값 추가
		var lastRow = tblSend.rows.length;
		var newRow = tblSend.insertRow(lastRow);
		var objCell = newRow.insertCell(0);
		objCell.innerHTML = "<input type='hidden' id='USR_ID_RCV' name='USR_ID_RCV' value='" + $("input[id='USR_ID_List']")[index].value + "' />";
		
		// input checkbox 삭제
		$(this).parent().parent().remove();
	});
}

function remove() {
	// 선택된 것이 없으면 return
	if ($("#selectRcv option:selected").length == 0) return;
	
	var tblSend = document.getElementById("tblSend");
	
	$("#selectRcv option:selected").each(function() {
		var index = $("#selectRcv option").index(this);
		
		// input checkbox 추가
		var html = "";
		html += "<tr>";
		html += "<td>";
		html += "<input type='checkbox' id='chkList' value='Y' />";
		html += "<input type='hidden' id='USR_ID_List' value='" + $(this).val() + "' />";
		html += "<input type='hidden' id='USR_NM_List' value='" + $(this).text() + "' />";
		html += "</td>";
		html += "<td>";
		html += $(this).text();
		html += "</td>";
		html += "</tr>";
		$("#tblList").append(html);
		
		// hidden값 삭제
		tblSend.deleteRow(index);
		
		// select tag 삭제
		$("#selectRcv option:eq(" + index + ")").remove();
	});
}

function send() {
	if ($("#selectRcv option").size() == 0) {
		alert("수신자를 추가해 주세요");
		return;
	}
	
	$.ajax({
		url: "smsSend.do",
		data: $("#smsForm").serializeArray(),
		type: "post",
		cache : false,
		dataType : "html",
		success: function(data) {
			alert(data);
		}
	});
}
</script>

<form id="smsForm" name="smsForm">
	<input type="hidden" name="token" value="${sessionScope.token}" />
	<div id="leftDiv">
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
		<div><a href="javascript:remove();"><span>삭제</span></a></div>
	</div>
	<div id="rightDiv">
		<select multiple id="selectRcv" style="width:150px; height:120px; overflow-y:scroll;"></select>
		<div><input type="button" onclick="send();" value="발송" /></div>
	</div>
	<div>
		<table id="tblSend"></table>
	</div>
</form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<style type="text/css">
	.on {background-color:#737b84; color:#fff;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$(".move").click(function() {
		var mode = $(this).attr("class") == "move up" ? "up" : "down";
		
		$("td a").each(function() {
			if ($(this).attr("class") == "on") {
				var element = $(this).closest("tr");
				
				if (mode == "up" && element.prev().html() != null) {
					element.insertBefore(element.prev());
				} else if (mode == "down" && element.next().html() != null) {
					element.insertAfter(element.next());
				}
			}
		});
	});
	$("td a").click(function() {
		$("td a").removeClass("on");
		$(this).addClass("on");
	});
});
</script>
<div>테이블 행 동적 이동</div>
<table border="1" cellspacing="0" cellpadding="3" bordercolor="#999999" style="border-collapse:collapse;">
	<tr>
		<td><a href="#">첫번째 행</a></td>
	</tr>
	<tr>
		<td><a href="#">두번째 행</a></td>
	</tr>
	<tr>
		<td><a href="#">세번째 행</a></td>
	</tr>
</table>
<button type="button" class="move up">위로</button>
<button type="button" class="move down">아래로</button>