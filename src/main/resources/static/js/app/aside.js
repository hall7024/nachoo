var aside = {
    init: function() {
        var _this = this;

        var menuUrl = $("#asideForm #menu_url").val();
        if (menuUrl) {
            $("#kt_aside a.menu-link[menu-url='" + menuUrl + "']").addClass('active');
        }

        $('#kt_aside a.menu-link').on('click', function() {
            _this.go_menu($(this).attr('menu-url'));
        });
    },
    go_menu: function(url) {
        $("#asideForm").attr('action', url).submit();
    }
}

aside.init();