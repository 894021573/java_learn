<main>
    <form action="index.php?r=blog/do-add-article" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
        <div id="plpost">
            <p class="yname"><span>标题:</span>
                <input name="title" type="text" class="inputText" id="username" value="" size="30" autocomplete="off">
            </p>
            <p class="yname"><span>分类:</span>
                <select name="categoryId">
                    <?php foreach ($this->context->category as $item): ?>
                    <option value="<?=$item['id']?>"><?=$item['name']?></option>
                    <?php endforeach;?>
                </select>
            </p>
            <p class="yzm"><span>内容:</span>
                <textarea name="content" rows="30" id="saytext"></textarea>
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