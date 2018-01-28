$(document).ready(function() {
    $('#editPrice').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('productname'); // Extract info from data-* attributes
        var prodid = button.data('id'); // Extract info from data-* attributes
        var price1 = button.data('pi'); // Extract info from data-* attributes
        var price2 = button.data('pii'); // Extract info from data-* attributes
        var price3 = button.data('piii'); // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
        modal.find('.modal-title').text('Введіть ціни для ' + recipient);
        modal.find('#id').val(prodid);
        modal.find('#priceinput1').val(price1);
        modal.find('#priceinput2').val(price2);
        modal.find('#priceinput3').val(price3);
    })
//    $("#submit1").click(function(e) {
//            alert("Form Submitted Successfully......");
//        }
//    )


    $('#submit').on('click', function (e) {
        e.preventDefault();
//            alert( "Handler for .submit() called." );
        $.ajax({
            type: 'get',
            url: 'addprices',
            data: 'id=' + $('#id').val() + '\u0026' + 'p1=' + $('#priceinput1').val() + '\u0026' + 'p2=' + $('#priceinput2').val() + '\u0026' + 'p3=' + $('#priceinput3').val() + '',
            success: function () {
//                    alert('id='+$('#id').val()+';p2='+$('#priceinput2').val()+';p1='+$('#priceinput2').val()+';p3='+$('#priceinput3').val());
//                    alert($('#myForm').serialize());
//                    $('#mainTable').find('#')
//                    $('#pi').data('pi', '245');
//                    $('#editPrice').data( 'pi', 15 );
//                    form.attr("pi").data(25);

                $('#editPrice').modal('hide');
            }
        });
//            $('#editPrice').modal('hide');

//            $( "#myForm" ).submit();
        $('#editPrice').modal('hide');

    });

});
    //    });

