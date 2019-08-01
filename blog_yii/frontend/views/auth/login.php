<main class="r_box">
    <form class="form-horizontal" role="form" action="index.php?r=auth/do-login" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2">
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
            </div>
            <div style="clear:both"></div>
            <p style="color: red;">
                <?php
                echo Yii::$app->getSession()->getFlash('error');
                // echo Yii::$app->getSession()->getFlash('success');
                ?>
            </p>
    </form>
</main>