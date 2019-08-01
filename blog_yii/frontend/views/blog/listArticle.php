<style>
    .r_box li h3 a {
        color: #015fb6;
    }

    .post_item_foot a:link, .post_item_foot a:visited, .post_item_foot a:active {
        color: #015fb6;
    }

    .post_item_foot a:link, .post_item_foot a:visited, .post_item_foot a:active {
        color: #015fb6;
    }

    .post_item_foot {
        font-size: 12px;
        color: #555;
        padding-top: 5px;
        #margin-left: 10px;
    }
</style>

<main class="r_box">
    <?php foreach ($list as $item): ?>
        <div class="panel panel-default">
            <div class="panel-body">
                <h4><a href="index.php?r=blog/show-article&id=<?= $item['id'] ?>" style="color:#015fb6"><?= $item['title'] ?></a></h4>
                <p><?= $item['content'] ?></p>
                <div class="post_item_foot">
                    <a href="https://www.cnblogs.com/kakake/" class="lightblue"><?= $item['userVo']['nickname'] ?></a>
                    发布于 <?= date('Y-m-d H:i:s', $item['createdAt']) ?>
                    <span class="article_comment">
                    <a href="https://www.cnblogs.com/kakake/p/11142389.html#commentform" title=""
                       class="gray">评论(<?= $item['commentNum'] ?>)</a>
                </span>
                    <span class="article_view">
                    <a href="https://www.cnblogs.com/kakake/p/11142389.html" class="gray">阅读(<?= $item['viewNum'] ?>
                        )</a>
                </span></div>

            </div>
        </div>
    <?php endforeach; ?>
    <?= $showPage ?>
</main>

