jQuery(document).ready(function() {
    
   "use strict";

   $('#deleteClientAlert').hide();
   $('#updateClientForm').hide();
  
   jQuery('#toggleDeleteClient').click(function(){
      $('#deleteClientAlert').show();
      $('#updateClientForm').hide();
   });
   jQuery('#toggleBackDeleteClient').click(function(){
      $('#deleteClientAlert').hide();
   });

   jQuery('#toggleUpdateClient').click(function(){
      $('#updateClientForm').show();
      $('#deleteClientAlert').hide();
   });
   jQuery('#toggleBackUpdateClient').click(function(){
      $('#updateClientForm').hide();
   });

   $("form[name='addStylist']").validate({
      // Specify validation rules
      rules: {
         // The key name on the left side is the name attribute
         // of an input field. Validation rules are defined
         // on the right side
         stylistFirstName: "required",
         stylistLastName: "required",
         stylistAge: {
            required: true,
            number: true
         },
         stylistPhone: "required",
         stylistDept: "required"
      },
      // Specify validation error messages
      messages: {
         stylistFirstName: "Please update stylist's first name.",
         stylistLastName: "Please update stylist's last name.",
         stylistAge: {
            required: "Please update stylist's age.",
            number: "Please Enter a Valid Number."
         },
         stylistPhone: "Please update stylist's phone number.",
         stylistDept: "Please update stylist's departmant."
      },
      // Make sure the form is submitted to the destination defined
      // in the "action" attribute of the form when valid
      submitHandler: function(form) {
      form.submit();
    }
  });


});