<DOCTYPE! html>
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

<html lang="ja">
    <head>
        <meta charset="utf-8">
        <script src="./js/jquery-3.6.0.min.js"></script>
        <script>
            $(function(){
                $("#send").on("click",function(evnt){
                    //alert("hello");
                    $.ajax({
                        type: "POST",
                        url: "http://localhost:8080/rs_page/connect",
                        scriptCharset: 'utf-8',
                        data: {mode:"memberRead",member_id:"<%=member_id%>"}
                    }).done(function(data){
                        alert(data);
                    });
                });
            });
        </script>
    </head>
    <body>
        <!-- <form>
            <input type="hidden" name="mode" value="memberRead">
            <input type="hidden" name="member_id" value="<%=member_id%>">
            
        </form> -->
        <button id="send">送信</button>
    </body>
</html>