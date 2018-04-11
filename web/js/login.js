/*
  Jquery Validation using jqBootstrapValidation
   example is taken from jqBootstrapValidation docs 
  */
$(function() {

    $("#LoginForm input").jqBootstrapValidation({
        preventSubmit: true,
        submitError: function($form, event, errors) {
            // something to have when submit produces an error ?
            // Not decided if I need it yet
        },
        submitSuccess: function($form, event) {
            event.preventDefault(); // prevent default submit behaviour
            // get values from FORM
            var password = $("input#passwd").val();
			
            
            $.ajax({
                url: "login.php",
                type: "POST",
                data: {
					password: password
                },
                cache: false,
                success: function() {
                    // Success message
                    /*$('#success').html("<div class='alert alert-success'>");
                    $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                        .append("</button>");
                    $('#success > .alert-success')
                        .append("<strong>Your message has been sent. </strong>");
                    $('#success > .alert-success')
                        .append('</div>');*/
					url = 'document/presentationSlide/ppt/Silverlake-Mobility-MLEB-FinTech-Overview-v2.1-20102016.pptx'
					window.open(url);

                    //clear all fields
                    $('#LoginForm').trigger("reset");
					

                },
                error: function() {
                    // Fail message
                    $('#success').html("Fail to login");
                    //clear all fields
                    $('#LoginForm').trigger("reset");
                },
            })
        },
        filter: function() {
            return $(this).is(":visible");
        },
    });

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });
});


/*When clicking on Full hide fail/success boxes */
/*$('#firstname').focus(function() {
    $('#success').html('');
});*/
