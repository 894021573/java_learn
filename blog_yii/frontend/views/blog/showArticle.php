<main>
    <div class="infosbox">
        <div class="newsview">
            <h3 class="news_title"><?= $article['title'] ?></h3>
            <div class="bloginfo">
                <ul>
                    <li class="author">作者：<a href="/"><?=$article['hUser']['nickname']?></a></li>
                    <li class="lmname">分类：<a href="/"><?=$article['hCategory']['name']?></a></li>
                    <li class="timer">时间：<?=date('Y-m-d H:i:s',$article['createdAt'])?></li>
                </ul>
            </div>
            <div class="news_con">
                <?=$article['content']?>
            </div>
        </div>
        <div class="share">

        </div>
<!--        <div class="nextinfo">-->
<!--            <p>上一篇：<a href="/news/life/2018-03-13/804.html">作为一个设计师,如果遭到质疑你是否能恪守自己的原则?</a></p>-->
<!--            <p>下一篇：<a href="/news/life/">返回列表</a></p>-->
<!--        </div>-->
        <div class="news_pl">
            <h2>文章评论</h2>
            <div class="gbko">
                <script src="/e/pl/more/?classid=77&amp;id=106&amp;num=20"></script>
                <?php foreach ($comment['list'] as $item):?>
                <div class="fb">
                    <ul>
                        <p class="fbtime"><span><?= date('Y-m-d H:i:s',$item['createdAt'])?></span><?= $item['userVo']['nickname']?></p>
                        <p class="fbinfo"><?= $item['content']?></p>
                    </ul>
                </div>
                <?php endforeach;?>

                <?= $comment['showPage'] ?>

                <script>
                    function CheckPl(obj) {
                        if (obj.saytext.value == "") {
                            alert("您没什么话要说吗？");
                            obj.saytext.focus();
                            return false;
                        }
                        return true;
                    }
                </script>
                <form action="index.php?r=blog/add-comment" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
                    <div id="plpost">
                        <p class="saying"><span><a href="/e/pl/?classid=77&amp;id=106">共有<?=$comment['total']?>条评论</a></span>来说两句吧...</p>
                        <textarea name="content" rows="6" id="saytext"></textarea>
                        <input name="imageField" type="submit" value="提交">
                        <input name="id" type="hidden" id="id" value="<?= $article['id']?>">
                    </div>
                </form>
                <p style="color: red;">
                    <?php
                    echo Yii::$app->getSession()->getFlash('error');
                    // echo Yii::$app->getSession()->getFlash('success');
                    ?>
                </p>
            </div>
        </div>
    </div>
</main>