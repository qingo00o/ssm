/*bootStrap的notify提示框*/
function notifyMsg(msg){
       var notify =  $.notify({
            // options
            icon: 'glyphicon  glyphicon-ok-sign',
            title: '提示：',
            message: msg,
            target: '_blank'
        },{
            // settings
            element: 'body',
            position: null,
            type: "info",
            allow_dismiss: true,
            newest_on_top: true,
            showProgressbar: false,
            placement: {
                from: "top",
                align: "center"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 2000,
            timer: 1000,
            url_target: '_blank'
        });

       return notify;
    }