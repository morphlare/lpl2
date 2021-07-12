$(function(){
	var oldPassword = $("#oldPassword");
	var newPassword = $("#newPassword");
	var renewPassword = $("#renewPassword");
	var mg1 = $("#mg1");
	var mg2 = $("#mg2");
	var mg3 = $("#mg3");
	var saveBtn = $("#save");

	oldPassword.blur(function(){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/lpl2/player/pwdModify",
			data:{oldPassword:oldPassword.val()},
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			dataType:"json",
			success:function(data){
				if(data.result == "true"){//旧密码正确
					mg1.css("color","green");
					mg1.html("密码输入正确");
				}else if(data.result == "false"){//旧密码输入不正确
					mg1.css("color","red");
					mg1.html("密码输入错误");
				}else if(data.result == "sessionerror"){//当前用户session过期，请重新登录
					mg1.css("color","red");
					mg1.html("当前用户session过期，请重新登录");
				}else if(data.result == "error"){//旧密码输入为空
					mg1.css("color","blue");
					mg1.html("请输入旧密码");
				}
			},
			error:function(data){
				//请求出错
				mg1.css("color","red");
				mg1.html("请求错误");
			}
		});
	});

	newPassword.focus(function (){
		mg2.css("color","blue");
		mg2.html("密码长度必须大于5位且小于20位");
	});

	newPassword.blur(function (){
		if(newPassword.val() != null && newPassword.val().length >= 6 && newPassword.val().length < 20){
			mg2.css("color","green");
			mg2.html("新密码符合要求");
		}else {
			mg2.css("color","red");
			mg2.html("新密码不符合要求，请重新输入");
		}
	});

	renewPassword.focus(function (){
		mg3.css("color","blue");
		mg3.html("请重新输入新密码");
	});

	renewPassword.blur(function (){
		if (renewPassword.val() != null && renewPassword.val().length >= 6
			&& renewPassword.val().length < 20 && renewPassword.val() == newPassword.val()){
			mg3.css("color","green");
			mg3.html("已确认新密码");
		}else {
			mg3.css("color","red");
			mg3.html("密码输入不正确，请重新输入");
		}
	});

	saveBtn.click(function () {
		oldPassword.blur();
		newPassword.blur();
		renewPassword.blur();

		if (mg1.css("color") == "rgb(0, 128, 0)" && mg2.css("color") == "rgb(0, 128, 0)" && mg3.css("color") == "rgb(0, 128, 0)"){
			if(confirm("确定要修改密码？")){
				$("#pwdForm").submit();
			}
		}
	});
});