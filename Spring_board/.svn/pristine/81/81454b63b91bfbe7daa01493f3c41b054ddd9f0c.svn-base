/**
 * reply.js
 * 댓글 구현. 클로저를 이용한 모듈
 */
console.log("reply module");

var replyService = (function() { 
    function add(reply, callback, error){
        console.log("reply.add()");

        $.ajax({
            type : "post",
            url : "/replies/new",
            data : JSON.stringify(reply),
            contentType : "application/json; charset=urf-8",
            success : function(data){
                if(callback)
                callback(data);
            },
            error : function(xhr, stat, er){
                if(error){
                    error(er);
                }
            }
        })
    }
    
    function getList(param, callback, error){
        console.log("reply.getList()");
        var bno = param.bno; // 고정값. 무조건 있어야함
        var amount = param.amount || 10;
        var lastRno = param.lastRno || 0;
        var url = '/replies/' + bno + "/" + amount + "/" + lastRno;

        $.getJSON(url, function(data){
            if(callback)
            callback(data);
        });
        // $.ajax(url, { 위와 같은 코드로도 할 수 있음.
        //     // type : 'get', 기본이 get이기 때문에 없어도 됨
        //     dataType : 'json',
        //     // url : url, 위에 적었기 때문에 안써도 됨
        //     success : function(data){
        //         callback(data);
        //     }
        // })
    }

    function remove(rno, callback, error){
        console.log("reply.getList()");
        var url = '/replies/' + rno;

        $.ajax(url, {
            type : "delete"
        }).done(function(data){
            if(callback)
            callback(data);
            
        })
        // $.ajax(url, { 위랑 같은 코드
        //     type : "delete",
        //     success : function(data){
        //         callback(data);
        //     }
        // })
    }
    function modify(reply, callback, error){
        console.log("reply.modify()");
        var url = '/replies/' + reply.rno;

        $.ajax(url, {
            type : "put",
            url : "/replies/new",
            data : JSON.stringify(reply),
            contentType : "application/json; charset=urf-8",
            success : function(data){
                if(callback)
                callback(data);
            }
        })
    }
    function get(rno, callback, error){
        console.log("reply.getList()");
        var url = '/replies/' + rno;
        $.getJSON(url, function(data){
            if(callback)
            callback(data);
        });
    }

    function displayTime(timeValue) {
        return moment().diff(moment(timeValue), 'days') < 1 ? moment(timeValue).format('HH:mm:ss') : moment(timeValue).format('YY/MM/DD');  
    }

    return{
        add:add,
        getList:getList,
        remove:remove,
        modify:modify,
        get:get,
        displayTime:displayTime
    }
})();