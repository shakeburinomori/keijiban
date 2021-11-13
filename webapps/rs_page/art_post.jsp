<%@ page contentType="text/html; charset=UTF-8" %>
<%
String member_id = "";
Cookie[] cks = request.getCookies();
if(cks != null){
    for(int ck=0; ck<cks.length; ck++){
            if(cks[ck].getName().equals("member_id")){
                    member_id = cks[ck].getValue();
            }
    }
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script>
        $(function(){

            $("#send").on("click",function(evnt){
                alert($('#art_content').val());
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/rs_page/connect",
                    scriptCharset: 'utf-8',
                    data: {mode:"artCreate",art_name:$('#art_name').val(),art_content:$('#art_content').val(),member_id:"<%=member_id%>"}
                }).done(function(data){
                    alert(data);
                });
            });
        });
    </script>
    <title></title>
</head>
<body>
    <form>
        <input type="text" id="art_name">
        <textarea id="art_content" cols="30" rows="10"></textarea>
        <button id="send">投稿</button>
    </form>
</body>
</html>