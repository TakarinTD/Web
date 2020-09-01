$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click',function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
        if(text=='Edit'){
            $.get(href,function(note,status){
                $('.myForm #id').val(note.id);
                $('.myForm #title').val(note.title);
                $('.myForm #content').val(note.content);

            });

            $('.myForm #exampleModal').modal();
        }else{
            $('.myForm #id').val('');
            $('.myForm #title').val('');
            $('.myForm #content').val('');
            $('.myForm #exampleModal').modal();
        }
    });

    $('.table .delBtn').on('click',function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $('#myModal #delRef').attr('href',href);
        $('#myModal').modal();
    });
});