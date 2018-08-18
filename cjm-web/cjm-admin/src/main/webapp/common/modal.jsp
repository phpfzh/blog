<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- 查看详情模态框 -->
	<div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
		aria-labelledby="detailsModalLabel">
		<div id="detail-modal" class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="detailsModalLabel">
						<span class="glyphicon glyphicon-info-sign"></span>提示：正在进行查看详情操作
					</h4>
				</div>
				<div id="detail-modal-body" class="modal-body"></div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 设置模态框  -->
	<div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
		aria-labelledby="addModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="addModalLabel">
						<span class="glyphicon glyphicon-info-sign"></span>提示：正在进行设置操作
					</h4>

				</div>
				<div id="insert-modal-body" class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" id="btn-insert" class="btn btn-primary"
						onclick="insert()">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 编辑 模态框 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="editModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="editModalLabel">
						<span class="glyphicon glyphicon-info-sign"></span>提示：正在进行编辑操作
					</h4>
				</div>
				<div id="update-modal-body" class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" id="btn-update" class="btn btn-primary upbtn"
						onclick="update()">保存</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 删除  模态框  -->
	<div class="modal fade" id="delModal" tabindex="-1" role="dialog"
		aria-labelledby="delModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="delModalLabel">
						<span class="glyphicon glyphicon-info-sign"></span>提示：正在进行删除操作
					</h4>
				</div>
				<div id="del-modal-body" class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" id="del-btn" class="btn btn-danger" onclick="delById()">删除</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
		<!-- 查看收益详情模态框 -->
	<div class="modal fade" id="proDetailsModal" tabindex="-1" role="dialog"
		aria-labelledby="detailsModalLabel">
		<div id="detail-modal" class="modal-dialog" role="document" style="width:1300px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="detailsModalLabel">
						<span class="glyphicon glyphicon-info-sign"></span>提示：正在进行查看详情操作
					</h4>
				</div>
				<div id="proDetail-modal-body" class="modal-body"></div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>