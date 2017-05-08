$(function() {

	$('#search_button').button({
		icons: {
			primary: 'ui-icon-search',
		}
	});
	
	$('#logout').click(function(){
		$.removeCookie('user');
		window.location.href = '/S2S4H4'
	});
	
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
	}).parent().parent().find('.ui-widget-header').hide();
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
		},

		unhighlight: function(element, errorClass) {
			$(element).css('border', '1px solid #ccc');
			$(element).parent().find('span').html('&nbsp').addClass('succ');
		},
		errorLabelContainer: 'ol.reg_error',
		wrapper: 'li',

		rules: {
			user: {
				required: true,
				minlength: 2,
			},
			pass: {
				required: true,
				minlength: 6,
			},
		},
		messages: {
			user: {
				required: '账号不得为空!',
				minlength: '账号不得小于2位',
			},
			pass: {
				required: '密码不得为空!',
				minlength: '账号不得小于6位',
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
			user: {
				required: true,
				minlength: 2,
			},
			pass: {
				required: true,
				minlength: 6,
			},
			email: {
				required: true,
				email: 6,
			},
			date: {
				date: true,
			},
		},
		messages: {
			user: {
				required: '账号不得为空!',
				minlength: '账号不得小于2位',
			},
			pass: {
				required: '密码不得为空!',
				minlength: '账号不得小于6位',
			},
			email: {
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
});