<main>
    <form action="index.php?r=blog/do-edit-article" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
        <input type="hidden" name="id" value="<?=$article['id']?>">
        <div id="plpost">
            <p class="yname"><span>标题:</span>
                <input name="title" type="text" class="inputText" id="username" value="<?=$article['title']?>" size="30" autocomplete="off">
            </p>
            <p class="yname"><span>分类:</span>
                <select name="categoryId">
                    <?php foreach ($this->context->category as $item): ?>
                    <option value="<?=$item['id']?>" <?=$article['categoryId'] == $item['id'] ? 'selected' : ''?>><?=$item['name']?></option>
                    <?php endforeach;?>
                </select>
            </p>
            <p class="yzm"><span>内容:</span>
                <textarea name="content" rows="30" id="saytext"><?=$article['content']?></textarea>
            </p>
            <p>
                <input name="imageField" type="submit" value="保存" style="float: left">
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