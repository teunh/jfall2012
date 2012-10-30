require(["js/jquery/jquery-1.8.1.min", "js/jquery/jquery-ui-1.8.23.custom.min"], function() {
});

// Bootstrap dependencies
require(["js/bootstrap/js/bootstrap.min"]);
require(["js/bootstrap/js/bootstrap-modal"]);

// Angular dependencies
require(["angular/angular"], function() {
	require(["angular/i18n/angular-locale_nl-nl"]);
	require(["angular/i18n/angular-locale_en-us"]);
	require(["angular/angular-resource","angular/angular-ui", "angular/angular-ui-ieshiv"]);
	
	//resource dependencies
	require(["js/ui/resources"], function() {
		// Service depencendies
		require(["js/ui/services"], function() {
			//modules en controllers
			require(["js/ui/modules", "js/ui/Controller"], function() {
                setTimeout(function() {
                    $("#container").removeClass("onzichtbaar");
                    $("#wait").addClass("onzichtbaar");
                }, 200);
            });
		});
	});
});