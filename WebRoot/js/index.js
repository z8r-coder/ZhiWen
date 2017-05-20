$(function() {

	$('#search_button').button({
		icons: {
			primary: 'ui-icon-search',
		}
	});
	$('#question_button').button({
		icons: {
			primary: 'ui-icon-lightbulb',
		}
	}).click(function(){
		if($.cookie('user')){
			$('#question').dialog('open');
		}else{
			$('#error').dialog('open');
			setTimeout(function(){
				$('#error').dialog('close');
				$('#login').dialog('open');
			}, 500);
		}
	});
	//时间戳格式化
	var dateFormat = function (time) {
		//yy-mm-dd hh-mm-ss 格式
		var jsonDate = eval(time);
		var date = new Date(parseInt(time.date.time)).toLocaleString().replace(/:\d{1,2}$/,' ');
		return date.toString();
	}
	$.ajax({
		url : 'question!show.action',
		type : 'POST',
		success : function(response, status, xhr) {
			var json = $.parseJSON(response);
			var html = '';
			var arr = [];
			var summary = [];
			$.each(json, function(index, value){
				var jsonDate = eval(value);
				html += '<h4>'+ value.user +' 发表于 ' + dateFormat(value) + '</h4>'
				 + '<h3>' + value.title +'</h3>'
				 + 	'<div class="editor">' + value.content + '</div>'
				 + '<div class="bottom">0条评论 '
				 + '<span class="up">收起</span></div>'
				 + '<hr noshade="noshade" size="1"/>';
			});
			$('.content').append(html);
			
			$.each($('.editor'), function(index, value){
				arr[index] = $(value).html();
				summary[index] = arr[index].substr(0,200);
				
				if (summary[index].substring(199,200) == '<') {
					summary[index] = replacePos(summary[index], 200, '');
				}
				if(summary[index].substring(198,200) == '</'){
					summary[index] = replacePos(summary[index], 200, '');
					summary[index] = replacePos(summary[index], 199, '');
				}
				
				if(arr[index].length > 200){
					summary[index] = summary[index] + '...<span class="down">显示全部</span>';
					$(value).html(summary[index]);
				}
				$('.bottom .up').hide();
			});
			
			//由父节点委托绑定
			$.each($('.editor'), function(index, value){
				$(this).on('click', '.down', function (){
					$('.editor').eq(index).html(arr[index]);
					$(this).hide();
					$('.bottom .up').eq(index).show();
				});
			});
			
			$.each($('.bottom'), function(index, value){
				$(this).on('click', '.up',function(){
					$('.editor').eq(index).html(summary[index]);
					$(this).hide();
					$('.editor .down').eq(index).show();
				});
			});
			/*
			$.each($('.editor'), function(index, value){
				arr[index] = $(value).height();
				if($(value).height() > 155) {
					$(value).next('.bottom').find('.up').hide();
				}
				$(value).height(155);
			});
			$.each($('.bottom .down'), function(index, value){
				$(this).click(function(){
					$(this).parent().prev().height(arr[index]);
					$(this).hide();
					$(this).parent().find('.up').show();
				});
			});
			$.each($('.bottom .up'), function(index, value){
				$(this).click(function(){
					$(this).parent().prev().height(155);
					$(this).hide();
					$(this).parent().find('.down').show();
				});
			});
			*/
		},
	});
	
	$('#question').dialog({
		autoOpen: false,
		modal: true,
		width: 500,
		height: 380,
		resizable: false,
		buttons: {
			'发布': function() {
				$(this).ajaxSubmit({
					url : 'question!add.action',
					type : 'post',
					data : {
						'question.userAccount' : $.cookie('user'),
						'question.content' : $('.uEditorIframe').contents().find('#iframeBody').html(),
					},
					beforeSubmit : function(formData, jqForm, options){
						$('#loading').dialog('open');
						$('#question').dialog('widget').find('button').eq(1).button('disable');
					},
					success : function(responseText, statusText){
						if(responseText) {
							$('#question').dialog('widget').find('button').eq(1).button('enable');
							$('#loading').css('background', 'url(img/success.gif) no-repeat 20px center').html('登录成功');
							$('.uEditorIframe').contents().find('#iframeBody').html("请输入问题描述！")
							setTimeout(function(){
								$('#loading').dialog('close');
								$('#question').dialog('close');
								$('#question').resetForm();
								$('#loading').css('background', 'url(img/loading.gif) no-repeat 20px center').html('登录中...');
							}, 1000);
						}
					},
				});
			}
		}
	});
	
	$('.uEditorCustom').uEditor();
	
	$('#logout').click(function(){
		$.removeCookie('user');
		window.location.href = '/S2S4H4'
	});
	
	$('#error').dialog({
		autoOpen : false,
		modal : true,
		closeOnEscape : false,
		resizable : false,
		draggable : false,
		width : 200,
		height : 50,
	}).parent().find('.ui-widget-header').hide();
	
	$('#member, #logout').hide();
	if($.cookie('user')){
		$('#member, #logout').show();
		$('#member').html($.cookie('user'));
		$('#reg_a, #login_a').hide();
	}else {
		$('#member, #logout').hide();
		$('#reg_a, #login_a').show();
	}
	
	$('#reg_a').click(function() {
		$('#reg').dialog('open');
	});
	$('#login_a').click(function() {
		$('#login').dialog('open');
	});
	$('#loading').dialog({
		autoOpen : false,
		modal : true,
		closeOnEscape : false,
		resizable : false,
		draggable : false,
		width : 180,
		height : 50,
	}).parent().find('.ui-widget-header').hide();
	$('#login').dialog({
		autoOpen: false,
		modal: true,
		width: 320,
		height: 260,
		resizable: false,
		buttons: {
			'登录': function() {
				
				$(this).submit();
			}
		}
	}).validate({
		submitHandler: function(form) {
			$(form).ajaxSubmit({
				beforeSubmit : function(formData, jqForm, options){
					$('#loading').dialog('open');
					$('#login').dialog('widget').find('button').eq(1).button('disable');
				},
				success : function(responseText, statusText){
					if(responseText) {
						$('#login').dialog('widget').find('button').eq(1).button('enable');
						$('#loading').css('background', 'url(img/success.gif) no-repeat 20px center').html('登录成功');
						
						if($('#expires').is(':checked')){
							$.cookie('user',$('#user_login').val(), {
								expires : 7,
							});
						}else {
							$.cookie('user',$('#user_login').val());
						}
						
						setTimeout(function(){
							$('#loading').dialog('close');
							$('#login').dialog('close');
							$('#login').resetForm();
							$('#login span.star').html('*').removeClass('succ');
							$('#loading').css('background', 'url(img/loading.gif) no-repeat 20px center').html('登录中...');
							$('#member, #logout').show();
							$('#member').html($.cookie('user'));
							$('#reg_a, #login_a').hide();
						}, 1000);
					}
				},
			});
		},
		showErrors: function(errorMap, errorList) {
			var errors = this.numberOfInvalids();

			if(errors > 0) {
				$('#login').dialog('option', 'height', errors * 20 + 260);
			} else {
				$('#login').dialog('option', 'height', 260);
			}

			this.defaultShowErrors();
		},

		highlight: function(element, errorClass) {
			$(element).css('border', '1px solid #630');
			$(element).parent().find('span').html('*').removeClass('succ');
		},

		unhighlight: function(element, errorClass) {
			$(element).css('border', '1px solid #ccc');
			$(element).parent().find('span').html('&nbsp').addClass('succ');
		},
		errorLabelContainer: 'ol.reg_error',
		wrapper: 'li',

		rules: {
			'user.userAccount': {
				required: true,
				minlength: 2,
			},
			'user.userPassword': {
				required: true,
				minlength: 6,
				remote : {
					url : 'ajaxcheckAction!checkPassWord.action',
					type : 'POST',
					data : {
						'user.userAccount' : function(){
							return $('#user_login').val();
						},
					},
				},
			},
		},
		messages: {
			'user.userAccount': {
				required: '账号不得为空!',
				minlength: '账号不得小于2位',
			},
			'user.userPassword': {
				required: '密码不得为空!',
				minlength: '密码不得小于6位',
				remote : '账号或密码错误',
			},
		}
	});
	
	$('#reg').dialog({
		autoOpen: false,
		modal: true,
		width: 320,
		height: 340,
		resizable: false,
		buttons: {
			'提交': function() {
				$(this).submit();
			}
		}
	}).buttonset().validate({
		submitHandler: function(form) {
			$(form).ajaxSubmit({
				url : 'user!add.action',
				type : 'post',
				beforeSubmit : function(formData, jqForm, options){
					$('#loading').dialog('open');
					$('#reg').dialog('widget').find('button').eq(1).button('disable');
				},
				success : function(responseText, statusText){
					if(responseText) {
						$('#reg').dialog('widget').find('button').eq(1).button('enable');
						$('#loading').css('background', 'url(img/success.gif) no-repeat 20px center').html('数据新增成功');
						$.cookie('user',$('#user').val());
						setTimeout(function(){
							$('#loading').dialog('close');
							$('#reg').dialog('close');
							$('#reg').resetForm();
							$('#reg span.star').html('*').removeClass('succ');
							$('#loading').css('background', 'url(img/loading.gif) no-repeat 20px center').html('数据交互中...');
							$('#member, #logout').show();
							$('#member').html($.cookie('user'));
							$('#reg_a, #login_a').hide();
						}, 1000);
					}
				},
			});
		},
		showErrors: function(errorMap, errorList) {
			var errors = this.numberOfInvalids();

			if(errors > 0) {
				$('#reg').dialog('option', 'height', errors * 20 + 340);
			} else {
				$('#reg').dialog('option', 'height', 340);
			}

			this.defaultShowErrors();
		},

		highlight: function(element, errorClass) {
			$(element).css('border', '1px solid #630');
			$(element).parent().find('span').html('*').removeClass('succ');
		},

		unhighlight: function(element, errorClass) {
			$(element).css('border', '1px solid #ccc');
			$(element).parent().find('span').html('&nbsp').addClass('succ');
		},

		errorLabelContainer: 'ol.reg_error',
		wrapper: 'li',
		
		rules: {
			//这个地方是name属性
			'user.userAccount': {
				required: true,
				minlength: 2,
				remote : {
					url : 'ajaxcheckAction!ajaxCheck.action',
					type : 'POST',
				},
			},
			'user.userPassword': {
				required: true,
				minlength: 6,
			},
			'user.userEmail': {
				required: true,
				email: 6,
			},
			'user.userBirthday': {
				date: true,
			},
		},
		messages: {
			'user.userAccount': {
				required: '账号不得为空!',
				minlength: '账号不得小于2位',
				remote : '账号被占用',
			},
			'user.userPassword': {
				required: '密码不得为空!',
				minlength: '密码不得小于6位',
			},
			'user.userEmail': {
				required: '邮箱不得为空!',
				minlength: '请输入正确的邮箱',
			},
		}
	});

	$('#reg').buttonset();
	$('#date').datepicker({
		dateFormat: 'yy-mm-dd',
		dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
		monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
		altField: '#abc',
		altFormat: 'dd/mm/yy',
		appendText: '日历',
		showWeek: true,
		weekHeader: '周',
		firstDay: 1,
		showOtherMonths: true,
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		nextText: '下个月',
		prevText: '上个月',
		maxDate: 0,
	});
	
	var host = ['aa', 'aaaa', 'aaaaaa', 'bb'];
	$('#email').autocomplete({
		delay: 0,
		autoFocus: true,
		source: function(request, response) {
			var hosts = ['qq.com', '163.com', '263.com', 'gmail.com', 'sina.com.cn', 'hotmail.com'],
				term = request.term, //获取用户输入内容
				name = term, //邮箱用户名
				host = '', //邮箱的域名
				ix = term.indexOf('@'), //@的位置
				result = [];

			result.push(term);
			if(ix > -1) {
				name = term.slice(0, ix); //@前面的
				host = term.slice(ix + 1); //@后面的
			}

			if(name) {
				//如果用户已经输入@和后面的域名，
				//那么就找到相关的域名提示，比如bnbbs@1,就提示bnbbs@163.com
				//如果用户还没有输入@或后面的域名，
				//那么就把所有的域名都提示出来
				var findedHosts = (host ? $.grep(hosts, function(value, index) {
						return value.indexOf(host) > -1;
					}) : hosts),
					findedResult = $.map(findedHosts, function(value, index) {
						return name + '@' + value;
					});

				result = result.concat(findedResult);
			}

			response(result);
		},
	});
	$('#tabs').tabs({
		active: 0,
	});

	$('#accordion').accordion();
	
});
//替换特殊字符
function replace(strObj,pos,replaceText){
	return strObj.subStr(0, pos - 1) + replaceText + strObj.substring(pos, strObj.length);
}



