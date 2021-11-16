<%@page contentType="text/html; charset=UTF-8" %>
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
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/rs_keijiban.css">
    
    <script>
        var res_data,lines,jsondata;
        $(function(){
            $('.menu-btn').on('click', function(){
                $('.menu').toggleClass('is-active');
            });
            $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/rs_page/connect",
                    scriptCharset: 'utf-8',
                    data: {mode:"artReadList"}
                }).done(function(data){
                    // alert(data); レスポンスデータのデバッグ

                    lines = data.split(';');

                    //jsonデータの整形とhtmlタグの生成
                    for(var i in lines){
                        
                        // 文字列チェック
                        if(lines[i].match(/art/)){
                            jsondata = JSON.parse(lines[i]);
                        }else{
                            continue;
                        }
                        
                        var paragraph = $('<h2></h2>');
                        var contents = $('<p></p>');
                        paragraph.html(jsondata.art_name);
                        contents.html(jsondata.art_content);
                        $('#art_list').append(paragraph);
                        $('#art_list').append(contents);
                    }

                });
        });
 
    </script>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>記事一覧 / RS合同研究室</title>
</head>
<body>
    <header class="jumbotron" style="background: url('image/member/5/1.jpg');background-size: cover;"></header>
    <div class="border row text-center ">
        <a href="" class="col-sm-4 head_list p-4"><div >投稿記事</div></a>
        <a href="" class="col-sm-4 head_list p-4"><div >制作物</div></a>
        <a href="" class="col-sm-4 head_list p-4"><div >マイページ</div></a>
    </div>
    <div class="container">
        <div class="m-0 mt-4" style="text-align:right;">
            <button class="btn btn-outline-secondary pt-2 pb-2 menu-btn" type="button" >
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-justify" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M2 12.5a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5z"/>
                </svg>
            </button>
              <div class="menu">
                <div class="menu__item">TOP</div>
                <div class="menu__item">ABOUT</div>
                <div class="menu__item">BLOG</div>
                <div class="menu__item">CONTACT</div>
              </div>
        </div>
    </div>

    <main class="main">
        <div class="header">
            <h2 class="header h1">投稿記事</h2>
        </div>
        <div id="art_list"></div>
    </main>
</body>
</html>