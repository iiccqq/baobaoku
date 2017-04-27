jQuery.ready(function(){
	
					jQuery.ajax({	
								url : "../../health/lababa/list",
								data : {start : 0,count : 100,babyid:1,record_time:vm.record_time},
								success : function(r) {
												vm.lababaList = r.list;
											},
								dataType:'json'
						});
});



Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
var vm = new Vue({
		el : '#app',
		data : {
			record_time:new Date().Format("yyyy-MM-dd"),
			lababaList : [],
			dicList :[],
			count:1,
			status:1,
			showLababaList:true,
			showLababaForm:false
		},
		methods : {
			showList:function(){
				mui('#Popover_0').popover('hide');
					jQuery.ajax({	
								url : "../../health/lababa/list",
								data : {start : 0,count : 100,babyid:1,record_time:vm.record_time},
								success : function(r) {
												vm.lababaList = r.list;
											},
								dataType:'json'
						});
					vm.showLababaForm = false;
					vm.showLababaList = true;
			},			
			showForm:function(){
				mui('#Popover_0').popover('hide');
				vm.showLababaForm = true;
				vm.showLababaList = false;
			},
			addCount : function(){
				vm.count ++;
			},
			reduceCount : function(){
				vm.count --;
			},
			setStatus :  function(dic) {
				vm.status = dic.value;
				var s = dic.value;
				if(s==1||s==2)
					vm.count=1;
				else
					vm.count=0;
				
			},
			updateStatus : function() {
				vm.showLababaForm = false;
				vm.showLababaList = true;
				jQuery.ajax({	
					url : "../../health/lababa/1",
					data : {start : 0,count : 100,status :vm.status,count: vm.count,record_time:vm.record_time},
					success : function(r) {
									vm.lababaList = r.list;
									
						jQuery.ajax({	
								url : "../../health/lababa/list",
								data : {start : 0,count : 100,babyid:1,record_time:vm.record_time},
								success : function(r) {
												vm.lababaList = r.list;
											},
								dataType:'json'
						});
								},
					dataType:'json'
					});
				
				

		
			},
			openStatis : function() {
				var webview = mui.openWindow({
				    url:'static.html',
				    extras:{
				        name:'mui'  //扩展参数
				    }
				});
			}
		}
	});


	vm.dicList = [{value:1,text:'拉了（没透）',checked:true},{value:2,text:'拉了（透了）',checked:false},{value:3,text:'没拉（没透）',checked:false},{value:4,text:'没拉（透了）',checked:false}];

	


jQuery.ajax({	
								url : "../../health/lababa/list",
								data : {start : 0,count : 100,babyid:1,record_time:vm.record_time},
								success : function(r) {
												vm.lababaList = r.list;
											},
								dataType:'json'
						});