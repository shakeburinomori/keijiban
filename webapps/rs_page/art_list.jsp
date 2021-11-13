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
            $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/rs_page/connect",
                    scriptCharset: 'utf-8',
                    data: {mode:"artReadList"}
                }).done(function(data){
                    alert(data);
                });
            $("#send").on("click",function(evnt){
                //alert("hello");

            });
        });
    </script>
    <title>記事一覧 / RS合同研究室</title>
</head>
<body>
    <h1></h1>
</body>
</html>