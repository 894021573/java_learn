<main>
    <form action="index.php?r=blog/do-add-category" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
        <div id="plpost">
            <p class="yname"><span>类名:</span>
                <input name="name" type="text" class="inputText" id="username" value="" size="30" autocomplete="off">
            </p>
            <p>
                <input name="imageField" type="submit" value="发布" style="float: left">
            </p>
            <div style="clear:both"></div>
            <p style="color: red;">
                <?php
                echo Yii::$app->getSession()->getFlash('error');
                // echo Yii::$app->getSession()->getFlash('success');
                ?>
            </p>
        </div>
    </form>
</main>