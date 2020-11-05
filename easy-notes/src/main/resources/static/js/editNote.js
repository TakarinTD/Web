$(document).ready(
		function() {
			$("#noteForm").submit(function(event) {
				event.preventDefault();
				action = $(this).attr('action');
				update();
			});
			function update() {

				var formData = {
				    id: $("#id").val(),
					title : $("#title").val(),
					content : $("#content").val(),
					date : $("#date").val()
				}
                console.log(formData);
				$.ajax({
					type : "POST",
					url : action,
					data : JSON.stringify(formData),
					contentType:"application/json",
					dataType : "json",
					success : function(result) {
					    $('#exampleModal').modal('hide');
					    var myRow=$('#tableNote').find('tbody').find('tr');
					    var updated = new Date(result.updatedAt);
                        var day = updated.getDate();
                        var month = updated.getMonth()+1;
                        var year = updated.getFullYear();
                        var hour = updated.getHours();
                        var minute = updated.getMinutes();
                        var second = updated.getSeconds();
                        if(day < 10) {
                            day = '0' + day;
                        }
                        if(month < 10) {
                            month = '0' + month;
                        }
                        if(hour < 10) {
                            hour = '0' + hour;
                        }
                        if(minute < 10) {
                            minute = '0' + minute;
                        }
                        if(second < 10) {
                            second = '0' + second;
                        }
                        updated = year + '-' + month + '-' + day + ' ' + hour + ":" + minute + ":" + second + ".0";
					    for (var i = 0; i < myRow.length; i++) {
					        if($(myRow[i]).find('td:eq(0)').html() == result.id){
                                $(myRow[i]).find('td:eq(1)').html(result.title);
                                $(myRow[i]).find('td:eq(2)').html(result.content);
                                $(myRow[i]).find('td:eq(3)').html(result.date);
                                $(myRow[i]).find('td:eq(5)').html(updated);
                                break;
                            }
					    }
						document.getElementById("titleE").innerHTML = "- Title: " + result.title;
                        document.getElementById("contentE").innerHTML = "- Content: " + result.content;
                        document.getElementById("dateE").innerHTML = "- Date: " + result.date;
                        $('#editSuccess').modal();
					},
					error : function(e) {
						 $('#errorEdit').modal();
					}
				});
			}
		});