const test = {
    save: function() {
        const data = {
            userId: 'admin',
            userPwd: '1111',
            userName: '시스템관리자',
            userAuth: 'S'
        };

        $.ajax({
            type: 'POST',
            url: '/api/userinfo/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (r) {
            console.log(r);
            alert('등록되었습니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function() {
        const data = {
            userId: 'admin',
            userPwd: '1111',
            userName: '시스템관리자',
            userAuth: 'Z'
        };

        $.ajax({
            type: 'PUT',
            url: '/api/userinfo/update',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (r) {
            console.log(r);
            alert('등록되었습니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}
