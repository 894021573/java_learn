<!doctype html>
<html>
<head>
    <meta charset="gbk">
    <title>个人博客</title>
    <meta name="keywords" content="个人博客"/>
    <meta name="description" content="个人博客"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="statistic/css/base.css" rel="stylesheet">
    <link href="statistic/css/index.css" rel="stylesheet">
    <link href="statistic/css/m.css" rel="stylesheet">
    <link href="statistic/css/page.css" rel="stylesheet">
    <script src="statistic/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="statistic/js/comm.js"></script>
    <!--[if lt IE 9]>
    <script src="statistic/js/modernizr.js"></script>
    <![endif]-->
</head>
<body>
<header class="header-navigation" id="header">
    <nav>
        <div class="logo"><a href="/"><?= $this->context->nickname ?>H博客</a>
        </div>
        <h2 id="mnavh"><span class="navicon"></span></h2>
        <ul id="starlist">
            <li style="margin-right: 20px;">
                <form class="form-horizontal" role="form" method="get" action="index.php?r=blog/list-article">
                    <div class="form-group" style="width:400px;padding-top:16px">
                        <div class="col-sm-10" style="">
                            <input type="text" class="form-control" id="content" name="content" autocomplete="off" value="<?= $this->context->content?>">
                        </div>
                        <button type="submit" class="col-sm-2 btn btn-primary">搜索</button>
                    </div>
                </form>
            </li>
            <li>
                <a href="index.php?r=blog/list-article" <?= $this->context->nav == 'listArticle' ? "id='selected'" : '' ?>>首页</a>
            </li>
            <?php if (!$this->context->isLogin) : ?>
                <li><a href="index.php?r=auth/login" <?= $this->context->nav == 'login' ? "id='selected'" : '' ?>>登录</a>
                </li>
                <li><a href="index.php?r=auth/register" <?= $this->context->nav == 'register' ? "id='selected'" : '' ?>>注册</a>
                </li>
            <?php endif; ?>

            <?php if ($this->context->isLogin) : ?>
                <li>
                    <a href="index.php?r=blog/list-my-article" <?= $this->context->nav == 'listMyArticle' ? "id='selected'" : '' ?>>我的文章</a>
                </li>
                <li>
                    <a href="index.php?r=blog/add-article" <?= $this->context->nav == 'addArticle' ? "id='selected'" : '' ?>>发布文章</a>
                </li>
                <li>
                    <a href="index.php?r=blog/list-category" <?= $this->context->nav == 'listCategory' ? "id='selected'" : '' ?>>分类管理</a>
                </li>
                <li>
                    <a href="index.php?r=auth/login-out" <?= $this->context->nav == 'loginOut' ? "id='selected'" : '' ?>>退出</a>
                </li>
            <?php endif; ?>

        </ul>
    </nav>
</header>
<article>
    <!--    <aside class="l_box">-->
    <aside>
        <div class="panel panel-default">
            <div class="panel-heading">关于</div>
            <div class="panel-body">
                PHP做前端展示，JAVA做接口<br>
                使用技术：SpringBoot，Mysql，Redis，RabbitMQ，Mybatis-generator插件<br>
                SpringBoot：使用了依赖注入，路由配置，数据验证，拦截器，环境配置，发送邮件等功能<br>
                </p>
            </div>
        </div>
        <!--        <div class="search">-->
        <!--            <form action="/e/search/index.php" method="post" name="searchform" id="searchform">-->
        <!--                <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字词"-->
        <!--                       style="color: rgb(153, 153, 153);"-->
        <!--                       onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}"-->
        <!--                       onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}" type="text">-->
        <!--                <input name="show" value="title" type="hidden">-->
        <!--                <input name="tempid" value="1" type="hidden">-->
        <!--                <input name="tbname" value="news" type="hidden">-->
        <!--                <input name="Submit" class="input_submit" value="搜索" type="submit">-->
        <!--            </form>-->
        <!--        </div>-->
        <?php if ($this->context->isLogin) : ?>
            <div class="panel panel-default">
                <div class="panel-heading">
                    文章分类<a href="index.php?r=blog/add-category"
                           style="font-weight: bolder"> +</a>
                </div>
                <div class="panel-body">
                    <ul>
                        <?php foreach ($this->context->category as $item): ?>
                            <li>
                                <a href="index.php?r=blog/list-my-article&categoryId=<?= $item['id'] ?>"><?= $item['name'] ?>
                                    （<?= $item['num'] ?>）</a></li>
                        <?php endforeach; ?>
                    </ul>
                </div>
            </div>
        <?php endif; ?>
    </aside>
    <?= $content ?>
</article>
<footer>
    <!--    <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>-->
</footer>
<a href="#" class="cd-top">Top</a>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
