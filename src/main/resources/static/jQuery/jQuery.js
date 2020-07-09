$(document).ready(function(){
    $('#yearPicker').datepicker({
        changeMonth: false,
        changeYear: true,
        showButtonPanel: true,
        yearRange: '2005:2020', // Optional Year Range
        dateFormat: 'yy',
        });
});