<main>
    <form class="form-horizontal" role="form" action="index.php?r=blog/do-add-article" method="post">
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">标题:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="title" name="title" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="categoryId" class="col-sm-2 control-label">分类:</label>
            <div class="col-sm-10">
                <select id="categoryId" class="form-control" name="categoryId">
                    <?php foreach ($this->context->category as $item): ?>
                        <option value="<?= $item['id'] ?>"><?= $item['name'] ?></option>
                    <?php endforeach; ?>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">内容:</label>
            <div class="col-sm-10">
                <textarea id="content" name="content" class="form-control" rows="30"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2">
                <button type="submit" class="btn btn-primary">发布</button>
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