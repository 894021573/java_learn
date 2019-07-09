<main class="r_box">

    <form action="index.php?r=auth/do-register" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
        <div id="plpost">
            <p class="yname"><span>用户名:</span><input name="username" type="text" class="inputText" id="username" value="" size="16" autocomplete="off"></p>
            <p class="yzm"><span>密码:</span><input name="password" type="password" class="inputText" size="16" autocomplete="off"></p>
            <p class="yzm"><span>昵称:</span><input name="nickname" type="text" class="inputText" size="16" autocomplete="off"></p>
            <p class="yzm"><span>邮箱:</span><input name="email" type="text" class="inputText" size="16" autocomplete="off"></p>
            <p><input name="imageField" type="submit" value="注册" style="float: left"></p>
            <div style="clear:both"></div>
            <p style="color: red;">
                <?php
                    echo Yii::$app->getSession()->getFlash('error');
                echo Yii::$app->getSession()->getFlash('success');
                ?>
            </p>
        </div>
    </form>
</main>