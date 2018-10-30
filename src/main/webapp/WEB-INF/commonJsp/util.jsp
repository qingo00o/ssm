<%@page pageEncoding="UTF-8"%>
		<div class="modal fade" id="delcfmModel">
		  <div class="modal-dialog">
		    <div class="modal-content message_align">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
		        <h4 class="modal-title">提示框</h4>
		      </div>
		      <div class="modal-body">
		        <p>您确认要删除吗？</p>
		      </div>
		      <div class="modal-footer">
		      <input type="hidden"  id="delId" />
		      	 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		      	 <a  onclick="deleteUser()" class="btn btn-success" data-dismiss="modal">确认</a>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

