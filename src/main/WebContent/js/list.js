$(document).ready(function(){
	function onactive(){
		$("#"+page).css({'background-color':'#337ab7'});
		$("#"+page).css({'color':'#fff'});
	};
	function onleave(){
		$("#"+page).css({'background-color':'buttonface'});
		$("#"+page).css({'color':'buttontext'});
	};
	function send(){
		window.location.href="listuserbypage?page="+page+"&perpage="+$("#perpage").val();
	}
	var page = $("#pagehide").val();
	$(".perpage").val($("#perpagehide").val());
	
	onleave();
	if(page>=3){
		page = Number(page);
		var y = -2;
		$(".button_page").each(function(){	
			$(this).prop("id",page+y);
			$(this).prop("value",page+y);
			$(this).text(page+y);
			y++;
		});
	}
	onactive();
	$(".button_page").each(function(){
		$(this).show();
		if($(this).val()>$("#sizehide").val())
			$(this).hide();
	});
	
	onactive();
	$("#previous").click(function(){
		onleave();
		if(page>1)
			page--;
		if(page>=3){
			var x = -2;
			$(".button_page").each(function(){
				$(this).prop("id",page+x);
				$(this).prop("value",page+x);
				$(this).text(page+x);
				x++;
			});
		}
		onactive();
		send();
	});
	$("#next").click(function(){
		onleave();
		if(page<$("#sizehide").val())
			page++;
		if(page>=3){
			var x = -2;
			$(".button_page").each(function(){
				$(this).prop("id",page+x);
				$(this).prop("value",page+x);
				$(this).text(page+x);
				x++;
			});
		}
		onactive();
		send();
	});
	$(".button_page").click(function(){
		onleave();
		page = Number($(this).val());
		if(page>=2 && page<=(Number($("#sizehide").val())-2)){
			var x = -2;
			if(page == 2)
				x = -1;
			$(".button_page").each(function(){
				$(this).prop("id",page+x);
				$(this).prop("value",page+x);
				$(this).text(page+x);
				x++;
			});
		}
		onactive();
		send();
	});
	$("#perpage").change(function(){
		window.location.href="listuserbypage?page=1&perpage="+$("#perpage").val();
	});
});
