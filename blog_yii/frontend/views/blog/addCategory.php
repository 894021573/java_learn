<main>
    <form class="form-horizontal" role="form" action="index.php?r=blog/do-add-category" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">类名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2">
                <button type="submit" class="btn btn-primary">添加</button>
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