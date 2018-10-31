<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<style type="text/css">
	#insertForm>div{
		margin-bottom: 10px;
	}
	.table td,.table th{
		text-align: center;
	}
</style>
<%@ include file="../commonJsp/common.jsp" %>
</head>
<body>
		<%@ include file="../commonJsp/util.jsp" %>
		<div class="container-fluid" style="width: 800px;margin-top: 50px;">
			 <div class="tool" style="text-align: center;margin-bottom: 15px;">
				<div class="row">
						<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#insertUser"  onclick="changeUrl(1)">增加用户</button>
				</div>
			</div>
			<!-- 用户列表开始 -->
			<table class="table table-bordered table-hover">
				<thead>
		            <tr>
		                <th>id</th>
		                <th>用户名</th>
		                <th>密码</th>
		                <th>年龄</th>
		                <th>操作</th>
		            </tr>
		        </thead>
				<tbody>
					<c:forEach items="${userList }"  var="user">
							<tr >
								<td>${user.id}</td>
								<td>${user.userName}</td>
								<td>${user.password}</td>
								<td>${user.age}</td>
								<td>
										<button class="btn btn-info  btn-sm" data-toggle="modal" data-target="#insertUser"  onclick="updateUser(${user.id})">编辑用户</button>
										<%-- <button class="btn btn-danger  btn-sm"  onclick="deleteUser(${user.id})">删除用户</button> --%>
										<button class="btn btn-danger  btn-sm"  data-toggle="modal" data-target="#delcfmModel"      onclick="delReady(${user.id})">删除用户</button>
								</td>
							</tr>
					</c:forEach>
					
				</tbody>
			</table>
			<!-- 用户列表结束 -->
			
			<!-- 增加编辑用户模态框（Modal）开始 -->
		<div class="modal fade" id="insertUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
		            </div>
		            <div class="modal-body  contentBody">
		            		<form action=""  id="insertForm">
		            				<input type="hidden" name="id" id="id" />
		            				<div class="row"><div class="col-md-2 col-md-offset-3">用户名：</div><div class="col-md-5"><input type="text" id="userName" name="userName" /></div></div>
		            				<div class="row"><div class="col-md-2 col-md-offset-3" >密码：</div><div class="col-md-5"><input type="password" id="password" name="password"/></div></div>
		            				<div class="row"><div class="col-md-2 col-md-offset-3">年龄：</div><div class="col-md-5"><input type="text" id="age" name="age" /></div></div>
		            		</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary"  id="submit">提交</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!-- 增加编辑用户模态框（Modal）结束 -->
		
		</div>

</body>
<script type="text/javascript">
		var myUrl;
		/* 根据用户点击添加或者编辑改变URL */
		function changeUrl(flag){
				if (flag) {
					$("#id").removeAttr("name");
					myUrl="/ssm/user/insertUser";
				}else{
					myUrl="/ssm/user/updateUser";
					}
			}

		function delReady(id){
			$("#delId").val(id);
			}
		/* 删除用户的ajax请求方法 */
		function deleteUser(){
			var delUserId=$("#delId").val();
			$.ajax({
				type:"post",
				url:'/ssm/user/deleteUser',
				data:{
					'id':delUserId
					},
				dataType:'html',
				success:function(data){
					console.log("success");
					notifyMsg(data);
                }

			});
		}
		/* 更新用户前获取用户信息的方法 */
		function updateUser(id){
			changeUrl(0);
			$.ajax({
				type:"post",
				url:'/ssm/user/getUser',
				data:{
					'id':id
					},
				dataType:'json',
				success:function(data){
					$("#id").val(data.id);
					$("#userName").val(data.userName);
					$("#password").val(data.password);
					$("#age").val(data.age);
                }

			});
		}
		/* 模态框关闭后重置表单 */
		$('#insertUser').on('hidden.bs.modal', function (){
			document.getElementById("insertForm").reset();
		});
				
		
		$(function(){
			/* 模态框点击提交进行请求 */
			$("#submit").click(function(){
				$('#insertUser').modal('hide');
					$.ajax({
						type:"post",
						url:myUrl,
						data:$("#insertForm").serialize(),
						dataType:'html',
						success:function(data){
							console.log("success");
							
							notifyMsg(data);
		                }

					});
			});
		});
</script>
</html>