$(document).ready(function(){
    $('.nBtn').on('click',function(event){
         event.preventDefault();
         var today = new Date();
         var day = today.getDate();
         var month = today.getMonth()+1;
         var year = today.getFullYear();

         if(day < 10) {
             day = '0'+day;
         }

         if(month < 10) {
             month = '0'+month;
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
        hrefDelete=$(this).attr('href');
        $('#myModal #delRef').attr('href',hrefDelete);
        $('#myModal').modal();
    });

     $(".delNote").click(function(){
                event.preventDefault();
                console.log(hrefDelete);
                var id='';
                for(var i=7;i<hrefDelete.length;i++){
                    id+=hrefDelete[i];
                }
                $.ajax({
                    url: hrefDelete,//'delete/'+id,
                    type: "DELETE",
                    cache: false,
                    async:false,
                    success: function(data){
                        $('#myModal').modal('hide');
                        var myRow=$('#tableNote').find('tbody').find('tr');
                        for (var i = 0; i < myRow.length; i++) {
                            if($(myRow[i]).find('td:eq(0)').html()==id){
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
                        alert('Delete Success');
                    },
                    error : function(e) {
                        alert('Delete Error');
                    }
                });
            })

    $("body").on("click", ".eBtn", function(){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href,function(note,status){
            $('.myForm #id').val(note.id);
            $('.myForm #title').val(note.title);
            $('.myForm #content').val(note.content);
            $('.myForm #date').val(note.date);
        });
        $('.myForm #exampleModal').modal();
    });
});
//    function getAllNotes() {
//        console.log('a')
//        $.ajax({
//            url: "notes",
//            method: "GET",
//            dataType: "json",
//            success: function (data) {
//                console.log(data);
//                var tableBody = $('#tableNote tbody');
//                tableBody.empty();
//                $(data).each(function (index, note) {
//                    tableBody.append('<tr><td>'+note.id+'</td><td>'+note.title+'</td><td>'+note.content+'</td><td>'+note.date+'</td><td>'+note.createdAt+'</td><td>'+note.updatedAt+'</td><td><a href=\"delete/' + note.id + '\" class=\"btn btn-danger delBtn\" >Delete</a></td><td><a href=\"findOne/' + note.id + '\" class=\"btn btn-primary eBtn\" >Edit</a></tr>');
//                })
//            },
//            error: function (error) {
//                alert('error');
//            }
//        })
//    }