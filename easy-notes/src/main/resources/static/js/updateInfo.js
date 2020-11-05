$(document).ready(
		function() {
			$("#userInfoForm").submit(function(event) {
				event.preventDefault();
				update();
			});
			console.log("a");
			function update() {

				var formData = {
				    id: ${"#id"}.val()
				    fullName: $("#fullName").val()
				}
                console.log(formData);
				$.ajax({
					type : "POST",
					url : "/editInfo",
					data : JSON.stringify(formData),
					contentType:"application/json",
					dataType : "json",
					success : function(result) {
					    $('#exampleInfoModal').modal('hide');
					    document.getElementById("s1").innerHTML = result.fullName;
                        //$('#editUserSuccess').modal();
                        alert("success");
					},
					error : function(e) {
						 alert("error")
						 console.log(e);
					}
				});
			}
		});