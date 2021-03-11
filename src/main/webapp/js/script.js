/**
 * 
 */

 hideAndShowForm = function(formName) {
    var form = document.getElementById(formName);
    if (form.style.display === "none") {
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
  }