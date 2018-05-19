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
});