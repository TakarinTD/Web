$(document).ready(
		function() {
			$("#noteUserForm").submit(function(event) {
				event.preventDefault();
				update();
			});
			function update() {

				var formData = {
				    id: $("#id").val(),
					roleName: $("#role").val(),
					status: $("#active").val()
				}
                console.log(formData);
				$.ajax({
					type : "POST",
					url : "/editUser",
					data : JSON.stringify(formData),
					contentType:"application/json",
					dataType : "json",
					success : function(result) {
					    $('#exampleUserModal').modal('hide');
					    var myRow=$('#tableUser').find('tbody').find('tr');
					    for (var i = 0; i < myRow.length; i++) {
					        if($(myRow[i]).find('td:eq(0)').html() == result.id){
                                $(myRow[i]).find('td:eq(3)').html(result.status);
                                $(myRow[i]).find('td:eq(4)').html(result.roleName);
                                break;
                            }
					    }
					    console.log(result);
					    var stt;
					    if(result.status==1) {
					        stt="Active";
					    }
					    else stt="Stop active"
						document.getElementById("uName").innerHTML = "- User name \"" + result.userName + "\" have become an \"" + result.roleName + "\"";
                        document.getElementById("uActive").innerHTML = "- Status: " + stt;
                        $('#editUserSuccess').modal();
					},
					error : function(e) {
						 $('#errorUserEdit').modal();
						 console.log(e);
					}
				});
			}
		});