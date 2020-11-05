$(document).ready(function(){

    console.log(/*[[${notes}]]*/);

    $('.nBtn').on('click',function(event){
         event.preventDefault();
         var today = new Date();
         var day = today.getDate();
         var month = today.getMonth()+1;
         var year = today.getFullYear();

         if(day < 10) {
             day = '0' + day;
         }

         if(month < 10) {
             month = '0' + month;
         }
         today = year + '-' + month + '-' + day;
        $('.myNew #titleNew').val('');
        $('.myNew #contentNew').val('');
        $('.myNew #dateNew').val(today);
        $('.myNew #myNew').modal();
    });
    var hrefDelete;
    $("body").on("click", ".delBtn", function(){
        event.preventDefault();
        hrefDelete = $(this).attr('href');
        $('#myModal #delRef').attr('href',hrefDelete);
        $('#myModal').modal();
    });

     $(".delNote").click(function(){
                event.preventDefault();
                console.log(hrefDelete);
                var id = '';
                for(var i = 8; i < hrefDelete.length; i++){
                    id += hrefDelete[i];
                }
                $.ajax({
                    url: hrefDelete,//'delete/'+id,
                    type: "delete",
                    cache: false,
                    async:false,
                    success: function(data){
                        $('#myModal').modal('hide');

                        var myRow = $('#tableNote').find('tbody').find('tr');
                        for (var i = 0; i < myRow.length; i++) {
                            if($(myRow[i]).find('td:eq(0)').html() == id){
                                $(myRow[i]).find('td:eq(0)').html('');
                                $(myRow[i]).find('td:eq(1)').html('');
                                $(myRow[i]).find('td:eq(2)').html('');
                                $(myRow[i]).find('td:eq(3)').html('');
                                $(myRow[i]).find('td:eq(4)').html('DELETED!');
                                $(myRow[i]).find('td:eq(5)').html('');
                                $(myRow[i]).find('td:eq(6)').html('');
                                $(myRow[i]).find('td:eq(7)').html('');
                                break;
                            }
                        }
                        document.getElementById("idD").innerHTML = "Note " + id + " is deleted";
                        $('#deleteSuccess').modal();

                    },
                    error : function(e) {
                        $('#myModal').modal('hide');
                        $('#errorDelete').modal();
                    }
                });
            })

    $("body").on("click", ".eBtn", function(){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href,function(note,status){
            $('.myForm #id').val(note.id);
            $('.myForm #title').val(note.title);
            $('.myForm #content').val(note.content);
            $('.myForm #date').val(note.date);
        });
        $('.myForm #exampleModal').modal();
    });

    $("body").on("click", ".euBtn", function(){
        event.preventDefault();
        var href = $(this).attr('href');
        var status;
        console.log(href);
        $.get(href,function(user,status){
            $('.myUserForm #id').val(user.id);
            $('.myUserForm #role').val(user.roleName);
            if(user.status == 1) {
                status = "1";
            }
            else status = "0";
            $('.myUserForm #active').val(status);
        });
        $('.myUserForm #exampleUserModal').modal();
    });
    $("body").on("click", ".uiBtn", function(){
        event.preventDefault();
        var href = $(this).attr('href');
        var status;
        console.log(href);
        $.get(href,function(user,status){
            $('.infoForm #fullName').val(user.fullName);
            $('.infoForm #id').val(user.id);
        });
        $('.infoForm #exampleInfoModal').modal();
    });
});
