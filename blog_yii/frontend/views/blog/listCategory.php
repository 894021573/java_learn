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
    <?php foreach ($categories as $item): ?>
        <li>
            <!--            <i><a href="/"><img src="statistic/images/1.jpg"></a></i>-->
            <h3><a href="index.php?r=blog/list-my-article&categoryId=<?= $item['id'] ?>"><?= $item['name'] ?></a></h3>
            <div class="post_item_foot">
                <span class="article_view" style="float:right;">
                    <a href="index.php?r=blog/delete-category&id=<?=$item['id']?>" class="gray" onclick="return del()">删除</a>
                </span>

                <span class="article_view" style="float:right;">
                    <a href="index.php?r=blog/edit-category&id=<?=$item['id']?>" class="gray">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
                </span>
            </div>
        </li>
    <?php endforeach; ?>
</main>

<script>
    function del() {
        if(confirm("确实要删除吗？")){
            return true;
//            alert("已经删除！");
        }else {
//            alert("取消删除");
            return false;
//            alert("取消删除");
        }

    }
</script>

