//$("#r1").show();
$("a").click(function(ev){
	//ev.preventDefault();
	switch($(this).attr("tag")){
		case "overview":
			console.log("overview");
			$("#r2").hide();
			$("#r1").show();
			break;
		case "start_stn_freq":
			console.log("start_stn_freq");
			$("#r1").hide();
			$("#r2").show();
			break;
		default:
			console.log("default");
			break;
	}
});